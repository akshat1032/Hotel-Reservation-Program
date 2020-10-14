package com.capgemini.hotelreservation;

import java.util.*;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class AddHotelNameAndRateTest {

	private HotelReservation hotelReservation = new HotelReservation();
	String hotelName1 = "Lakewood";
	int weekdayRate1 = 110, weekendRate1 = 90, ratings1 = 3;
	String hotelName2 = "Bridgewood";
	int weekdayRate2 = 160, weekendRate2 = 60, ratings2 = 4;
	String hotelName3 = "Ridgewood";
	int weekdayRate3 = 220, weekendRate3 = 150, ratings3 = 5;

	Logger logger = Logger.getLogger(AddHotelNameAndRateTest.class.getName());

	// Test to check for addition of hotel to the reservation system
	@Test
	public void testAddHotelDetails() {

		// Calling the function to store details
		hotelReservation.addHotelNameAndRate(weekdayRate1, weekendRate1, ratings1, hotelName1,
				CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(weekdayRate2, weekendRate2, ratings2, hotelName2,
				CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(weekdayRate3, weekendRate3, ratings3, hotelName3,
				CustomerType.RegularCustomer);

		// Testing with weekday rate
		Assert.assertEquals(110, HotelReservation.hotelList.get("Lakewood").getWeekdayRate());
		Assert.assertEquals(160, HotelReservation.hotelList.get("Bridgewood").getWeekdayRate());
		Assert.assertEquals(220, HotelReservation.hotelList.get("Ridgewood").getWeekdayRate());

		// Testing with weekday rate
		Assert.assertEquals(90, HotelReservation.hotelList.get("Lakewood").getWeekendRate());
		Assert.assertEquals(60, HotelReservation.hotelList.get("Bridgewood").getWeekendRate());
		Assert.assertEquals(150, HotelReservation.hotelList.get("Ridgewood").getWeekendRate());

		// Testing for ratings
		Assert.assertEquals(3, HotelReservation.hotelList.get("Lakewood").getRatings());
		Assert.assertEquals(4, HotelReservation.hotelList.get("Bridgewood").getRatings());
		Assert.assertEquals(5, HotelReservation.hotelList.get("Ridgewood").getRatings());

		logger.info("Hotel details added and tested");
	}
}
