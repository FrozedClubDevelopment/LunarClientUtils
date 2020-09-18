# LunarClientUtils - Example Plugin for LunarClient's Official API

#### How to use
 1. Download LunarClient's API Bukkit plugin jar [[Click Here]](https://maven.moonsworth.com/repository/lunarclient-public/com/lunarclient/bukkitapi/1.0-SNAPSHOT/bukkitapi-1.0-20200729.212152-7.jar) 
 2. Download the latest release version of LunarClientUtils [[Click Here]](https://github.com/FrozedClubDevelopment/LunarClientUtils/releases/download/v1.0/LunarClientUtils-1.0-SNAPSHOT.jar)
 3. Add both jars into your server.
 4. Have fun with it.
 
#### General Information
 * In order to correctly get AntiCheat ON/OFF players, your server must be partnered with Lunar.
 * LunarClient Staff Modules only work on the 1.7.10 Version of Lunar Client.
 * Staff-Modules permission: "lunar.utils.staff-modules"
 * Command to get list of players on LunarClient: "/lc"

#### LunarClientAPI Usage
To use the API we get the instance of it firstly.

```java
LunarClientAPI.getInstance();
```

Once you have done that, you'll have access to all the methods currently available on LunarClient's Official API.
I'll list some methods here, keep in mind the API isn't limited the methods I'll list here, of course it has more methods.

```java
sendNotification(Player player, LCNotification notification);

isRunningLunarClient(Player player);
isRunningLunarClient(UUID playerUuid);

isRunningAntiCheat(Player player);
isRunningAntiCheat(UUID playerUuid);

giveAllStaffModules(Player player);
disableAllStaffModules(Player player);
setStaffModuleState(Player player, StaffModule module, boolean state);

sendCooldown(Player player, LCCooldown cooldown);
clearCooldown(Player player, LCCooldown cooldown);
```

#### Contact
 * Discord: Elb1to#0001
 * Twitter: Elb1to
 * Telegram: Elb1to