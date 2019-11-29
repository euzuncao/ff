package com.my;

public class TeamRoster{

    private String[] players;
    private String[] starters;

    public Player[] GetPlayers(final PlayerIndex index){
        if(players == null) return null;

        final Player[] namedPlayers = new Player[players.length];

        for (int ix = 0; ix < namedPlayers.length; ix++){
            namedPlayers[ix] = index.getPlayer(players[ix]);
        }

        return namedPlayers;
    }

    public Player[] GetStarters(final PlayerIndex index){
        if(starters == null) return null;

        final Player[] namedPlayers = new Player[starters.length];

        for (int ix = 0; ix < namedPlayers.length; ix++){
            namedPlayers[ix] = index.getPlayer(starters[ix]);
        }

        return namedPlayers;
    }
}