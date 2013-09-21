package BinarySearchTree;

public class BinarySearchTreeNodeInsertVisitor <T extends Comparable<? super T>> extends BinarySearchTreeNodeVisitor<T> {

	public BinarySearchTreeNodeInsertVisitor(T _target, BinarySearchTreeNode<T> root){
		super(root);
		target = _target;
		wasModified = false;
	}
	public BinarySearchTreeNode<T> apply(){
		return applyHelper(this);
	}
	public BinarySearchTreeNode<T> applyHelper(BinarySearchTreeNode<T> root){
		if(root == null){
			wasModified = true;
			return new BinarySearchTreeNode<T>(target);
		}else{
			if(root.value.compareTo(target) == 0){
				root.incCount();			
			}else{
				if(root.value.compareTo(target) > 0){
					root.left = applyHelper(root.left);					
				}else{
					root.right = applyHelper(root.right);
				}				
			}
			return root;
		}
	}
	public boolean wasModified(){
		return wasModified;
	}
	
	private T target;
	private boolean wasModified;
}
