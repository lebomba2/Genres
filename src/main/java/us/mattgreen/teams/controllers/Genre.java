package us.mattgreen.teams.controllers;

public class Genre {
    private String genreName;
    private String rating;

    public Genre(String genreName, String rating) {
        this.genreName = genreName;
        this.rating = rating;
    }

    public Genre() {
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
