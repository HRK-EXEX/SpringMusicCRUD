package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Music;
import com.example.demo.form.MusicForm;
import com.example.demo.service.MusicService;

@Controller
public class MainViewer {
	@Autowired
	MusicService mus;
	
	@GetMapping("")
	public String mainView() {
		return "index";
	}
	
	@PostMapping(value="music", params="select")
	public String selectView(Model m) {
		Iterable<Music> musics = mus.findAll();
		m.addAttribute("musics", musics);
		return "select";
	}

	@PostMapping(value="music", params="insert")
	public String insertView() {
		return "insert";
	}
	
	@PostMapping("insert-confirm")
	public String insertConfirmView(MusicForm mf) {
		return "insert-confirm";
	}
	
	@PostMapping("insert-done")
	public String insertDoneView(MusicForm mf) {
		Music m = new Music(null, mf.getSongName(), mf.getSinger());
		mus.insertMusic(m);
		return "insert-done";
	}
	
	@PostMapping(value="music", params="update")
	public String updateView(Model m) {
		Iterable<Music> musics = mus.findAll();
		m.addAttribute("musics", musics);
		return "update";
	}
	
	@PostMapping("update-input")
	public String updateInputView(MusicForm mf, Model m) {
		Optional<Music> music = mus.find(mf.getSongId());
		if (music.isPresent()) {
			Music update = music.get();
			m.addAttribute("music", update);
		}
		return "update-input";
	}
	
	@PostMapping("update-confirm")
	public String updateConfirmView(MusicForm mf, Model m) {
		Optional<Music> music = mus.find(mf.getSongId());
		if (music.isPresent()) {
			Music update = music.get();
			m.addAttribute("musicOld", update);
		}
		return "update-confirm";
	}
	
	@PostMapping("update-done")
	public String updateDoneView(MusicForm mf) {
		Music m = new Music(mf.getSongId(), mf.getSongName(), mf.getSinger());
		//System.out.printf("ID: %d, Name: %s, Singer: %s", m.getSongId(), m.getSongName(), m.getSinger());
		mus.insertMusic(m); // INSERT BECOMES UPDATE
		return "update-done";
	}
	
	@PostMapping(value="music", params="delete")
	public String deleteView(Model m) {
		Iterable<Music> musics = mus.findAll();
		m.addAttribute("musics", musics);
		return "delete";
	}
	
	@PostMapping("delete-confirm")
	public String deleteConfirmView(MusicForm mf, Model m) {
		Optional<Music> music = mus.find(mf.getSongId());
		if (music.isPresent()) {
			Music update = music.get();
			m.addAttribute("music", update);
		}
		return "delete-confirm";
	}
	
	@PostMapping("delete-done")
	public String deleteDoneView(MusicForm mf) {
		//System.out.printf("ID: %d, Name: %s, Singer: %s", m.getSongId(), m.getSongName(), m.getSinger());
		mus.deleteMusic(mf.getSongId()); // INSERT BECOMES UPDATE
		return "delete-done";
	}
 }
