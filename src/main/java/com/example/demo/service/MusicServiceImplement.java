package com.example.demo.service;

import java.util.Optional;

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
	public Optional<Music> find(Integer id) {
		// TODO Auto-generated method stub
		return mus.findById(id);
	}

	@Override
	public void insertMusic(Music m) {
		// TODO Auto-generated method stub
		mus.save(m);
	}

	@Override
	public void deleteMusic(Integer id) {
		// TODO Auto-generated method stub
		mus.deleteById(id);
	}
}
