package BinarySearchTree;


public class BinarySearchTreeNodeFindVisitor<T extends Comparable<? super T>> extends BinarySearchTreeNodeVisitor<T> {
	public BinarySearchTreeNodeFindVisitor(T _target, BinarySearchTreeNode<T> root){
		super(root);
		target = _target;		
	}
	public BinarySearchTreeNode<T> apply(){
		return applyHelper(this);
	}
	public BinarySearchTreeNode<T> applyHelper(BinarySearchTreeNode<T> root){
		if(root == null){
			return null;
		}else{
			if(root.value.compareTo(target) == 0){
				return root;
			}else{
				if(root.value.compareTo(target) < 0){
					return applyHelper(root.left); 
				}else{
					return applyHelper(root.right);
				}
			}
		}
	}
	
	private T target;
}
