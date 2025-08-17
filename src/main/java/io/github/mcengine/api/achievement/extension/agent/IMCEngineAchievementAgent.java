package io.github.mcengine.api.achievement.extension.agent;

import org.bukkit.plugin.Plugin;

/**
 * Represents an Achievement-based Agent module that can be dynamically loaded into the MCEngine.
 * <p>
 * Implement this interface to integrate achievement-related agents into the system.
 */
public interface IMCEngineAchievementAgent {

    /**
     * Called when the Achievement Agent is loaded by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onLoad(Plugin plugin);

    /**
     * Called when the Achievement Agent is unloaded or disabled by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onDisload(Plugin plugin);

    /**
     * Sets a unique ID for this Achievement Agent instance.
     *
     * @param id The unique ID assigned by the engine.
     */
    void setId(String id);
}
