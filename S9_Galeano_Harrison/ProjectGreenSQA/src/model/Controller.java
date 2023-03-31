package model;

import java.text.ParseException;
import java.util.Calendar;

public class Controller {

    //SIZE is the size of the array to object Project
    private final static int SIZE = 10;
    private Project[] projects;

    public Controller() {

        projects = new Project[SIZE];

    }

    //
    public boolean RegisterProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {

        int pos = getFirstValidPosition();

        if (pos != -1)
            projects[pos] = new Project(name, clientName, initialDate, finalDate, budget);
        else {
            System.out.println("No available space");
        }
        return false;
    }

    //this methods return the int of the available position in the array of the object Project
    private int getFirstValidPosition() {
            int pos = -1;
            boolean isFound = false;
            for (int i = 0; i < 10 && !isFound; i++) {
                if (projects[i] == null) {
                    pos = i;
                    isFound = true;
                }
            }
            return pos;
    }
    // Date class also has their own before() and after() method
    public String searchProjectsAfterDate(Calendar evaluateDate) throws ParseException {
        for (int i = 0; i < SIZE; i++) {
            if (projects[i].getInitialDate().compareTo(evaluateDate) > 0) {
                System.out.println("the dates after the evaluate date are:\n"+
                        "Project "+ i + projects[i].getProjectInfo());
            }
        }
        return null;
    }

    // Date class also has their own before() and after() method
    public String searchProjectsBeforeDate (Calendar evaluateDate) throws ParseException {
        for (int i = 0; i < SIZE; i++) {
            if (projects[i].getFinalDate().compareTo(evaluateDate) > 0) {
                System.out.println("the dates before the evaluate date are:\n" +
                        "Project " + i + projects[i].getProjectInfo());
            }
        }
        return null;
    }
    public String toString () {
            return "Has been saved";
    }
}
