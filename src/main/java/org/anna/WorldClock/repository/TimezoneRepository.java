package org.anna.WorldClock.repository;

import org.anna.WorldClock.entity.Timezone;
import org.anna.WorldClock.util.Reader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TimezoneRepository {

    private final Reader reader = new Reader();

    private final JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERY = "INSERT INTO timezones(countryCode, countryZone, gmtOffset) VALUES (?, ?, ?)";
    private final String SELECT_ALL_QUERY = "SELECT * FROM timezones";
    private final String SELECT_QUERY = "SELECT * FROM timezones WHERE id = ? Limit 1";

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

        jdbcTemplate.batchUpdate(INSERT_QUERY, batchArgs);
    }

    public Timezone getTimezoneById(Long id){
        return jdbcTemplate.queryForObject(SELECT_QUERY, new Object[]{id}, new TimezoneRowMapper());
    }

    public List<Timezone> getAllTimezones(){
        List<Timezone> timezones = jdbcTemplate.query(SELECT_ALL_QUERY, new TimezoneRowMapper());
        timezones.forEach(System.out::println);
        return timezones;
    }








}
