//Christopher Morris
// Date 9/9/2021
// Program Name: Spell Checker
// This program reads two files(test file and dictionary) to make sure the words spelled in the test file are accurately spelled.

package morris_spellcheck;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Morris_SpellCheck {
	
	static ArrayList<String> test = new ArrayList<String>();
	static ArrayList<String> dictionary = new ArrayList<String>();
			
	public static void main(String[] args) throws IOException {
	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the file to be checked: ");	
		String testFile = input.nextLine();
		System.out.print("Enter the dictionary: ");
		String dictFile = input.nextLine();
		
		SpellChecker(testFile, dictFile);
		
		input.close();
	}
		
		private static void SpellChecker(String testFile, String dictFile) throws IOException {
			
			String words;
			
			try 
				(BufferedReader BuffRead = new BufferedReader(new FileReader(testFile))) {
					while ((words = BuffRead.readLine()) != null) {
						test.add(words);
					}
				}
			try
				(BufferedReader BuffRead2 = new BufferedReader(new FileReader(dictFile))) {
					while ((words = BuffRead2.readLine()) != null) {
						dictionary.add(words);
					}
				}
	
	Iterator<String> SpellCheckIterator = test.iterator();
	while (SpellCheckIterator.hasNext()) {
		String checkword = SpellCheckIterator.next();
	if (!dictionary.contains(checkword)) {
		System.out.println(checkword + " is an unknown word!");
	}
}	
}
}