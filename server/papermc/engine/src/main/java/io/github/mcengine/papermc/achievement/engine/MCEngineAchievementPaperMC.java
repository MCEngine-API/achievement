package io.github.mcengine.papermc.achievement.engine;

import io.github.mcengine.api.achievement.MCEngineAchievementApi;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main SpigotMC plugin class for MCEngineAchievement.
 */
public class MCEngineAchievementPaperMC extends JavaPlugin {

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        saveDefaultConfig(); // Save config.yml if it doesn't exist

        boolean enabled = getConfig().getBoolean("enable", false);
        if (!enabled) {
            getLogger().warning("Plugin is disabled in config.yml (enable: false). Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        MCEngineAchievementApi api = new MCEngineAchievementApi(this);

        api.checkUpdate("github", "MCEngine", "achievement", getConfig().getString("github.token", "null"));
    }

    /**
     * Called when the plugin is disabled.
     */
    @Override
    public void onDisable() {}
}
