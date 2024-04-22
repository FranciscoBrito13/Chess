import java.util.ArrayList;

public class Pawn extends Piece{

    private boolean firstMove = true;


    public Pawn(int team, Position position){
        super(team, position, 1);
    }

    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validPositions = new ArrayList<>();
        int currentColumn = getPosition().getColumn();
        int currentRow = getPosition().getRow();

        if (firstMove) {
            if (board.isFree(new Position(currentColumn, currentRow + 2)) && board.isFree(new Position(currentColumn, currentRow + 1))) {
                validPositions.add(new Position(currentColumn, currentRow + 2));
            }
            firstMove = false;
        }

        if (board.isFree(new Position(currentColumn, currentRow + 1))) {
            validPositions.add(new Position(currentColumn, currentRow + 1));
        }

        // Check diagonal captures
        if (currentColumn > 0 && board.isOccupiedByOpponent(getPosition(), new Position(currentColumn - 1, currentRow + 1))) {
            validPositions.add(new Position(currentColumn - 1, currentRow + 1));
        }

        if (currentColumn < 8 && board.isOccupiedByOpponent(getPosition(), new Position(currentColumn + 1, currentRow + 1))) {
            validPositions.add(new Position(currentColumn + 1, currentRow + 1));
        }

        return validPositions;
    }

    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Pawn with id = 1." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
