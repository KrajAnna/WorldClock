package org.anna.WorldClock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimezoneController {

    private final TimezoneRepository timezoneRepository;

    public TimezoneController(TimezoneRepository timezoneRepository) {
        this.timezoneRepository = timezoneRepository;
    }

    @GetMapping("")
    @ResponseBody
    public String getHome() {
        timezoneRepository.createTable();
        return "Elo";
    }

}
