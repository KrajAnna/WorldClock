package org.anna.WorldClock;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TimezoneService {

    private final TimezoneRepository timezoneRepository;

    public TimezoneService(TimezoneRepository timezoneRepository) {
        this.timezoneRepository = timezoneRepository;
    }

    public void loadDataToDatabase() {
        timezoneRepository.createTable();
        timezoneRepository.loadData();
    }

}

