package org.olly.matillion.foodmart.cli;

import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.service.FoodmartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component @Profile("!test")
public class FoodmartCommandLineRunner implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(FoodmartCommandLineRunner.class);

    @Autowired
    FoodmartService foodmartService;
    EmployeeLogger employeeLogger;
    FoodmartConsoleReader console;

    public FoodmartCommandLineRunner(){
        super();
        this.employeeLogger = new EmployeeLogger();
        this.console = new FoodmartConsoleReader();
    }

    @Override
    public void run(String... args) {
//        Scanner scanner = new Scanner(System.in);

        String department;
        String payType;
        String education;

        if (args.length == 3) {
            department = args[0];
            payType = args[1];
            education = args[2];
        } else {
            System.out.print("Please enter a department: ");
            department = console.readLine();
            System.out.print("Please enter a pay type: ");
            payType = console.readLine();
            System.out.print("Please enter a education level: ");
            education = console.readLine();
        }

        System.out.printf("Querying employee table for department = %s, pay type = %s and education = %s \n", department, payType, education);

        List<Employee> employeeList = null;

        try {
            employeeList = foodmartService.findEmployees(department, payType, education);
        } catch (Exception e) {
            log.error("This query resulted in an error: {}", e.getMessage(), e);
            System.out.println("Exiting");
           return;
        }

        System.out.printf("%s employees match criteria \n", employeeList.size());
        employeeLogger.outputEmployees(employeeList);
        System.out.println("Goodbye!");
    }
}
