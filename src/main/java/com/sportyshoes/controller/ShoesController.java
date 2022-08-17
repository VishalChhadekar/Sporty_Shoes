package com.sportyshoes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Shoe;
import com.sportyshoes.service.SportyShoesService;

@RestController
@RequestMapping("/admin")
public class ShoesController {

	@Autowired
	private SportyShoesService shoeService;

	// ADD SHOE
	@PostMapping("/shoe")
	public ResponseEntity<Shoe> adminHome(@RequestBody Shoe shoe) {
		return new ResponseEntity<Shoe>(shoeService.addShoes(shoe), HttpStatus.OK);
	}

	// GET SHOE BY ID
	@GetMapping("/shoe/{id}")
	public Shoe getShoeById(@PathVariable Long id) {
		return shoeService.getShoeById(id);
	}

	// DELETE SHOE
	@DeleteMapping("/shoe/{id}")
	public String deleteShoe(@PathVariable Long id) {
		shoeService.deleteShoe(id);
		return "Shoe deleted Successfully";
	}

	// UPDATE SHOE
	@PutMapping("/shoe/{id}")
	public Shoe updateShoe(@RequestBody Shoe shoe, @PathVariable Long id) {
		return shoeService.updateShoe(shoe, id);
	}

}
