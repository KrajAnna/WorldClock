package org.anna.WorldClock;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TimezoneRepository {

    private final Reader reader = new Reader();

    private final JdbcTemplate jdbcTemplate;

    public TimezoneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(){
        jdbcTemplate.execute("DROP TABLE IF EXISTS timezones");
        jdbcTemplate.execute("CREATE TABLE timezones (" +
                "id int primary key auto_increment," +
                "countryCode VARCHAR(3)," +
                "countryZone VARCHAR(50)," +
                "gmtOffset float)");
    }

    public void loadData() {
        List<Object[]> batchArgs = reader.readFile()
                .stream()
                .map(t -> new Object[] { t.getCountryCode(),t.getCountryZone(),t.getGmtOffset()})
                .collect(Collectors.toList());

        jdbcTemplate.batchUpdate(
                "INSERT INTO timezones(countryCode, countryZone, gmtOffset) VALUES (?, ?, ?)",
                batchArgs
        );
    }








}
