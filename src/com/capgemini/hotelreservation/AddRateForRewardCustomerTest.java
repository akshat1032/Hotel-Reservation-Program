package com.capgemini.hotelreservation;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class AddRateForRewardCustomerTest {

	private HotelReservation hotelReservation = new HotelReservation();
	String hotelName1 = "Lakewood";
	int weekdayRateReward1 = 80, weekendRateReward1 = 80, ratings1 = 3;
	String hotelName2 = "Bridgewood";
	int weekdayRateReward2 = 110, weekendRateReward2 = 50, ratings2 = 4;
	String hotelName3 = "Ridgewood";
	int weekdayRateReward3 = 100, weekendRateReward3 = 40, ratings3 = 5;

	Logger logger = Logger.getLogger(FindBestRatedHotelTest.class.getName());

	@Test
	public void testAddRewardCustomerRate() {
		// Calling the function to store details
		hotelReservation.addHotelNameAndRateForReward(weekdayRateReward1, weekendRateReward1, ratings1, hotelName1,
				CustomerType.RewardCustomer);
		hotelReservation.addHotelNameAndRateForReward(weekdayRateReward2, weekendRateReward2, ratings2, hotelName2,
				CustomerType.RewardCustomer);
		hotelReservation.addHotelNameAndRateForReward(weekdayRateReward3, weekendRateReward3, ratings3, hotelName3,
				CustomerType.RewardCustomer);

		// Testing with weekday rate
		Assert.assertEquals(80, HotelReservation.hotelListReward.get("Lakewood").getWeekdayRate());
		Assert.assertEquals(110, HotelReservation.hotelListReward.get("Bridgewood").getWeekdayRate());
		Assert.assertEquals(100, HotelReservation.hotelListReward.get("Ridgewood").getWeekdayRate());

		// Testing with weekend rate
		Assert.assertEquals(80, HotelReservation.hotelListReward.get("Lakewood").getWeekendRate());
		Assert.assertEquals(50, HotelReservation.hotelListReward.get("Bridgewood").getWeekendRate());
		Assert.assertEquals(40, HotelReservation.hotelListReward.get("Ridgewood").getWeekendRate());

		// Testing for ratings
		Assert.assertEquals(3, HotelReservation.hotelListReward.get("Lakewood").getRatings());
		Assert.assertEquals(4, HotelReservation.hotelListReward.get("Bridgewood").getRatings());
		Assert.assertEquals(5, HotelReservation.hotelListReward.get("Ridgewood").getRatings());

		logger.info("Hotel details added and tested");

	}

}
