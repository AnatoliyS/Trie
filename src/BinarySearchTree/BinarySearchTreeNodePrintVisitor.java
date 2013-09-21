package BinarySearchTree;

public class BinarySearchTreeNodePrintVisitor<T extends Comparable<? super T>> extends BinarySearchTreeNodeVisitor<T> {

	public BinarySearchTreeNodePrintVisitor(BinarySearchTreeNode<T> root){
		super(root);
		res = new StringBuilder();
	}
	public BinarySearchTreeNode<T> apply(){
		applyHelper(this);
		return null;
	}
	public void applyHelper(BinarySearchTreeNode<T> root){
		if(root.left != null){
			applyHelper(root.left);
		}
		res.append(root.value.toString() + " ");
		if(root.right != null){
			applyHelper(root.right);
		}			
	}
	public String getPrint(){
		return res.toString();
	}

	private StringBuilder res;
}