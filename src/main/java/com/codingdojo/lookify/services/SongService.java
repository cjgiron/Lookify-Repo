package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
        return songRepository.findAll();
    }
	
	public List<Song> topTenSongs() {
		
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> searchArtist(String search) {
		return songRepository.findByArtistContaining(search);
	}
	
	public Song createSong(Song s) {
        return songRepository.save(s);
    }
	
	public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
	
	public Song updateSong(Long id, String title, String artist, Integer rating) {
		Song s = this.findSong(id);
		
		s.setId(id);
		s.setTitle(title);
		s.setArtist(artist);
		s.setRating(rating);
	
		return songRepository.save(s);
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
}
