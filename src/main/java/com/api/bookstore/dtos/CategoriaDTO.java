package com.api.bookstore.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.api.bookstore.domain.Categoria;
import com.api.bookstore.domain.Livro;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;

	private List<LivroDto> livros = new ArrayList<>();

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public CategoriaDTO(Categoria obj, List<Livro> livros) {
		this(obj);
		livros.forEach(cat -> this.livros.add(new LivroDto(cat)));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<LivroDto> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroDto> livros) {
		this.livros = livros;
	}
}
