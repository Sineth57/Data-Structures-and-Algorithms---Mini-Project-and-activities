
package dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;



public class ListGraph {
    
    private class Node{
        private String label;
        
        public Node(String label){
            this.label = label;
        }
        
        @Override
        public String toString(){
          return label;  
        }
    }
    
    private Map<String,Node> nodes = new HashMap<>();
    private Map<Node,List<Node>> adjacencyList = new HashMap<>();
    
    
    public void addNode(String label){
        Node node = new Node((label));
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node,new ArrayList<>() );
    }
    
    public void addEdge(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        
        if(fromNode == null || toNode == null){
            throw new IllegalArgumentException();
        }
        
        adjacencyList.get(fromNode).add(toNode);
    }
    
    
    public void removeEdge(String from,String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        
        if(fromNode == null || toNode == null){
            return;
        }
        
        adjacencyList.get(fromNode).remove(toNode);
    }
    
    public void removeNode(String label){
        Node node = nodes.get(label);
        
        if(node == null){
            return;
        }
        
        for(Node n : adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
        }
        
        adjacencyList.remove(node);
        nodes.remove(node);
    }
    
    
    public void traverseDFS(String root){
        
        Node node = nodes.get(root);
        
        if(node == null){
          return;  
        }
        
        Set<Node> visited = new HashSet<>(); //RESULT
        Stack<Node> stack = new Stack<>(); //STACK
        stack.push(node);
        
        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            if(visited.contains(currentNode)){
                continue;
            }
            visited.add(currentNode);
            System.out.println(currentNode);
            
            for(Node neighbour : adjacencyList.get(currentNode)){
                if(!visited.contains(neighbour)){
                    stack.push(neighbour);
                }
            }
            
        }
        
    }
    
    public void traverseBFS(String root){
        Node node = nodes.get(root);
        
        if(node == null){
          return;  
        }
        
        Set<Node> visited = new HashSet<>(); //RESULT
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            if(visited.contains(currentNode)){
                continue;
            }
            visited.add(currentNode);
            System.out.println(currentNode);
            
            for(Node neighbour : adjacencyList.get(currentNode)){
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                }
            }
            
        }
        
        
    }
    
    
    
    public void print(){
        for(Node from:adjacencyList.keySet()){
            List<Node> toNodes = adjacencyList.get(from);
            if(!toNodes.isEmpty()){
                System.out.println(from+" is connect to "+toNodes);
            }
        }
    }
    
    
    
    
    
}
