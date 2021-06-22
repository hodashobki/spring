package com.Hoda.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Hoda.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify,Long>{
	List<Lookify> findAll();
//	List<User> findFirst10ByUsername(String username);
	List<Lookify> findTop10ByOrderByRatingDesc();
	List<Lookify> findByArtistContaining(String artist);
	List<Lookify> findByTitleContaining(String title);
}
