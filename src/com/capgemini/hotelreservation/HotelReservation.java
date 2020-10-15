package com.capgemini.hotelreservation;

import java.time.DayOfWeek;
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
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
	}

	public enum Weekend {
		SATURDAY, SUNDAY;
	}

	// Instance variable for storing details of hotel and list of hotels
	public static HashMap<String, Hotel> hotelList = new HashMap<String, Hotel>();

	// Adding hotel name and rate for each hotel to the system
	public void addHotelNameAndRate(int weekdayRate, int weekendRate, int ratings, String hotelName,
			CustomerType customerType) {
		Hotel hotelDetails = new Hotel(weekdayRate, weekendRate, ratings, customerType);
		hotelList.put(hotelName, hotelDetails);
	}

	// Return cheapest hotel and best rated by range of date based on weekend and
	// weekdays
	public String cheapestHotelByDate(ArrayList<String> date) {
		LocalDate dateFormat[] = new LocalDate[2];
		int dateIndex = 0;
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
		int rate[][] = { { hotelList.get("Lakewood").getWeekdayRate(), hotelList.get("Lakewood").getWeekendRate() },
				{ hotelList.get("Bridgewood").getWeekdayRate(), hotelList.get("Bridgewood").getWeekendRate() },
				{ hotelList.get("Ridgewood").getWeekdayRate(), hotelList.get("Ridgewood").getWeekendRate() } };
		int totalRate[] = new int[3];
		int hotelIndex = 0;
		int noOfDays = dateFormat[1].getDayOfMonth() - dateFormat[0].getDayOfMonth();
		int counterNoOfDays = 0;
		do {
			dateIndex = 0;
			do {
				int day = dateFormat[dateIndex].getDayOfWeek().getValue();
				if (day == 1 || day == 2 || day == 3 || day == 4 || day == 5) {
					totalRate[hotelIndex] = totalRate[hotelIndex] + rate[hotelIndex][0];
				} else if (day == 6 || day == 7) {
					totalRate[hotelIndex] = totalRate[hotelIndex] + rate[hotelIndex][1];
				}
				counterNoOfDays++;
				dateIndex++;
			} while (counterNoOfDays <= noOfDays);
			hotelIndex++;
			counterNoOfDays = 0;
		} while (hotelIndex != 3);
		int ratings[] = { hotelList.get("Lakewood").getRatings(), hotelList.get("Bridgewood").getRatings(),
				hotelList.get("Ridgewood").getRatings() };
		String hotel = "";
		
			return ratings[0]>ratings[1]?ratings[0]>ratings[2]?"Lakewood, Total Rates: $"+totalRate[0]:"Ridgewood, Total Rates: $"+totalRate[2]:ratings[1]>ratings[2]?"Bridgewood, Total Rates: $"+totalRate[1]:"Ridgewood, Total Rates: $"+totalRate[2];
	}
	
	

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(HotelReservation.class.getName());
		// Welcome message added
		logger.info("Welcome to Hotel Reservation Program");
	}
}
