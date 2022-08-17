package com.sportyshoes.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Shoe;
import com.sportyshoes.repository.ShoeRepository;

@Service
public class ShoeServiceImp implements SportyShoesService {

	@Autowired
	private ShoeRepository shoeRepository;

	@Override
	public Shoe addShoes(Shoe shoe) {
		return shoeRepository.save(shoe);
	}

	@Override
	public Shoe getShoeById(Long id) {
		return shoeRepository.findById(id).get();
	}

	@Override
	public void deleteShoe(Long id) {
		shoeRepository.deleteById(id);
	}

	@Override
	public Shoe updateShoe(Shoe shoe, Long id) {
		Shoe existingShoe = shoeRepository.findById(id).get();
		if (Objects.nonNull(shoe.getCategory())) {
			existingShoe.setCategory(shoe.getCategory());
		}
		if (Objects.nonNull(shoe.getShoeName())) {
			existingShoe.setShoeName(shoe.getShoeName());
		}
		if (Objects.nonNull(shoe.getPrice())) {
			existingShoe.setPrice(shoe.getPrice());
		}
		return shoeRepository.save(existingShoe);
	}

	@Override
	public List<Shoe> getAllShoes() {
		return shoeRepository.findAll();
	}

}
