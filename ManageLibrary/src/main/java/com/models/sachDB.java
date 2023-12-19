package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.JDBCUtil;

public class sachDB {
	public static int insertSach(sach sach) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO sach (tensach, slsach, ngaynhap, mathuthu, theloai) VALUES (?, ?, ?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, sach.getTensach());
            preparedStatement.setInt(2, sach.getSlsach());
            preparedStatement.setString(3, sach.getNgaynhap());
            preparedStatement.setString(4, sach.getMathuthu());
            preparedStatement.setString(5, sach.getTheloai());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        sach.setMasach(generatedId); 
                        System.out.println("ID sách vừa được tạo: " + generatedId);
                        return generatedId;
                    } else {
                        System.out.println("Không thể lấy ID sách được tạo.");
                        return 0;
                    }
                }
            } else {
                System.out.println("Thêm sách thất bại");
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
	public static List<sach> getAllBooks() {
        List<sach> books = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM sach");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int masach = resultSet.getInt("masach");
                String tensach = resultSet.getString("tensach");
                int slsach = resultSet.getInt("slsach");
                String ngaynhap = resultSet.getString("ngaynhap");
                String mathuthu = resultSet.getString("mathuthu");
                String theloai = resultSet.getString("theloai");

                sach book = new sach(masach, tensach, slsach, ngaynhap, mathuthu, theloai);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
	public static boolean updateBookById(int masach, sach updatedBook) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE sach SET tensach = ?, slsach = ?, ngaynhap = ?, mathuthu = ?, theloai = ? WHERE masach = ?")) {

            preparedStatement.setString(1, updatedBook.getTensach());
            preparedStatement.setInt(2, updatedBook.getSlsach());
            preparedStatement.setString(3, updatedBook.getNgaynhap());
            preparedStatement.setString(4, updatedBook.getMathuthu());
            preparedStatement.setString(5, updatedBook.getTheloai());
            preparedStatement.setInt(6, masach);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Book with ID " + masach + " updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update book with ID " + masach + ". No rows affected.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteSach(int masach) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM sach WHERE masach = ?")) {

            preparedStatement.setInt(1, masach);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static sach getBookById(int masach) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM sach WHERE masach = ?")) {

            preparedStatement.setInt(1, masach);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String tensach = resultSet.getString("tensach");
                    int slsach = resultSet.getInt("slsach");
                    String ngaynhap = resultSet.getString("ngaynhap");
                    String mathuthu = resultSet.getString("mathuthu");
                    String theloai = resultSet.getString("theloai");

                    return new sach(masach, tensach, slsach, ngaynhap, mathuthu, theloai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static List<sach> getFilteredBooks(String tenSachFilter, String maThuThuFilter, String theLoaiFilter, String ngayNhapFilter) {
        List<sach> sachList = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = buildFilteredQuery(connection, tenSachFilter, maThuThuFilter, theLoaiFilter, ngayNhapFilter);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int masach = resultSet.getInt("masach");
                String tensach = resultSet.getString("tensach");
                int slsach = resultSet.getInt("slsach");
                String ngaynhap = resultSet.getString("ngaynhap");
                String mathuthu = resultSet.getString("mathuthu");
                String theloai = resultSet.getString("theloai");

                sach sachObj = new sach(masach, tensach, slsach, ngaynhap, mathuthu, theloai);
                sachList.add(sachObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sachList;
    }

    public static PreparedStatement buildFilteredQuery(Connection connection, String tenSachFilter, String maThuThuFilter, String theLoaiFilter, String ngayNhapFilter) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM sach WHERE 1=1");

        if (tenSachFilter != null && !tenSachFilter.isEmpty()) {
            query.append(" AND tensach LIKE ?");
        }
        if (maThuThuFilter != null && !maThuThuFilter.isEmpty()) {
            query.append(" AND mathuthu = ?");
        }
        if (theLoaiFilter != null && !theLoaiFilter.isEmpty()) {
            query.append(" AND theloai LIKE ?");
        }
        if (ngayNhapFilter != null && !ngayNhapFilter.isEmpty()) {
            query.append(" AND ngaynhap = ?");
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

        int parameterIndex = 1;
        if (tenSachFilter != null && !tenSachFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, "%" + tenSachFilter + "%");
        }
        if (maThuThuFilter != null && !maThuThuFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, maThuThuFilter);
        }
        if (theLoaiFilter != null && !theLoaiFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, "%" + theLoaiFilter + "%");
        }
        if (ngayNhapFilter != null && !ngayNhapFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex, ngayNhapFilter);
        }

        return preparedStatement;
    }

}
