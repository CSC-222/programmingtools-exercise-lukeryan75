import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import jave.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**Luke Ryan*/

public class ChainReactionMain {

    public static void main(String[] args){

        ArrayList<ArrayList<String>> wordSets = new ArrayList<>();
        String filename = "wordList.txt";

        try{
            FileInputStream file = new FileInputStream(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String words = scanner.nextLine();
                String[] wordArray = words.split(",");
                ArrayList<String> row = new ArrayList<>(Arrays.asList(wordArray));
                wordSets.add(row);
            }
        }
        catch (FileNotFoundException e){
            System.out.printf("File %s does not exist\n",filename);
        }

        cleanData(wordSets);

        while(true)
        {
            int chainLength = 0;
            int guesses = 0;
            int difficulty = 0;

            System.out.println("*********************************");
            System.out.println("*                               *");
            System.out.println("*       CHAIN REACTION          *");
            System.out.println("*  CAN YOU COMPLETE THE CHAIN?  *");
            System.out.println("*                               *");
            System.out.println("*********************************\n");
			System.out.println("Tutorial..................press 0");
            System.out.println("Beginner..................press 1");
            System.out.println("Pro.......................press 2");
            System.out.println("Superstar.................press 3");
            System.out.println("Custom....................press 4\n");
            System.out.print("SELECT DIFFICULTY: ");
            difficulty = new Scanner(System.in).nextInt();
            switch (difficulty) {
                case 0:{
                    chainLength = 5;
                    guesses = 10;
                    break;
                }
                case 1:{
                    chainLength = 7;
                    guesses = 15;
                    break;
                }
                case 2: {
                    chainLength = 9;
                    guesses = 20;
                    break;
                }
                case 3: {
	             System.out.print("Enter Chain Length: ");
                    chainLength = (new Scanner(System.in)).nextInt();
	             System.out.print("enter number of Guesses: ");
                    guesses = (new Scanner(System.in)).nextInt();
                    break;
                }
                default: {
                    System.out.print("an invalid selection, choose 0-3. ");
                    
                    break;
                }
            }

            ChainReaction c = new ChainReaction(guesses,chainLength, wordSets);
            c.playGame();
            System.out.println("\nPlay Again (y)es or (n)o");
            char option = new Scanner(System.in).next().toLowerCase().charAt(0);
            if(option == 'y'){
                System.out.println("\nTHANK YOU FOR PLAYING!");
                continue;
            }
        }
    }

    public static void cleanData(ArrayList<ArrayList<String>> wordSets){
	set<String> firstWords = new HashSet<>();
	fir (ArrayList<String> row : wordSets) {
		if (!row.isEmpty()){
			firstWords.add(row.get(0));
		}
	}
	    set<Stirng> validWords = new HashSet<>();
	    for (ArrayList<String> row : wordSets) {
		    if (row.size() > 1) {
			    for (String word : row){
				    if (firstWords.contains(word)){
					    validWords.add(word);
					    
				    }
			    }
		    }
	    }
	    int totalWordCount = 0; 
	for (ArrayList<String> row : wordSets) {
		for (String word : row) {
			if (validWords.contains(word)){
				totalWordCount++;
			}
		}
	}
	    int uniqueWordCount = validWords.size();
	    System.out.println("Total Word Count: " + totalWordCount);
	    System.out.println("Number of Unique Words: " + uniqueWordCount);
	    System.out.println("Dataset Cleaning: Complete");
    }
}
