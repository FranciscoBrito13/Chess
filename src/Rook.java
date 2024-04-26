import java.util.ArrayList;

public class Rook extends Piece{
    private boolean hasMoved = false;
    public Rook(int team, Position position){
        super(team, position, 4);
    }

    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validPositions = new ArrayList<>();
        int currentColumn = getPosition().getColumn();
        int currentRow = getPosition().getRow();

        //Checks the movement to the right
//        for(int i = 1; i <= 8 - currentColumn; i++){
//            Position position = advanceColumnRow( i, 0);
//            boolean isFree = board.isFree(position);
//            if(board.isFree(advanceColumnRow( i, 0))){
//                validPositions.add(advanceColumnRow(+ i, 0));
//            } else {
//                if(board.findPieceAtPosition(position).getTeam() != getTeam()) {
//                    validPositions.add(advanceColumnRow( i, 0));
//                }
//                break;
//            }
//        }
        //Checks the movement to the left
//        for(int i = 1; i <= currentColumn - 1; i++){
//            Position position = advanceColumnRow( i, 0);
//            boolean isFree = board.isFree(position);
//            if(board.isFree(advanceColumnRow( i, 0))){
//                validPositions.add(advanceColumnRow( i, currentRow));
//            } else {
//                if(board.findPieceAtPosition(position).getTeam() != getTeam()) {
//                    validPositions.add(advanceColumnRow( i, currentRow));
//                }
//                break;
//            }
//        }
        //Checks the movement upwards
        for (int i = 1; i <= 8; i++) {
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
//        for(int i = 1; i <= currentColumn - 1; i++){
//            Position position = advanceColumnRow(0, currentRow - i);
//            if(position == null) return validPositions; // Pode nao funionar
//            boolean isFree = board.isFree(position);
//            if(isFree){
//                validPositions.add(advanceColumnRow(0, currentRow - i));
//            } else {
//                if(board.findPieceAtPosition(position).getTeam() != getTeam()) {
//                    validPositions.add(advanceColumnRow(0, currentRow - i));
//                }
//                break;
//            }
//        }
        return validPositions;
    }
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Rook with id = 4." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
