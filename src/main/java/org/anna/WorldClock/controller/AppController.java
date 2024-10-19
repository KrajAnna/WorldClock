package org.anna.WorldClock.controller;

import org.anna.WorldClock.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    private final TimeService timezoneService;

    public AppController(TimeService timezoneService) {
        this.timezoneService = timezoneService;
    }

    @GetMapping("")
    public String getHome() {
        return "welcome";
    }

    @GetMapping("/farewell")
    public String leaveApp() {
        return "farewell";
    }

    @GetMapping("/home")
    public String homeView() {
        return "home";
    }


}
