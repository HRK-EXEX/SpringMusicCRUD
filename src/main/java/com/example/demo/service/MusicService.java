package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Music;

public interface MusicService {
	Iterable<Music> findAll();
	Optional<Music> find(Integer id);
	void insertMusic(Music mus);
	void deleteMusic(Integer id);
}
