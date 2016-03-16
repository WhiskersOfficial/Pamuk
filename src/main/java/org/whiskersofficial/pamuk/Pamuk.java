package org.whiskersofficial.pamuk;

import com.github.zafarkhaja.semver.Version;
import org.bukkit.Bukkit;
import org.whiskersofficial.pamuk.util.Utils;
import org.whiskersofficial.pamuk.util.VersionUtil;

public class Pamuk {

    public static final String prefix = "&7[&fPamuk&7] ";

    private PamukPlugin plugin;

    protected Pamuk(PamukPlugin plugin) {
        this.plugin = plugin;

        Bukkit.getConsoleSender().sendMessage(color(prefix + "&bMeow."));
    }

    public static String color(String message) {
        return Utils.color(message);
    }

    public static boolean isPluginUpToDate(String pluginName) {
        if (Bukkit.getPluginManager().getPlugin(pluginName) == null) {
            return false;
        } else {
            Version latest = VersionUtil.getLatestVersion(pluginName);
            Version current = VersionUtil.getCurrentVersion(pluginName);

            return !latest.greaterThan(current);
        }
    }

    public PamukPlugin getPlugin() {
        return plugin;
    }

}
