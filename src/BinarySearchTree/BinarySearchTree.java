package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<? super T>> {
	public BinarySearchTree(){
		size = 0;
		root = null;
	}
	
	public void insert(T value){
		if(size == 0){
			root = new BinarySearchTreeNode<T> (value);
			size = 1;
		}else{
			BinarySearchTreeNodeInsertVisitor<T> insertVisitor = new BinarySearchTreeNodeInsertVisitor<T>(value, root);
			root = insertVisitor.apply();
			if(insertVisitor.wasModified()){
				size++;
			}
		}
	}
	
	public boolean find(T value){
		if(size == 0) return false;
		BinarySearchTreeNodeVisitor<T> findVisitor = new BinarySearchTreeNodeFindVisitor<T>(value, root);
		BinarySearchTreeNode<T> result = findVisitor.apply();
		return (result != null);
	}
	
	public int getCount(T value){
		if(size == 0) return 0;
		BinarySearchTreeNodeVisitor<T> findVisitor = new BinarySearchTreeNodeFindVisitor<T>(value, root);
		BinarySearchTreeNode<T> result = findVisitor.apply();		
		return (result != null) ? result.getCount() : 0;
	}
	
	public String treeToString(){
		BinarySearchTreeNodePrintVisitor<T> printVisitor = new BinarySearchTreeNodePrintVisitor<T>(root);
		printVisitor.apply();
		return printVisitor.getPrint();
	}
	
	public int getSize(){
		return size;
	}
	
	public void clean(){
		if(size == 0) return;
		BinarySearchTreeNodeCleanVisitor<T> cleanVisitor = new BinarySearchTreeNodeCleanVisitor<T>(root);
		root = cleanVisitor.apply();
		size = 0;
	}
	
	private BinarySearchTreeNode<T> root;
	private int size;
}
