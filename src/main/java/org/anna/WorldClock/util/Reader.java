package org.anna.WorldClock.util;

import lombok.NoArgsConstructor;
import org.anna.WorldClock.entity.Timezone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Reader {

    private String filepath = "timezones.txt";

    public List<Timezone> readFile() {
        List<Timezone> timezones = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Timezone timezone = new Timezone();
                timezone.setCountryCode(splitLine(line)[0]);
                timezone.setCountryZone(splitLine(line)[1]);
                timezone.setGmtOffset(Float.parseFloat(splitLine(line)[2]));
                timezones.add(timezone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timezones;
    }

    private String[] splitLine(String line) {
        return line.split(",");
    }




}
