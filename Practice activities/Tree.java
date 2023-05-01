
package dsa;


public class Tree {
    
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
        
        if(root == null){
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
            }else{
                
                if(currentNode.rightChild == null){
                    currentNode.rightChild = node;
                    break;
                }
                currentNode = currentNode.rightChild; 
            }
        }
        
        
        
        
    
    }
    
    public boolean find(int value){
        Node currentNode = root;
        
        while(currentNode != null){
            if(value < currentNode.value){
                currentNode = currentNode.leftChild;
            }else if(value > currentNode.value){
                currentNode = currentNode.rightChild;
            }else{
                return true;
            }
        }
        
        return false;
    }
    
    public void traversalPreOrder(){
        traversalPreOrder(root);
    }
    
    private void traversalPreOrder(Node root){
        
        if(root == null){
            return;
        }
        
        System.out.println(root.value); //root
        traversalPreOrder(root.leftChild); //left
        traversalPreOrder(root.rightChild); //right
        
    }
    
    public void traversalInOrder(){
        traversalInOrder(root);
    }
    
    
    private void traversalInOrder(Node root){
        if(root == null){
            return;
        }
        
        traversalInOrder(root.leftChild); //left
        System.out.println(root.value); //root        
        traversalInOrder(root.rightChild); //right
    }
    
    
    public void traversalPostOrder(){
        traversalPostOrder(root);
    }
    
    private void traversalPostOrder(Node root){
        if(root == null){
            return;
        }
        
        traversalPostOrder(root.leftChild); //left
        traversalPostOrder(root.rightChild); //right
        System.out.println(root.value); //root        
        
    }
    
}
