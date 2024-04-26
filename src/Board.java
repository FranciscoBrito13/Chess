import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board {
    private List<Piece> board;
    private HashSet<Position> occupiedPositions;
    private int turn;
    private int moveCount = 0;

    public boolean isPawnMovedTwoSquares() {
        return pawnMovedTwoSquares;
    }

    private boolean pawnMovedTwoSquares = false;

    public Board(){
        board = new ArrayList<>();
        occupiedPositions = new HashSet<>();
        turn = 0;
    }
    public void startBoard(){
        //Adds the pawns
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            addPieceAndPosition(new Pawn(0, new Position(i, 2)));
            addPieceAndPosition(new Pawn(1, new Position(i , 7)));
        }
        //Adds the rooks to the board
        addPieceAndPosition(new Rook(0, new Position(1, 1)));
        addPieceAndPosition(new Rook(0, new Position(COMMONS.BOARD_SIZE, 1)));
        addPieceAndPosition(new Rook(1, new Position(1, COMMONS.BOARD_SIZE)));
        addPieceAndPosition(new Rook(1, new Position(COMMONS.BOARD_SIZE, COMMONS.BOARD_SIZE)));

        //Adds the both kings
        addPieceAndPosition(new King(0, new Position(5, 1)));
        addPieceAndPosition(new King(1, new Position(5, COMMONS.BOARD_SIZE)));

        //Adds the Bishops
        addPieceAndPosition(new Bishop(0, new Position(3, 1)));
        addPieceAndPosition(new Bishop(0, new Position(6, 1)));
        addPieceAndPosition(new Bishop(1, new Position(3, COMMONS.BOARD_SIZE)));
        addPieceAndPosition(new Bishop(1, new Position(6, COMMONS.BOARD_SIZE)));

        //Adds the Knights
        addPieceAndPosition(new Knight(0, new Position(2, 1)));
        addPieceAndPosition(new Knight(0, new Position(7, 1)));
        addPieceAndPosition(new Knight(1, new Position(2, COMMONS.BOARD_SIZE)));
        addPieceAndPosition(new Knight(1, new Position(7, COMMONS.BOARD_SIZE)));

        //Adds the Queens
        addPieceAndPosition(new Queen(0, new Position(4, 1)));
        addPieceAndPosition(new Queen(1, new Position(4, COMMONS.BOARD_SIZE)));
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
        Piece piece = findPieceAtPosition(origin);
        if(piece == null){
            System.out.println("No Piece Found at at the Origin");
            return;
        }
        if(piece.getTeam() == turn) {
            if (!isValidMove(piece, destination)) {
                if (isEnPassant(piece, destination)) {
                    playEnPassant(piece, origin, destination);
                    System.out.println("Playing en Passant");
                    return;
                } else {
                    System.out.println("That's Not a Valid Move");
                    return;
                }
            } else {
                if(isFree(destination)){
                    playRegularMove(piece, origin, destination);
                    System.out.println("Moving the Piece");
                    return;
                } else {
                    playCaptureMove(piece, origin, destination);
                    System.out.println("Playing a Capture Move");
                    return;
                }

            }
        } else {
            System.out.println("Wrong Team Playing");
        }
    }

    public Piece findPieceAtPosition(Position origin){
        for(Piece piece : board){
            if(piece.getPosition().equals(origin)){
                return piece;
            }
        }
        return null;
    }
    private boolean isValidMove(Piece piece, Position destination){
        List<Position> validMoves = piece.getValidMoves(this);
        if(validMoves.isEmpty()) return false;
        for(Position p : validMoves){
            if(p != null) {
                if (p.equals(destination)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isEnPassant(Piece piece, Position destination){
        return pawnMovedTwoSquares && (piece.getId() == 1) && (destination.equals(piece.advanceColumnRow(1, 1)) || destination.equals(piece.advanceColumnRow(-1, 1)) && isFree(destination));

    }
    private void playEnPassant(Piece piece,Position origin, Position destination){
        occupiedPositions.removeIf(pos1 -> pos1.equals(origin));
        piece.setPosition(destination);
        occupiedPositions.add(destination);
        occupiedPositions.removeIf(pos1 -> pos1.equals(piece.advanceColumnRow(0, -1)));
        removePieceByPosition(piece.advanceColumnRow(0, -1));
        pawnMovedTwoSquares = false;
        moveCount++;
        turn ^= 1;
    }
    private void playRegularMove(Piece piece,Position origin, Position destination){
        if(piece.getId() == 1) {
            if (destination.equals(piece.advanceColumnRow(0, 2))) {
                pawnMovedTwoSquares = true;
                System.out.println("A pawn just moved two squares");
                occupiedPositions.removeIf(pos1 -> pos1.equals(origin));
                piece.setPosition(destination);
                occupiedPositions.add(destination);
                moveCount++;
                turn ^= 1;
                return;
            }
            ((Pawn) piece).setFirstMove(false);
        }
        if(piece.getId() == 4) ((Rook) piece).setHasMoved(true);
        if(piece.getId() == 6) ((King) piece).setHasMoved(true);
        pawnMovedTwoSquares = false;
        occupiedPositions.removeIf(pos1 -> pos1.equals(origin));
        piece.setPosition(destination);
        occupiedPositions.add(destination);
        moveCount++;
        turn ^= 1;
    }
    private void playCaptureMove(Piece piece,Position origin, Position destination){
        pawnMovedTwoSquares = false;
        removePieceByPosition(destination);
        occupiedPositions.removeIf(pos1 -> pos1.equals(origin));
        piece.setPosition(destination);
        moveCount++;
        turn ^= 1;
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

    public void showCurrentOccupiedPositions(){
        for(Position p : occupiedPositions){
            System.out.println("Posição Ocupada: " + p);
        }
    }
    public List<Piece> getBoard(){
        return board;
    }

    public void showAvailableMoves(Position origin){
        Piece p = findPieceAtPosition(origin);
        if(p == null){
            return;
        }
        int count = 0;
        for(Position pos : p.getValidMoves(this)){
            System.out.println(pos);
            count++;
        }
        if(count == 0) System.out.println("No available moves except, maybe, enPassant");
    }
    @Override
    public String toString(){
        String s = "";
        for(Piece p : board){
            s = s.concat(p.toString() + System.lineSeparator());
        }
        return s;
    }
    public void pieceToMatrix(){
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
    public void teamToMatrix(){
        int[][] boardMatrix = new int[8][8];
        for(Piece p : board){
            int row = 7 - (p.getPosition().getRow() - 1); // Inverting the row index
            int col = p.getPosition().getColumn() - 1;
            if(p.getTeam() == 0)
                boardMatrix[row][col] = 1;
            if(p.getTeam() == 1)
                boardMatrix[row][col] = 2;
        }
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
                System.out.print(boardMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(System.lineSeparator());

    }

}
