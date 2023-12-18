package org.example;

import java.sql.*;

public class ClientsDB {

    private static Connection connection;
    public ClientsDB(String DB_CONNECTION,String DB_USER, String DB_PASSWORD) {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void createClientDB() {
        try(Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS Client(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(20) NOT NULL," +
                    "surname VARCHAR(20) NOT NULL," +
                    "age INT NOT NULL," +
                    "email VARCHAR(40)"+
                    ")");
            System.out.println("Table 'Client' succesfully created");
        }catch (SQLException e){
            System.out.println( "Create table 'Client' - mistake" + e);
        }

    }

    public void getClientDB(){

        try(Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM Client");

            while (result.next()) {
                System.out.println("UserId : " + result.getString(1)+
                        " Name : "+result.getString(2)+
                        " Surname : "+result.getString(3)+
                        " Age : "+result.getString(4)+
                        " Email : "+result.getString(5)
                );
            }
        }catch (SQLException e){
            System.out.println( "Get info from ClientDB - mistake" + e);
        }

    }
    public void addClientToDB(String name, String surname, int age, String email){

        try(PreparedStatement prepared = connection.prepareStatement("INSERT INTO Client(name, surname, age, email)" +
                " VALUES(?, ?, ?, ?)")){
            prepared.setString(1, name);
            prepared.setString(2, surname);
            prepared.setInt(3, age);
            prepared.setString(4, email);
            prepared.executeUpdate();

            System.out.println( name + " " + surname + " added to ClientDB");


        }catch (SQLException e){
            System.out.println( "Add client to ClientDB - mistake : " + e);
        }

    }

    public void addClientToDB(String name, String surname, int age){

        try(PreparedStatement prepared = connection.prepareStatement("INSERT INTO Client(name, surname, age)" +
                " VALUES(?, ?, ?)")){
            prepared.setString(1, name);
            prepared.setString(2, surname);
            prepared.setInt(3, age);

            prepared.executeUpdate();

            System.out.println( name + " " + surname + " added to ClientDB");


        }catch (SQLException e){
            System.out.println( "Add client to ClientDB - mistake : " + e);
        }

    }


    public void dropClientDB(){
        try(Statement statement = connection.createStatement()){
            statement.execute("DROP TABLE IF EXISTS Client");
            System.out.println( "Table Client dropped");


        }catch (SQLException e){
            System.out.println( "Drop table Client - mistake" + e);
        }
    }

    public static void addTenRandomClients(ClientsDB clientsDB){
        clientsDB.addClientToDB("Fake1", "User", 13, "prosto.acc.fake1@gmail.com");
        clientsDB.addClientToDB("Fake2", "User", 27, "prosto.acc.fake2@gmail.com");
        clientsDB.addClientToDB("Fake3", "User", 12, "prosto.acc.fake3@gmail.com");
        clientsDB.addClientToDB("Fake4", "User", 26);
        clientsDB.addClientToDB("Fake5", "User", 96, "prosto.acc.fake5@gmail.com");
        clientsDB.addClientToDB("Fake6", "User", 32, "prosto.acc.fake6@gmail.com");
        clientsDB.addClientToDB("Fake7", "User", 85, "prosto.acc.fake7@gmail.com");
        clientsDB.addClientToDB("Fake8", "User", 59);
        clientsDB.addClientToDB("Fake9", "User", 103, "prosto.acc.fake9@gmail.com");
        clientsDB.addClientToDB("Fake10", "User", 82);
    }




}
