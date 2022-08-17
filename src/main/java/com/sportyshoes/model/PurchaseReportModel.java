package com.sportyshoes.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReportModel {
	private Long pr_id;
	private Date dOP;
	private User purchasedBy;
	private Shoe shoe;
	private Long userId;
	private Long shoeId;
}
