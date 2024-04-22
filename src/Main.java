import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.startBoard();
        b.move(new Position(1,2 ), new Position(1, 4));
        b.toMatrix();
        b.move(new Position(2, 7), new Position(1,6));
        b.toMatrix();

    }
}