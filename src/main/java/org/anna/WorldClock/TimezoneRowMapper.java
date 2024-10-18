package org.anna.WorldClock;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimezoneRowMapper implements RowMapper<Timezone> {
    @Override
    public Timezone mapRow(ResultSet rs, int rowNum) throws SQLException {
        Timezone timezone = new Timezone();
        timezone.setCountryCode(rs.getString("countryCode"));
        timezone.setCountryZone(rs.getString("countryZone"));
        timezone.setCountryCode(rs.getString("gmtOffset"));
        return timezone;
    }
}
