package com.ajdi.yassin.popularmoviespart1.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by Yassin Ajdi.
 */
public class Movie {

    @SerializedName("id")
    private long id;

    @SerializedName("Title")
    private String Title;

    @SerializedName("Poster ")
    private String Poster;

    @SerializedName("Poster")
    private String Poster1;

    @SerializedName("backdrop_path")
    private String backdrop;

    @SerializedName("Plot")
    private String Plot;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("Rated")
    private String Rated;

    @SerializedName("Released")
    private String Released;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getImageUrl() {
        if (Poster1 == null)
        return Poster;
        else
            return Poster1;
    }

    public void setImageUrl(String imageUrl) {
        this.Poster = imageUrl;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getOverview() {
        return Plot;
    }

    public void setOverview(String overview) {
        this.Plot = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String  getUserRating() {
        return Rated;
    }

    public void setUserRating(String userRating) {
        this.Rated = userRating;
    }

    public String getReleaseDate() {
        return Released;
    }

    public void setReleaseDate(String releaseDate) {
        this.Released = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Double.compare(movie.popularity, popularity) == 0 &&
                Objects.equals(Rated, movie.Rated) &&
                Objects.equals(Title, movie.Title) &&
                Objects.equals(Poster, movie.Poster) &&
                Objects.equals(Plot, movie.Plot) &&
                Objects.equals(Released, movie.Released);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, Title, Poster, Plot, popularity, Rated, Released);
    }
}
