package com.capgemini.hotelreservation;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HotelReservation {

	public enum CustomerType {
		RegularCustomer, RewardCustomer;
	}

	// Instance variable for storing details of hotel and list of hotels
	public static HashMap<String, Hotel> hotelList = new HashMap<String, Hotel>();
	public static HashMap<String, Hotel> hotelListReward = new HashMap<String, Hotel>();

	// Adding hotel name and rate for each hotel to the system
	public void addHotelNameAndRate(int weekdayRate, int weekendRate, int ratings, String hotelName,
			CustomerType customerType) {
		Hotel hotelDetails = new Hotel(weekdayRate, weekendRate, ratings, customerType);
		hotelList.put(hotelName, hotelDetails);
	}

	// Adding hotel name and rate for each hotel for Reward customer
	public void addHotelNameAndRateForReward(int weekdayRate, int weekendRate, int ratings, String hotelName,
			CustomerType customerType) {
		Hotel hotelDetails = new Hotel(weekdayRate, weekendRate, ratings, customerType);
		hotelListReward.put(hotelName, hotelDetails);
	}

	// Return cheapest hotel and best rated by range of date based on weekend and
	// weekdays
	public String cheapestHotelByDate(ArrayList<String> date, CustomerType customerType) {
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
		List<Integer> rateWeekday;
		List<Integer> rateWeekend;
		List<Integer> ratings;
		if (customerType == CustomerType.RegularCustomer) {
			rateWeekday = hotelList.values().stream().map(detail -> detail.getWeekdayRate()).collect(Collectors.toList());
			rateWeekend = hotelList.values().stream().map(detail -> detail.getWeekendRate()).collect(Collectors.toList());
			ratings = hotelList.values().stream().map(detail -> detail.getRatings()).collect(Collectors.toList());
		} else {
			rateWeekday = hotelListReward.values().stream().map(detail -> detail.getWeekdayRate()).collect(Collectors.toList());
			rateWeekend = hotelListReward.values().stream().map(detail -> detail.getWeekendRate()).collect(Collectors.toList());
			ratings = hotelListReward.values().stream().map(detail -> detail.getRatings()).collect(Collectors.toList());
		}
		int totalRate[] = new int[3];
		int hotelIndex = 0;
		int noOfDays = dateFormat[1].getDayOfMonth() - dateFormat[0].getDayOfMonth();
		int counterNoOfDays = 0;
		do {
			dateIndex = 0;
			do {
				int day = dateFormat[dateIndex].getDayOfWeek().getValue();
				if (day == 1 || day == 2 || day == 3 || day == 4 || day == 5) {
					totalRate[hotelIndex] = totalRate[hotelIndex] + rateWeekday.get(hotelIndex);
				} else if (day == 6 || day == 7) {
					totalRate[hotelIndex] = totalRate[hotelIndex] + rateWeekend.get(hotelIndex);
				}
				counterNoOfDays++;
				dateIndex++;
			} while (counterNoOfDays <= noOfDays);
			hotelIndex++;
			counterNoOfDays = 0;
		} while (hotelIndex != 3);
		if (totalRate[0] == totalRate[1] && totalRate[0] < totalRate[2]) {
			if (ratings.get(0)>ratings.get(1)) {
				return "Ridgewood, Total Rates: $" + totalRate[0];}
			else
				return "Bridgewood, Total Rates: $" + totalRate[1];
		} else if (totalRate[0] == totalRate[2] && totalRate[0] < totalRate[1]) {
			if (ratings.get(0)>ratings.get(2))
				return "Ridgewood, Total Rates: $" + totalRate[0];
			else
				return "Lakewood, Total Rates: $" + totalRate[2];
		} else if (totalRate[1] == totalRate[2] && totalRate[1] < totalRate[0]) {
			if (ratings.get(1)>ratings.get(2))
				return "Bridgewood, Total Rates: $" + totalRate[1];
			else
				return "Ridgewood, Total Rates: $" + totalRate[2];
		} else {
			return totalRate[0] < totalRate[1]
					? totalRate[0] < totalRate[2] ? "Ridgewood, Total Rates: $" + totalRate[0]
							: "Lakewood, Total Rates: $" + totalRate[2]
					: totalRate[1] < totalRate[2] ? "Bridgewood, Total Rates: $" + totalRate[1]
							: "Ridgewood, Total Rates: $" + totalRate[2];
		}
	}

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(HotelReservation.class.getName());
		// Welcome message added
		logger.info("Welcome to Hotel Reservation Program");
	}
}
