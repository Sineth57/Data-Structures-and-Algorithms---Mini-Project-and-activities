public class AlgorithmTest {

public static void main(String[] args) {
StackList numbers = new StackList(); // Initialize Stack List
numbers.push(10);
numbers.push(20);
numbers.push(30);
numbers.push(40);
numbers.show();

int peekItemFirst = numbers.peek();
System.out.println("Peek Item First "+ peekItemFirst); // 40

int popItem = numbers.pop();
System.out.println("Pop Item "+ popItem); // 40

int peekItemLast = numbers.peek();
System.out.println("Peek Item Last "+ peekItemLast); // 30

numbers.show(); // 10,20,30,0,0

}
}

class StackList{
int[] numbers = new int[5];
int count = 0;

// Show
public void show(){
for (int element: numbers) {
System.out.print(element+", ");
}
}

// pop
public int pop(){
// count = 3
count--; // count = count - 1
// [10,20,***30***,0,0],
int popData = numbers[count]; // count = 2
// [0,1,***2***,3,4]
numbers[count] = 0;

return popData;
}
// push
public void push(int data){ // push(10), push(20)
numbers[count] = data; // 0 -> 10, 1 -> 20
count++; // 1, 2
// [10,20,0,0,0]
}
// peek
public int peek(){
return numbers[count-1];
}
// search
public int search(){
return 0;
}

}