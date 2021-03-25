package me.neruxov.joinme.commands;

import me.neruxov.joinme.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class ReloadConfig extends Command {

    public ReloadConfig(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        String prefix = Main.getConfig().getString("prefix");

        if (sender.hasPermission(Main.getConfig().getString("reload_config_permission"))) {
            Main.getInstance().reloadConfig();
            sender.sendMessage(prefix + " §7Config has been §asuccessfully §7 reloaded!");
        } else {
            sender.sendMessage(Main.getConfig().getString("no_permission"));
        }
    }

}
