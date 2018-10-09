package com.xebia.assignment.service;

import com.xebia.assignment.model.Animal;
import com.xebia.assignment.store.YakYield;


/**
 * This is the Service interface for all the yak services
 *
 */
public interface YakService {

    /**
     * @param elapsedTimeInDays
     * @return
     */
    public YakYield getTotalYakYield(int elapsedTimeInDays);
    /**
     * @param yak
     * @param elapsedTimeInDays
     * @return
     */
    public YakYield getYakYieldForAYak(Animal yak, int elapsedTimeInDays);
    /**
     * @param yak
     * @param elapsedTimeInDays
     */
    public void calculateAndSaveYieldForDay(Animal yak,int elapsedTimeInDays);

}
