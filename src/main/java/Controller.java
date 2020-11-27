import Model.Records;
import View.AskingData;

import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
        int numberOfRecords = new AskingData().NumberOfRecords();
        int numberOfThreads = new AskingData().NumberOfThreads();

        //Set a range and rest to assign to each thread
        int range = numberOfRecords / numberOfThreads;
        int rest = numberOfRecords % numberOfThreads;

		for (int x = 0; x < numberOfThreads; x++) {
            //If the rest isnt 0, it will start adding 1 at the range so the first threads will cover it
            if (rest != 0 && x < rest) {
                new Records(range + 1).start();
            } else {
                new Records(range).start();
            }

		}

    }
}
