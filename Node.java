// 
// Author: Saloni Rawat
// Class:  Node 
// 
// Description: 
// Creates a Node object (to be used in Binary Tree) which can 
// store the word and it's count respectively. 
// The class also contains setters and getters for the word and count
// the left and right child.
// See methods for more information.
//

public class Node {
	private String data;
	private int count = 0;
	private Node lChild;
	private Node rChild;
	
/////////////////////////////////////////////////////////////////// 
///   Node(							)    						/// 
/// Input : no input							   				/// 
/// Output: no output 											///
/// Returns nothing												///
/// Description: initializes the left and right child to null	///
///////////////////////////////////////////////////////////////////
	
	public Node() {
		lChild = rChild = null;
	}
	
/////////////////////////////////////////////////////////////////// 
///   getData()		                           					/// 
/// Input : No input needed						   				/// 
/// Output: no output 											///
/// Returns the word										   	///
///////////////////////////////////////////////////////////////////
	
	public String getData() {
		return data;
	}
	
/////////////////////////////////////////////////////////////////// 
///   setData(word that needs to be updated)  					/// 
/// Input : the word that needs to be added						///
/// Output: no output 											///
/// Returns nothing 										   	///
///////////////////////////////////////////////////////////////////
	
	public void setData(String data) {
		this.data = data;
	}
	
/////////////////////////////////////////////////////////////////// 
///   getCount()		                      					/// 
/// Input : No input needed						   				/// 
/// Output: no output 											///
/// Returns the count for the word							   	///
///////////////////////////////////////////////////////////////////
	
	public int getCount() {
		return count;
	}
	
/////////////////////////////////////////////////////////////////// 
///   setCount()  												/// 
/// Input : the word that needs to be updated along with the	///
/// Output: no output 											///
/// Returns nothing 										   	///
/// Description: Increments the count by 1						///
///////////////////////////////////////////////////////////////////
	
	public void setCount() {
		count=count+1;
	}
	
/////////////////////////////////////////////////////////////////// 
///   getlChild()  												/// 
/// Input : no input 											///
/// Output: no output 											///
/// Returns the left child									   	///
///////////////////////////////////////////////////////////////////
	
	public Node getlChild() {
		return lChild;
	}
	
/////////////////////////////////////////////////////////////////// 
///   setlChild(Node) 											/// 
/// Input : Node that needs to be added							///
/// Output: no output 											///
/// Returns nothing											   	///
///////////////////////////////////////////////////////////////////
	
	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}
	
/////////////////////////////////////////////////////////////////// 
///   getrChild()  												/// 
/// Input : no input 											///
/// Output: no output 											///
/// Returns the right child									   	///
///////////////////////////////////////////////////////////////////
	
	public Node getrChild() {
		return rChild;
	}
	
/////////////////////////////////////////////////////////////////// 
///   setrChild(Node) 											/// 
/// Input : Node that needs to be added							///
/// Output: no output 											///
/// Returns nothing											   	///
///////////////////////////////////////////////////////////////////
	
	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}

}
