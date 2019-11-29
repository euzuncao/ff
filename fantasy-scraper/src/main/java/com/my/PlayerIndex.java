package com.my;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class PlayerIndex {
    private Map<String, Player> index = new HashMap<String, Player>();

    public PlayerIndex(){
        try {
            initializeIndex();           
        } catch (Exception e) {
            
        }
    }

    public Player getPlayer(String playerId){
        return index.getOrDefault(playerId, null);
    }

    private void initializeIndex()  throws FileNotFoundException, IOException {
        String fileName = "/Users/euzuncao/src/my/fantasy-scraper/src/main/java/com/my/nfl.json";

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(fileName));
        Type type = new TypeToken<HashMap<String, Player>>(){}.getType();
        index = gson.fromJson(reader, type);

        System.out.printf("Count of players: %s\n", index.size());
    }
}