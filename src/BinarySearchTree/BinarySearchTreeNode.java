package BinarySearchTree;

public class BinarySearchTreeNode<T extends Comparable<? super T>> {
	public BinarySearchTreeNode(){
		value = null;
		left = right = null;
		count = 0;		
	}
	public BinarySearchTreeNode(T _value){
		value = _value;
		left = right = null;
		count = 1;
	}
	public BinarySearchTreeNode(BinarySearchTreeNode<T> other){
		assert(other != null);
		value = other.value;
		left = other.left;
		right = other.right;
		count = other.count;		
	}
	public T getValue(){
		return value;
	}
	public void setValue(T _value){
		value = _value;
		count = 0;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int _count){
		count = _count;
	}
	public void incCount(){
		count++;
	}
	
	protected T value;
	protected int count;
	protected BinarySearchTreeNode<T> left;
	protected BinarySearchTreeNode<T> right;
}
