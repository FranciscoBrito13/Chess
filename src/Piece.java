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

    //A positive value is to the right of the view of the pawn and to the front
    protected Position advanceColumnRow(int column, int row) {

        Position newPosition = null;
        int newColumn = getPosition().getColumn() + column;
        int newRow = getPosition().getRow() + row;

        if (getTeam() == 0) {
            if (newColumn > 0 && newColumn < 9 && newRow > 0 && newRow < 9) {
                newPosition = new Position(newColumn, newRow);
            }
        } else if (getTeam() == 1) {
            int newColumnReverse = getPosition().getColumn() - column;
            int newRowReverse = getPosition().getRow() - row;
            if (newColumnReverse > 0 && newColumnReverse < 9 && newRowReverse > 0 && newRowReverse < 9) {
                newPosition = new Position(newColumnReverse, newRowReverse);
            }
        }

        return newPosition;
    }

    protected Position up(){
        return advanceColumnRow(0, 1);
    }
}
