import java.util.ArrayList;

public class King extends Piece{
    public King(int team, Position position){
        super(team, position, 6);
    }



    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        return null;
    }

    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a King with id = 0." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
