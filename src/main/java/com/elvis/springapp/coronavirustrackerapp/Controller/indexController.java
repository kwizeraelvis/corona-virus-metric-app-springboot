package com.elvis.springapp.coronavirustrackerapp.Controller;

import com.elvis.springapp.coronavirustrackerapp.Services.CoronaVirusDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    private final CoronaVirusDataService coronaVirusDataService;

    public indexController(CoronaVirusDataService coronaVirusDataService) {
        this.coronaVirusDataService = coronaVirusDataService;
    }

    @RequestMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("locationStatistics", coronaVirusDataService.getStatsList());
        return "index";
    }

}
