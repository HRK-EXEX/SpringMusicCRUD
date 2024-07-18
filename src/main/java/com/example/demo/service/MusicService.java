package com.example.demo.service;

import com.example.demo.entity.Music;

public interface MusicService {
	Iterable<Music> findAll();
	void insertMusic(Music mus);
}
