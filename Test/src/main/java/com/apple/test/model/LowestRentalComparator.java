package com.apple.test.model;
import java.util.Comparator;

public class LowestRentalComparator implements Comparator<Car> {

	public int compare(Car c1, Car c2) {
		if (c1.getRent().getPrice() < c2.getRent().getPrice()) {
			return 0;
		}
		else if ((c1.getRent().getPrice() - c1.getRent().getDiscount())  < (c2.getRent().getPrice() -c2.getRent().getDiscount())) {
			return 1;
		}else {
			return -1;
		}
	}

}
