package com.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LeagueRosters {

    public TeamRoster[] Rosters;

    public LeagueRosters(String leagueId) {
        try {
            initializeRosters(leagueId);
        } catch (Exception e) {

        }
    }

    private void initializeRosters(String leagueId) throws IOException {
        URL url = new URL (getAllRostersUrl(leagueId));
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        StringBuilder response = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
        }

        Gson gson = new Gson();
        Rosters = gson.fromJson(response.toString(), new TypeToken<TeamRoster[]>(){}.getType());
    }

    private static String getAllRostersUrl(String leagueId){
        return String.format("https://api.sleeper.app/v1/league/%s/rosters", leagueId);
    }
}