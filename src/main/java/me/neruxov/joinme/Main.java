package me.neruxov.joinme;

import me.neruxov.joinme.commands.JoinMe;
import me.neruxov.joinme.commands.ServerConnect;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new JoinMe("joinme"));
        getProxy().getPluginManager().registerCommand(this, new ServerConnect("ij342nj43h23jk4h23jk4h234h23hlasndjkkjsdmjklmnasjfna"));
    }
}
