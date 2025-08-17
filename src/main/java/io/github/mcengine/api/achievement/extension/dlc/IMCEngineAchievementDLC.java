package io.github.mcengine.api.achievement.extension.dlc;

import org.bukkit.plugin.Plugin;

/**
 * Represents an Achievement-based DLC module that can be dynamically loaded into the MCEngine.
 * <p>
 * Implement this interface to integrate downloadable content into the system.
 */
public interface IMCEngineAchievementDLC {

    /**
     * Called when the Achievement DLC is loaded by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onLoad(Plugin plugin);

    /**
     * Called when the Achievement DLC is unloaded or disabled by the engine.
     *
     * @param plugin The plugin instance providing context.
     */
    void onDisload(Plugin plugin);

    /**
     * Sets a unique ID for this Achievement DLC instance.
     *
     * @param id The unique ID assigned by the engine.
     */
    void setId(String id);
}
