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
	public void addHotelNameAndRate(int rate, String hotelName, CustomerType customerType) {
		Hotel hotelDetails = new Hotel(rate, customerType);
		hotelList.put(hotelName, hotelDetails);
	}

	// Return cheapest hotel by range of date
	public String cheapestHotelByDate(ArrayList<String> date) {
		LocalDate dateFormat[] = new LocalDate[2]; int dateIndex = 0;
		String dateregex = "^(([0-9])|([0-2][0-9])|([3][0-1]))(January|February|March|April|May|June|July|August|September|October|November|December)\\d{4}$";
		Pattern pattern = Pattern.compile(dateregex);
		for (String inputDate : date) {
			Matcher m = pattern.matcher(inputDate);
			if (m.matches()) {
				dateFormat[dateIndex] = LocalDate.of((Integer.parseInt(inputDate.substring(inputDate.length() - 4))),
						Month.valueOf(inputDate.toUpperCase().substring(2, inputDate.length() - 4)),
						Integer.parseInt(inputDate.substring(0, 2)));
				dateIndex++;
			}
		}
		int rate[] = { hotelList.get("Lakewood").getRate(), hotelList.get("Bridgewood").getRate(),
				hotelList.get("Ridgewood").getRate() };
		int totalRate[] = new int[3];
		int hotelIndex = 0;
		int noOfDays = dateFormat[1].getDayOfMonth() - dateFormat[0].getDayOfMonth();
		int counterNoOfDays = 0;
		do {
			do {
				totalRate[hotelIndex] = totalRate[hotelIndex] + rate[hotelIndex];
				counterNoOfDays++;
			}while (counterNoOfDays <= noOfDays);
			hotelIndex++;
			counterNoOfDays = 0;
		} while (hotelIndex != 3);
		return totalRate[0] < totalRate[1]
				? totalRate[0] < totalRate[2] ? "Lakewood, Total Rates: $" + totalRate[0]
						: "Ridgewood, Total Rates: $" + totalRate[2]
				: totalRate[1] < totalRate[2] ? "Bridgewood, Total Rates: $" + totalRate[1]
						: "Ridgewood, Total Rates: $" + totalRate[2];
	}

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(HotelReservation.class.getName());
		// Welcome message added
		logger.info("Welcome to Hotel Reservation Program");
	}
}
