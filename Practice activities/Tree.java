
public class Tree{
    private class Node{
        
        private int value;
        private Node leftChild;
        private Node rightChild;
        
        public Node(int value){
            this.value = value;
        }
        
    }
    
    private Node root;
    
    public void insert(int value){
        
        Node node = new Node(value);
        
    if (root == null){
    
    root = node;
    return;
    }
    
    Node currentNode = root;
        while(true){
           if(value < currentNode.value){
               
               if(currentNode.leftChild == null){
                   currentNode.leftChild = node;
                   break;
               }
               
               currentNode = currentNode.leftChild;
   } else{
       
       if(curr.rightChild == null){
           currentNode.rightChild = node;
           break;
       }
       currentNode = currentNode.rightChild;
   }
        }
    }
    
    
    public void find(int vale){
        Node currentNode = root;
        
        while(currentNode != null){
            if(value < currentNode.value){
                currentNode = currentNode.leftChild;
            }
            else if(value > currentNode.value){
                currentNode = currentNode.rightChild
                
            }
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		Tree tree = new Tree;
		
		tree.insert(10);
	}
}
