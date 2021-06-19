package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;


@Controller
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "/songs/home.jsp";
	}
	
	@RequestMapping("/songs")
	public String index(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/songs/index.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.topTenSongs();
		model.addAttribute("songs", songs);
		return "/songs/topTen.jsp";
	}
	
	@RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";
    }
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/songs";
		}
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.GET)
    public String show(Model model, @PathVariable("id") Long id) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/songs/show.jsp";
    }
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String artistSearch(Model model, @RequestParam(value="artist") String artist) {
		List<Song> songs = songService.searchArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "/songs/search.jsp";
		
	}

	
	
	@RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/songs/edit.jsp";
    }
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/edit.jsp";
        } else {
            songService.updateSong(song.getId(), song.getTitle(), song.getArtist(), song.getRating());
            return "redirect:/songs";
        }
    }
	
	@RequestMapping(value="/songs/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}
