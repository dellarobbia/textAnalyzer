package test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import analysisDB.DBController;

class TestDBController 
{
	@Test
	void testOpenDBConnection()
	{
		DBController testDBController = new DBController("filename not needed for this test");
		
		testDBController.openDBConnection();
	}
	
	@Test
	void testQueryWordOccurences()
	{
		DBController testDBController = new DBController("testFile");
		//override DBController's unique identifier for filenames
		testDBController.setFilename("testFile");
		HashMap<String,Integer> testQueryResults = testDBController.queryWordOccurences();
		boolean pass = false;
		
		if(testQueryResults.get("test") == 1)
			pass = true;
		
		assertTrue(pass);
	}
	
	@Test
	void testAddWordOccurance()
	{
		DBController testDBController = new DBController("testRecord");
		
		HashMap<String,Integer> testResults = new HashMap<String, Integer>();
		
		testDBController.addWordOccurance("testWord", 1);
		
		testResults = testDBController.queryWordOccurences();
		
		boolean pass = false;
		
		if(testResults.get("testWord") == 1)
			pass = true;
		
		assertTrue(pass);
	}
}
