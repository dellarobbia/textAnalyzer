package textAnalyzer;

import java.util.Scanner;

public interface ConsoleMenus<T>
{
	void dispPrompt(String prompt);
	T getUserInput(Scanner userInput);
}
