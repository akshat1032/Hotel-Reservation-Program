package com.capgemini.hotelreservationtest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotelreservation.FindBestRatedHotelTest;
import com.capgemini.hotelreservation.HotelReservation;
import com.capgemini.hotelreservation.HotelReservation.CustomerType;

public class StreamRefactoringHotelReservationRegularCustomerTest {

	private HotelReservation hotelReservation = new HotelReservation();
	String hotelName1 = "Lakewood";
	int weekdayRate1 = 110, weekendRate1 = 90, ratings1 = 3;
	String hotelName2 = "Bridgewood";
	int weekdayRate2 = 160, weekendRate2 = 60, ratings2 = 4;
	String hotelName3 = "Ridgewood";
	int weekdayRate3 = 220, weekendRate3 = 150, ratings3 = 5;

	Logger logger = Logger.getLogger(FindBestRatedHotelTest.class.getName());

	@Test
	public void testFindCheapestHotelForRegularCustomer() {
		// Calling the function to store details
		hotelReservation.addHotelNameAndRate(weekdayRate1, weekendRate1, ratings1, hotelName1,
				CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(weekdayRate2, weekendRate2, ratings2, hotelName2,
				CustomerType.RegularCustomer);
		hotelReservation.addHotelNameAndRate(weekdayRate3, weekendRate3, ratings3, hotelName3,
				CustomerType.RegularCustomer);

		ArrayList<String> date = new ArrayList<String>();
		date.add("11September2020");
		date.add("12September2020");

		Assert.assertEquals("Lakewood, Total Rates: $200",
				hotelReservation.cheapestHotelByDate(date, CustomerType.RegularCustomer));
		logger.info("Cheapest best rated hotel for regular customer tested");

	}


}
