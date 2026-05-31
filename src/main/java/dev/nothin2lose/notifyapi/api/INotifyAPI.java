package dev.nothin2lose.notifyapi.api;

import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Public service interface for NotifyAPI.
 *
 * <p>Other plugins retrieve this via the Bukkit Services Manager:
 * <pre>{@code
 * RegisteredServiceProvider<INotifyAPI> rsp =
 *     Bukkit.getServicesManager().getRegistration(INotifyAPI.class);
 * if (rsp != null) {
 *     INotifyAPI api = rsp.getProvider();
 * }
 * }</pre>
 */
public interface INotifyAPI {

    /** Send a single notification to one player. */
    void send(Player player, Notification notification);

    /** Broadcast a notification to multiple players (e.g. all online). */
    void broadcast(Collection<? extends Player> players, Notification notification);

    /** Send a notification after a delay (in ticks). */
    void sendDelayed(Player player, Notification notification, long delayTicks);

    /** Explicitly remove the active BossBar for a player. */
    void clearBossBar(Player player);
}
