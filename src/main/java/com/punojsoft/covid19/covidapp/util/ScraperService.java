package com.punojsoft.covid19.covidapp.util;

import com.punojsoft.covid19.covidapp.model.CoronaCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScraperService {


    public List<CoronaCase> getCoronaCaseDetailsForNepal(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("tbody tr");
        List<CoronaCase> coronaCases = new ArrayList<>();
        for (Element element : elements) {
            if (element.select("a[href='country/nepal/']").text().equals("Nepal")) {
                CoronaCase coronaCase = new CoronaCase();
                coronaCase.setTotalCases(element.select("td:nth-of-type(3)").text());
                coronaCase.setNewCases(element.select("td:nth-of-type(4)").text());
                coronaCase.setTotalDeaths(element.select("td:nth-of-type(5)").text());
                coronaCase.setNewDeaths(element.select("td:nth-of-type(6)").text());
                coronaCase.setTotalRecovered(element.select("td:nth-of-type(7)").text());
                coronaCase.setActiveCases(element.select("td:nth-of-type(8)").text());
                coronaCase.setSerious(element.select("td:nth-of-type(9)").text());
                coronaCase.setTotCasePerOneMPop(element.select("td:nth-of-type(10)").text());
                coronaCase.setDeathsPerOneMPop(element.select("td:nth-of-type(11)").text());
                coronaCase.setTotalTest(element.select("td:nth-of-type(13)").text());
                coronaCase.setTestPerOneMPop(element.select("td:nth-of-type(14)").text());
                coronaCase.setPopulation(element.select("td:nth-of-type(15)").text());
                coronaCases.add(coronaCase);
            }
        }
        return coronaCases;
    }

    public List<CoronaCase> getCoronaCaseDetailsFroWorld(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select(".total_row_body .total_row");
        List<CoronaCase> coronaCases = new ArrayList<>();
        elements.forEach(element -> {
            System.out.println(element);
            CoronaCase coronaCase = new CoronaCase();
            coronaCase.setTotalCases(element.select("td:nth-of-type(3)").text());
            coronaCase.setNewCases(element.select("td:nth-of-type(4)").text());
            coronaCase.setTotalDeaths(element.select("td:nth-of-type(5)").text());
            coronaCase.setNewDeaths(element.select("td:nth-of-type(6)").text());
            coronaCase.setTotalRecovered(element.select("td:nth-of-type(7)").text());
            coronaCase.setActiveCases(element.select("td:nth-of-type(8)").text());
            coronaCase.setSerious(element.select("td:nth-of-type(9)").text());
            coronaCase.setTotCasePerOneMPop(element.select("td:nth-of-type(10)").text());
            coronaCase.setDeathsPerOneMPop(element.select("td:nth-of-type(11)").text());
            coronaCase.setTotalTest(element.select("td:nth-of-type(13)").text());
            coronaCase.setTestPerOneMPop(element.select("td:nth-of-type(14)").text());
            coronaCase.setPopulation(element.select("td:nth-of-type(15)").text());
            coronaCases.add(coronaCase);

        });
        return coronaCases;
    }
}
