package com.sportyshoes.service;

import java.util.List;

import com.sportyshoes.model.Shoe;

public interface SportyShoesService {

	Shoe addShoes(Shoe shoe);

	Shoe getShoeById(Long id);

	void deleteShoe(Long id);

	Shoe updateShoe(Shoe shoe, Long id);

	List<Shoe> getAllShoes();

}
