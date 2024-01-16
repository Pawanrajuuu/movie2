/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.*;
 *
 */

// Write your code here
package com.example.artgallery.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class GalleryJpaService {

    @Autowired
    private GalleryRepository galleryRepository;

    public List<Gallery> getAllGalleries() {
        return galleryRepository.findAll();
    }

    public Gallery createGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public Gallery getGalleryById(int galleryId) {
        return galleryRepository.findById(galleryId).orElse(null);
    }

    public Gallery updateGallery(int galleryId, Gallery updatedGallery) {
        Gallery existingGallery = galleryRepository.findById(galleryId).orElse(null);
        if (existingGallery != null) {
            existingGallery.setGalleryName(updatedGallery.getGalleryName());
            existingGallery.setLocation(updatedGallery.getLocation());
            existingGallery.setArtists(updatedGallery.getArtists());
            return galleryRepository.save(existingGallery);
        }
        return null;
    }

    public void deleteGallery(int galleryId) {
        galleryRepository.deleteById(galleryId);
    }

    public List<Artist> getGalleryArtists(int galleryId) {
        Gallery gallery = galleryRepository.findById(galleryId).orElse(null);
        return (gallery != null) ? gallery.getArtists() : null;
    }

    public List<Artist> getAllArtistsInGalleries() {
        return galleryRepository.findAllArtistsInGalleries();
    }

    public void addArtistToGallery(int galleryId, int artistId) {
        galleryRepository.addArtistToGallery(galleryId, artistId);
    }

    
}
