public class Array {

    private int [] items;
    private int count;

    public Array(int length){

        items = new int[length];
    }

    public void insert(int item){

        if(items.length == count){
            int [] temItems = new int[count*2];

            for (int i=0; i<count; i++){
                temItems[i] = items[i];
            }

            items = temItems;
        }
        items[count] = item;
        count++;
    }

    public void display(){
        for (int i=0; i<count; i++){
            System.out.println(items[i]);
        }
    }

    public void removeAt(int index){
        if (index<0 || count <index) {
            throw new IllegalArgumentException();
        }
        for (int i=index;i<count-1;i++){
            items[i] = items[i+1];
        }
        count --;
    }

    public void search(int item){
        for (int i =0; i<count-1;i++){
            if (items[i] == item){

            }
        }

    }
}
