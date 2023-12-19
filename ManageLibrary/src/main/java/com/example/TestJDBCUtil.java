package com.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		try {
			Connection connection = JDBCUtil.getConnection();
			
			Statement st= connection.createStatement();
			
			String sql ="INSERT INTO `library`.`sinhvien` (`masv`, `ten`, `email`, `lop`, `khoa`) "
					+ "VALUES (\'SV01\', \'Vo Thi Phuong Loan\', \'phloankute@gmail.com\', \'21SPT\', \'tin\')";
			int check = st.executeUpdate(sql);
			
			System.out.println("so dong "+ check);
			if (check>0) {
				System.out.println("ok");
			}else {
				System.out.println("fail");
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

