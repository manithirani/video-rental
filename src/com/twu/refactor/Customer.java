package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentalList.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
        Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
            Rental rental = rentals.next();
            result += rental.toString();
        }
        result += addFooterLines(calculateTotalAmount(), calculateTotalFrequentRenterPoints());
		return result;
	}

    private int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental eachRental : rentalList){
            frequentRenterPoints += eachRental.calculateRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double calculateTotalAmount() {
        double totalAmount=0;
        for(Rental rental : rentalList){
            totalAmount += rental.calculatePrice();

        }
        return totalAmount;
    }

    private String addFooterLines(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

}
