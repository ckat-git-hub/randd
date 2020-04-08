package com.data.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.data.service.AntiqueDataExportService;

@Service
public class AntiqueDataExportServiceImpl implements AntiqueDataExportService {
	
	/*
	@Autowired
    DataSource dataSource; */
	
	@Autowired
	Environment environment;

	@Override
	public void exportFormDataAsMSAccessForm() {

		try {
			//Access DB Url
			String databaseURL = "jdbc:ucanaccess://D:\\test\\dataentry\\product\\workspace\\msaccess-export-api\\src\\com\\data\\service\\template\\AGSFormFilling.accdb";

			//Create DataSource here
		    DataSource driverManagerDataSource = new DriverManagerDataSource();
			((DriverManagerDataSource)driverManagerDataSource).setUrl(databaseURL);
			((DriverManagerDataSource)driverManagerDataSource).setDriverClassName("net.ucanaccess.jdbc.UcanaccessDriver");

			//get connection here
			Connection connection = driverManagerDataSource.getConnection();

			//Insert to table sql query
			String sql = "INSERT INTO FormFillingTable (FORM_NO, RECORD_NO, SALES_DATE,CUSTOMER_NAME, INITIALS, EMAIL_ADDRESS, DEALER_NAME, "
					+ "CUSTOMER_ADDRESS, CITY, STATE, CUSTOMER_PHONE, DEALER_PHONE, DELIVERY_TIME, INVOICE_NO, INSURANCE_POLICY_NO,"
					+ "CHESIS_NO,BASIC_AMOUNT,INSURANCE_AMOUNT, TOTAL_AMOUNT, DISCOUNT, NET_AMOUNT, EMPLOYER, CREDIT_CARD_NO,REMARK ) "
					+ "VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";

			//Delete all records from table for fresh entries
			String truncateTab = "DELETE FROM FormFillingTable";
			PreparedStatement preparedStatement = connection.prepareStatement(truncateTab);
			preparedStatement.executeUpdate();
			System.out.println("## Table truncated successfully. ##");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, "200_001");
			preparedStatement.setString(2, "2");
			preparedStatement.setString(3, "02/01/2020");
			preparedStatement.setString(4, "Hello Customer1");

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
