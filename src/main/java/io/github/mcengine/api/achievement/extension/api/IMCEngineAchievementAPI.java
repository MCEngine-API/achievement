package io.github.mcengine.api.achievement.extension.api;

import org.bukkit.plugin.Plugin;

/**
 * Represents an Achievement-based API module that can be dynamically loaded into the MCEngine.
 * <p>
 * Implement this interface to provide achievement-related APIs to the system.
 */
public interface IMCEngineAchievementAPI {

    /**
     * Called when the Achievement API is loaded by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onLoad(Plugin plugin);

    /**
     * Called when the Achievement API is unloaded or disabled by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onDisload(Plugin plugin);

    /**
     * Sets a unique ID for this Achievement API instance.
     *
     * @param id The unique ID assigned by the engine.
     */
    void setId(String id);
}
