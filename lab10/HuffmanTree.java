public String decode(String message){
	StringBuilder result = new StringBuilder;
	BinaryTree<HuffData> currentTree = huffData;
	for(int i = 0; i < codeMessage.length(); i++){
		if(codeMessage.charAt(i) == '1'){
			currentTree = currentTree.getRightSubtree();
		} else {
			currentTree = currentTree.getLeftSubtree();
		}
		if(currentTree.isLeaf()){
			HuffData theData = currentTree.getData();
			result.append(theData.symbol);
			currentTree = huffTree;
		}
	}
	return result.toString();
}
public static void main(String[] args){
	
}