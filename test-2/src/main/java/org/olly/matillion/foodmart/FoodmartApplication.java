package org.olly.matillion.foodmart;

import org.olly.matillion.foodmart.data.DataConnectionException;
import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.repository.EmployeeQueryException;
import org.olly.matillion.foodmart.service.FoodmartService;
import org.olly.matillion.foodmart.service.FoodmartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class FoodmartApplication  {

	static Logger log = LoggerFactory.getLogger(FoodmartApplication.class);

	FoodmartService foodmartService;

	public FoodmartApplication(){
		super();
		this.foodmartService = new FoodmartServiceImpl();
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String department;
		String payType;
		String education;

		if(args.length != 3){
			log.error("The correct number of parameters have not been provided. Please state department, pay type and education level in that order");
			System.out.print("Please enter a department: ");
			department = scanner.nextLine();
			System.out.print("Please enter a pay type: ");
			payType = scanner.nextLine();
			System.out.print("Please enter a education level: ");
			education = scanner.nextLine();
		}else {
			department = args[0];
			payType = args[1];
			education = args[2];
		}

		System.out.printf("Querying employee table for department = %s, pay type = %s and education = %s \n", department, payType, education);

		List<Employee> employeeList = null;

		try {
			employeeList = new FoodmartApplication().queryEmployeeRepository(department, payType, education);
		} catch (EmployeeQueryException e) {
			log.error("Exception loading employee data: {}", e.getMessage(), e);
			System.exit(-1);
		} catch(DataConnectionException e){
			log.error("Exception connecting to repository: {}", e.getMessage(), e);
			System.exit(-1);
		}

		System.out.printf("%s employees match criteria \n", employeeList.size());
		employeeList.stream().forEach(employee -> log.info(employee.toString()));

	}

	public List<Employee> queryEmployeeRepository(String department, String payType, String education) throws DataConnectionException, EmployeeQueryException {
		return foodmartService.findEmployees(department, payType, education);
	}
}
