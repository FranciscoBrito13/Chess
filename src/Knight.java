import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(int team, Position position){
        super(team, position, 3);
    }


    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validPositions = new ArrayList<>();
        int currentColumn = getPosition().getColumn();
        int currentRow = getPosition().getRow();

        int[][] pairOfMovement = {
                {1,2},
                {-1,2},
                {1,-2},
                {-1,-2},
                {2, 1},
                {2, -1},
                {-2, 1},
                {-2,-1}
        };
        for(int i = 0; i < pairOfMovement.length; i++){
            Position position = advanceColumnRow(pairOfMovement[i][0], pairOfMovement[i][1]);
            if(position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if(pieceAtPosition.getTeam() != getTeam()){
                        validPositions.add(position);
                    }
                }
            }
        }

        return validPositions;

    }
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Knight with id = 3." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
