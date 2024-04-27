public class Main {
    public static void main(String[] args) {
        Board b = new Board();

        // Initial moves
        b.move(new Position('d', 2), new Position('d', 4)); // White pawn moves
        b.move(new Position('d', 7), new Position('d', 5)); // Black pawn moves

        // Further moves
        b.move(new Position('e', 2), new Position('e', 4)); // White pawn moves
        b.move(new Position('e', 7), new Position('e', 5)); // Black pawn moves

        b.move(new Position('d', 1), new Position('f', 3)); // White bishop moves
        b.move(new Position('d', 8), new Position('f', 6)); // Black bishop moves

        b.move(new Position('f', 1), new Position('c', 4)); // White bishop moves
        b.move(new Position('f', 8), new Position('c', 5)); // Black bishop moves

        // Additional moves
        b.move(new Position('g', 1), new Position('h', 3)); // White knight moves
        b.move(new Position('g', 8), new Position('h', 6)); // Black knight moves

        b.move(new Position('b', 1), new Position('c', 3)); // White knight moves
        b.move(new Position('b', 8), new Position('c', 6)); // Black knight moves

        b.move(new Position('g', 2), new Position('g', 4)); // White pawn moves
        b.move(new Position('g', 7), new Position('g', 5)); // Black pawn moves

        // Display board after moves
        b.pieceToMatrix();
        b.teamToMatrix();
        b.showAttackedPositions();
    }
}