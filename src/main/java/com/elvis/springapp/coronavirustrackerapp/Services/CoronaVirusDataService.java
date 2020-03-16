package com.elvis.springapp.coronavirustrackerapp.Services;

import com.elvis.springapp.coronavirustrackerapp.Domain.VirusStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoronaVirusDataService {
    private static final String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
    private List<VirusStats> statsList =  new ArrayList<>();


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        List<VirusStats> stats = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DATA_URL))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader reader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        for (CSVRecord record : records){
            VirusStats virusStats = new VirusStats();
            virusStats.setCountry(record.get("Country/Region"));
            virusStats.setLatestCases(Integer.parseInt(record.get(record.size() - 1)));
            virusStats.setState(record.get("Province/State"));
            stats.add(virusStats);
        }
        this.statsList = stats;
    }

    public List<VirusStats> getStatsList() {
        return statsList;
    }

    public void setStatsList(List<VirusStats> statsList) {
        this.statsList = statsList;
    }
}
