package com.coinCollection.Project;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Coin{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srNo;
	private String country;
	private int denomination;
	private int yearOfMinting;
	private double currentValue;
	@Temporal(TemporalType.DATE)
	private Date accuiredDate;
	
	public Coin() {
		
	}
	
	public Coin(int srNo, String country, int denomination, int yearOfMinting, double currentValue, Date accuiredDate) {
		super();
		this.srNo = srNo;
		this.country = country;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.currentValue = currentValue;
		this.accuiredDate = accuiredDate;
	}
	

	public int getSrNo() {
		return srNo;
	}


	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	public int getYearOfMinting() {
		return yearOfMinting;
	}

	public void setYearOfMinting(int yearOfMinting) {
		this.yearOfMinting = yearOfMinting;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	
	public Date getAccuiredDate() {
		return accuiredDate;
	}
	
	public void setAccuiredDate(Date accuiredDate) {
		this.accuiredDate = accuiredDate;
	}
	
	public void display() {
		System.out.printf("%-7d%-20s%-15s%-18d%-15.2f%-15s\n",getSrNo(),getCountry(),getDenomination(),getYearOfMinting(),getCurrentValue(),getAccuiredDate());
	}
	
}
