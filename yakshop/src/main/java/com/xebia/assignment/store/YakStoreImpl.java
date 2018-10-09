package com.xebia.assignment.store;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class YakStoreImpl implements YakStore {

	private Map<Integer, Map<Integer, YakYield>> yakStore = new HashMap<Integer, Map<Integer, YakYield>>();

	/* (non-Javadoc)
	 * @see com.xebia.assignment.store.YakStore#getYieldForYak(int, int)
	 */
	public YakYield getYieldForYak(int id, int elapsedTimeInDays) {
		// get the yield map for this yak from store
		Map<Integer, YakYield> dayYieldMap = (Map<Integer, YakYield>) yakStore
				.get(id);
		return dayYieldMap.get(elapsedTimeInDays);
	}

	/* (non-Javadoc)
	 * @see com.xebia.assignment.store.YakStore#getTotalYield(int)
	 */
	public YakYield getTotalYield(int elapsedTimeInDays) {
		double totalMilk = 0;
		int totalSkins = 0;
		Iterator it = yakStore.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			YakYield yield = ((Map<Integer, YakYield>) pair.getValue())
					.get(elapsedTimeInDays);
			totalMilk += yield.getMilk();
			totalSkins += yield.getSkin();
		}
		return new YakYield(totalMilk, totalSkins);
	}

	/* (non-Javadoc)
	 * @see com.xebia.assignment.store.YakStore#saveYieldForDay(int, int, com.xebia.assignment.store.YakYield)
	 */
	public void saveYieldForDay(int id, int elapsedTimeInDays, YakYield yield) {
		// get the yield map for this yak
		Map<Integer, YakYield> dayYieldMap = (Map<Integer, YakYield>) yakStore
				.get(id);
		if (dayYieldMap == null) {
			dayYieldMap = new HashMap<Integer, YakYield>();
			yakStore.put(id, dayYieldMap);
		}
		// store the yield
		dayYieldMap.put(elapsedTimeInDays, yield);
	}
}
