package org.whiskersofficial.pamuk.threads;

import org.whiskersofficial.pamuk.PamukPlugin;

public class PamukUpdater implements Runnable {

    PamukPlugin plugin;

    public PamukUpdater(PamukPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        plugin.getLogger().info("Updater started...");

        String[] pluginsToUpdate = {
                "Pamuk",
                "BaskaPlugin"
        };


    }
}
