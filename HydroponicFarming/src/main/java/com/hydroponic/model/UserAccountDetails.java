package com.hydroponic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserAccountDetails {

	@Id
	private String mobileNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Products> productsList;

}
