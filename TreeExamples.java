import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeExamples {
	
	public static Node root=null;
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
		}
		
	}
	
	public Node insert(Node temp,int data) {
		Node newNode = new Node(data);
		Queue<Node> q = new LinkedList<Node>();
		if(temp==null) {
			temp=newNode;
		}
		else {
			q.offer(temp);
			while(!q.isEmpty()) {
				Node node=q.poll();
				if(node.left!=null)
					q.offer(node.left);
				else if(node.right!=null)
					q.offer(node.right);
				else if(node.left==null)
					node.left=newNode;
				else
					node.right=newNode;
			}
			
		}
		q.clear();
		return temp;
	}
	
	public void printLevelOrder() {
		Queue<Node> q = new LinkedList<Node>();
		if(root!=null)
		q.offer(root);
		while(!q.isEmpty()) {
			Node node=q.poll();
			System.out.print(node.data+"->");
			if(node.left!=null)
				q.offer(node.left);
			if(node.right!=null)
				q.offer(node.right);
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeExamples tree =new TreeExamples();
		Scanner sc = new Scanner(System.in);
		//Node newNode = new Node(4);
		//root=newNode;
		System.out.println("How Many nodes");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("enter node value  " +(i+1) );
			root=tree.insert(root, sc.nextInt());
		}
		
		tree.printLevelOrder();

	}

}
