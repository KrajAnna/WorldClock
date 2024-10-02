package org.anna.WorldClock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private String filepath = "timezones.txt";

    protected List<String> readFile(String filepath) {
        List<String> timezones = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            timezones = new ArrayList<>();
            String l;
            while ((l = br.readLine()) != null) {
                timezones.add(l);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return timezones;
    }

}
