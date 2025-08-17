package io.github.mcengine.api.achievement.extension.library;

import org.bukkit.plugin.Plugin;

/**
 * Represents an Achievement-based Library module that can be dynamically loaded into the MCEngine.
 * <p>
 * Implement this interface to provide achievement-related library support to the system.
 */
public interface IMCEngineAchievementLibrary {

    /**
     * Called when the Achievement Library is loaded by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onLoad(Plugin plugin);

    /**
     * Called when the Achievement Library is unloaded or disabled by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onDisload(Plugin plugin);

    /**
     * Sets a unique ID for this Achievement Library instance.
     *
     * @param id The unique ID assigned by the engine.
     */
    void setId(String id);
}
