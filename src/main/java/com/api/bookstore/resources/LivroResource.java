package com.api.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.bookstore.dtos.LivroDto;
import com.api.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
		LivroDto dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<Page<LivroDto>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "titulo") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<LivroDto> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	/*@GetMapping
	public ResponseEntity<List<LivroDto>> findAll(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Livro> list = service.findAll(id_cat);
		List<LivroDto> listDto = list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}*/
}
