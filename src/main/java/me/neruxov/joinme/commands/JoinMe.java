package me.neruxov.joinme.commands;

import java.util.Iterator;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class JoinMe extends Command {

    public JoinMe(String name) {
        super(name);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {

        } else if (sender.hasPermission("joinme.use")) {
            Iterator<ProxiedPlayer> pl = BungeeCord.getInstance().getPlayers().iterator();
            ProxiedPlayer p = pl.next();
            String server = p.getServer().getInfo().getName();

            TextComponent msg1 = new TextComponent("§8[§5JoinMe§8] " + p.getDisplayName() +" §7 plays on §6" + p.getServer().getInfo().getName());
            msg1.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("§cJoin now!").create()));
            msg1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,
                    "/ij342nj43h23jk4h23jk4h234h23hlasndjkkjsdmjklmnasjfna " + p.getServer().getInfo().getName()));

            TextComponent msg2 = new TextComponent("§8[§5JoinMe§8] §8» §cJoin now!");
            msg2.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("§cJoin now!").create()));
            msg2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,
                    "/ij342nj43h23jk4h23jk4h234h23hlasndjkkjsdmjklmnasjfna " + p.getServer().getInfo().getName()));

            BungeeCord.getInstance().broadcast(msg1);
            BungeeCord.getInstance().broadcast(msg2);
        } else {
           sender.sendMessage("§cYou aren't allowed to use this command!");
        }
    }
}
