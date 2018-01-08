package com.example.thrane.have_i_watched_it;

/**
 * Created by Thrane on 25-07-2017.
 */

public class Episode {
    public int id;
    public String name;
    public int season;
    public int episode;


    Episode(int id, String name, int season, int episode)
    {
        this.name = name;
        this.season = season;
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }
}

