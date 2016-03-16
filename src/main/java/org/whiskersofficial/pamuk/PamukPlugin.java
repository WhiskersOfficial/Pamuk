package org.whiskersofficial.pamuk;

import org.bukkit.plugin.java.JavaPlugin;
import org.whiskersofficial.pamuk.threads.PamukUpdater;
import org.whiskersofficial.pamuk.util.Configuration;

public class PamukPlugin extends JavaPlugin implements Whisker {

    private static Pamuk api;

    private static Configuration config;

    String whiskerVersion = "1.0";

    @Override
    public void onEnable() {
        api = new Pamuk(this);
        config = new Configuration(this, "config.yml", true);

        Thread updaterThread = new Thread(new PamukUpdater(), "Pamuk-Updater");
        updaterThread.run();
    }

    @Override
    public void onDisable() {

    }

    @Override
    public String getWhiskerVersion() {
        return whiskerVersion;
    }

    public static Pamuk getPamuk() {
        return api;
    }
}
