package org.example;


import java.sql.SQLException;

public class Main {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/____?serverTimezone=Europe/Kiev";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "_______";
    public static void main(String[] args) {

        //CLIENTS DB

        ClientsDB clientsDB = new ClientsDB(DB_CONNECTION, DB_USER, DB_PASSWORD);

        clientsDB.dropClientDB();
        clientsDB.createClientDB();


        ClientsDB.addTenRandomClients(clientsDB);
        clientsDB.addClientToDB("VLadyslav", "Dryk", 19, "prosto.acc.vlada@gmail.com");
        clientsDB.addClientToDB("Anastasia", "Prosto", 27, "prosto.acc.nastya@gmail.com");
        clientsDB.getClientDB();


        //ORDERS DB

        OrdersDB ordersDB = new OrdersDB(DB_CONNECTION, DB_USER, DB_PASSWORD);

        ordersDB.dropOrderDB();
        ordersDB.createOrderDB();


        OrdersDB.addTenRandomOrders(ordersDB);
        ordersDB.addOrderToDB(999, 888);
        ordersDB.addOrderToDB(666, 777);

        ordersDB.getOrderDB();
    }
}