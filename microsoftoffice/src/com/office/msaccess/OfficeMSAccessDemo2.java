package com.office.msaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.BasicConfigurator;

public class OfficeMSAccessDemo2 {

	public static void main(String[] args) {
		try {
			//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String databaseURL = "jdbc:ucanaccess://src//com//office//msaccess//db//AGSFormFilling.accdb";

			BasicConfigurator.configure();
			Connection connection = DriverManager.getConnection(databaseURL);
			String sql = "INSERT INTO FormFillingTable (FORM_NO, RECORD_NO, SALES_DATE,CUSTOMER_NAME, INITIALS, EMAIL_ADDRESS, DEALER_NAME, "
					+ "CUSTOMER_ADDRESS, CITY, STATE, CUSTOMER_PHONE, DEALER_PHONE, DELIVERY_TIME, INVOICE_NO, INSURANCE_POLICY_NO,"
					+ "CHESIS_NO,BASIC_AMOUNT,INSURANCE_AMOUNT, TOTAL_AMOUNT, DISCOUNT, NET_AMOUNT, EMPLOYER, CREDIT_CARD_NO,REMARK ) "
					+ "VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, "200_001");
			preparedStatement.setString(2, "8");
			preparedStatement.setString(3, "02/01/2020");
			preparedStatement.setString(4, "Hello Customer");
			
			preparedStatement.setString(5, "H.C.");
			preparedStatement.setString(6, "hi@hello.com");
			preparedStatement.setString(7, "Hello Dealer");
			preparedStatement.setString(8, "Hello Address");
			preparedStatement.setString(9, "Gadag");
			preparedStatement.setString(10, "Kar");
			preparedStatement.setString(11, "12331214");
			preparedStatement.setString(12, "0919989998");
			preparedStatement.setString(13, "Anytime");
			preparedStatement.setString(14, "IN12312312");
			preparedStatement.setString(15, "IP123123123");
			preparedStatement.setString(16, "CH1231231232");
			preparedStatement.setString(17, "0.025");
			preparedStatement.setString(18, "2000");
			preparedStatement.setString(19, "2500");
			preparedStatement.setString(20, "1.2");
			preparedStatement.setString(21, "5000");
			preparedStatement.setString(22, "Self Employed");
			preparedStatement.setString(23, "12345678");
			preparedStatement.setString(24, "NA");

			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println("A row has been inserted successfully.");
			}

			sql = "SELECT * FROM FormFillingTable";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				String formNo = result.getString("FORM_NO");
				String recordNo = result.getString("RECORD_NO");
				String salesDate = result.getString("SALES_DATE");
				String custName = result.getString("CUSTOMER_NAME");

				System.out.println(formNo + ", " + recordNo + ", " + salesDate + ", " + custName);
			}
		} catch (Exception e) {
			e.fillInStackTrace();
		}
	}
}
