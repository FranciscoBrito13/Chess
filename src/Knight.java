import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(int team, Position position){
        super(team, position, 3);
    }


    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        return null;
    }
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Knight with id = 3." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
