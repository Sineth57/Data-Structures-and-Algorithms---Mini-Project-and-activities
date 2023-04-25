class Queue{
    private int[] items;
    private int rear;
    private int count;
    private int front;
    
    public Queue(int size){
        items = new int[size];
    }
    
    public void enqueue(int item){
        if (count == items.length){
            throw new IllegalAccessError();
            
        } 
        
        //circualr array
        items[rear] = item;
        rear = (rear + 1)%items.length;
        count++;
        
    }
    
    public int dequeue(){
        int item = items[front];
        items[front] =0;
        front = (front+1)%items.length;
        count--;
        return item;
    }
    
    public void isEmpty(){
        return count == 0;
    }
    
    public void isFull(){
        return count == items.length;
    }
    
    public void size(){
        return count;
    }
    
    public void peek(){
        return items[front];
    }
    
    public void display(){
        System.out.println(Arrays.toString(items));
    }
}


public class Main
{
	public static void main(String[] args) {
	
	Queue queue = new Queue(5);
	
	}
}
