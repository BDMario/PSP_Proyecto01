import Model.Records;
import View.AskingData;

import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
        int numberOfRecords = new AskingData().NumberOfRecords();
        int numberOfThreads = new AskingData().NumberOfThreads();

        int range = numberOfRecords / numberOfThreads;
        int rest = numberOfRecords % numberOfThreads;

		for (int x = 0; x < numberOfThreads; x++) {

            if (rest != 0 && x < rest) {
                new Records(range + 1).start();
            } else {
                new Records(range).start();
            }

		}

    }
}
