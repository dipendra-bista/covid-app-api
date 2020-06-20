package com.punojsoft.covid19.covidapp.controller;

import com.punojsoft.covid19.covidapp.model.CoronaCase;
import com.punojsoft.covid19.covidapp.util.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/world")
public class CovidWorldController {
    @Autowired
    private ScraperService scraperService;

    @GetMapping("/current-case")
    public List<CoronaCase> getCoronaCaseDetails() throws IOException {
        return scraperService.getCoronaCaseDetailsFroWorld("https://www.worldometers.info/coronavirus/");
    }
}
