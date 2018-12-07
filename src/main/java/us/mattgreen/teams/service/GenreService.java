package us.mattgreen.teams.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import us.mattgreen.teams.controllers.Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Service annotation tells spring that this class is a service
@Service
public class GenreService {
    private static Log log = LogFactory.getLog(GenreService.class);

    private List<Genre> genres = new ArrayList<>(Arrays.asList(
            new Genre("Action", "5-Awesome"),
            new Genre("Romantic Comedy", "2-lame"),
            new Genre("Horror", "3-meh"),
            new Genre("Musicals", "1-kill me now"),
            new Genre("Sci-Fi", "4-beam me up goodness")
    ));

    public List<Genre> getAllGenres() {
        return genres;
    }

    public Genre getGenre(String id) {
        // lambda expression
        // This line gets the genres list and turns it into a stream
        // "filter" will filter the stream
        // inside of "filter" is a lambda expression
        // you define the variable "t"
        // the arrow indicates a lambda expression, similar to a foreach
        // t.getGenreName() gets the name, .contains(id) checks if genreName contains "id"
        // .findFirst() returns the first match from contains
        // .get() gets the selected object
        log.debug("Getting genre by id: \"" + id + "\"");
        return genres.stream().filter(t -> t.getGenreName().contains(id)).findFirst().get();
    }

    public void addGenre(Genre genre) {
        log.debug("Adding genre: \"" + genre + "\"");
        genres.add(genre);
        log.trace("Genre \"" + genre + "\" added successfully.");
    }

    public void updateGenre(Genre genre, String id) {
        log.debug("Searching for genre by ID: \"" + id + "\"");
        for(int i = 0; i < genres.size() ;i++) {
            Genre g = genres.get(i);
            if (g.getGenreName().equals(id)) {
                log.debug("genre \"" +g.getGenreName() + "\" found. Updating to \"" + genre + "\"");
                genres.set(i, genre);
                log.trace("Genre with id \"" + id + "\" updated successfully");
                return;
            }
        }
    }

    public void deleteGenre(String id) {
        log.debug("Deleting genre id " + id + "\" ...");
        genres.removeIf(g -> g.getGenreName().equals(id));
        log.debug(id + " deleted successfully.");
    }
}
