import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.startBoard();

        //b.showAvailableMoves(new Position('a',2 )); THIS DOESNT WORK BECAUSE IT CALLS THE PAWN FUNCION AND SETS FIRSTMOVE TO FALSE
        b.move(new Position('a',2 ), new Position('a', 4));
        b.pieceToMatrix();

        b.move(new Position('a', 7), new Position('a',6));
        b.pieceToMatrix();


        b.move(new Position('a', 4), new Position('a',5) );
        b.pieceToMatrix();

        b.move(new Position('b', 7), new Position('b',5) );
        b.pieceToMatrix();

        b.move(new Position('h', 2), new Position('h',3) );
        b.pieceToMatrix();

        b.move(new Position('h', 7), new Position('h',6) );
        b.pieceToMatrix();

        b.move(new Position('a', 5), new Position('b',6) );
        b.pieceToMatrix();


    }
}