import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class BinaryTree {
	

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
	
	public void inorderTraversal(Node root) {
		if(root == null)
			return;

		// left - root -right
		inorderTraversal(root.left);
		System.out.print(root.data + ", ");
		inorderTraversal(root.right);
	}
	
	public void preorderTraversal(Node root) {
		if(root == null)
			return;

		// root - left - right
		System.out.print(root.data + ", ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	public void postorderTraversal(Node root) {
		if(root == null)
			return;
		
		// left - right - root
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data + ", ");
	}
	
	public void levelorderTraversal(Node root) {
		
	}	
}

class Main{
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree();
		
		System.out.print("Inorder Traversal of tree is: ");
		tree.inorderTraversal(root);
		System.out.println();
		
		System.out.print("Preorder Traversal of tree is: ");
		tree.preorderTraversal(root);
		System.out.println();
		
		System.out.print("Postorder Traversal of tree is: ");
		tree.postorderTraversal(root);
		System.out.println();
		
		System.out.println("Levelorder Traversal of tree is: ");
		tree.levelorderTraversal(root);	
		System.out.println();
	}
}
