// 
// Author: Saloni Rawat
// Class:  BinaryTree 
// 
// Description: 
// Creates a binary tree of type Nodes. The class has methods to find the depth of the tree, add/search word, 
// maximum frequency word and total number of words in the tree
// See methods for more information.
//

public class BinaryTree {

	private Node root, temp;
	private int count, preOrderCount = 0, postOrderCount = 0, inOrderCount = 0, max = 0, sum= 0;
	private int maxDepth;

/////////////////////////////////////////////////////////////////// 
///   BinaryTree(							)    				/// 
/// Input : no input							   				/// 
/// Output: no output 											///
/// Returns nothing												///
/// Description: initializes the root to null and count = 0 	///
///////////////////////////////////////////////////////////////////
	
	public BinaryTree() {
		root = null;
		count = 0;
	}

/////////////////////////////////////////////////////////////////// 
///   getRoot()		                           					/// 
/// Input : No input needed						   				/// 
/// Output: no output 											///
/// Returns the root of the binary tree						   	///
///////////////////////////////////////////////////////////////////
	
	public Node getRoot() {

		return root;
	}

///////////////////////////////////////////////////////////////////////////
///   getTreeDepth()                           							/// 
/// Input : No input needed						   						/// 
/// Output: no output 													///
/// Returns the depth of the tree by calling getTreeDepth(Node, int) 	///
///////////////////////////////////////////////////////////////////////////
	
	public int getTreeDepth() {
		maxDepth = 0;
		return getTreeDepth(root, 0);
	}

	// returns count of a particular string
	
/////////////////////////////////////////////////////////////////// 
///   returnCount(Node, String)                					/// 
/// Input : the root of the tree, the word		   				/// 
/// Output: no output 											///
/// Returns the count of the word							   	///
///////////////////////////////////////////////////////////////////
	
	public int returnCount(Node root, String data) {

		Node n = treeContains(root, data);
		if (n == null) {
			return 0;
		}
		return n.getCount();

	}
	
/////////////////////////////////////////////////////////////////// 
///   getTreeDepth(Node, int)                					/// 
/// Input : the root of the tree, depth			   				/// 
/// Output: no output 											///
/// Returns the depth of the tree							   	///
///////////////////////////////////////////////////////////////////	

	private int getTreeDepth(Node root, int depth) {
		if (root == null) {
			return depth - 1;
		}
		if (depth > maxDepth) {
			maxDepth = depth;
		}
		int lChildDepth = getTreeDepth(root.getlChild(), depth + 1);
		int rChildDepth = getTreeDepth(root.getrChild(), depth + 1);

		return lChildDepth > rChildDepth ? lChildDepth : rChildDepth;
	}

/////////////////////////////////////////////////////////////////// 
///   prettyPrintTree()		      -- NOT USED  					/// 
/// Input : no input							   				/// 
/// Output: no output 											///
/// Returns nothing 										   	///
/// Description: Calls the prettyPrintTree(Node,int,int)		///
///////////////////////////////////////////////////////////////////
	
	public void prettyPrintTree() {
		System.out.print("prettyPrintTree starting");
		for (int i = 0; i <= this.getTreeDepth(); i++) {
			prettyPrintTree(root, 0, i);
			System.out.println();
		}
	}

/////////////////////////////////////////////////////////////////// 
///   prettyPrintTree(Node, int, int)      -- NOT USED			/// 
/// Input : root, currentlevel, desiredlevel	   				/// 
/// Output: prints the entire tree								///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////
	
	private void prettyPrintTree(Node root, int curLevel, int desiredLevel) {
		if (root == null) {
			if (curLevel == desiredLevel) {
				System.out.print("<> ");
			}
			return;
		}

		prettyPrintTree(root.getlChild(), curLevel + 1, desiredLevel);
		if (curLevel == desiredLevel) {
			System.out.print("<" + root.getData() + "> ");
		}
		prettyPrintTree(root.getrChild(), curLevel + 1, desiredLevel);
	}

/////////////////////////////////////////////////////////////////// 
///   treeContains(Node, String)	      						/// 
/// Input : root and the word to search			   				/// 
/// Output: no output 											///
/// Returns the node containing the string 					   	///
///////////////////////////////////////////////////////////////////
	
	public Node treeContains(Node root, String data) {
		if (root == null) {
			// Tree is empty, so it certainly doesn't contain data.
			// System.out.println("Root is empty");
			return null;
		} else if (data.equals(root.getData())) {
			// Yes, the data has been found in the root node.
			return root;
		} else if (data.compareTo(root.getData()) < 0) {
			// If the data occurs, it must be in the left subtree.
			// count++;
			return treeContains(root.getlChild(), data);
		} else {
			// If the data occurs, it must be in the right subtree.
			// count++;
			return treeContains(root.getrChild(), data);
		}

	}

	// Add attempt 2
/////////////////////////////////////////////////////////////////// 
///   add(String)												/// 
/// Input : word to be added 					   				/// 
/// Output: no output											///
/// Returns nothing 										   	///
///	Description: Calls the recAdd method						///
///////////////////////////////////////////////////////////////////
	
	public void add(String data) {
		// System.out.println("Starting Add");
		if (root == null) {
			// First item in tree
			Node ng = new Node();
			ng.setData(data);
			// System.out.println("Ng data: " + ng.getData());

			root = ng;
			// System.out.print("Root added : " + root.getData());
			count = 1;

		} else {
			recAdd(data, root);
		}
	}

/////////////////////////////////////////////////////////////////// 
///   recAdd(String, Node)										/// 
/// Input : root and the word to add			   				/// 
/// Output: no output											///
/// Returns nothing 										   	///
///	Description: adds the word to the tree						///
///////////////////////////////////////////////////////////////////
	
	private void recAdd(String data, Node root) {
		if (root == null) {
			System.out.println("OOPS, this shouldn't happen!!");
			System.exit(0);
		}

		if (data.compareTo(root.getData()) < 0) {
/////////////////////////////////
///   go to left			  ///
/////////////////////////////////
			if (root.getlChild() == null) {
				// put the data on the left child
				Node ng = new Node();
				ng.setData(data);
				ng.setCount();
				root.setlChild(ng);
				count++;
				return;
			} else {
				recAdd(data, root.getlChild());
			}
		} else {
/////////////////////////////////
///   go to right			  ///
/////////////////////////////////
			if (root.getrChild() == null) {
				// put the data on the left child
				Node ng = new Node();
				ng.setData(data);
				ng.setCount();
				root.setrChild(ng);
				count++;
				return;
			} else {
				recAdd(data, root.getrChild());
			}

			// System.out.println("Count: " + count);
		}

	}
	
/////////////////////////////////////////////////////////////////// 
///   totalWordsTree()											/// 
/// Input : no input							   				/// 
/// Output: no output											///
/// Returns the count of the items in the tree				   	///
///////////////////////////////////////////////////////////////////

	public int totalWordsTree() {
		return count;
	}

/////////////////////////////////////////////////////////////////// 
///   preOrder()												/// 
/// Input : no input							   				/// 
/// Output: no output											///
/// Returns nothing 										   	///
///	Description: Calls the preOrder(Node) method				///
///////////////////////////////////////////////////////////////////
	
	public void preOrder() {
		System.out.print("PRE:  ");

		preOrder(root);
		System.out.println();

	}

/////////////////////////////////////////////////////////////////// 
///   preOrder(Node)											/// 
/// Input : no input							   				/// 
/// Output: prints the first 20 words in a pre-Order 			///
/// traversal of the tree									   	///
///////////////////////////////////////////////////////////////////
	private void preOrder(Node root) {

		if (root == null) {
			return;
		}
		if (preOrderCount < 20) {

			System.out.print("< " + root.getData() + " > ");
			//System.out.println(" Count: " + preOrderCount);
			preOrderCount++;
			preOrder(root.getlChild());
			preOrder(root.getrChild());
		}

	}

/////////////////////////////////////////////////////////////////// 
///   inOrder()													/// 
/// Input : no input							   				/// 
/// Output: no output											///
/// Returns nothing 										   	///
///	Description: Calls the inOrder(Node) method					///
///////////////////////////////////////////////////////////////////
	
	public void inOrder() {
		System.out.print("IN:   ");
		inOrder(root);
		System.out.println();
	}

/////////////////////////////////////////////////////////////////// 
///   inOrder(Node)												/// 
/// Input : no input							   				/// 
/// Output: prints the first 20 words in a in-Order 			///
/// traversal of the tree									   	///
///////////////////////////////////////////////////////////////////
	
	private void inOrder(Node root) {
		// inOrderCount++;
		// System.out.println(" Count: " + inOrderCount);
		if (root == null) {
			return;
		}

		// System.out.println(" Count: " + inOrderCount);
		inOrder(root.getlChild());
		if (inOrderCount < 20) {
			System.out.print("< " + root.getData() + " > ");
			inOrderCount++;
			//System.out.println(" Count: " + inOrderCount);
		}
		inOrder(root.getrChild());

	}

/////////////////////////////////////////////////////////////////// 
///   postOrder()												/// 
/// Input : no input							   				/// 
/// Output: no output											///
/// Returns nothing 										   	///
///	Description: Calls the postOrder(Node) method				///
///////////////////////////////////////////////////////////////////
	
	public void postOrder() {
		System.out.print("POST: ");
		postOrder(root);
		System.out.println();
	}

/////////////////////////////////////////////////////////////////// 
///   postOrder(Node)											/// 
/// Input : no input							   				/// 
/// Output: prints the first 20 words in a post-Order 			///
/// traversal of the tree									   	///
///////////////////////////////////////////////////////////////////
	
	private void postOrder(Node root) {
		if (root == null) {
			return;
		}

		postOrder(root.getlChild());
		postOrder(root.getrChild());
		if (postOrderCount < 20) {
			postOrderCount++;
			System.out.print("< " + root.getData() + " > ");
			//System.out.println(" Count: " + postOrderCount);

		}

	}
	
/////////////////////////////////////////////////////////////////// 
///   maxFrequency(Node)										/// 
/// Input : root								   				/// 
/// Output: no output											///
/// Returns the node containing the word that occurs max  	   	///
///////////////////////////////////////////////////////////////////
	
	public Node maxFrequency(Node root) {
		
		if(root == null) {
			return null;
		}
		
		//System.out.println("The count for " + root.getData() + " is " + root.getCount());
/////////////////////////////////////////////////////////////////////////
///   checks if the max is greater than count of root 				  ///
///		if yes, update the value of the Max with count of root		  ///
/////////////////////////////////////////////////////////////////////////
		
		if(max<root.getCount()) {
			max = root.getCount();
			temp = root;
			
			
		}
		
		maxFrequency(root.getlChild());
		maxFrequency(root.getrChild());
		
		return temp;
	}
	
/////////////////////////////////////////////////////////////////// 
///   totalWords(Node)											/// 
/// Input : root								   				/// 
/// Output: no output											///
/// Returns the sum of the ocunts of all nodes			 	   	///
///////////////////////////////////////////////////////////////////
	
	public int totalWords(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		//System.out.println("The count for " + root.getData() + " is " + root.getCount());
/////////////////////////////////////////////////////////////////
///   adds the count of the node root to the sum			  ///
/////////////////////////////////////////////////////////////////
		sum = sum + root.getCount();
		
		totalWords(root.getlChild());
		totalWords(root.getrChild());
		
		return sum;
	}
	
/////////////////////////////////////////////////////////////////// 
///   deepestLeaves(Node)										/// 
/// Input : root								   				/// 
/// Output: prints the words in the deepest leaves				///
/// Returns nothing										 	   	///
///////////////////////////////////////////////////////////////////
	
	public void deepestLeaves(Node root, int level) {
		
		
		if(root == null) {
			return;
		}
		
		//System.out.println("the current word is " + root.getData());
/////////////////////////////////////////////////////////////////////////
///   checks if the max is greater than count of root 				  ///
///		if yes, update the value of the Max with count of root		  ///
/////////////////////////////////////////////////////////////////////////
		
		if((root.getlChild() == null)	&& (root.getrChild() == null) && level == getTreeDepth() ) {
			//System.out.println("left Child : " + root.getlChild() + " right child : " + root.getrChild());
			System.out.print("Deepest Leaves: ");
			//max = root.getCount();
			temp = root;
			
			System.out.println(temp.getData());
			
			
		}
		
		deepestLeaves(root.getlChild(), level+1);
		deepestLeaves(root.getrChild(), level+1);
		
		
	}
}
