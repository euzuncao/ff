package com.my;

public class App {
    public static void main(String[] args) throws Exception {
        PlayerIndex pi = new PlayerIndex();
        Qualifiers qualifiers = new Qualifiers();
        
        int count = 10;
        for (QualifierInfo info : qualifiers.qualifiers) {
            LeagueRosters lr = new LeagueRosters(info.leagueId);
            TeamRoster roster = lr.Rosters[info.rosterId-1];
            Player[] players = roster.GetStarters(pi);

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("\n%s\n", info.userName));
            sb.append("-----------\n");

            for(int ix = 0; ix < players.length; ix++){
                sb.append(String.format("%3s : %3s : %s (%s)\n", 
                    players[ix].position, 
                    players[ix].team,
                    players[ix].full_name, 
                    players[ix].player_id));
            }

            System.out.printf(sb.toString());

            if (count-- <= 0) break;
        }
    }

    // https://api.sleeper.app/v1/user/475126369693462528/leagues/nfl/2019
    public static String getAllLeaguesForUser(String userId){
        return String.format("https://api.sleeper.app/v1/user/%s/leagues/nfl/2019", userId);
    }

    public static String getAllRosters(String leagueId){
        return String.format("https://api.sleeper.app/v1/league/%s/rosters", leagueId);
    }

    public static String getAllPlayers(){
        return String.format("https://api.sleeper.app/v1/players/nfl");
    }
}
