import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTreeOperations {
	public Node buildTree() {
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
		
		if(data == -1)
			return null;
		
		Node root = new Node(data);
		root.left = buildTree();
		root.right = buildTree();
		return root;
	}
	
	public boolean search(Node root, int value) {
		//base case
		if(root == null)
			return false;
		
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		
		while(true) {			// level-order traversal
			int nodeCount = que.size();
			if(nodeCount == 0)
				break;
			
			while(nodeCount > 0) {
				Node node = que.peek();
				if(node.data == value) {
					//System.out.println("Node is found");
					return true;
				}
				que.remove();
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
				nodeCount--;
			}
		}
		//System.out.println("Node not found");
		return false;
	}
	
	public void printNthLevel(Node root, int n) {  // root node is level 0
		if(root == null)
			return;
		if(n == 0)
			System.out.print(root.data + " ");
		
		printNthLevel(root.left, n-1);
		printNthLevel(root.right, n-1);
	}
	
	public int heightOfTree(Node root) {
		if(root ==  null)
			return 0;
		
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public int diameterOfTree(Node root) {
		if(root == null)
			return 0;
		
		int diameter_1 = heightOfTree(root.left) + heightOfTree(root.right);
		int diameter_2 = diameterOfTree(root.left) + diameterOfTree(root.right);
		return Math.max(diameter_1, diameter_2) + 1;
		
	}
}

class Main{
	public static void main(String[] args) {
		
		BinaryTreeOperations tree = new BinaryTreeOperations();
		Node root = tree.buildTree();
		
		if(tree.search(root, 2))
			System.out.println("Node is found");
		else
			System.out.println("Node not found");
		
		tree.printNthLevel(root, 2);
		
		System.out.println("\n" + "Height of the tree: " + tree.heightOfTree(root));
		
		System.out.println("Diameter of the tree: " + tree.diameterOfTree(root));
	}
}

/*
 *        5
 *       / \
 *      4   6
 *     /   / \
 *    2   7   8
 *    
 * Input: 5 4 2 -1 -1 -1 6 7 -1 -1 8 -1 -1
 * 
 *  Output:
 *		Node is found
 *		2 7 8 
 *		Height of the tree: 3
 *		Diameter of the tree: 6
 */
