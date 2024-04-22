import java.util.ArrayList;

public abstract class Piece {
    private final int team; //0 for white 1 for black
    private Position position;

    private int id;

    public Piece(int team, Position position, int id){
        this.team = team;
        this.position = position;
        this.id = id;
    }
    public abstract ArrayList<Position> getValidMoves(Board board);

    public int getTeam() {
        return team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position newPosition){
        position = newPosition;
    }

    public int getId() {
        return id;
    }
}
