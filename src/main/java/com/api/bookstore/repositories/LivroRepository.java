package com.api.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	/*
	 * @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo"
	 * ) List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);
	 */

}
