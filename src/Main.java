import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.startBoard();

        b.showAvailableMoves(new Position('a',2 )); //Works
        b.move(new Position('a',2 ), new Position('a', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('h',7 )); //Works
        b.move(new Position('h', 7), new Position('h',5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('a',1 )); //Works
        b.move(new Position('a', 1), new Position('a',3) );
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('h',8 )); //It works
        b.move(new Position('h', 8), new Position('h',6) );
        b.pieceToMatrix();

//        b.showAvailableMoves(new Position('a',3 ));
//        b.move(new Position('a', 3), new Position('d',3) );
//        b.pieceToMatrix();

//        b.showAvailableMoves(new Position('h',7 ));
//        b.move(new Position('h', 7), new Position('h',6) );
//        b.pieceToMatrix();
//
//        b.showAvailableMoves(new Position('a',5));
//        b.move(new Position('a', 5), new Position('b',6) );
//        b.pieceToMatrix();


    }
}