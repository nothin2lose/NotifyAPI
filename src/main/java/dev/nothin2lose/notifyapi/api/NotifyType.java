package dev.nothin2lose.notifyapi.api;

public enum NotifyType {
    CHAT,
    ACTION_BAR,
    TITLE,
    BOSS_BAR,

    /**
     * Resolves the actual notification type at dispatch time based on the receiving
     * player's primary LuckPerms group using the {@code luckperms-routing} config table.
     * Falls back to {@code default-notify-type} when LuckPerms is not installed or the
     * player's group has no mapping.
     */
    ROUTED
}
