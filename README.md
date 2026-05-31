# NotifyAPI — Public API

Compile-time interfaces for the [NotifyAPI](https://github.com/nothin2lose/NotifyAPI) Paper plugin.

This repository contains **only** the public contract:

- `INotifyAPI`
- `Notification`
- `NotifyType`

The full plugin (hooks, commands, implementation) stays in a **private** repository.

## Maven

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.nothin2lose</groupId>
    <artifactId>NotifyAPI</artifactId>
    <version>1.0.1</version>
    <scope>provided</scope>
</dependency>
```

## Gradle

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.nothin2lose:NotifyAPI:1.0.1")
}
```

## Runtime (server)

Install the **NotifyAPI plugin JAR** on your Paper server — this API jar is **not** a server plugin.

```yaml
# plugin.yml of your plugin
softdepend:
  - NotifyAPI
```

```java
RegisteredServiceProvider<INotifyAPI> rsp =
    Bukkit.getServicesManager().getRegistration(INotifyAPI.class);
if (rsp != null) {
    INotifyAPI api = rsp.getProvider();
    api.send(player, Notification.builder()
        .type(NotifyType.ACTION_BAR)
        .message("<green>Hello!")
        .build());
}
```

## JitPack

Build: [jitpack.io/#nothin2lose/NotifyAPI](https://jitpack.io/#nothin2lose/NotifyAPI)

Use a release tag (e.g. `1.0.1`) as the version.

## License

MIT — see [LICENSE](LICENSE).
