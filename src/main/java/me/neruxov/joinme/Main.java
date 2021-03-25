package me.neruxov.joinme;

import me.neruxov.joinme.commands.JoinMe;
import me.neruxov.joinme.commands.ReloadConfig;
import me.neruxov.joinme.commands.ServerConnect;
import me.neruxov.joinme.utils.JoinMeCodes;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;

public class Main extends Plugin {

    private static Main instance;
    private static Configuration configuration;
    private static JoinMeCodes storage = new JoinMeCodes(new HashMap<String, ProxiedPlayer>());

    @Override
    public void onEnable() {
        instance = this;
        handleConfig();
        registerCommands();
    }

    public void registerCommands() {
        getProxy().getPluginManager().registerCommand(this, new JoinMe("joinme"));
        getProxy().getPluginManager().registerCommand(this, new ServerConnect("ij342nj43h23jk4h23jk4h234h23hlasndjkkjsdmjklmnasjfna"));
        getProxy().getPluginManager().registerCommand(this, new ReloadConfig("jmreload"));
    }

    public static Main getInstance() {
        return instance;
    }

    public static Configuration getConfig() {
        return configuration;
    }

    public static JoinMeCodes getStorage() {
        return storage;
    }

    public void reloadConfig() {
        try {
            Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleConfig() {

        if (!getDataFolder().exists())
            getDataFolder().mkdir();

        File file = new File(getDataFolder(), "config.yml");


        if (!file.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            System.err.printf("Can not read the config, please recreate it.");
        }

    }

}
