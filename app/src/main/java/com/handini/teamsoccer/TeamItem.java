package com.handini.teamsoccer;

public class TeamItem {
    String strTeam, strAlternate,strLeague,strManager, strStadium,strStadiumThumb,strStadiumDescription,strDescriptionEN,strTeamBadge;

    public TeamItem(String strTeam, String strAlternate, String strLeague, String strManager, String strStadium, String strStadiumThumb, String strStadiumDescription, String strDescriptionEN, String strTeamBadge) {
        this.strTeam = strTeam;
        this.strAlternate = strAlternate;
        this.strLeague = strLeague;
        this.strManager = strManager;
        this.strStadium = strStadium;
        this.strStadiumThumb = strStadiumThumb;
        this.strStadiumDescription = strStadiumDescription;
        this.strDescriptionEN = strDescriptionEN;
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrManager() {
        return strManager;
    }

    public void setStrManager(String strManager) {
        this.strManager = strManager;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }
    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }
}