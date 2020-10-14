package com.capgemini.hotelreservation;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class AddHotelNameAndRateTest {

	private HotelReservation hotelReservation = new HotelReservation();

	// Test to check for addition of hotel to the reservation system
	@Test
	public void testAddHotelNameAndRate() {
		String hotelName1 = "Lakewood";
		int rate1 = 110;
		String hotelName2 = "Bridgewood";
		int rate2 = 160;
		String hotelName3 = "Ridgewood";
		int rate3 = 220;
		// Calling the function to store details
		hotelReservation.addHotelNameAndRate(rate1, hotelName1, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(rate2, hotelName2, CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(rate3, hotelName3, CustomerType.RegularCustomer);

		// Storing returned details in array list by hotel
		ArrayList<Hotel> hotelDetails1 = HotelReservation.hotelList.get(hotelName1);
		ArrayList<Hotel> hotelDetails2 = HotelReservation.hotelList.get(hotelName2);
		ArrayList<Hotel> hotelDetails3 = HotelReservation.hotelList.get(hotelName3);

		// Testing with rate
		Assert.assertEquals(110, hotelDetails1.get(0).getRate());
		Assert.assertEquals(160, hotelDetails2.get(0).getRate());
		Assert.assertEquals(220, hotelDetails3.get(0).getRate());

	}
}
