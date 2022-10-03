import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import static java.lang.System.out;

public class BinaryTree implements Iterable<Integer> {
	public class Node {
		private int key;
		private int value;
		private Node left, right;
		
		/// <summary>
		/// Constructor for node, without <see cref="Node.left">left</see> and <see cref="Node.right">right</see> references.
		/// </summary>
		/// <param name="key">The key of the node.</param>
		/// <param name="value">The value of the node.</param>
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
		/// <summary>
		/// Get the <see cref="Node.key">key</see> of the node.
		/// </summary>
		/// <returns>The key as integer.</returns>
		public int getKey() {
			return key;
		}
		/// <summary>
		/// Set the <see cref="Node.key">key</see> value.
		/// </summary>
		/// <param name="value">The int value the key should be.</param>
		public void setKey(int value) {
			key = value;
		}
		/// <summary>
		/// Get the <see cref="Node.value">value</see> of the node.
		/// </summary>
		/// <returns>The value as integer.</returns>
		public int getValue() {
			return value;
		}
		/// <summary>
		/// Set the <see cref="Node.value">value</see> of the node.
		/// </summary>
		/// <param name="value">The int value the value should be.</param>
		public void setValue(int value) {
			this.value = value;
		}
		/// <summary>
		/// Get the <see cref="Node.left">left</see> of the node.
		/// </summary>
		/// <returns>The left node reference.</returns>
		public Node getLeft() {
			return left;
		}
		/// <summary>
		/// Set the <see cref="Node.left">left</see> reference.
		/// </summary>
		/// <param name="node">The reference to the left node.</param>
		public void setLeft(Node node) {
			left = node;
		}
		/// <summary>
		/// Get the <see cref="Node.right">right</see> of the node.
		/// </summary>
		/// <returns>The right node reference.</returns>
		public Node getRight() {
			return right;
		}
		/// <summary>
		/// Set the <see cref="Node.right">right</see> reference.
		/// </summary>
		/// <param name="node">The reference to the right node.</param>
		public void setRight(Node node) {
			right = node;
		}
	}
	
	//The root of the binary tree
	private Node root;
	private int treeSize = 0;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int size) {
		Random random = new Random();
		root = new Node(random.nextInt(size * 2 - size / 4, size * 2 + size / 4), 0);
		treeSize++;
		
		while(treeSize < size)
			add(random.nextInt(size*4) + 1, random.nextInt(size) + 1);
	}
	
	/// <summary>
	/// Add a <see cref="Node"/> with <see cref="Node.key">key</see> and <see cref="Node.value">value</see> to the existing tree.
	/// </summary>
	/// <param name="key">The key of the node.</param>
	/// <param name="value">The value of the node.</param>
	public void add(int key, int value) {
		//Add a node if the tree is empty
		if(root == null) {
			root = new Node(key, value);
			treeSize++;
			return;
		}
		
		//Set a pointer to the start of the tree
		Node pointer = root;
		
		while(true) {
			//If a Node with the key already exists, update its value
			if(key == pointer.getKey()) {
				pointer.setValue(value);
				break;
			}
			
			if(key < pointer.getKey()) {
				//Stop the loop if the left reference does not exist
				if(pointer.getLeft() == null)
					break;
				
				//Move down the left of the tree
				pointer = pointer.getLeft();
			}
			else {
				//Stop the loop if the right reference does not exist
				if(pointer.getRight() == null)
					break;
				
				//Move down the right of the tree
				pointer = pointer.getRight();
			}
			
		}
		
		//Set the value right or left.
		if(key < pointer.getKey()) {
			pointer.setLeft(new Node(key, value));
			treeSize++;
		}
		else if(key > pointer.getKey()) {
			pointer.setRight(new Node(key, value));
			treeSize++;
		}
	}
	
	/// <summary>
	/// Lookup a specific <see cref="Node.key"/>.
	/// </summary>
	/// <param name="key">The key to find.</param>
	/// <returns>The <see cref="Node.value"/> if found, otherwise <c>null</c>.</returns>
	public Integer lookup(int key) {
		Node pointer = root;
		
		while(pointer != null) {
			//Return the value if found
			if(pointer.getKey() == key)
				return pointer.getValue();
			
			//Go left if key is smaller otherwise right
			if(key < pointer.getKey())
				pointer = pointer.getLeft();
			else
				pointer = pointer.getRight();
		}
		
		//Return null if not found
		return null;
	}
	
	public Iterator<Integer> iterator() {
		return new TreeIterator();
	}
	
	public class TreeIterator implements Iterator<Integer> {
		private Queue queue;
		Node pointer;
		
		public TreeIterator() {
			pointer = root;
			queue = new Queue();
			
			queue.add(root);
		}
		
		@Override
		public boolean hasNext(){
			return queue.start != null;
		}
		
		@Override
		public Integer next() {
			pointer = queue.remove();
			
			if(pointer.getLeft() != null)
				queue.add(pointer.getLeft());
			if(pointer.getRight() != null)
				queue.add(pointer.getRight());
			
			return pointer.getValue();
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
