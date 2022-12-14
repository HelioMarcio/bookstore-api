package com.api.bookstore.dtos;

import java.io.Serializable;

import com.api.bookstore.domain.Livro;

public class LivroDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;

	public LivroDto() {
		super();
	}

	public LivroDto(Integer id, String titulo, String nomeAutor, String texto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
	}

	public LivroDto(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.nomeAutor = obj.getNomeAutor();
		this.texto = obj.getTexto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
