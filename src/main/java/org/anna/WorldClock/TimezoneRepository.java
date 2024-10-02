package org.anna.WorldClock;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimezoneRepository {


    private final JdbcTemplate jdbcTemplate;

    public TimezoneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(){
        jdbcTemplate.execute("DROP TABLE IF EXISTS timezones");
        jdbcTemplate.execute("CREATE TABLE timezone (" +
                "id int primary key auto_increment," +
                "countryCode VARCHAR(3)," +
                "gmtOffset float)");
    }







}
