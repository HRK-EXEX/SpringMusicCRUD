package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Music;
import com.example.demo.repo.MusicCrudRepository;

@Service
public class MusicServiceImplement implements MusicService{
	@Autowired
	MusicCrudRepository mus;
	
	@Override
	public Iterable<Music> findAll() {
		// TODO Auto-generated method stub
		return mus.findAll();
	}

	@Override
	public void insertMusic(Music m) {
		// TODO Auto-generated method stub
		mus.save(m);
	}
}
