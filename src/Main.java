public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.startBoard();

        // Test various piece movements
        b.showAvailableMoves(new Position('d', 2));
        b.move(new Position('d', 2), new Position('d', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('d', 7));
        b.move(new Position('d', 7), new Position('d', 5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('b', 1));
        b.move(new Position('b', 1), new Position('c', 3));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('g', 8));
        b.move(new Position('g', 8), new Position('f', 6));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('d', 1));
        b.move(new Position('d', 1), new Position('d', 3));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('d', 8));
        b.move(new Position('d', 8), new Position('d', 6));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('d', 3));
        b.move(new Position('d', 3), new Position('b', 5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('d', 6));
        b.move(new Position('d', 6), new Position('f', 4));
        b.pieceToMatrix();

        // Additional test movements
        b.showAvailableMoves(new Position('e', 2));
        b.move(new Position('e', 2), new Position('e', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('c', 1));
        b.move(new Position('c', 1), new Position('d', 2));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('f', 8));
        b.move(new Position('f', 8), new Position('e', 7));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('c', 7));
        b.move(new Position('c', 7), new Position('c', 5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('f', 1));
        b.move(new Position('f', 1), new Position('g', 2));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('b', 8));
        b.move(new Position('b', 8), new Position('c', 6));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('g', 2));
        b.move(new Position('g', 2), new Position('g', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('e', 7));
        b.move(new Position('e', 7), new Position('e', 5));
        b.pieceToMatrix();

        // More test movements
        b.showAvailableMoves(new Position('a', 2));
        b.move(new Position('a', 2), new Position('a', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('h', 1));
        b.move(new Position('h', 1), new Position('g', 2));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('f', 7));
        b.move(new Position('f', 7), new Position('f', 5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('b', 2));
        b.move(new Position('b', 2), new Position('b', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('e', 1));
        b.move(new Position('e', 1), new Position('f', 2));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('h', 8));
        b.move(new Position('h', 8), new Position('g', 7));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('c', 2));
        b.move(new Position('c', 2), new Position('c', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('g', 1));
        b.move(new Position('g', 1), new Position('f', 2));
        b.pieceToMatrix();

        // Even more test movements
        b.showAvailableMoves(new Position('a', 7));
        b.move(new Position('a', 7), new Position('a', 5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('h', 2));
        b.move(new Position('h', 2), new Position('h', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('e', 8));
        b.move(new Position('e', 8), new Position('d', 7));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('a', 1));
        b.move(new Position('a', 1), new Position('b', 2));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('f', 2));
        b.move(new Position('f', 2), new Position('f', 4));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('h', 7));
        b.move(new Position('h', 7), new Position('h', 5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('b', 7));
        b.move(new Position('b', 7), new Position('b', 5));
        b.pieceToMatrix();

        b.showAvailableMoves(new Position('g', 7));
        b.move(new Position('g', 7), new Position('g', 5));
        b.pieceToMatrix();
    }
}