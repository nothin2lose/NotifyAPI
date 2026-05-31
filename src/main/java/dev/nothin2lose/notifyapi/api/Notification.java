package dev.nothin2lose.notifyapi.api;

import java.util.Objects;

/**
 * Immutable, thread-safe notification data object.
 * Use {@link #builder()} to construct instances.
 */
public final class Notification {

    private final NotifyType type;
    private final String message;
    private final String subtitle;
    private final int duration;
    private final int priority;

    private Notification(Builder builder) {
        this.type = Objects.requireNonNull(builder.type, "type must not be null");
        this.message = Objects.requireNonNull(builder.message, "message must not be null");
        this.subtitle = builder.subtitle;
        this.duration = builder.duration;
        this.priority = builder.priority;
    }

    public NotifyType getType() {
        return type;
    }

    /** MiniMessage string. May contain {@code <papi:placeholder>} tags. */
    public String getMessage() {
        return message;
    }

    /** Only relevant for {@link NotifyType#TITLE}. May be {@code null}. */
    public String getSubtitle() {
        return subtitle;
    }

    /** Duration in seconds (BOSS_BAR) or ignored for other types. */
    public int getDuration() {
        return duration;
    }

    /** Higher priority overrides a running BossBar. */
    public int getPriority() {
        return priority;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private NotifyType type;
        private String message;
        private String subtitle;
        private int duration = 5;
        private int priority = 0;

        private Builder() {}

        public Builder type(NotifyType type) {
            this.type = type;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
