package com.carloscarvalho.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloscarvalho.workshopmongo.domain.Post;
import com.carloscarvalho.workshopmongo.repository.PostRepository;
import com.carloscarvalho.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {

		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date min, Date max) {
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repo.FullSearch(text, min, max);
	}

}
