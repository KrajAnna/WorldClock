package org.anna.WorldClock;

import lombok.Data;

@Data
public class Timezone {
    private long id;
    private String countryCode;
    private String countryZone;
    private float gmtOffset;

    public Timezone(String countryCode, String countryZone, float gmtOffset) {
        this.countryCode = countryCode;
        this.countryZone = countryZone;
        this.gmtOffset = gmtOffset;
    }

    public Timezone() {

    }
}
