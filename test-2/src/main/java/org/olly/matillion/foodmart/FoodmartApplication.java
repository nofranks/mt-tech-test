package org.olly.matillion.foodmart;

import org.olly.matillion.foodmart.cli.FoodmartCommandLineRunner;
import org.olly.matillion.foodmart.service.FoodmartServiceImpl;

public class FoodmartApplication  {

	public static void main(String[] args) {
		new FoodmartCommandLineRunner(new FoodmartServiceImpl()).run(args);
	}
}
