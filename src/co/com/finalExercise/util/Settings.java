package co.com.finalExercise.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Settings {
    public static final int MAIN =0,
            SUBJECTS=1;

    public static void getMenu (int type) throws Exception {
        if(type==MAIN){
            System.out.println("----MAIN MENU----");
            System.out.println("1. Print the list of teachers");
            System.out.println("2. Print the list of Subjects");
            System.out.println("3. Create student and assign it to a subject");
            System.out.println("4. Create subject");
            System.out.println("5. Show subjects for a student");
            System.out.println("0. Exit");
        }else if (type==SUBJECTS){
            System.out.println("----SUBJECT MENU----");
            System.out.println("1. Digit the desired subject name to get the related information)");
            System.out.println("2. Return to main menu");
        }else {
            throw new Exception("The inserted option is not valid");
        }
    }


    public static Object getData(String message, String type){
        Object object = new Object();
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        if (type.equals("STRING")){
            object = sc.next().toUpperCase();
        }else if (type.equals("DOUBLE")){
            object = sc.nextDouble();
        }else if (type.equals("INT")){
            object = sc.nextInt();
        }
        return object;
    }

    public static void validateOption(int typeMenu, String option) throws Exception {
        List<String> listOption;
        if(typeMenu==MAIN){
            listOption = new ArrayList<String>() {
                {
                    add("0");
                    add("1");
                    add("2");
                    add("3");
                    add("4");
                    add("5");
                }
            };
        }else if (typeMenu==SUBJECTS){
            listOption = new ArrayList<String>() {
                {
                    add("0");
                    add("1");

                }
            };
        }else{
            throw new Exception("The inserted option is not valid");
        }
        if (!listOption.contains(option)){
            throw new Exception("Please, insert the number of one valid option");
        }
    }

}