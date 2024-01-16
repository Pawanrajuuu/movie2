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
@RequestMapping("/arts")
public class ArtController {

    @Autowired
    private ArtJpaService artJpaService;

    @GetMapping
    public List<Art> getAllArts() {
        return artJpaService.getAllArts();
    }

    @PostMapping
    public Art createArt(@RequestBody Art art) {
        return artJpaService.createArt(art);
    }

    @GetMapping("/{artId}")
    public Art getArtById(@PathVariable int artId) {
        return artJpaService.getArtById(artId);
    }

    @PutMapping("/{artId}")
    public Art updateArt(@PathVariable int artId, @RequestBody Art art) {
        return artJpaService.updateArt(artId, art);
    }

    @DeleteMapping("/{artId}")
    public void deleteArt(@PathVariable int artId) {
        artJpaService.deleteArt(artId);
    }

    @GetMapping("/{artId}/artist")
    public Artist getArtistForArt(@PathVariable int artId) {
        return artJpaService.getArtistForArt(artId);
    }
}
