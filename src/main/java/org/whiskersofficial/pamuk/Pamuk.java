package org.whiskersofficial.pamuk;

import org.bukkit.Bukkit;
import org.whiskersofficial.pamuk.util.Utils;

public class Pamuk {

    private PamukPlugin plugin;
    private String prefix;

    protected Pamuk(PamukPlugin plugin) {
        this.plugin = plugin;
        this.prefix = "&7[&fPamuk&7] ";

        Bukkit.getConsoleSender().sendMessage(color(prefix + "&bMeow."));
    }

    public static String color(String message) {
        return Utils.color(message);
    }

    public PamukPlugin getPlugin() {
        return plugin;
    }

}
