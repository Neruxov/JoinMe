package me.neruxov.joinme.utils;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;

public class JoinMeCodes {

    HashMap<String, ProxiedPlayer> JoinMeCodes;

    public JoinMeCodes (HashMap<String, ProxiedPlayer> JoinMeCodes) {
        this.JoinMeCodes = JoinMeCodes;
    }

    public void addJoinMeCode(String code, ProxiedPlayer player) {
        this.JoinMeCodes.put(code, player);
    }

    public void removeJoinCode(String code) {
        this.JoinMeCodes.remove(code);
    }

    public HashMap<String, ProxiedPlayer> getCodes() {
        return this.JoinMeCodes;
    }

}