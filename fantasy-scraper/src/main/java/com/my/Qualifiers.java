package com.my;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Qualifiers {

    public List<QualifierInfo> qualifiers = new ArrayList<QualifierInfo>();

    public Qualifiers(){
        try {
            initializeQualifiers();           
        } catch (Exception e) {
            
        }
    }

    private void initializeQualifiers() {
        String csvFile = "/Users/euzuncao/src/my/fantasy-scraper/src/main/java/com/my/Megalabowl_week12.csv";
        BufferedReader br = null;
        String line = "";
        String delimiter = ",";
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] qualifier = line.split(delimiter);

                QualifierInfo qi = new QualifierInfo();
                qi.leagueId = qualifier[0];
                qi.rosterId = Integer.parseInt(qualifier[1]);
                qi.userId = qualifier[2];
                qi.userName = qualifier[3];
                qi.points = Double.parseDouble(qualifier[4]);

                qualifiers.add(qi);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}