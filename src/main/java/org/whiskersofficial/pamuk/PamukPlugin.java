package org.whiskersofficial.pamuk;

import org.bukkit.plugin.java.JavaPlugin;
import org.whiskersofficial.pamuk.threads.PamukUpdater;

public class PamukPlugin extends JavaPlugin {

    private static Pamuk api;

    @Override
    public void onEnable() {
        api = new Pamuk(this);

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
