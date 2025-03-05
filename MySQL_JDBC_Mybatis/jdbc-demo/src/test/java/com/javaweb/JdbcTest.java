package com.javaweb;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {
    /**
     * JDBC QuickStart
     */
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        //1. driver  --> cliquer deux fois option -> driver mysql jdbc -> copy Reference
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.get the database's connection
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);

        //3. Obtain the SQL execution object
        Statement statement = connection.createStatement();

        //4.execute SQL
        int i = statement.executeUpdate("update user set age = 25 where id = 1");//DML
        System.out.println(i + " rows are affected ^_^" );

        //5. release resource
        statement.close();
        connection.close();

    }

    @Test
    public void testSelect() throws ClassNotFoundException, SQLException {
        // get connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web01", "root", "123456");

        // PreparedStatement object
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");

        // set args
        pstmt.setString(1, "amy"); // the first ? arg
        pstmt.setString(2, "123456"); // the second ? arg

        // execute sql
        ResultSet rs = pstmt.executeQuery();
        // process the results
        while (rs.next()) {
            int id = rs.getInt("id");
            String uName = rs.getString("username");
            String pwd = rs.getString("password");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            System.out.println("ID: " + id + ", Username: " + uName + ", Password: " + pwd + ", Name: " + name + ", Age: " + age);
        }
        // close
        rs.close();
        pstmt.close();
        conn.close();

    }
}
