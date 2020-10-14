package com.capgemini.hotelreservation;

import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class Hotel {
	private int weekdayRate;
	private int weekendRate;
	private int ratings;
	private CustomerType customerType;

	// Constructor for initialization
	public Hotel(int weekdayRate, int weekendRate, int ratings,  CustomerType c) {
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.ratings = ratings;
		this.customerType = CustomerType.RegularCustomer;
	}
	// return the ratings
	public int getRatings() {
		return ratings;
	}

	// return the customer type
	public CustomerType getCustomerType() {
		return customerType;
	}
	
	// return the weekday
	public int getWeekdayRate() {
		return weekdayRate;
	}
	
	// return the weekend
	public int getWeekendRate() {
		return weekendRate;
	}

}
