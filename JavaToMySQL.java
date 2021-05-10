package javaprojects.test_task_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JavaToMySQL {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/students";
    private static final String user = "root";
    private static final String password = "123456";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void start() {
        String query = "select count(*) from list";
        Scanner scanner = new Scanner(System.in);

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Current number of students : " + count +
                        ". \nChoose your next action. Type:\n'ADD' to create " +
                        "a new student;\n'DELETE' to remove a student with " +
                        "an unique ID;\n'SHOW' to print students list");
            }
            // start executing commands
            String ask = scanner.nextLine();
            while (!ask.equals("EXIT")) {
                try {
                    newQuery(ask);
                    ask = scanner.nextLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Read the instructions properly!");
                }
            }

            System.out.println("Goodbye!");

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) {}
            try {
                stmt.close();
            } catch (SQLException se) {}
            try {
                rs.close();
            } catch (SQLException se) {}
        }
    }

    public static void newQuery(String ask) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String query;

        //Print all students in console
        if (ask.equals("SHOW")) {
            query = "select id, name, surname, patronymic, class, birthday from list";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String patronymic = rs.getString(4);
                String group = rs.getString(5);
                String birthday = rs.getString(6);
                System.out.printf("ID: %d, %s %s %s %s %s %n", id, name, surname, patronymic, group, birthday);
            }
        }

        //Add a new student
        if (ask.equals("ADD")) {
            System.out.println("Please input info about new student in format:\n" +
                    "Ivan Ivanovich Ivanov 11A 2003-06-07");

            String s = scanner.nextLine();
            query = "INSERT INTO students.list (name, surname, patronymic, class, birthday) \n" +
                    " VALUES ('"
                    + s.split(" ")[0] + "', " + "'"
                    + s.split(" ")[1] + "', " + "'"
                    + s.split(" ")[2] + "', " + "'"
                    + s.split(" ")[3] + "', " + "'"
                    + s.split(" ")[4] + "');";
            stmt.executeUpdate(query);
        }

        //Delete a student by ID (Auto-incrementing in SQL)
        if (ask.equals("DELETE")) {
            System.out.println("Input the unique ID of the student:");

            int i = scanner.nextInt();
            query = "DELETE FROM students.list\n" +
                    "WHERE id='" + i + "';";
            stmt.executeUpdate(query);
            System.out.println("Command executed. Input 'SHOW' to see the changes");
        }
    }
}