import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(int team, Position position){
        super(team, position, 5);
    }


    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        return null;
    }
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Queen with id = 5." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
