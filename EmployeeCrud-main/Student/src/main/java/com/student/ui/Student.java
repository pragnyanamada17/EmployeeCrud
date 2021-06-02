package com.student.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.core.util.StringUtils;

public class Student {
	public static void main(String[] args) {
		try {
			Connection connection = null;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "apple", "apple123");
			System.out.println("connection sucessfull");

			Scanner sc = new Scanner(System.in);

			@SuppressWarnings("unused")
			String name;
			@SuppressWarnings("unused")
			int Rollno;
			int marks;
			char Grade = 0;
			Scanner s = new Scanner(System.in);

			System.out.println("1.Add new Student Grade");
			System.out.println("2.veiw all gardes ");
			System.out.println("3.exit");
			System.out.println("please enter your choice");
			int ch = s.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Add new Student");
				System.out.println("Student roll no");
				Rollno = s.nextInt();

				System.out.println(" Student name");
				name = s.next();
				if(StringUtils.isStrictlyNumeric(name)) {
					throw new Exception("name should be letters");
				}
				System.out.println(" marks obtained");
				marks = s.nextInt();

				String q = "insert into student(Rollno,name,marks) values(?,?,?)";
				PreparedStatement pstmt = connection.prepareStatement(q);
				Statement smt = connection.createStatement();
				ResultSet rs = smt.executeQuery("select Rollno from student");
				while (rs.next()) {
					if (Rollno == rs.getInt("Rollno")) {
						throw new Exception("Rollnumber already exits");
					}
					
				}

				pstmt.setInt(1, Rollno);

				pstmt.setString(2, name);
				pstmt.setInt(3, marks);

				if (marks < 0)
					throw new Exception("negative number");
				else

					pstmt.executeUpdate();

				System.out.println("inserting...");

				pstmt.close();

				if (marks >= 90) {
					Grade = 'A';
				} else if (marks >= 80 && marks < 90) {
					Grade = 'B';
				} else if (marks >= 60 && marks < 80) {
					Grade = 'C';
				} else if (marks >= 40 && marks < 60) {
					Grade = 'D';
				} else {
					Grade = 'E';
				}

				System.out.println("Your grade is " + Grade);
				break;
			case 2:

				System.out.println("veiw all gardes ");
				System.out.println("\r\n" + "1. More than equals 90 marks is Grade A\r\n"
						+ "2. More than equals 80 less than 90 is grade B\r\n"
						+ "3. More than equals 60 less than 80 is grade C\r\n"
						+ "4. More than equals 40 less than 60 is grade D\r\n" + "5. Less than 40 is Grade E");

			case 3:

				System.out.println("Thank you for using the application");
				System.exit(0);
				break;

			}

		} catch (

		Exception E) {
			System.out.println(E);
		}
	}
}
