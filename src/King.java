import java.util.ArrayList;

public class King extends Piece{
    private boolean inCheck = false;
    private boolean hasMoved = false;
    public King(int team, Position position){
        super(team, position, 6);
    }

    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validPositions = new ArrayList<>();


        int[][] validPairs = {
                {1,0},
                {0,1},
                {-1,0},
                {0,-1},
                {1,1},
                {1,-1},
                {-1,1},
                {-1,-1}
        };
        for(int i = 0; i < validPairs.length; i++){
            Position position = advanceColumnRow(validPairs[i][0], validPairs[i][1]);
            if(position != null){
                if (board.isFree(position)) {
                    validPositions.add(position);
                    setAttackedPosition(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if(pieceAtPosition.getTeam() != getTeam()){
                        validPositions.add(position);
                        setAttackedPosition(position);
                    }
                }
            }
        }


        return validPositions;
    }
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a King with id = 0." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
