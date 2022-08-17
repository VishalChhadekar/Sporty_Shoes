package com.sportyshoes.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.PurchaseReportModel;
import com.sportyshoes.model.Shoe;
import com.sportyshoes.model.User;
import com.sportyshoes.repository.PurchaseReportRepository;
import com.sportyshoes.repository.ShoeRepository;
import com.sportyshoes.repository.UserRepository;

@Service
public class PurchaseReportServiceImp implements PurchaseReportService {

	@Autowired
	private PurchaseReportRepository reportRepository;
	@Autowired
	private UserRepository uRepository;
	@Autowired
	private ShoeRepository shoeRepository;

	@Override
	public PurchaseReport createPR(PurchaseReportModel pRModel) {
		User user = uRepository.findById(pRModel.getUserId()).get();
		Shoe shoe = shoeRepository.findById(pRModel.getShoeId()).get();
		PurchaseReport pReport = new PurchaseReport();
		pReport.setShoe(shoe);
		pReport.setPurchasedBy(user);
		pReport.setDOP(null);
		return reportRepository.save(pReport);
	}

	@Override
	public PurchaseReport getPurchaseReportById(Long id) {
		return reportRepository.findById(id).get();
	}

	@Override
	public void deletePR(Long id) {
		reportRepository.deleteById(id);
	}

	@Override
	public PurchaseReport updatePR(PurchaseReportModel pReport, Long id) {
		PurchaseReport oldPurchaseReport = reportRepository.findById(id).get();

		if (Objects.nonNull(pReport.getUserId())) {
			User user = uRepository.findById(pReport.getUserId()).get();
			oldPurchaseReport.setPurchasedBy(user);
		}
		if (Objects.nonNull(pReport.getShoeId())) {
			Shoe shoe = shoeRepository.findById(pReport.getShoeId()).get();
			oldPurchaseReport.setShoe(shoe);
		}
		reportRepository.save(oldPurchaseReport);
		return oldPurchaseReport;
	}

	@Override
	public List<PurchaseReport> getAllPR() {
		return reportRepository.findAll();
	}

	@Override
	public List<PurchaseReport> getAllPRByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
