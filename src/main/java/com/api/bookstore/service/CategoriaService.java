package com.api.bookstore.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.bookstore.domain.Categoria;
import com.api.bookstore.dtos.CategoriaDTO;
import com.api.bookstore.repositories.CategoriaRepository;
import com.api.bookstore.service.exception.DataViolationException;
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
		return new CategoriaDTO(entity, entity.getLivros());
	}

	@Transactional(readOnly = true)
	public Page<CategoriaDTO> findAllPaged(PageRequest pageRequest) {
		Page<Categoria> list = repository.findAll(pageRequest);
		return list.map(obj -> new CategoriaDTO(obj));
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

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " + Categoria.class.getName());
		} catch (DataIntegrityViolationException e) {
			throw new DataViolationException("Objeto não pode ser removido. Possui items associados.");
		}

	}

}
