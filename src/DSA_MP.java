import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Array {
 
    char[] items;
    int count;

    public Array(int aLength){

        items = new char[aLength];
    }


    //insert an item to the end
    public void insertItem(char aChar){
        items[count] = aChar;
        count++;
    }


    //getting the index of the charactor
    public int itemIndex(char aChar){
        for(int i=0; i<count; i++){
            if(items[i] == aChar){
                return i;
            }
        }
        return -1;
    }

}


class Letters {

    Array alphabet = new Array(52);

    public Letters(){

        insertChar();

    }

    public void insertChar(){
        int val = 0;

        //to get only the simple letters with ascii values
        for(char c = 97 ; c <= 122 ;c++){
            alphabet.insertItem(c);
        }

        //for get only the capital letters with ascii values
        for(char c = 65 ; c <= 90 ; c++){
            alphabet.insertItem(c);
        }

    }

    public int getValue(Character c){

        return alphabet.itemIndex(c);
    }



}

class LinkedListB {

     class Node{
        String nWord;
        int nValue;
        Node nextNode;

        public Node(String nWord, int nValue){
            this.nWord = nWord;
            this.nValue = nValue;
        }
    }

    Node firstNode;
    Node lastNode;


    //adding the node to the end
    public void addEnd(String nWord, int nValue){
        Node node = new Node(nWord,nValue);

        if(firstNode == null){
            firstNode=lastNode=node;
        }
        else{
            lastNode.nextNode = node;
            lastNode = node;

        }


    }

    //method of generating HK7 file
    public void generateWordsHKnFile(int nfile){
        try{
            FileWriter file = new FileWriter("C:\\Users\\UserST\\Desktop\\txt files DS MP\\wordsHK"+nfile+".txt");
            Node currentNode = firstNode;
            int j = 1;
            while(currentNode != null){
                file.write(j+"\t\t"+currentNode.nWord+"\t\t\t"+currentNode.nValue+"\n");
                currentNode = currentNode.nextNode;
                j++;
            }

            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //method of removing duplicate elements
    public void removeDuplicateElements(){
        Node currentNode = firstNode;
        Node tempNode = null;
        Node nextNode = null;

        while(currentNode != null){
            tempNode = currentNode;
            nextNode = currentNode.nextNode;

            while(nextNode != null){
                if(currentNode.nWord.equals(nextNode.nWord)){
                    tempNode.nextNode = nextNode.nextNode;
                }else{
                    tempNode = nextNode;
                }
                nextNode = nextNode.nextNode;
            }
            currentNode = currentNode.nextNode;

        }
    }




    //method to get the size of the file generated in task 1 (no of words)
    public int size(){
        int wCount = 0;

        Node currentNode = firstNode;
        while(currentNode != null){
            wCount++;
            currentNode = currentNode.nextNode;
        }
        return wCount;
    }
}
class Hashtable {

    String[] enteringWords;
    int size;
    int count;


    //to genarate wordsQHKn file
    String[] words;
    int[] hashKeys;
    int[] newHashkeys;
    int[] qhashKeys;

    public Hashtable(int size){

        //getting the size of previous one
        enteringWords = new String[size];
        this.size = size;
        this.count = 0;

        //for the task 2 table
        words = new String[size];
        hashKeys = new int[size];
        newHashkeys = new int[size];
        qhashKeys = new int[size];

    }

    private int hash(int key){
        return key % size;

    }

    //method of inserting data
    public void put(int key, String value){

        //hash value = key mod size
        int hashValue = hash(key);
        int temp = key;
        int i = 1;

        do{
            if(enteringWords[hashValue] == null){
                enteringWords[hashValue] = value;

                words[count] = value;
                hashKeys[count] = key;
                newHashkeys[count] = temp;
                qhashKeys[count] = hashValue;
                count++;
                return;
            }

            //creating new hash key
            temp = key + i*i + i;
            hashValue = hash(temp);
            i++;

        }
        while(hashValue > -1);

    }

    //method of creating QHK file
    public void generateWordsQHKnFile(int nfile){
        try{
            FileWriter file = new FileWriter("C:\\Users\\UserST\\Desktop\\txt files DS MP\\wordsQHK"+nfile+".txt");

            for(int i = 0 ; i < enteringWords.length ; i++){
                file.write(i+1+"\t"+words[i]+"\t\t"+hashKeys[i]+"\t"+newHashkeys[i]+"\t"+qhashKeys[i]+"\n");
            }

            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}




class DSAMiniProject {

       public static void main(String[] args) {
        Letters alphabet = new Letters();
        LinkedListB wordlist = new LinkedListB();

        //task 1

        try{
            int nfile = 7;
            File inputFile = new File("C:\\Users\\UserST\\Desktop\\txt files DS MP\\file"+nfile+".txt");
            Scanner file = new Scanner(inputFile);

            while(file.hasNext()){
                String word = file.next();
                String validWord = "";
                int wordValue = 0;

                //getting the letter without symbols or numbers
                for(int i = 0 ; i < word.length() ; i++){
                    if(word.charAt(i) >= 65 && word.charAt(i) <=90 || word.charAt(i) >= 97 && word.charAt(i) <= 122 ){

                        //getting valid words next to the current one
                        validWord = validWord + word.charAt(i);

                        //getting value of each word value to find the values for letters
                        wordValue = wordValue + alphabet.getValue(word.charAt(i));
                    }
                }

                if(validWord.length() > 0){
                    wordlist.addEnd( validWord,wordValue);
                }
            }

            //calling method to remove duplicates
            wordlist.removeDuplicateElements();

            //calling method to create HK7 file
            wordlist.generateWordsHKnFile(nfile);


            //Task 2

            int hashtableSize = wordlist.size();
            Hashtable hashTable = new Hashtable(hashtableSize);


            inputFile = new File("C:\\Users\\UserST\\Desktop\\txt files DS MP\\wordsHK"+nfile+".txt");
            file = new Scanner(inputFile);


            String line = null;
            String [] words = null;

            while(file.hasNext()){
                line = file.nextLine();

                //dividing word by word
                words = line.split("\\W+");
                hashTable.put(Integer.parseInt(words[2]),words[1]);
            }

            hashTable.generateWordsQHKnFile(nfile);




        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

