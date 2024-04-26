import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(int team, Position position){
        super(team, position, 5);
    }


    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validPositions = new ArrayList<>();
        int currentColumn = getPosition().getColumn();
        int currentRow = getPosition().getRow();

        //Checks the movement to the right
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(i, 0);
            if(position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        //Checks the movement to the left
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(-i, 0);
            if(position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        //Checks the movement upwards
        for (int i = 1; i <= COMMONS.BOARD_SIZE; i++) {
            Position position = advanceColumnRow(0, i);
            if (position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        //Checks the movement downwards
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(0, -i);
            if(position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        //Check the upright
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(i,i);
            if(position != null){
                if(board.isFree(position)){
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        //Check the upleft
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(-i,i);
            if(position != null){
                if(board.isFree(position)){
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        //Check the downright
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(i,-i);
            if(position != null){
                if(board.isFree(position)){
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        //Check the downleft
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(-i,-i);
            if(position != null){
                if(board.isFree(position)){
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                    }
                    break;
                }
            }
        }
        return validPositions;
    }
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Queen with id = 5." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
