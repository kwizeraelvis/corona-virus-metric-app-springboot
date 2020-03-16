package com.elvis.springapp.coronavirustrackerapp.Domain;

public class VirusStats {
    private String state;
    private String country;
    private int latestCases;
    private int DeltaDiffrence;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestCases() {
        return latestCases;
    }

    public void setLatestCases(int latestCases) {
        this.latestCases = latestCases;
    }

    public int getDeltaDiffrence() {
        return DeltaDiffrence;
    }

    public void setDeltaDiffrence(int deltaDiffrence) {
        DeltaDiffrence = deltaDiffrence;
    }
}
