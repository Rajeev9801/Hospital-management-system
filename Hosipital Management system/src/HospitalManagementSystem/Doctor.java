package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    private Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;

    }
    public void viewDoctors() {
        String query = "select * from doctor";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctor: ");
            System.out.println("+---------------+--------------------+----------------------+");
            System.out.println("| Doctor Id    | Name               | specialization        |");
            System.out.println("+---------------+--------------------+----------------------+");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specilization");
                System.out.printf("|%-15s|%-20s|%-23s|%n", id, name, specialization);
                System.out.println(("+---------------+--------------------+----------------------+"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean getDoctorById(int id){
        String query = "SELECT * FROM Patient WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;


    }
}

