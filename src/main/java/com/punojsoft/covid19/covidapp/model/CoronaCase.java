package com.punojsoft.covid19.covidapp.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CoronaCase {
    private String totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, serious,
            totCasePerOneMPop, deathsPerOneMPop, testPerOneMPop,
            population;
    private String totalTest;


}
