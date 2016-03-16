package org.whiskersofficial.pamuk;

import org.bukkit.Bukkit;
import org.whiskersofficial.pamuk.util.Utils;

public class Pamuk {

    private PamukPlugin plugin;

    protected Pamuk(PamukPlugin plugin) {
        this.plugin = plugin;

        Bukkit.getConsoleSender().sendMessage(color("&7[&fPamuk&7] &bMeow."));
    }

    public static String color(String message) {
        return Utils.color(message);
    }

    public PamukPlugin getPlugin() {
        return plugin;
    }

}
