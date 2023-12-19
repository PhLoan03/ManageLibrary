package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.JDBCUtil;

public class thuthuDB {
	public static String getMaThuthuByEmail(String email) {
        String mathuthu = null;

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT mathuthu FROM thuthu WHERE email=?")) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    mathuthu = resultSet.getString("mathuthu");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mathuthu;
	}
	public static boolean isValidUser(String email, String pass) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM thuthu WHERE email = ? AND pass = ?")) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
