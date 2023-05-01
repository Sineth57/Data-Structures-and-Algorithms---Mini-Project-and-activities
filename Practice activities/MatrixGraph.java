
package dsa;


public class MatrixGraph {
    
    private boolean matrix[][];
    private int verTexCount;
    
    public MatrixGraph(int verTexCount){
        this.verTexCount = verTexCount;
        matrix = new boolean[verTexCount][verTexCount];
    }
    
    
    public void addEdge(int x, int y){
        
        if(x >= 0 && y >= 0  && x < verTexCount && y < verTexCount){
            matrix[x][y] = true; 
            matrix[y][x] = true;
        } else{
            throw new IllegalArgumentException();
        }   
    }
    
    public void removeEdge(int x , int y){
        if(x >= 0 && y >= 0  && x < verTexCount && y < verTexCount){
            matrix[x][y] = false; 
            matrix[y][x] = false;
        } else{
            throw new IllegalArgumentException();
        }  
    }
    
    public boolean isEdge(int x, int y){
        if(x >= 0 && y >= 0  && x < verTexCount && y < verTexCount){
            return matrix[x][y];
        } 
        return false;
    }
    
    
    public void print(){
        for(boolean val[] : matrix){
            for(boolean v : val){                
                System.out.print((v ? 1:0)+" ");
            }
            System.out.println();
        }
    }
    
}
