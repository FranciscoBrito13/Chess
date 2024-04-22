import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(int team, Position position){
        super(team, position, 2);
    }


    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        return null;
    }
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Bishop with id = 2." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
