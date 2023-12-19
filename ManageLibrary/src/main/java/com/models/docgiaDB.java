package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.JDBCUtil;

public class docgiaDB {
	public static List<docgia> getAllDocGia() {
        List<docgia> docGias = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM sinhvien");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String masv = resultSet.getString("masv");
                String ten = resultSet.getString("ten");
                String email = resultSet.getString("email");
                String lop = resultSet.getString("lop");
                String khoa = resultSet.getString("khoa");

                docgia docGia = new docgia(masv, ten, email, lop, khoa);
                docGias.add(docGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return docGias;
    }
	public static List<docgia> getFilteredDocGia(String maSvFilter, String tenFilter, String emailFilter, String lopFilter, String khoaFilter) {
        List<docgia> docGias = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection()) {
            StringBuilder query = new StringBuilder("SELECT * FROM sinhvien WHERE 1=1");

            if (maSvFilter != null && !maSvFilter.isEmpty()) {
                query.append(" AND masv = ?");
            }

            if (tenFilter != null && !tenFilter.isEmpty()) {
                query.append(" AND ten LIKE ?");
            }

            if (emailFilter != null && !emailFilter.isEmpty()) {
                query.append(" AND email = ?");
            }

            if (lopFilter != null && !lopFilter.isEmpty()) {
                query.append(" AND lop = ?");
            }

            if (khoaFilter != null && !khoaFilter.isEmpty()) {
                query.append(" AND khoa = ?");
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {
                int parameterIndex = 1;

                if (maSvFilter != null && !maSvFilter.isEmpty()) {
                    preparedStatement.setString(parameterIndex++, maSvFilter);
                }

                if (tenFilter != null && !tenFilter.isEmpty()) {
                    preparedStatement.setString(parameterIndex++, "%" + tenFilter + "%");
                }

                if (emailFilter != null && !emailFilter.isEmpty()) {
                    preparedStatement.setString(parameterIndex++, emailFilter);
                }

                if (lopFilter != null && !lopFilter.isEmpty()) {
                    preparedStatement.setString(parameterIndex++, lopFilter);
                }

                if (khoaFilter != null && !khoaFilter.isEmpty()) {
                    preparedStatement.setString(parameterIndex++, khoaFilter);
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String masv = resultSet.getString("masv");
                        String ten = resultSet.getString("ten");
                        String email = resultSet.getString("email");
                        String lop = resultSet.getString("lop");
                        String khoa = resultSet.getString("khoa");

                        docgia docGia = new docgia(masv, ten, email, lop, khoa);
                        docGias.add(docGia);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return docGias;
    }
}
