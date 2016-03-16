package org.whiskersofficial.pamuk;

import org.bukkit.plugin.java.JavaPlugin;
import org.whiskersofficial.pamuk.threads.PamukUpdater;
import org.whiskersofficial.pamuk.util.Configuration;

public class PamukPlugin extends JavaPlugin {

    private static Pamuk api;

    private static Configuration config;

    @Override
    public void onEnable() {
        api = new Pamuk(this);
        config = new Configuration(this, "config.yml", true);

        Thread updaterThread = new Thread(new PamukUpdater(this));
        updaterThread.run();
    }

    @Override
    public void onDisable() {

    }

    public static Pamuk getPamuk() {
        return api;
    }
}
