import java.util.*;

public class Main {
	
	private static class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	public static void display(Node node) {
		String str = node.data + " -> ";
		for(Node child: node.children) {
			str += child.data + ", ";
		}
		System.out.println(str);
		
		for(Node child: node.children) {
			display(child);
		}
	}
	
	public static void main(String[] args){
		//Generic Tree Data
		int arr[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		
		Stack<Node> st = new Stack<>();
		Node root = null;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == -1) {
				st.pop();
			}else {
				Node n = new Node();
				n.data = arr[i];
				if(st.size() > 0) {
					st.peek().children.add(n);
				}else {
					root = n;
				}
				st.push(n);
			}
		}		
		display(root);
    }
}

