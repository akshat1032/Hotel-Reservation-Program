package com.capgemini.hotelreservation;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public static HashMap<String, Hotel> hotelList = new HashMap<String, Hotel>();

	// Adding hotel name and rate for each hotel to the system
	public void addHotelNameAndRate(int weekdayRate, int weekendRate,  String hotelName, CustomerType customerType) {
		Hotel hotelDetails = new Hotel(weekdayRate, weekendRate, customerType);
		hotelList.put(hotelName, hotelDetails);
	}

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(HotelReservation.class.getName());
		// Welcome message added
		logger.info("Welcome to Hotel Reservation Program");
	}
}
