package io.github.mcengine.api.achievement;

import org.bukkit.plugin.Plugin;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Map;

import io.github.mcengine.api.achievement.database.IMCEngineAchievementApiDatabase;
import io.github.mcengine.api.achievement.database.sqlite.MCEngineAchievementApiDatabaseSQLite;
import io.github.mcengine.api.mcengine.util.*;

/**
 * Main API class for MCEngineAchievement.
 * Handles AI model initialization, extension loading (AddOns/DLCs), and token validation.
 */
public class MCEngineAchievementApi {

    /**
     * Singleton instance of the API.
     */
    private static MCEngineAchievementApi instance;

    /**
     * Database handler instance for storing and retrieving player tokens.
     */
    private final IMCEngineAchievementApiDatabase db;

    /**
     * The Bukkit plugin instance associated with this AI API.
     */
    private final Plugin plugin;

    /**
     * Constructs a new AI API instance with the given plugin.
     * Initializes the AI model and loads addons and DLCs from the filesystem.
     *
     * Also loads supported models from config:
     * - ai.{platform}.models
     * - ai.custom.{server}.models
     *
     * Supports platforms: deepseek, openai, openrouter, customurl.
     *
     * @param plugin The Bukkit plugin instance.
     */
    public MCEngineAchievementApi(Plugin plugin) {
        instance = this;
        this.plugin = plugin;

        // Initialize database based on type
        String dbType = plugin.getConfig().getString("database.type", "sqlite").toLowerCase();
        switch (dbType) {
            case "sqlite":
                this.db = new MCEngineAchievementApiDatabaseSQLite(plugin);
                break;
            default:
                throw new IllegalArgumentException("Unsupported database type: " + dbType);
        }
    }

    /**
     * Gets the global API singleton instance.
     *
     * @return The {@link MCEngineAchievementApi} instance.
     */
    public static MCEngineAchievementApi getApi() {
        return instance;
    }

    /**
     * Gets the Bukkit plugin instance linked to this API.
     *
     * @return The plugin instance.
     */
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Gets the database handler implementation.
     *
     * @return The database API implementation.
     */
    public IMCEngineAchievementApiDatabase getDB() {
        return db;
    }

    /**
     * Checks for updates by querying the specified Git platform.
     * Logs to console if a new version is available.
     *
     * @param gitPlatform The platform to query ("github" or "gitlab").
     * @param org         The organization or user.
     * @param repository  The repository name.
     * @param token       The access token (nullable).
     */
    public void checkUpdate(String gitPlatform, String org, String repository, String token) {
        MCEngineApiUtilUpdate.checkUpdate(plugin, gitPlatform, org, repository, token);
    }
}
