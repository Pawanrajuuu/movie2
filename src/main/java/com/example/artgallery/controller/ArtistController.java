/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.artgallery.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistJpaService artistJpaService;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistJpaService.getAllArtists();
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistJpaService.createArtist(artist);
    }

    @GetMapping("/{artistId}")
    public Artist getArtistById(@PathVariable int artistId) {
        return artistJpaService.getArtistById(artistId);
    }

    @PutMapping("/{artistId}")
    public Artist updateArtist(@PathVariable int artistId, @RequestBody Artist artist) {
        return artistJpaService.updateArtist(artistId, artist);
    }

    @DeleteMapping("/{artistId}")
    public void deleteArtist(@PathVariable int artistId) {
        artistJpaService.deleteArtist(artistId);
    }

    @GetMapping("/{artistId}/arts")
    public List<Art> getArtistArts(@PathVariable int artistId) {
        return artistJpaService.getArtistArts(artistId);
    }

    @GetMapping("/{artistId}/galleries")
    public List<Gallery> getArtistGalleries(@PathVariable int artistId) {
        return artistJpaService.getArtistGalleries(artistId);
    }
}
