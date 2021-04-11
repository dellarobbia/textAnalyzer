package analysisDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Controls connection to MYSQL DB built for the program
 * @author Andrew McKay
 *
 */
public class DBController 
{
	private String filename;
	
	//Constructor
	public DBController(String filename) 
	{
		setFilename(filename + "-" + System.getProperty("user.name") + "-" + LocalDateTime.now());
	}
	
	//Getters & Setters
	public String getFilename()
	{
		return filename;
	}
	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	//Class methods
	/**
	 * Opens a connection to mySQL DB using the text analyzer program's log-in credentials
	 * @return open Connection object
	 */
	public Connection openDBConnection()
	{
		Connection dbConnection = null;
		
		try 
		{
			dbConnection = DriverManager.getConnection("jdbc:sqlite:wordOccurences.db");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return dbConnection;
	}
	
	/**
	 * Close a DB connection
	 * @param openConnection
	 */
	public void closeDBConnection(Connection openConnection)
	{
		try
		{
			openConnection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a word and its occurences in the file being analyzed
	 * @param addWord String representing the word being added to the DB
	 * @param addOccurance int representing the number of times the word occured in the file
	 */
	public void addWordOccurance(String addWord, int addOccurance)
	{
		Connection textAnalyzerDB = openDBConnection();
		
		String addRecordSQL = 
				"INSERT INTO wordOccurences (fileName, word, occurences) " +
				"VALUES (?, ?, ?);";
		
		try
		{
			PreparedStatement addWordOccuranceStatement = textAnalyzerDB.prepareStatement(addRecordSQL);
			addWordOccuranceStatement.setString(1, filename);
			addWordOccuranceStatement.setString(2, addWord);
			addWordOccuranceStatement.setInt(3, addOccurance);
			addWordOccuranceStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		closeDBConnection(textAnalyzerDB);
	}
	
	public HashMap<String, Integer> queryWordOccurences()
	{
		Connection textAnalyzerDB = openDBConnection();
		HashMap<String, Integer> queryResults = new HashMap<String, Integer>();
		
		String wordOccurencesQuery = 
				"SELECT word, occurences " +
				"FROM wordOccurences " +
				"WHERE filename = '" + filename + "'";
		
		ResultSet query = queryResults(wordOccurencesQuery, textAnalyzerDB);
		
		try 
		{
			if(query.next())
			{
				do
				{
					queryResults.put(query.getString("word"), query.getInt("occurences"));
				} while(query.next());
			}
			else
				System.out.println(wordOccurencesQuery);
				
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return queryResults;
	}
	
	/**
	 * Return the results of a query
	 * @param sql SQL command String
	 * @param textAnalyzerDB database Connection object
	 * @return ResultSet of query results
	 */
	private ResultSet queryResults(String sql, Connection textAnalyzerDB) 
	{
		ResultSet newResultSet = null;
		PreparedStatement sqlStatement = null;
		
		try
		{
			sqlStatement = textAnalyzerDB.prepareStatement(sql);
			newResultSet = sqlStatement.executeQuery();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.out.print("SQL statement: \n" + sql + "\n");
			System.exit(0);
		}
		
		return newResultSet;
	}
}
