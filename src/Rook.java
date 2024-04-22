import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(int team, Position position){
        super(team, position, 4);
    }

    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        return null;
    }
    @Override
    public String toString(){
        return "Playing for team: " + getTeam() + ". Im a Rook with id = 4." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
