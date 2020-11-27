package Model;

import com.github.javafaker.Faker;

import java.sql.*;

public class Records extends Thread{
    private final int numberOfRecords;

    public Records(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    @Override
    public void run() {
        super.run();
        try {
            String myURL = "jdbc:mysql://localhost/bbdd_psp_1";
            Connection conn = DriverManager.getConnection(myURL,"root","");
            // create a Statement from the connection
            Statement statement = conn.createStatement();
            // insert the data for every record assigned to this thread
            Faker emailFake;
            for (int x = 0; x < numberOfRecords; x++){
                //Create a fake email with a maven repository
                emailFake = new Faker();
                emailFake.internet().emailAddress();
                statement.executeUpdate("INSERT INTO `empleados`(`EMAIL`, `INGRESOS`) VALUES ('" + emailFake + "','" + ((int) (Math.random() * (10-1000 + 1) +1000)) + "')");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
