package BinarySearchTree;

public class BinarySearchTreeNodeCleanVisitor<T extends Comparable<? super T>> extends BinarySearchTreeNodeVisitor<T> {

	public BinarySearchTreeNodeCleanVisitor(BinarySearchTreeNode<T> root){
		super(root);
	}
	public BinarySearchTreeNode<T> apply(){
		applyHelper(this);
		return null;
	}
	public void applyHelper(BinarySearchTreeNode<T> root){
		if(root.left != null){
			applyHelper(root.left);
		}
		if(root.right != null){
			applyHelper(root.right);
		}
		root = null;
	}
}