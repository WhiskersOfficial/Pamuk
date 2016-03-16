package org.whiskersofficial.pamuk;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.whiskersofficial.pamuk.threads.PamukUpdater;
import org.whiskersofficial.pamuk.util.Configuration;

public class PamukPlugin extends JavaPlugin {

    private static Pamuk api;

    private static Configuration config;

    public static final String whiskerVersion = "1.0";
    public static final String whiskerName = "Pamuk";

    @Override
    public void onEnable() {
        api = new Pamuk(this);
        config = new Configuration(this, "config.yml", true);

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new PamukUpdater(), 100L);

    }

    @Override
    public void onDisable() {

    }

    public static Pamuk getPamuk() {
        return api;
    }
}
