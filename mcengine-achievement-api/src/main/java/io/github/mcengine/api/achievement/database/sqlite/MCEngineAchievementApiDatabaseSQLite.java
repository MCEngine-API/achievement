package io.github.mcengine.api.achievement.database.sqlite;

import io.github.mcengine.api.achievement.database.IMCEngineAchievementApiDatabase;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.sql.*;

/**
 * SQLite implementation for the AI API database.
 * Handles encrypted player token storage and retrieval.
 */
public class MCEngineAchievementApiDatabaseSQLite implements IMCEngineAchievementApiDatabase {

    /** The Bukkit plugin instance. */
    private final Plugin plugin;

    /** The JDBC SQLite database URL. */
    private final String databaseUrl;

    /**
     * Constructs a new SQLite database handler from plugin config.
     * Path is retrieved from config key: database.sqlite.path
     *
     * @param plugin The Bukkit plugin instance.
     */
    public MCEngineAchievementApiDatabaseSQLite(Plugin plugin) {
        this.plugin = plugin;
        String fileName = plugin.getConfig().getString("database.sqlite.path", "achievement.db");
        File dbFile = new File(plugin.getDataFolder(), fileName);

        // Create the file if it doesn't exist
        if (!dbFile.exists()) {
            try {
                boolean created = dbFile.createNewFile();
                if (created) {
                    plugin.getLogger().info("SQLite database file created: " + dbFile.getAbsolutePath());
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Failed to create SQLite database file: " + e.getMessage());
                e.printStackTrace();
            }
        }

        this.databaseUrl = "jdbc:sqlite:" + dbFile.getAbsolutePath();
        createTable();
    }

    /**
     * Creates the 'achievement' table if it does not exist.
     * Columns: id (auto-increment), player_uuid, platform, token.
     */
    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS achievement (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                player_uuid TEXT NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
