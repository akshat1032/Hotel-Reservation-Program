package com.capgemini.hotelreservation;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class AddHotelNameAndRateTest {

	private HotelReservation hotelReservation = new HotelReservation();
	String hotelName1 = "Lakewood";
	int weekdayRate1 = 110, weekendRate1 = 90;
	String hotelName2 = "Bridgewood";
	int weekdayRate2 = 160, weekendRate2 = 60;
	String hotelName3 = "Ridgewood";
	int weekdayRate3 = 220, weekendRate3 = 150;

	// Test to check for addition of hotel to the reservation system
	@Test
	public void testAddHotelNameAndRate() {

		// Calling the function to store details
		hotelReservation.addHotelNameAndRate(weekdayRate1, weekendRate1, hotelName1, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(weekdayRate2, weekendRate2, hotelName2, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(weekdayRate3, weekendRate3, hotelName3, CustomerType.RegularCustomer);

		// Testing with weekday rate
		Assert.assertEquals(110, HotelReservation.hotelList.get("Lakewood").getWeekdayRate());
		Assert.assertEquals(160, HotelReservation.hotelList.get("Bridgewood").getWeekdayRate());
		Assert.assertEquals(220, HotelReservation.hotelList.get("Ridgewood").getWeekdayRate());

		// Testing with weekday rate
		Assert.assertEquals(90, HotelReservation.hotelList.get("Lakewood").getWeekendRate());
		Assert.assertEquals(60, HotelReservation.hotelList.get("Bridgewood").getWeekendRate());
		Assert.assertEquals(150, HotelReservation.hotelList.get("Ridgewood").getWeekendRate());
	}
}
