import java.sql.SQLOutput;
import java.util.ArrayList;

public class Pawn extends Piece{
    private boolean firstMove = true;

    public Pawn(int team, Position position){
        super(team, position, 1);
    }
    //A positive value is to the right of the view of the pawn and to the front
    private Position advanceColumnRow(int column, int row) {
        Position newPosition = null;
        if(getTeam() == 0){
            newPosition = new Position(getPosition().getColumn() + column, getPosition().getRow() + row);
        }
        if(getTeam() == 1){
            newPosition = (new Position(getPosition().getColumn() - column, getPosition().getRow() - row));
        }
        return newPosition;
    }

    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validPositions = new ArrayList<>();
        int currentColumn = getPosition().getColumn();
        int currentRow = getPosition().getRow();

        if (firstMove) {
            if (board.isFree(advanceColumnRow(0,2)) && board.isFree(advanceColumnRow(0,1))) {
                validPositions.add(advanceColumnRow(0,2));
            }
            firstMove = false;
        }

        if (board.isFree(advanceColumnRow(0,1))) {
            validPositions.add(advanceColumnRow(0,1));
        }

        // Check diagonal captures
        if (board.isOccupiedByOpponent(getPosition(), advanceColumnRow(-1, 1))) {
            validPositions.add(advanceColumnRow(-1, 1));
        }
        if (board.isOccupiedByOpponent(getPosition(),advanceColumnRow(1, 1))) {
            validPositions.add(advanceColumnRow(1, 1));
        }

        return validPositions;
    }
    
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Pawn with id = 1." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
