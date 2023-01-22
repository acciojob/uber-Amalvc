package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database

		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer c=customerRepository2.findById(customerId).get();
		customerRepository2.delete(c);

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		int val=Integer.MAX_VALUE;
		boolean flag=false;
		List<Driver>d=driverRepository2.findAll();
		TripBooking tripBooking = new TripBooking(fromLocation, toLocation, distanceInKm, TripStatus.CONFIRMED);
		if(d.size()==0){
			throw new Exception("No cab available!");
		}
		for(Driver driver:d){
			if(driver.getCab().getAvailable()==true) {


				int fare = distanceInKm * driver.getCab().getPerKmRate();
				tripBooking.setBill(fare);
				driver.getCab().setAvailable(false);
				Customer customer = customerRepository2.findById(customerId).get();
				tripBooking.setCustomer(customer);
				tripBooking.setDriver(driver);
				driver.getTripBookingList().add(tripBooking);
				customer.getTripBookingList().add(tripBooking);
				customerRepository2.save(customer);
				driverRepository2.save(driver);
				tripBookingRepository2.save(tripBooking);
				flag=true;
				break;
			}
		}
		if(flag==false){
			throw new Exception("No cab available!");
		}


		return tripBooking;


	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking t=tripBookingRepository2.findById(tripId).get();
		t.setStatus(TripStatus.CANCELED);
		t.setBill(0);
		Driver d=t.getDriver();
		d.getCab().setAvailable(true);
		t.getCustomer().getTripBookingList().remove(t);
		tripBookingRepository2.save(t);



	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking t=tripBookingRepository2.findById(tripId).get();
		t.setStatus(TripStatus.COMPLETED);
		Driver d=t.getDriver();
		d.getCab().setAvailable(true);
		tripBookingRepository2.save(t);

	}
}
