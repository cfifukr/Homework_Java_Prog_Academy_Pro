package org.example;

import java.sql.*;
import java.util.Random;

public class OrdersDB{

    private static Connection connection;
    public OrdersDB(String DB_CONNECTION,String DB_USER, String DB_PASSWORD) {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void createOrderDB() {
        try(Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS Ord (" +
                            "orderId INT AUTO_INCREMENT PRIMARY KEY," +
                            "goodId INT NOT NULL, " +
                            "userId INT NOT NULL, " +
                            "date DATETIME DEFAULT current_timestamp" +
                            ")");
            System.out.println("Table 'Order' succesfully created");
        }catch (SQLException e){
            System.out.println( "Create table 'Order' - mistake" + e);
        }

    }

    public void getOrderDB(){

        try(Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM Ord");

            while (result.next()) {
                System.out.println("OrderId : " + result.getString(1)+
                        ", UserID : "+result.getString(2)+
                        ", GoodID : "+result.getString(3)+
                        ", Date and Time : "+result.getString(4));
            }
        }catch (SQLException e){
            System.out.println( "Get info from OrderDB - mistake" + e);
        }

    }
    public void addOrderToDB(int userId, int goodId){

        try(PreparedStatement prepared = connection.prepareStatement("INSERT INTO Ord(goodId, userId)" +
                " VALUES(?, ?)")){
            prepared.setInt(1, goodId);
            prepared.setInt(2, userId);
            prepared.executeUpdate();

            System.out.println( "User#" + userId + " have ordered good#" + goodId);


        }catch (SQLException e){
            System.out.println( "Add order to OrderDB - mistake : " + e);
        }

    }


    public void dropOrderDB(){
        try(Statement statement = connection.createStatement()){
            statement.execute("DROP TABLE IF EXISTS Ord");
            System.out.println( "Table 'Order' dropped");


        }catch (SQLException e){
            System.out.println( "Drop table 'Order' - mistake" + e);
        }
    }

    public static void addTenRandomOrders(OrdersDB ordersDB){
        Random random = new Random();
        for(int i = 0; i < 10; i ++ ){
            ordersDB.addOrderToDB(random.nextInt(100),random.nextInt(100));
        }

    }




}
