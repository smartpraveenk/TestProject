package com.xebia.assignment.model;

import com.xebia.assignment.store.YakYield;

public interface Animal {

	YakYield calculateYakYieldForDay(int elapsedTimeInDays);

	int getId();

	String display(int forDays);

	double getTotalMilkQuantity(int timeElapsed);

	int getSkinCount(int i);

}
