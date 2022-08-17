package com.sportyshoes.service;

import java.util.List;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.PurchaseReportModel;
import com.sportyshoes.model.User;

public interface PurchaseReportService {

	PurchaseReport createPR(PurchaseReportModel pRModel);

	PurchaseReport getPurchaseReportById(Long id);

	void deletePR(Long id);

	PurchaseReport updatePR(PurchaseReportModel pReport, Long id);

	List<PurchaseReport> getAllPR();

	List<PurchaseReport> getAllPRByCategory(String category);

}
