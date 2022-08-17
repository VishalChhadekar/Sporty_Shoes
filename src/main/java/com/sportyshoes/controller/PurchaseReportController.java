package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.PurchaseReportModel;
import com.sportyshoes.service.PurchaseReportService;

@RestController
@RequestMapping("/admin")
public class PurchaseReportController {

	@Autowired
	private PurchaseReportService purchaseReportService;

	// CREATE PR
	@PostMapping("/purchasereport")
	public PurchaseReport createPR(@RequestBody PurchaseReportModel pRModel) {
		return purchaseReportService.createPR(pRModel);
	}

	// GET PR BY ID
	@GetMapping("/purchasereport/{id}")
	public PurchaseReport getPurchaseReportById(@PathVariable Long id) {
		return purchaseReportService.getPurchaseReportById(id);

	}

	// DELETE PR
	@DeleteMapping("/purchasereport/{id}")
	public void deletePR(@PathVariable Long id) {
		purchaseReportService.deletePR(id);
	}

	// UPDATE PR
	@PutMapping("/purchasereport/{id}")
	public PurchaseReport updatePR(@RequestBody PurchaseReportModel pReport, @PathVariable Long id) {
		return purchaseReportService.updatePR(pReport, id);
	}

}
