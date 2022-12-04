package com.api.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.bookstore.domain.Categoria;
import com.api.bookstore.dtos.CategoriaDTO;
import com.api.bookstore.repositories.CategoriaRepository;
import com.api.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Transactional(readOnly = true)
	public CategoriaDTO findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		Categoria entity = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		return new CategoriaDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<CategoriaDTO> findAll() {
		List<Categoria> list = repository.findAll();
		return list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	}

	@Transactional
	public CategoriaDTO create(CategoriaDTO dto) {
		Categoria obj = new Categoria();
		obj.setNome(dto.getNome());
		obj.setDescricao(dto.getDescricao());
		obj = repository.save(obj);
		return new CategoriaDTO(obj);
	}

	@Transactional
	public CategoriaDTO update(Integer id, CategoriaDTO objDto) {
		try {
			Categoria obj = repository.getReferenceById(id);
			obj.setNome(objDto.getNome());
			obj.setDescricao(objDto.getDescricao());
			obj = repository.save(obj);
			return new CategoriaDTO(obj);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " + Categoria.class.getName());
		}
	}
}
