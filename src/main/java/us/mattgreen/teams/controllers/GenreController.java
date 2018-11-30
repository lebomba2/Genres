package us.mattgreen.teams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.mattgreen.teams.service.GenreService;

import java.util.List;

// This is all it takes to define a REST controller
@RestController
public class GenreController {

    // Autowired automatically injects dependencies (beans)
    // These two lines, the annotation and the declaration,
    // are all it takes to import the bean (genreService)
    @Autowired
    private GenreService genreService;

    // RequestMapping maps this to the path "/Genres"
    @RequestMapping("/Genres")
    public List<Genre> getGenres() {
        return genreService.getAllGenres();
    }

    // RequestMapping maps this to the path "/Genres/{id}"
    @RequestMapping("/Genres/{id}")
    public Genre getGenre(@PathVariable String id) {
        return genreService.getGenre(id);
    }

    // RequestMapping redirects this to the path "/Genres" and sets the method to POST
    @RequestMapping(method=RequestMethod.POST, value="/Genres")
    public void addGenre(@RequestBody Genre genre) {
        genreService.addGenre(genre);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/Genres/{id}")
    public void updateGenre(@RequestBody Genre genre, @PathVariable String id) {
        genreService.updateGenre(genre, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/Genres/{id}")
    public void deleteGenre(@PathVariable String id) {
        genreService.deleteGenre(id);
    }
}
