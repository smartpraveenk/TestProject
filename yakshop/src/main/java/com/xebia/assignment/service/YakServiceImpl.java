package com.xebia.assignment.service;

import com.xebia.assignment.model.Animal;
import com.xebia.assignment.store.YakStore;
import com.xebia.assignment.store.YakStoreImpl;
import com.xebia.assignment.store.YakYield;


public class YakServiceImpl implements YakService {
    private YakStore yakStore;
    /**
     * 
     */
    public  YakServiceImpl(){
        yakStore = new YakStoreImpl();
    }
    /* (non-Javadoc)
     * @see com.xebia.assignment.service.YakService#getTotalYakYield(int)
     */
    public YakYield getTotalYakYield(int elapsedTimeInDays) {
        return yakStore.getTotalYield(elapsedTimeInDays);
    }

    /* (non-Javadoc)
     * @see com.xebia.assignment.service.YakService#getYakYieldForAYak(com.xebia.assignment.model.Animal, int)
     */
    public YakYield getYakYieldForAYak(Animal yak, int elapsedTimeInDays) {
        if(yakStore.getYieldForYak(yak.getId(),elapsedTimeInDays) == null){
            calculateAndSaveYieldForDay(yak,elapsedTimeInDays);
        }
        return yakStore.getYieldForYak(yak.getId(),elapsedTimeInDays);
    }



    /* (non-Javadoc)
     * @see com.xebia.assignment.service.YakService#calculateAndSaveYieldForDay(com.xebia.assignment.model.Animal, int)
     */
    public void calculateAndSaveYieldForDay(Animal yak, int elapsedTimeInDays) {
        YakYield yield = yak.calculateYakYieldForDay(elapsedTimeInDays);
        yakStore.saveYieldForDay(yak.getId(),elapsedTimeInDays,yield);
    }





}
