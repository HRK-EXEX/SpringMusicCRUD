package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Music;

public interface MusicCrudRepository extends CrudRepository<Music, Integer>{
	
}
