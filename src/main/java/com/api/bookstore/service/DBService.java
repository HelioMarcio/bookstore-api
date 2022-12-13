package com.api.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bookstore.domain.Categoria;
import com.api.bookstore.domain.Livro;
import com.api.bookstore.repositories.CategoriaRepository;
import com.api.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ciência", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografia");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Fazendo um código limpo", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V.", "Livro de nerd engenheiro", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "Robert Martin", "As máquinas estão sem tempo", cat2);
		Livro l4 = new Livro(null, "The War of te Worlds", "H.G. Wells", "Livro da guerra dos mundos", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Livro do maninho robot", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
