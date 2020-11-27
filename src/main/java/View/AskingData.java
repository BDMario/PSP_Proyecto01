package View;

import java.util.Scanner;

public class AskingData {
    public int NumberOfRecords() {
        Scanner sc = new Scanner(System.in);
        boolean gotRecords = true;
        do{
            System.out.println("Escriba el numero de registros que desee introducir: ");
            String records = sc.nextLine();
            //Call a method to check if the string given is an integer greater than 0
            int newRecords = checkIfIntGreaterThan0(records);
            if (newRecords > 0) {
                System.out.println("Number of records saved");
                gotRecords = false;
                return newRecords;
            } else if (newRecords == 0) {
                System.out.println("Need at least one record");
            }
        }while(gotRecords);
        sc.close();
        //Returns -1 if something went wrong to handle it
        return -1;
    }

    public int NumberOfThreads() {
        Scanner sc = new Scanner(System.in);
        boolean gotThreads = true;
        do{
            System.out.println("Escriba el numero de hilos que desee utilizar: ");
            String numberOfThreads = sc.nextLine();
            int newNumberOfThreads = checkIfIntGreaterThan0(numberOfThreads);
            if(newNumberOfThreads > 0) {
                System.out.println("Number of threads saved");
                gotThreads = false;
                return newNumberOfThreads;
            } else if (newNumberOfThreads == 0){
                System.out.println("Need at least one thread");
            }
        }while(gotThreads);
        sc.close();
        return -1;
    }

    private static int checkIfIntGreaterThan0(String value) {
        try { //If records is a valid number, numberOfThreads will be asked
            int newValue = Integer.parseInt(value);
            if (newValue > 0) {
                return newValue;
            } else {
                return 0;
            }
        }
        catch (NumberFormatException e){
            System.out.println(value + " is not a valid number");
            return -1;
        }
    }
}
