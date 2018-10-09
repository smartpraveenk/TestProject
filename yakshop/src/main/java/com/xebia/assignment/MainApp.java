package com.xebia.assignment;

import java.io.File;
import java.util.List;

import com.xebia.assignment.io.XmlReader;
import com.xebia.assignment.model.Animal;
import com.xebia.assignment.service.ServiceFactory;
import com.xebia.assignment.service.YakService;
import com.xebia.assignment.store.YakYield;

/**
 * THis is the main class of the application
 *
 */
public class MainApp {
	private final YakService service = ServiceFactory.getInstance()
			.getYakService();

	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.process(
				"C:\\Users\\admin\\Downloads\\YakShop-master\\YakShop-master\\src\\test\\resources\\herd.xml",
				"14");

	}

	/**
	 * @param xmlFilePath
	 * @param elapsedTime
	 */
	private void process(String xmlFilePath, String elapsedTime) {
		File input = new File(xmlFilePath);
		int elapsedTimeInDays = Integer.parseInt(elapsedTime);
		List<Animal> yakList = new XmlReader(input).read();

		for (Animal yak : yakList) {
			service.calculateAndSaveYieldForDay(yak, elapsedTimeInDays);
		}
		YakYield totalYakYield = service.getTotalYakYield(elapsedTimeInDays);
		show(elapsedTimeInDays, totalYakYield, yakList);
	}

	/**
	 * @param forDays
	 * @param yield
	 * @param yakList
	 */
	public static void show(int forDays, YakYield yield, List<Animal> yakList) {
		System.out.println("T = " + forDays + "\n\n");
		System.out.println("In Stock:");
		System.out.println("\t\t" + yield.getMilk() + " liters of milk");
		System.out.println("\t\t" + yield.getSkin() + " skins of wool");
		System.out.println("Herd:\n\n");
		for (Animal yak : yakList) {
			System.out.println(yak.display(forDays));
		}
	}
}
