package com.api.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.bookstore.domain.Livro;
import com.api.bookstore.dtos.LivroDto;
import com.api.bookstore.repositories.LivroRepository;
import com.api.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Transactional(readOnly = true)
	public LivroDto findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		Livro entity = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	    return new LivroDto(entity);
	}
}
