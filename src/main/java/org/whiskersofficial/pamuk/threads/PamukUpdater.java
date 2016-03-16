package org.whiskersofficial.pamuk.threads;

import org.whiskersofficial.pamuk.Pamuk;

public class PamukUpdater implements Runnable {

    public void run() {
        System.out.println("[Pamuk Updater] Updater started...");

        String repoOwner = "WhiskersOfficial";
        String[] pluginsToUpdate = {
                "Pamuk"
        };

        for (String plugin : pluginsToUpdate) {
            if (!Pamuk.isPluginUpToDate(plugin)) {
                System.out.println("[Pamuk] Grrr, " + plugin + " is out of date");
            }
        }
    }

}
