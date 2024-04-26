import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(int team, Position position){
        super(team, position, 2);
    }


    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validPositions = new ArrayList<>();
        int currentColumn = getPosition().getColumn();
        int currentRow = getPosition().getRow();

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
        return "Playing for team: " + getTeam() + ". Im a Bishop with id = 2." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
