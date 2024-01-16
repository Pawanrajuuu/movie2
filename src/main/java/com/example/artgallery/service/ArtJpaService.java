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
public class ArtJpaService {

    @Autowired
    private ArtRepository artRepository;

    public List<Art> getAllArts() {
        return artRepository.findAll();
    }

    public Art createArt(Art art) {
        return artRepository.save(art);
    }

    public Art getArtById(int artId) {
        return artRepository.findById(artId).orElse(null);
    }

    public Art updateArt(int artId, Art updatedArt) {
        Art existingArt = artRepository.findById(artId).orElse(null);
        if (existingArt != null) {
            existingArt.setArtTitle(updatedArt.getArtTitle());
            existingArt.setTheme(updatedArt.getTheme());
            existingArt.setArtist(updatedArt.getArtist());
            return artRepository.save(existingArt);
        }
        return null;
    }

    public void deleteArt(int artId) {
        artRepository.deleteById(artId);
    }

    public Artist getArtistForArt(int artId) {
        Art art = artRepository.findById(artId).orElse(null);
        return (art != null) ? art.getArtist() : null;
    }

}
