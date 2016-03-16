package org.whiskersofficial.pamuk.util;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class Configuration {

    private File configFile;
    private String configName;
    private FileConfiguration fileConfiguration;

    public Configuration(JavaPlugin plugin, String configName, Boolean shouldCopy) {
        this.configName = configName;
        this.configFile = new File(plugin.getDataFolder(), configName);

        if (shouldCopy.booleanValue()) {
            firstRun(plugin);
        }

        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.configFile);

        load();
    }

    public FileConfiguration getConfig() {
        load();

        return this.fileConfiguration;
    }

    public void save() {
        try {
            this.fileConfiguration.save(this.configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            this.fileConfiguration.load(this.configFile);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void firstRun(JavaPlugin plugin) {
        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();
            copy(plugin.getResource(this.configName), this.configFile);
        }
    }

    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte['?'];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception localException) {
        }
    }
}
