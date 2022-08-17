package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.Shoe;
import com.sportyshoes.model.User;
import com.sportyshoes.service.PurchaseReportService;
import com.sportyshoes.service.SportyShoesService;
import com.sportyshoes.service.UserService;

@RestController
public class SearchController {

	@Autowired
	private SportyShoesService shoeService;

	@Autowired
	private UserService uService;

	@Autowired
	private PurchaseReportService purchaseReportService;

	// LIST OF ALL SHOES
	@GetMapping("/shoes")
	public List<Shoe> getAllShoes() {
		return shoeService.getAllShoes();
	}

	// LIST OF ALL USERS
	@GetMapping("/users")
	public List<User> getAllUser() {
		return uService.getAllUser();
	}

	// LIST OF ALL PRs
	@GetMapping("/purchasereports")
	public List<PurchaseReport> getAllPR() {
		return purchaseReportService.getAllPR();
	}

	// LIST OF ALL PRs BY CATEGORY
	@GetMapping("/purchasereports/{category}")
	public List<PurchaseReport> getAllPRByCategory(@PathVariable String category) {
		return purchaseReportService.getAllPRByCategory(category);
	}
	// LIST OF ALL PRs BY DOP

}
