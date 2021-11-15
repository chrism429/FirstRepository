// Author Name: Chris Morris
// Date: 10/17/2021
// Program Name: Morris_Word_Occurrence
// Purpose: Read a file and output statistics based on the file read. Outputs word frequencies, sorted by most frequently occurring word.
// Purpose: Create a JUnitTest for the first time to test classes

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Morris_Word_Occurences extends Application {
	
	/** 
	 * create button and basic application with button to read file as the center
	 */
	
	Button button;
		
		public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("Word Occurrence File Reader");
			button = new Button();
			button.setText("Read File");
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			Scene scene = new Scene(layout, 200, 200);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}

	public static void main(String[] args) throws FileNotFoundException {
		
			launch(args);
		
		/**
		 *  Read file word by word
		 */
		File macbeth = new File("C:\\Users\\User\\Documents\\MacbethPlayTxt.txt");
		/**
		 *  Seems that this file could be too big to properly read all the words in the text... It's not producing the correct result. But this program works for other texts.
		 */
		Scanner input = new Scanner(macbeth);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (input.hasNext()) {
			String reader = input.next();
			if (map.containsKey(reader) == false)
				map.put(reader, 1);
			else {
				int count = (int)(map.get(reader));
				map.remove(reader);
				map.put(reader, count+1);
			}
			
		}
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); {
		Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() 
		{
			public int compare (Map.Entry<String, Integer> x, Map.Entry<String, Integer> y) {
				return (y.getValue()).compareTo(x.getValue());
		}
		} );
		for (Map.Entry<String, Integer> i:sortedList) {
			System.out.println(i.getKey() + " --- This word occurred this many times: " + i.getValue());
		}
	}
		input.close();
}
}