package com.twu.refactor;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double calculatePrice() {
        double amount = 0;
        switch (getMovie().getPriceCode()) {
        case Movie.REGULAR:
            amount += 2;
            if (daysRented > 2)
                amount += (daysRented - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            amount += 3.0;
            break;
        case Movie.CHILDRENS:
            amount += 1.5;
            if (daysRented > 3)
                amount += (daysRented - 3) * 1.5;
            break;

        }
        return amount;
    }

    int calculateRenterPoints() {
        int frequentRenterPoints = 1;
        frequentRenterPoints = addBonusPointForTwoDayRental(frequentRenterPoints);
        return frequentRenterPoints;
    }

    private int addBonusPointForTwoDayRental(int frequentRenterPoints) {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    @Override
    public String toString() {
        // show figures for this rental
        return String.format("\t%s\t%s\n", getMovie().getTitle(),
                String.valueOf(calculatePrice()));
    }
}