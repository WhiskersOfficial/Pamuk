package org.whiskersofficial.pamuk.threads;

import org.whiskersofficial.pamuk.util.VersionUtil;

public class PamukUpdater implements Runnable {

    public void run() {
        System.out.println("[Updater] Updater started...");

        String repoOwner = "WhiskersOfficial";
        String[] pluginsToUpdate = {
                "Pamuk"
        };

        for (String plugins : pluginsToUpdate) {
            if (VersionUtil.isPluginUpToDate(plugins)) {
                System.out.println("Plugin " + plugins + " is up to date");
            } else {
                System.out.println("Plugin " + plugins + " is out of date");
                System.out.println("Current Version: " + VersionUtil.getCurrentVersion(plugins));
                System.out.println("Latest Version: " + VersionUtil.getLatestVersion(plugins));
            }
        }
    }

}
