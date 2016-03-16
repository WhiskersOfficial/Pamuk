package org.whiskersofficial.pamuk.threads;

import org.bukkit.Bukkit;
import org.whiskersofficial.pamuk.util.HTTPUtils;

public class PamukUpdater implements Runnable {
    public void run() {
        System.out.println("[Updater] Updater started...");

        String[] pluginsToUpdate = {
                "Pamuk",
                "BaskaPlugin"
        };

        for (String plugins : pluginsToUpdate) {
            if (Bukkit.getPluginManager().getPlugin(plugins) == null) {
               System.out.println("[Updater] Plugin " + plugins + " is not installed on this server. Updater will skip it.");
            } else {
                String releasesJSON = HTTPUtils.GETRequest("https://api.github.com/repos/WhiskersOfficial/" + plugins + "/releases");
            }
        }
    }
}
