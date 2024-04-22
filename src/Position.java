import java.awt.*;

public class Position {
    private int column; //The equivalent to a letter in chess
    private int row; //The equivalent to a number in chess

    public Position(int column, int row){
        this.column = column;
        this.row = row;
    }

    public int getColumn(){
        return column;
    }
    public void setColumn(int x){column = x;}
    public int getRow(){
        return row;
    }
    public void setRow(int x){row = x;}

    public String toString(){
        return "x = " + column + " y = " + row;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Position position = (Position) obj;
        return (position.getColumn() == column  && position.getRow() == row);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + column;
        result = 31 * result + row;
        return result;
    }

}
