import java.util.ArrayList;

public class Pawn extends Piece{
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

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
            if (board.isFree(advanceColumnRow(0,2)) && board.isFree(advanceColumnRow(0,1))) {
                validPositions.add(advanceColumnRow(0,2));
            }
        }

        if (board.isFree(advanceColumnRow(0,1))) {
            validPositions.add(advanceColumnRow(0,1));
        }

        // Check diagonal captures
        Position p1 = advanceColumnRow(-1, 1);
        setAttackedPosition(p1);
        if (board.isOccupiedByOpponent(getPosition(), p1) && board.findPieceAtPosition(p1).getTeam() != getTeam()) {
            validPositions.add(p1);
        }
        Position p2 = advanceColumnRow(1, 1);
        setAttackedPosition(p2);
        if (board.isOccupiedByOpponent(getPosition(),p2)  && board.findPieceAtPosition(p2).getTeam() != getTeam()) {
            validPositions.add(p2);
        }

        return validPositions;
    }

    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Pawn with id = 1." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
