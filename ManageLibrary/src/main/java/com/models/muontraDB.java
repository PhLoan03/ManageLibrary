package com.models;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.JDBCUtil;

public class muontraDB {
    public static int insertMuonTra(muontra muonTra) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO muontra (masv, masach, ngaymuon, trangthai, mathuthu) VALUES (?, ?, ?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, muonTra.getMasv());
            preparedStatement.setInt(2, muonTra.getMasach());
            preparedStatement.setString(3, muonTra.getNgaymuon());
            preparedStatement.setString(4, muonTra.getTrangthai());
            preparedStatement.setString(5, muonTra.getMathuthu());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (var generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        muonTra.setMamuontra(generatedId);
                        System.out.println("ID mượn trả vừa được tạo: " + generatedId);
                        return generatedId;
                    } else {
                        System.out.println("Không thể lấy ID mượn trả được tạo.");
                        return 0;
                    }
                }
            } else {
                System.out.println("Thêm mượn trả thất bại");
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static List<muontra> getAllMuonTra() {
        List<muontra> muontras = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM muontra");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int mamuontra = resultSet.getInt("mamuontra");
                String masv = resultSet.getString("masv");
                int masach = resultSet.getInt("masach");
                String ngaymuon = resultSet.getString("ngaymuon");
                String trangthai = resultSet.getString("trangthai");
                String mathuthu = resultSet.getString("mathuthu");

                muontra muonTra = new muontra(mamuontra, masv, masach, mathuthu, ngaymuon, trangthai);
                muontras.add(muonTra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return muontras;
    }

    public static boolean deleteMuonTra(int mamuontra) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM muontra WHERE mamuontra = ?")) {

            preparedStatement.setInt(1, mamuontra);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateMuonTra(int mamuontra, muontra updatedMuonTra) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE muontra SET masv = ?, masach = ?,mathuthu = ?, ngaymuon = ?, trangthai = ? WHERE mamuontra = ?")) {

            preparedStatement.setString(1, updatedMuonTra.getMasv());
            preparedStatement.setInt(2, updatedMuonTra.getMasach());
            preparedStatement.setString(3, updatedMuonTra.getMathuthu());
            preparedStatement.setString(4, updatedMuonTra.getNgaymuon());
            preparedStatement.setString(5, updatedMuonTra.getTrangthai());
            preparedStatement.setInt(6, mamuontra);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static muontra getMuonTraById(int idMuonTra) {
        muontra muonTra = null;

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM muontra WHERE mamuontra = ?")) {

            preparedStatement.setInt(1, idMuonTra);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int mamuontra = resultSet.getInt("mamuontra");
                    String masv = resultSet.getString("masv");
                    int masach = resultSet.getInt("masach");
                    String ngaymuon = resultSet.getString("ngaymuon");
                    String trangthai = resultSet.getString("trangthai");
                    String mathuthu = resultSet.getString("mathuthu");

                    muonTra = new muontra(mamuontra, masv, masach, mathuthu, ngaymuon, trangthai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return muonTra;
    }
    public static boolean updateMuonTraStatus(int mamuontra) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE muontra SET trangthai = 'Đã trả' WHERE mamuontra = ?")) {

            preparedStatement.setInt(1, mamuontra);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<muontra> getFilteredMuonTra(String tenFilter, String ngayMuonFilter, String maThuThuFilter, String maSinhVienFilter, String trangThaiFilter, String maSachFilter) {
        List<muontra> muontras = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = buildFilteredQuery(connection, tenFilter, ngayMuonFilter, maThuThuFilter, maSinhVienFilter, trangThaiFilter, maSachFilter);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int mamuontra = resultSet.getInt("mamuontra");
                String masv = resultSet.getString("masv");
                int masach = resultSet.getInt("masach");
                String ngaymuon = resultSet.getString("ngaymuon");
                String trangthai = resultSet.getString("trangthai");
                String mathuthu = resultSet.getString("mathuthu");

                muontra muonTra = new muontra(mamuontra, masv, masach, mathuthu, ngaymuon, trangthai);
                muontras.add(muonTra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return muontras;
    }

    private static PreparedStatement buildFilteredQuery(Connection connection, String tenFilter, String ngayMuonFilter, String maThuThuFilter, String maSinhVienFilter, String trangThaiFilter, String maSachFilter) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM muontra WHERE 1=1");

        if (tenFilter != null && !tenFilter.isEmpty()) {
            query.append(" AND masv IN (SELECT masv FROM docgia WHERE ten LIKE ?)");
        }
        if (ngayMuonFilter != null && !ngayMuonFilter.isEmpty()) {
            query.append(" AND ngaymuon = ?");
        }
        if (maThuThuFilter != null && !maThuThuFilter.isEmpty()) {
            query.append(" AND mathuthu = ?");
        }
        if (maSinhVienFilter != null && !maSinhVienFilter.isEmpty()) {
            query.append(" AND masv = ?");
        }
        if (trangThaiFilter != null && !trangThaiFilter.isEmpty()) {
            query.append(" AND trangthai = ?");
        }
        if (maSachFilter != null && !maSachFilter.isEmpty()) {
            query.append(" AND masach = ?");
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

        int parameterIndex = 1;
        if (tenFilter != null && !tenFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, "%" + tenFilter + "%");
        }
        if (ngayMuonFilter != null && !ngayMuonFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, ngayMuonFilter);
        }
        if (maThuThuFilter != null && !maThuThuFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, maThuThuFilter);
        }
        if (maSinhVienFilter != null && !maSinhVienFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, maSinhVienFilter);
        }
        if (trangThaiFilter != null && !trangThaiFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex++, trangThaiFilter);
        }
        if (maSachFilter != null && !maSachFilter.isEmpty()) {
            preparedStatement.setString(parameterIndex, maSachFilter);
        }

        return preparedStatement;
    }
    public static List<muontra> getMuonTraQuaHan() {
        List<muontra> muontras = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM muontra WHERE trangthai = ? AND ngaymuon IS NOT NULL")) {

            preparedStatement.setString(1, "Chưa trả");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int maMuonTra = resultSet.getInt("mamuontra");
                    String maSV = resultSet.getString("masv");
                    int maSach = resultSet.getInt("masach");
                    String ngayMuon = resultSet.getString("ngaymuon");
                    String trangThai = resultSet.getString("trangthai");
                    String maThuThu = resultSet.getString("mathuthu");

                    muontra muontra = new muontra(maMuonTra, maSV, maSach, maThuThu, ngayMuon, trangThai);

                    // Kiểm tra xem đã quá hạn mượn hay chưa
                    if (muontra.isQuaHan()) {
                        muontras.add(muontra);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return muontras;
    }

    
}
