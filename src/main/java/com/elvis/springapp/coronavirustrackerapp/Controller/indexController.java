package com.elvis.springapp.coronavirustrackerapp.Controller;

import com.elvis.springapp.coronavirustrackerapp.Domain.VirusStats;
import com.elvis.springapp.coronavirustrackerapp.Services.CoronaVirusDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class indexController {

    private final CoronaVirusDataService coronaVirusDataService;

    public indexController(CoronaVirusDataService coronaVirusDataService) {
        this.coronaVirusDataService = coronaVirusDataService;
    }

    @RequestMapping({"/", "/index"})
    public String index(Model model){
        List<VirusStats> stats = coronaVirusDataService.getStatsList();
        int TotalCases = stats
                .stream()
                .mapToInt(VirusStats::getLatestCases)
                .sum();
        model.addAttribute("locationStatistics", coronaVirusDataService.getStatsList());
        model.addAttribute("TotalCases", TotalCases);
        return "index";
    }

}
