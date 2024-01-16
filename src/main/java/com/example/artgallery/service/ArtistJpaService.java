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
public class ArtistJpaService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist getArtistById(int artistId) {
        return artistRepository.findById(artistId).orElse(null);
    }

    public Artist updateArtist(int artistId, Artist updatedArtist) {
        Artist existingArtist = artistRepository.findById(artistId).orElse(null);
        if (existingArtist != null) {
            existingArtist.setArtistName(updatedArtist.getArtistName());
            existingArtist.setGenre(updatedArtist.getGenre());
            existingArtist.setGalleries(updatedArtist.getGalleries());
            return artistRepository.save(existingArtist);
        }
        return null;
    }

    public void deleteArtist(int artistId) {
        artistRepository.deleteById(artistId);
    }

    public List<Art> getArtistArts(int artistId) {
        Artist artist = artistRepository.findById(artistId).orElse(null);
        return (artist != null) ? artist.getArts() : null;
    }

    public List<Gallery> getArtistGalleries(int artistId) {
        Artist artist = artistRepository.findById(artistId).orElse(null);
        return (artist != null) ? artist.getGalleries() : null;
    }

}
