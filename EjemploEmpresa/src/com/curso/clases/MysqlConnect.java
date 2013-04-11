package com.curso.clases;

import java.sql.*;


public class MysqlConnect{
	
	  static Connection conn = null;
  
	  // Todas las conexiones van a compartir estos atributos: static
	  static String url = "jdbc:mysql://localhost:3306/";
	  static String dbName = "itcourses";
	  static String driver = "com.mysql.jdbc.Driver";
	  static String userName = "root"; 
	  static String password = "root";	
	
	
     public static void main(String[] args) {
	  
    	 System.out.println("MySQL Connect Example");  
	  
		 try {
			 	// Connect to database
			 	Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,password);
				
				System.out.println("Connected to the database");

				// Data base operations
			//	insert(conn);
			//  update(conn);
			//  get(conn);
			// 	delete(conn);
		 
		 } 
		 
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
		 
  }
     
     public static void insert (Connection conn) {
    	 
    	 try {
    	 
	    	 String insertTableSQL = "INSERT INTO IDIOMAS VALUES (?,?,?)";
			  
			  //language types insert
			  PreparedStatement preparedStatement = null;
			  preparedStatement = conn.prepareStatement(insertTableSQL);		  
			    
			  preparedStatement.setInt(1, 4);
			  preparedStatement.setString(2, "cat");
			  preparedStatement.setString(3, "Catalan");
						
			  preparedStatement.executeUpdate();
			  
			  // Close connection
			  conn.close();
			  System.out.println("Disconnected from database");
    	 }
    	 
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
		 
  }

	 public static void update (Connection conn) {
		  
		 try {
			  
			  
			  String SQL = "UPDATE IDIOMAS SET ABBREVIATION = ? WHERE ID_LANGUAGE = ?";
			  
			  //language types update
			  PreparedStatement preparedStatement = null;
			  preparedStatement = conn.prepareStatement(SQL);		  

			  preparedStatement.setString(1, "mm");
			  preparedStatement.setInt(2, 4);
			
			  preparedStatement.executeUpdate();  
			  
			  
			  // Close connection
			  conn.close();
			  System.out.println("Disconnected from database");
    	 }
    	 
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
		 
  }

	  public static void get (Connection conn) {
		  
			 try {
				 
				  String id = "2";
				 				  
				  String SQL = "SELECT * FROM IDIOMAS WHERE ID_LANGUAGE = "+id;
				  
				  //language types get
				  PreparedStatement preparedStatement = null;
				  preparedStatement = conn.prepareStatement(SQL);				  

				  ResultSet results = preparedStatement.executeQuery(SQL);

				  while (results.next()) {
					  System.out.println("Result obtained: "+ results.getString(2) );
					  System.out.println("Result obtained: "+ results.getString("DESCRIPTION") );
				  }

				  // Close connection
				  conn.close();
				  System.out.println("Disconnected from database");
	    	 }
	    	 
			 catch (Exception e) {
				 System.out.println(e.getMessage());
			 }
			 
	  }
	  
	  
		 public static void delete (Connection conn) {
			  
			 try {

				  String SQL = "DELETE IDIOMAS WHERE ID_LANGUAGE = ?";
				  
				  //language types delete
				  PreparedStatement preparedStatement = null;
				  preparedStatement = conn.prepareStatement(SQL);			  

				  preparedStatement.setInt(1, 3);		  	
							
				  preparedStatement.executeUpdate();  

				  // Close connection
				  conn.close();
				  System.out.println("Disconnected from database");
	    	 }
	    	 
			 catch (Exception e) {
				 System.out.println(e.getMessage());
			 }
			 
	  }
 
}
