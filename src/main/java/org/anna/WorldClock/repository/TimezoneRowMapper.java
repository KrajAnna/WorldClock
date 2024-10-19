package org.anna.WorldClock.repository;

import org.anna.WorldClock.entity.Timezone;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimezoneRowMapper implements RowMapper<Timezone> {
    @Override
    public Timezone mapRow(ResultSet rs, int rowNum) throws SQLException {
        Timezone timezone = new Timezone();
        timezone.setCountryCode(rs.getString("countryCode"));
        timezone.setCountryZone(rs.getString("countryZone"));
        timezone.setGmtOffset(rs.getFloat("gmtOffset"));
        timezone.setId(rs.getInt("id"));
        return timezone;
    }
}
