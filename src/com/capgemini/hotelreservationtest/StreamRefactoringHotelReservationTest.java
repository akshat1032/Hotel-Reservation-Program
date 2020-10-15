package com.capgemini.hotelreservationtest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotelreservation.FindBestRatedHotelTest;
import com.capgemini.hotelreservation.HotelReservation;
import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class StreamRefactoringHotelReservationTest {

	
	private HotelReservation hotelReservation = new HotelReservation();
	String hotelName1 = "Lakewood";
	int weekdayRateReward1 = 80, weekendRateReward1 = 80, ratings1 = 3;
	String hotelName2 = "Bridgewood";
	int weekdayRateReward2 = 110, weekendRateReward2 = 50, ratings2 = 4;
	String hotelName3 = "Ridgewood";
	int weekdayRateReward3 = 100, weekendRateReward3 = 40, ratings3 = 5;

	Logger logger = Logger.getLogger(FindBestRatedHotelTest.class.getName());

	@Test
	public void testFindCheapestHotelForRewardCustomer() {
		// Calling the function to store details
		hotelReservation.addHotelNameAndRateForReward(weekdayRateReward1, weekendRateReward1, ratings1, hotelName1,
				CustomerType.RewardCustomer);
		hotelReservation.addHotelNameAndRateForReward(weekdayRateReward2, weekendRateReward2, ratings2, hotelName2,
				CustomerType.RewardCustomer);
		hotelReservation.addHotelNameAndRateForReward(weekdayRateReward3, weekendRateReward3, ratings3, hotelName3,
				CustomerType.RewardCustomer);

		ArrayList<String> date = new ArrayList<String>();
		date.add("11September2020");
		date.add("12September2020");
		
		Assert.assertEquals("Ridgewood, Total Rates: $140", hotelReservation.cheapestHotelByDate(date, CustomerType.RewardCustomer));
		logger.info("Cheapest best rated hotel for reward customer tested");

	}
}
