package org.whiskersofficial.pamuk.util;

import com.github.zafarkhaja.semver.Version;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class VersionUtil {

    public static Version getLatestVersion(String pluginName) {
        if (Bukkit.getPluginManager().getPlugin(pluginName) == null) {
            return Version.valueOf("0.0.0");
        } else {
            String releasesJSON = HTTPUtils.getRequest("https://api.github.com/repos/" +
                    "WhiskersOfficial/" + pluginName + "releases");

            Gson gson = new Gson();
            JsonArray releases = gson.fromJson(releasesJSON, JsonArray.class);
            return Version.valueOf(((JsonObject) releases.get(0))
                    .get("tag_name")
                    .toString()
                    .replace("\"", ""));
        }
    }

    public static Version getCurrentVersion(String pluginName) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);

        if (plugin == null) {
            return Version.valueOf("0.0.0");
        } else {
            return Version.valueOf(plugin.getDescription().getVersion());
        }
    }
}
