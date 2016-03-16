package org.whiskersofficial.pamuk.threads;

import com.github.zafarkhaja.semver.Version;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.whiskersofficial.pamuk.util.HTTPUtils;

public class PamukUpdater implements Runnable {
    public void run() {
        System.out.println("[Updater] Updater started...");

        String repoOwner = "Admicos"; //NOTE TO SELF: WhiskersOfficial by default
        String[] pluginsToUpdate = {
             /* "Pamuk" //NOTE TO SELF: Uncomment after testing */
                "VKick" //NOTE TO SELF: Remove after testing
        };

        for (String plugins : pluginsToUpdate) {
            if (Bukkit.getPluginManager().getPlugin(plugins) == null) {
               System.out.println("[Updater] Plugin " + plugins + " is not installed on this server. Updater will skip it.");
            } else {
                String releasesJSON = HTTPUtils.GETRequest("https://api.github.com/repos/" + repoOwner + "/" + plugins + "/releases");

                Gson gson = new Gson();
                JsonArray releases = gson.fromJson(releasesJSON, JsonArray.class);
                Version latest = Version.valueOf(((JsonObject) releases.get(0)).get("tag_name").toString());
                Version current = Version.valueOf(Bukkit.getPluginManager()
                        .getPlugin(plugins)
                        .getDescription()
                        .getVersion());

                if (latest.greaterThan(current)) {
                    System.out.println("[Updater] Plugin " + plugins + " is out of date.");
                    System.out.println("Latest: " + latest.toString());
                    System.out.println("Current: " + current.toString());
                } else {
                    System.out.println("[Updater] Plugin " + plugins + " is up to date.");
                }
            }
        }
    }
}
