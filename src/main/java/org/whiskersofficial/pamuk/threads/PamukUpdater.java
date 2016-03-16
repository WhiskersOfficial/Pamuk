package org.whiskersofficial.pamuk.threads;

import org.whiskersofficial.pamuk.util.VersionUtil;

public class PamukUpdater implements Runnable {
    public void run() {
        System.out.println("[Pamuk Updater] Updater started...");

        String repoOwner = "WhiskersOfficial";
        String[] pluginsToUpdate = {
             "Pamuk"
        };

        for (String plugins : pluginsToUpdate) {
            if (VersionUtil.isPluginUpToDate(plugins, repoOwner)) {
                System.out.println("[Pamuk Updater] Plugin " + plugins + " is up to date");
            } else {
                System.out.println("[Pamuk Updater] Plugin " + plugins + " is out of date");
                System.out.println("[Pamuk Updater] Current Version: " + VersionUtil.getCurrentVersion(plugins));
                System.out.println("[Pamuk Updater] Latest Version: "  + VersionUtil.getLatestVersion(plugins, repoOwner));
            }
        }
    }
}
