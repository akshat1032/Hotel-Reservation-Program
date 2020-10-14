package com.capgemini.hotelreservation;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class AddHotelNameAndRateTest {

	private HotelReservation hotelReservation = new HotelReservation();
	String hotelName1 = "Lakewood";
	int rate1 = 110;
	String hotelName2 = "Bridgewood";
	int rate2 = 160;
	String hotelName3 = "Ridgewood";
	int rate3 = 220;

	// Test to check for addition of hotel to the reservation system
	@Test
	public void testAddHotelNameAndRate() {
		
		// Calling the function to store details
		hotelReservation.addHotelNameAndRate(rate1, hotelName1, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(rate2, hotelName2, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(rate3, hotelName3, CustomerType.RegularCustomer);
		
		// Testing with rate
		Assert.assertEquals(110, HotelReservation.hotelList.get("Lakewood").getRate());
		Assert.assertEquals(160, HotelReservation.hotelList.get("Bridgewood").getRate());
		Assert.assertEquals(220, HotelReservation.hotelList.get("Ridgewood").getRate());

	}
	
	// Test to check for cheapest hotel for date range
	@Test
	public void testCheapestHotelForDate() {
		
		// Calling the function to store details
		hotelReservation.addHotelNameAndRate(rate1, hotelName1, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(rate2, hotelName2, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(rate3, hotelName3, CustomerType.RegularCustomer);
		//Giving Date
		ArrayList<String> date = new ArrayList<String>();
		date.add("10September2020");
		date.add("11September2020");
		Assert.assertEquals("Lakewood, Total Rates: $220", hotelReservation.cheapestHotelByDate(date));
	}
}
