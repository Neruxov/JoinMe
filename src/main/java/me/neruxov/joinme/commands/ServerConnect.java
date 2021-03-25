package me.neruxov.joinme.commands;

import me.neruxov.joinme.Main;
import me.neruxov.joinme.utils.JoinMeCodes;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServerConnect extends Command {

    public ServerConnect(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            return;
        }

        ProxiedPlayer p = (ProxiedPlayer) sender;

        JoinMeCodes storage = Main.getInstance().getStorage();

        List<String> codes = new ArrayList<>(storage.getCodes().keySet());

        String prefix = Main.getConfig().getString("prefix");
        String expire_message = Main.getConfig().getString("joinme_expired_message");
        String player_connects = Main.getConfig().getString("player_connect_message").replace("%player%", p.getDisplayName());

        if (args.length == 2) {
            if (codes.contains(args[1])) {
                String server = args[0];
                ServerInfo info = ProxyServer.getInstance().getServerInfo(server);
                p.connect(info);

                storage.getCodes().get(args[1]).sendMessage(player_connects);

                ProxyServer.getInstance().getScheduler().schedule(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        storage.removeJoinCode(args[1]);
                    }
                }, (int) Main.getConfig().getDouble("code_expiry_time"), TimeUnit.SECONDS);
            } else {
                sender.sendMessage(prefix + " " + expire_message);
            }
        }
    }

}
