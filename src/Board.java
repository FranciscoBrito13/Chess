import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board {
    private List<Piece> board;
    private HashSet<Position> occupiedPositions;
    private int turn;

    public Board(){
        board = new ArrayList<>();
        occupiedPositions = new HashSet<>();
        turn = 0;
    }
    public void startBoard(){
        //Adds the pawns
        for(int i = 1; i <= 8; i++){
            addPieceAndPosition(new Pawn(0, new Position(i, 2)));
            addPieceAndPosition(new Pawn(1, new Position(i , 7)));
        }
        //Adds the rooks to the board
        addPieceAndPosition(new Rook(0, new Position(1, 1)));
        addPieceAndPosition(new Rook(0, new Position(8, 1)));
        addPieceAndPosition(new Rook(1, new Position(1, 8)));
        addPieceAndPosition(new Rook(1, new Position(8, 8)));

        //Adds the both kings
        addPieceAndPosition(new King(0, new Position(5, 1)));
        addPieceAndPosition(new King(1, new Position(5, 8)));

        //Adds the Bishops
        addPieceAndPosition(new Bishop(0, new Position(3, 1)));
        addPieceAndPosition(new Bishop(0, new Position(6, 1)));
        addPieceAndPosition(new Bishop(1, new Position(3, 8)));
        addPieceAndPosition(new Bishop(1, new Position(6, 8)));

        //Adds the Knights
        addPieceAndPosition(new Knight(0, new Position(2, 1)));
        addPieceAndPosition(new Knight(0, new Position(7, 1)));
        addPieceAndPosition(new Knight(1, new Position(2, 8)));
        addPieceAndPosition(new Knight(1, new Position(7, 8)));

        //Adds the Queens
        addPieceAndPosition(new Queen(0, new Position(4, 1)));
        addPieceAndPosition(new Queen(1, new Position(4, 8)));
    }

    public void showCurrentPositions(){
        for(Position p : occupiedPositions){
            System.out.println("Posição Ocupada: " + p);
        }
    }
    public List<Piece> getBoard(){
        return board;
    }
    @Override
    public String toString(){
        String s = "";
        for(Piece p : board){
            s = s.concat(p.toString() + System.lineSeparator());
        }
        return s;
    }
    public void toMatrix(){
        int[][] boardMatrix = new int[8][8];
        for(Piece p : board){
            int row = 7 - (p.getPosition().getRow() - 1); // Inverting the row index
            int col = p.getPosition().getColumn() - 1;
            boardMatrix[row][col] = p.getId();
        }
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
                System.out.print(boardMatrix[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println(System.lineSeparator());
    }
    private void addPieceAndPosition(Piece piece) {
        board.add(piece);
        occupiedPositions.add(piece.getPosition());
    }
    private void removePieceAndPositionByPiece(Piece piece) {
        occupiedPositions.remove(piece.getPosition());
        board.remove(piece);
    }
    private void removePositionByPiece(Piece piece){
        occupiedPositions.remove(piece.getPosition());
    }
    private void removePieceByPosition(Position position){
        board.removeIf(p -> p.getPosition().equals(position));

    }
    private Piece getPieceFromPosition(Position p){
        for(Piece piece : board){
            if(piece.getPosition().equals(p)){
                return piece;
            }
        }
        return null;
    }
    public void move(Position origin, Position destination){
        boolean contains = false;

        for(Piece p : board){
            if(p.getPosition().equals(origin)){
                for(Position pos : p.getValidMoves(this)){
                    System.out.println("This is a valid move: " + pos);
                    if(pos.equals(destination)) {
                        contains = true;
                    }
                }

                if(contains && p.getTeam() == turn){
                    if(isFree(destination)){
                        occupiedPositions.removeIf(pos1 -> pos1.equals(origin));
                        p.setPosition(destination);
                        occupiedPositions.add(destination);

                    } else {
                        removePieceByPosition(destination);
                        occupiedPositions.removeIf(pos1 -> pos1.equals(origin));
                        p.setPosition(destination);
                    }
                    turn ^= 1;
                    return;
                }
                return;
            }
        }
    }
    public boolean isOccupiedByOpponent(Position current, Position newPosition) {
        Piece newPositionPiece = null;
        if(isFree(newPosition)){
            return false;
        }
        for(Piece p: board){
            if(p.getPosition().equals(newPosition))
                newPositionPiece = p;
        }
        for(Piece p: board){
            if(p.getPosition().equals(current)){
                if(p.getTeam() != newPositionPiece.getTeam())
                    System.out.println("Is occupied by opponent");
                    return true;
            }
        }
        return false;
    }
    public boolean isFree(Position p){
        return !occupiedPositions.contains(p);
    }
}
