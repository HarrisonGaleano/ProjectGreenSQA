package ui;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import model.Controller;

public class Main{

	private Scanner reader;
	private Calendar calendarTime;
	private Controller controller;
	private SimpleDateFormat dateFormat;

	private String date;//this String date is to store what is to be converted to Calendar then or evaluate


	public Main() {

		calendarTime = Calendar.getInstance();
		reader = new Scanner(System.in);
		controller = new Controller();
		dateFormat = new SimpleDateFormat("dd/M/yy");
	}

	public static void main(String[] args) throws ParseException {

		int option = 3;
		Main exe = new Main();

		do {
			System.out.println("1. Create a Project\n"+
					"2. Search a project whit a Date\n"+
					"3. Close program");
			option = exe.reader.nextInt();
			exe.menu(option);

		}while(option != 3);


		exe.menu(option);

	}

	// Incomplete
	public void menu(int option) throws ParseException {
		//max is the maximum options to chose
		int max = 3;
		validateIntegerInput(option, max);

		switch (option) {
			case 1:
				RegisterProject();
				System.out.println(controller);
				break;
			case 2:
				Calendar evaluateDate = calendarTime;
				System.out.println("1. Search projects after a date.\n"+
						"2. Search projects before a date.\n"+
						"3. Exit");
				option = reader.nextInt();
				max = 3;
				validateIntegerInput(option, max);
				if (option == 1){
					System.out.println("Put the date for evaluate in 'dd/M/yy' format.");
					reader.nextLine();
					date = reader.next();
					searchProjectsAfterDate(evaluateDate);
				}
				if (option == 2){
					System.out.println("Put the date for evaluate in 'dd/M/yy' format.");
					reader.nextLine();
					date = reader.next();
					searchProjectsBeforeDate(evaluateDate);
				}
				if (option == 3){
					option = 1;
					System.out.println("Exit");
				}

		}

	}
	public void RegisterProject() throws ParseException {
		String name;
		String clientName;
		Calendar initialDate = calendarTime;
		Calendar finalDate = calendarTime;
		double budget;


		//name
		reader.nextLine();
		System.out.println("You have selected the projects option\n" +
				"\n" +
				"To make a project:\n" +
				"---Introduce the name of project.");
		name = reader.next();

		//clientName
		reader.nextLine();
		System.out.println("---Introduce the name of client´s project");
		clientName = reader.next();

		//initialDate
		reader.nextLine();
		System.out.println("---Introduce the start date in the format: 'dd/M/yy'.");
		date = reader.next();
		initialDate.setTime(dateFormat.parse(date));//The parse is for convert the date(String) in a Calendar object to be deposited in the initialDate
		System.out.println("The beginning date is: "+dateFormat.format(calendarTime.getTime()));//The format is for convert a Calendar object in a String

		//finalDate
		reader.nextLine();
		System.out.println("---Introduce the finish date in the format: 'dd/M/yy'.");
		date = reader.next();
		finalDate.setTime(dateFormat.parse(date));//The parse is for convert the date(String) in a Calendar object to be deposited in the initialDate
		System.out.println("The final date is: "+dateFormat.format(calendarTime.getTime()));//The format is for convert a Calendar object in a String

		//budget
		System.out.println("---Who is the budget for the project");
		budget = reader.nextInt();

		//constructor
		controller.RegisterProject(name, clientName, initialDate, finalDate, budget);


	}

	//Incomplete
	public void searchProjectsAfterDate(Calendar evaluateDate) throws ParseException {
		evaluateDate.setTime(dateFormat.parse(date));
		//constructor
		controller.searchProjectsAfterDate(evaluateDate);
	}
	
	//Incomplete
	public void searchProjectsBeforeDate(Calendar evaluateDate) throws ParseException {
		evaluateDate.setTime(dateFormat.parse(date));
		//constructor
		controller.searchProjectsAfterDate(evaluateDate);

	}
	public int validateIntegerInput(int input, int max){

		boolean flag = false;

		do {
			if (input <=max && input >0) {
				flag =  true;
			} else {
				System.out.println("Probably that is not a number or a valid option. Enter a whole number.");
				reader.nextInt();
			}
		} while (!flag);

		return input;

	}
}

