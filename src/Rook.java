import java.util.ArrayList;

public class Rook extends Piece{
    private boolean hasMoved = false;
    public Rook(int team, Position position){
        super(team, position, 4);
    }

    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        /*
        TALVEZ FUNCIONE FAZER TUDO COM 1 SÓ LOOP; DEPOIS POR CADA i VERIFICAR O RESPETIVO SITIO
        */
        ArrayList<Position> validPositions = new ArrayList<>();
        int currentColumn = getPosition().getColumn();
        int currentRow = getPosition().getRow();

        //Checks the movement to the right
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(i, 0);
            if(position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                    setAttackedPosition(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                        setAttackedPosition(position);
                    }
                    break;
                }
            }
        }
        //Checks the movement to the left
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(-i, 0);
            if(position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                    setAttackedPosition(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                        setAttackedPosition(position);
                    }
                    break;
                }
            }
        }
        //Checks the movement upwards
        for (int i = 1; i <= COMMONS.BOARD_SIZE; i++) {
            Position position = advanceColumnRow(0, i);
            if (position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                    setAttackedPosition(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                        setAttackedPosition(position);
                    }
                    break;
                }
            }
        }
        //Checks the movement downwards
        for(int i = 1; i <= COMMONS.BOARD_SIZE; i++){
            Position position = advanceColumnRow(0, -i);
            if(position != null) {
                if (board.isFree(position)) {
                    validPositions.add(position);
                    setAttackedPosition(position);
                } else {
                    Piece pieceAtPosition = board.findPieceAtPosition(position);
                    if (pieceAtPosition.getTeam() != getTeam()) {
                        validPositions.add(position);
                        setAttackedPosition(position);
                    }
                    break;
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
        return "Playing for team: " + getTeam() + ". Im a Rook with id = 4." + " My current Position is: x = " + getPosition().getColumn() + " y = " + getPosition().getRow();
    }
}
