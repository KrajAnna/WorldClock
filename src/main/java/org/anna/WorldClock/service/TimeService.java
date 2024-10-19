package org.anna.WorldClock.service;

import org.anna.WorldClock.entity.Timezone;
import org.anna.WorldClock.repository.TimezoneRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class TimeService {

    private final TimezoneRepository timezoneRepository;

    public TimeService(TimezoneRepository timezoneRepository) {
        this.timezoneRepository = timezoneRepository;
    }

    public void loadDataToDatabase() {
        timezoneRepository.createTable();
        timezoneRepository.loadData();
    }

    public ZonedDateTime getCurrentUtcTime() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }

    public Timezone getTimeById(Long id) {
        return timezoneRepository.getTimezoneById(id);
    }

    public List<Timezone> getAllTimezones() {
        return timezoneRepository.getAllTimezones();
    }

}

