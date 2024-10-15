package org.anna.WorldClock;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class TimezoneController {

    private final TimezoneService timezoneService;

    public TimezoneController(TimezoneService timezoneService) {
        this.timezoneService = timezoneService;
    }

    @GetMapping("")
    public String getHome() {
       // timezoneRepository.createTable();
        return "welcome";
    }

    @GetMapping("/app")
    public String useApp(Model model) {
        timezoneService.loadDataToDatabase();
        model.addAttribute("currentDateTime", LocalDateTime.now());
        return "home";
    }

    @GetMapping("/farewell")
    public String leaveApp() {
        // timezoneRepository.createTable();

        return "farewell";
    }

    @GetMapping("/home")
    public String homeView() {
        // timezoneRepository.createTable();
        return "home";
    }

}
