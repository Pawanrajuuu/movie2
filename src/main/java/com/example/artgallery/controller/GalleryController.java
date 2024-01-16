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
@RequestMapping("/galleries")
public class GalleryController {

    @Autowired
    private GalleryJpaService galleryJpaService;

    @GetMapping
    public List<Gallery> getAllGalleries() {
        return galleryJpaService.getAllGalleries();
    }

    @PostMapping
    public Gallery createGallery(@RequestBody Gallery gallery) {
        return galleryJpaService.createGallery(gallery);
    }

    @GetMapping("/{galleryId}")
    public Gallery getGalleryById(@PathVariable int galleryId) {
        return galleryJpaService.getGalleryById(galleryId);
    }

    @PutMapping("/{galleryId}")
    public Gallery updateGallery(@PathVariable int galleryId, @RequestBody Gallery gallery) {
        return galleryJpaService.updateGallery(galleryId, gallery);
    }

    @DeleteMapping("/{galleryId}")
    public void deleteGallery(@PathVariable int galleryId) {
        galleryJpaService.deleteGallery(galleryId);
    }

    @GetMapping("/{galleryId}/artists")
    public List<Artist> getGalleryArtists(@PathVariable int galleryId) {
        return galleryJpaService.getGalleryArtists(galleryId);
    }

    @GetMapping("/artists")
    public List<Artist> getAllArtistsInGalleries() {
        return galleryJpaService.getAllArtistsInGalleries(
