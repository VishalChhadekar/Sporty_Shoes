package com.sportyshoes.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

import com.sportyshoes.exceptions.ShoeNotPresentException;
import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.Shoe;
import com.sportyshoes.model.User;
import com.sportyshoes.service.PurchaseReportService;
import com.sportyshoes.service.SportyShoesService;
import com.sportyshoes.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SportyShoesService shoeService;

	@Autowired
	private UserService uService;

	@Autowired
	private PurchaseReportService purchaseReportService;

	// ADD SHOE
	@PostMapping("/shoe")
	public ResponseEntity<Shoe> adminShoe(@RequestBody Shoe shoe) throws Exception {
		return new ResponseEntity<Shoe>(shoeService.addShoes(shoe), HttpStatus.OK);
	}

	// GET SHOE BY ID
	@GetMapping("/shoe/{id}")
	public Shoe getShoeById(@PathVariable Long id) throws Exception {
		Shoe shoe = shoeService.getShoeById(id);
		if (Objects.isNull(shoe)) {
			throw new ShoeNotPresentException();
		}
		return shoe;
	}

	// DELETE SHOE
	@DeleteMapping("/shoe/{id}")
	public String deleteShoe(@PathVariable Long id) throws Exception {
		shoeService.deleteShoe(id);
		return "Shoe deleted Successfully";
	}

	// UPDATE SHOE
	@PutMapping("/shoe/{id}")
	public Shoe updateShoe(@RequestBody Shoe shoe, @PathVariable Long id) throws Exception {
		return shoeService.updateShoe(shoe, id);
	}

	// LIST OF ALL SHOES
	@GetMapping("/shoes")
	public List<Shoe> getAllShoes() throws Exception {
		return shoeService.getAllShoes();
	}

	// LIST OF ALL USERS
	@GetMapping("/users")
	public List<User> getAllUser() throws Exception {
		return uService.getAllUser();
	}

	// LIST OF ALL PRs
	@GetMapping("/purchasereports")
	public List<PurchaseReport> getAllPR() throws Exception {
		return purchaseReportService.getAllPR();
	}

	// LIST OF ALL PRs BY CATEGORY
	@GetMapping("/purchasereports/{category}")
	public List<PurchaseReport> getAllPRByCategory(@PathVariable String category) throws Exception {
		return purchaseReportService.getAllPRByCategory(category);
	}

	// LIST OF ALL PRs BY DOP
	@GetMapping("/purchasereports/date/{dateInMs}")
	public List<PurchaseReport> getAllPRByDop(@PathVariable Long dateInMs) throws Exception {
		Date date = new Date(dateInMs);
		return purchaseReportService.getAllPRByDop(date);
	}

}
