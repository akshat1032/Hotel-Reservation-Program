package com.capgemini.hotelreservation;

import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class Hotel {
	private int rate;
	private CustomerType customerType;

	// Constructor for initialization
	public Hotel(int rate, CustomerType c) {
		this.rate = rate;
		this.customerType = CustomerType.RegularCustomer;
	}

	// return the rate
	public int getRate() {
		return rate;
	}

	// return the customer type
	public CustomerType getCustomerType() {
		return customerType;
	}

}
