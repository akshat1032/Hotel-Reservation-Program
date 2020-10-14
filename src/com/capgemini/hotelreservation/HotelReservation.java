package com.capgemini.hotelreservation;

import java.util.*;
import java.util.logging.Logger;

public class HotelReservation {

	public enum CustomerType {
		RegularCustomer;
	}

	public enum Weekday {
		mon, tues, wed, thurs, fri;
	}

	public enum Weekend {
		sat, sun;
	}

	// Instance variable for storing details of hotel and list of hotels
	public static ArrayList<Hotel> hotelDetails = new ArrayList<Hotel>();
	public static HashMap<String, ArrayList<Hotel>> hotelList = new HashMap<String, ArrayList<Hotel>>();

	// Adding hotel name and rate for each hotel to the system
	public void addHotelNameAndRate(int rate, String hotelName, CustomerType customerType) {
		hotelDetails.add(new Hotel(rate, customerType));
		hotelList.put(hotelName, hotelDetails);

		// Initializing an empty array list to add details of the next hotel
		hotelDetails = new ArrayList<>();
	}

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(HotelReservation.class.getName());
		// Welcome message added
		logger.info("Welcome to Hotel Reservation Program");
	}
}
