import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.startBoard();
        b.move(new Position('a',2 ), new Position('a', 4));
        b.toMatrix();
        b.move(new Position('b', 7), new Position('b',5));
        b.toMatrix();
        b.move(new Position('b', 2), new Position('b',4) );
        b.toMatrix();
        b.move(new Position('b', 5), new Position('a',4) );
        b.toMatrix();
    }
}