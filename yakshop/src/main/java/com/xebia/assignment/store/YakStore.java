package com.xebia.assignment.store;

public interface YakStore {

	/**
	 * @param id
	 * @param elapsedTimeInDays
	 * @return
	 */
	public YakYield getYieldForYak(int id, int elapsedTimeInDays);

	/**
	 * @param elapsedTimeInDays
	 * @return
	 */
	public YakYield getTotalYield(int elapsedTimeInDays);

	/**
	 * @param id
	 * @param elapsedTimeInDays
	 * @param yield
	 */
	public void saveYieldForDay(int id, int elapsedTimeInDays, YakYield yield);
}
