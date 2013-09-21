package BinarySearchTree;

public abstract class BinarySearchTreeNodeVisitor<T extends Comparable<? super T>> extends BinarySearchTreeNode<T> {
	public BinarySearchTreeNodeVisitor(){}
	public BinarySearchTreeNodeVisitor(BinarySearchTreeNode<T> root){
		super(root);
	}
	public abstract BinarySearchTreeNode<T> apply();
}
