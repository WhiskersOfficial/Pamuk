package org.whiskersofficial.pamuk;

import org.whiskersofficial.pamuk.threads.PamukUpdater;
import org.whiskersofficial.pamuk.util.Configuration;

public class PamukPlugin extends Whisker {

    private static Pamuk api;

    private static Configuration config;

    public static final String whiskerVersion = "1.0";

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

    public static Pamuk getPamuk() {
        return api;
    }
}
