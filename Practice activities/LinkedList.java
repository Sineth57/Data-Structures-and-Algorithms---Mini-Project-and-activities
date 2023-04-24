public class LinkedList{
    
    private class Node{
        
     private int value;
     private Node nextNode;
     
     public Node(int value){
         this.value = value;
     }
}
    
    private Node firstNode;
    private Node nextNode;
    private Node lastNode;
    
    
    //add to first method
    public void addFrist(int item){
        Node node = new Node(item);
        
        if(firstNode == null){
            firstNode = lastNode = null;
        }else{
            node.nextNode = firstNode;
            firstNode = node;
        }
       
    }
    
    //add to last node
    public void addLast(int item){
        Node node = new Node(item);
        
        if(firstNode == null){
            firstNode = lastNode = null;
        }else{
        
        lastNode.nextNode = node;
        lastNode = node;
        }
    }
    
    //search items index
    public int indexOf(int item){
        
        int index = 0;
        Node currentNode = firstNode;
         
        while (currentNode != null){
            if(currentNode.value == item){
                return index;
            }
            currentNode = currentNode.nextNode;
            index++;
        } 
        
        return -1;
    }
    
    
    //print all methd
    public void printAll(){
        
        Node currentNode = firstNode;
        
        while(currentNode != null) {
           System.out.println(currentNode.value);
           
           currentNode = currentNode.nextNode;
        }
    }
    
    
    
    //delete first node method
    public void deleteFirst(){
        
        if(firstNode == null){  //checking whether the list is empty
            throw new NoSuchElementException(); 
        }
        
        Node secondNode = firstNode.nextNode; //choose second node
        firstNode.nextNode = null; //rmeove pointer
        firstNode = secondNode; //second node assigns to firstNode 
    }
    
    
    
    //delete last node method
    public void deleteLase(){
        Node currentNode = firstNode;
        Node previousNode;
        
        
        while(currentNode =!null){
        
            if(currentNode.nextNode == lastNode){
                previousNode=currentNode;
                lastNode=previousNode;
                lastNode.nextNode=null;
                break;
            }    
            currentNode = currentNode.nextNode;
        }
    }
    
}