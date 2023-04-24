public class Main {

    public static void main(String[] args) {
        Array s = new Array(4);
        s.insert(7);
        s.insert(1);
        s.insert(5);
        s.insert(4);

        s.removeAt(2);

        s.display();
    }
}
