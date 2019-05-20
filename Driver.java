import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//--------------------------------------------------------------------------- 
//
// Driver
//			Parses the text from the file 
// 			as available on  http://www.gutenberg.org/ebooks/345.txt.utf-8.
//
// Author: Saloni Rawat
// Date: 27th Nov 2018
// Class: MET CS342
// Issues: None Known
//
// Description: 
// 			This program parses the text from the file and prints the count of various words and answers the other 
//			questions in the project.
//			See comments below for more information.
//
// Assumption:
//		The Headers and footers are considered part of a file 
// 		The special characters are replace by "" and resulting string is considered to be one word.
//		
// 	

public class Driver {
	
	private BinaryTree bt = new BinaryTree();
	private final String TRANSYLVANIA = "transylvania";
	private final String VAMPIRE = "vampire";
	private final String HARKER = "harker";
	private final String EXPOSTULATE = "expostulate";
	private final String RENFIELD = "renfield";
	private final String FANG = "fang";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		
		me.doReadFromFile();
		//System.out.println("Start printing");
		//me.printTree();
		me.doQ1();
		me.doQ2();
		me.doQ3();
		me.doQ4();
		me.doQ5();
		me.doQ6();
		me.doQ7();
		me.doQ8();
		me.doQ9();
		me.doQ10();
		
	}
	

/////////////////////////////////////////////////////////////////// 
///   doQ1  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: The count for the words - transylvania, vampire,	///
///		harker, expostulate, renfield and fang					///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	public void doQ1() {
		returnCount(TRANSYLVANIA);
		returnCount(VAMPIRE);
		returnCount(HARKER);
		returnCount(EXPOSTULATE);
		returnCount(RENFIELD);
		returnCount(FANG);

	}
	

/////////////////////////////////////////////////////////////////// 
///   doQ2	 ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: The depth of the tree 								///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	public void doQ2() {
		int depth = bt.getTreeDepth();
		
		System.out.println("Depth of the tree is :" +  depth);
	}
	

/////////////////////////////////////////////////////////////////// 
///   doQ3  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: The number of  different words in the book 			///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	public void doQ3() {
		int totalWords = bt.totalWordsTree();
		 
		 System.out.println("The total number of words in the book are: " + totalWords);
	}
	

/////////////////////////////////////////////////////////////////// 
///   doQ4  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: The word at the root 								///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	public void doQ4() {
		Node n = bt.getRoot();
		String data = n.getData();
		
		System.out.println("The word at the root of the tree is : " + data);
	}


/////////////////////////////////////////////////////////////////// 
///   doQ5  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: The words at the deepest leaves in the tree			///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	public void doQ5() {
		System.out.println("The words at the deepest leaves are:" );
		bt.deepestLeaves(bt.getRoot(), 0);
	}
	

/////////////////////////////////////////////////////////////////// 
///   doQ6  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: The total number of words							///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	
	public void doQ6() {
		
		int words = bt.totalWords(bt.getRoot());
		System.out.println("The total number of words in the book are: " + words);
		
	}
	

/////////////////////////////////////////////////////////////////// 
///   doQ7  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: the word that occurs most frequently				///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	
	public void doQ7() {
		Node max = bt.maxFrequency(bt.getRoot());
		
		System.out.println("The word that occurs the most is: " + max.getData() + ". It occurs " + max.getCount() + " times.");
	}
	

/////////////////////////////////////////////////////////////////// 
///   doQ8  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: the first 20 words in Pre-order Traversal			///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	
	public void doQ8() {
		 bt.preOrder();
	}
	
/////////////////////////////////////////////////////////////////// 
///   doQ9  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: the first 20 words in Post-order Traversal			///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	public void doQ9() {
		
		bt.postOrder();
	}
	
/////////////////////////////////////////////////////////////////// 
///   doQ10  ()                           						/// 
/// Input : No data to be inserted                 				/// 
/// Output: the first 20 words in In-order Traversal			///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////

	public void doQ10() {
		
		bt.inOrder();
	}
	
/////////////////////////////////////////////////////////////////// 
///   returnCount ()                       						/// 
/// Input : word whose count needs to be printed   				/// 
/// Output: prints the count for the word 						///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////
	
	public void returnCount(String data) {
		Node temp = bt.getRoot();
		
		int tempCount = bt.returnCount(temp, data);
		
		System.out.println("Count for " + data + " is : " + tempCount);
		
	}


/////////////////////////////////////////////////////////////////// 
///   removeSpecial  (text from which special characters need 	///
///	to be removed)                           					/// 
/// Input : String that needs to be manipulated   				/// 
/// Output: no output 											///
/// Returns String with all special characters removed		   	///
///////////////////////////////////////////////////////////////////

	public String removeSpecial(String text) {
// text = text.replaceAll("[^\\x00-\\x7f]+", "");
// text = text.replace("--", " ");
		text = text.replace("-tm", "");
		text = text.replace(",", "");
		text = text.replace(".", "");
		text = text.replace(":", "");
		text = text.replace("-", "");
		text = text.replace("/", "");
		text = text.replace("@", "");
		text = text.replace("(", "");
		text = text.replace(")", "");
		text = text.replace("'", "");
		text = text.replace("*", "");
		text = text.replace(";", "");
		text = text.replace("?", "");
		text = text.replace("\"", "");
		text = text.replace("!", "");
		text = text.replace("&", "");
		text = text.replace("#", "");
		text = text.replace("$", "");
		text = text.replace("%", "");
		text = text.replace("<", "");
		text = text.replace(">", "");
		text = text.replace("_", "");
		text = text.replace("+", "");
		text = text.replace("=", "");
		text = text.replace(" ", "");

		return text;

	}

/////////////////////////////////////////////////////////////////// 
///   doReadFromFile ()                        					/// 
/// Input : no input							  				/// 
/// Output: no output 											///
/// Returns nothing											   	///
/// Description: Reads the file and populates the list with 	///
///		unique words and their counts							///
///////////////////////////////////////////////////////////////////

	public void doReadFromFile() {

		try {

			Scanner sc = null;

			sc = new Scanner(new File("2018.txt"));

			while (sc.hasNextLine()) {
				Scanner s2 = new Scanner(sc.nextLine());
				while (s2.hasNext()) {
					String s = s2.next();

					String word = s;
					//int listCount;

					word = removeSpecial(word);
					word = word.toLowerCase();
					//System.out.println(word + ",Next Word");
					Node n = bt.getRoot();
					
					if(word.equals("")) {
						continue;
					}

/////////////////////////////////////////////////////////////////// 
///   compares if the word exists in the list, if yes 			///
///		then update the count, otherwise add to list. 			///
///////////////////////////////////////////////////////////////////
					if(bt.treeContains(n, word)!= null) {  // count =1 to start the search at the root
						//increase the count
						Node temp = bt.treeContains(n, word);
						temp.setCount();
						//System.out.println("Count is" + temp.getCount());
						continue;
					}else {
						//System.out.println("Adding new word" + word);
						bt.add(word);
					}
//					if (list.search(word)) {
//						listCount = list.returnCount(word);
//// System.out.println(listCount);
//						listCount = listCount + 1;
//						list.updateCount(word, listCount);
//// System.out.println(word + ", " + listCount);
//					} else {
//						list.addToHead(word, 1);
				}
			}
		} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
