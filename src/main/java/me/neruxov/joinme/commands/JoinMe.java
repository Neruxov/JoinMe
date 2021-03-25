package me.neruxov.joinme.commands;

import java.util.HashMap;
import java.util.Iterator;

import me.neruxov.joinme.Main;
import me.neruxov.joinme.utils.JoinMeCodes;
import me.neruxov.joinme.utils.RandomCodeGenerator;
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
        if (!(sender instanceof ProxiedPlayer)) {
            return;
        } else if (args.length == 1) {
            return;
        } else if (sender.hasPermission(Main.getConfig().getString("joinme_use_permission"))) {
            Iterator<ProxiedPlayer> pl = BungeeCord.getInstance().getPlayers().iterator();
            ProxiedPlayer p = pl.next();
            String server = p.getServer().getInfo().getName();

            RandomCodeGenerator codegen = new RandomCodeGenerator();
            String code = codegen.RandomCodeGenerator();
            JoinMeCodes storage = Main.getInstance().getStorage();
            storage.addJoinMeCode(code, (ProxiedPlayer) sender);

            String prefix = Main.getConfig().getString("prefix");
            String hovertext = Main.getConfig().getString("hover_text");

            TextComponent msg1 = new TextComponent(prefix + " " + p.getDisplayName() +"§7 plays on §6" + p.getServer().getInfo().getName());
            msg1.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder(hovertext).create()));
            msg1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,
                    "/ij342nj43h23jk4h23jk4h234h23hlasndjkkjsdmjklmnasjfna " + p.getServer().getInfo().getName() + " " + code));

            TextComponent msg2 = new TextComponent(prefix + " " + "§8» §cJoin now!");
            msg2.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder(hovertext).create()));
            msg2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,
                    "/ij342nj43h23jk4h23jk4h234h23hlasndjkkjsdmjklmnasjfna " + p.getServer().getInfo().getName() + " " + code));

            BungeeCord.getInstance().broadcast(msg1);
            BungeeCord.getInstance().broadcast(msg2);
        } else {
            sender.sendMessage(Main.getConfig().getString("no_permission"));
        }
    }
}
