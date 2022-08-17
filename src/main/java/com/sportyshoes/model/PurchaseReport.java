package com.sportyshoes.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReport {
	@Id
	@SequenceGenerator(name = "pr_sequence", sequenceName = "pr_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pr_sequence")
	private Long pr_id;
	private Date dOP;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User purchasedBy;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shoe_id", referencedColumnName = "shoeid")
	private Shoe shoe;
}
