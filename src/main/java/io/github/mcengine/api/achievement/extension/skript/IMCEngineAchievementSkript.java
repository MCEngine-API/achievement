package io.github.mcengine.api.achievement.extension.skript;

import org.bukkit.plugin.Plugin;

/**
 * Represents an Achievement-based Skript module that can be dynamically loaded into the MCEngine.
 * <p>
 * Implement this interface to integrate scripted achievement content into the system.
 */
public interface IMCEngineAchievementSkript {

    /**
     * Called when the Achievement Skript module is loaded by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onLoad(Plugin plugin);

    /**
     * Called when the Achievement Skript module is unloaded or disabled by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onDisload(Plugin plugin);

    /**
     * Sets a unique ID for this Achievement Skript instance.
     *
     * @param id The unique ID assigned by the engine.
     */
    void setId(String id);
}
