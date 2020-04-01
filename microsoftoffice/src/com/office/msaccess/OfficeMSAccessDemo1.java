package com.office.msaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.BasicConfigurator;

public class OfficeMSAccessDemo1 {

	public static void main(String[] args) {
		

		try {
			//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String databaseURL = "jdbc:ucanaccess://src//com//office//msaccess//db/Person.accdb";

			BasicConfigurator.configure();
			Connection connection = DriverManager.getConnection(databaseURL);
			
			String sql = "INSERT INTO Person (pid,paddess,pname,psalary ) VALUES (?, ?, ?,?)";
			
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, "9");
			preparedStatement.setString(2, "hbl 200");
			preparedStatement.setString(3, "hbl boy");
			preparedStatement.setString(4, "3400");
			
			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println("A row has been inserted successfully.");
			}

			sql = "SELECT * FROM Person";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				String formNo = result.getString("pid");
				String recordNo = result.getString("paddess");
				String salesDate = result.getString("pname");
				String custName = result.getString("psalary");

				System.out.println(formNo + ", " + recordNo + ", " + salesDate + ", " + custName);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
