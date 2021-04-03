package textAnalyzer;

/**
 * Classes responsible for performing different analyses on a given text.
 * @author Andrew McKay
 *
 */

public interface Analyzers 
{
	/**
	 * Perform an analysis on a string of text
	 * @param analyzeText string of text to be analyzed
	 * @return Text string of analysis results
	 */
	String analyze(String analyzeText);
}
