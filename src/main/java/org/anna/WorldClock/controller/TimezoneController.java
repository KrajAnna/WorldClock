package org.anna.WorldClock.controller;

import org.anna.WorldClock.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
@RequestMapping("/app")
@Controller
public class TimezoneController {

    private final TimeService timezoneService;

    public TimezoneController(TimeService timezoneService) {
        this.timezoneService = timezoneService;
    }


    @GetMapping("")
    public String useApp(Model model) {
        timezoneService.loadDataToDatabase();
        model.addAttribute("utcTime", timezoneService.getCurrentUtcTime());
        model.addAttribute("timezones", timezoneService.getAllTimezones());
        return "home";
    }

    @GetMapping("/{id}")
    public String showInfo(@PathVariable Long id, Model model) {
        model.addAttribute("time", timezoneService.getTimeById(id));
        return "time";
    }


}
