package com.bhaumik.yahooweatherpoc.model.query.result;

import com.bhaumik.yahooweatherpoc.model.query.result.channel.Astronomy;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Atmosphere;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Location;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Unit;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Weather;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Wind;

/**
 * Created by bhaumik on 9/27/17.
 */

public class Channel {

    private String title;
    private String link;
    private String description;
    private String language;
    private String lastBuildDate;
    private String ttl;

    private Unit units;
    private Location location;
    private Wind wind;
    private Atmosphere atmosphere;
    private Astronomy astronomy;
    private Weather item;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public Unit getUnits() {
        return units;
    }

    public void setUnits(Unit units) {
        this.units = units;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public Weather getItem() {
        return item;
    }

    public void setItem(Weather item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", ttl='" + ttl + '\'' +
                ", units=" + units +
                ", location=" + location +
                ", wind=" + wind +
                ", atmosphere=" + atmosphere +
                ", astronomy=" + astronomy +
                ", item=" + item +
                '}';
    }
}
