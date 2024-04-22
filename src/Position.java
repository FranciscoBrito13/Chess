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
    public boolean equals(Position a){
        return a.getRow() == row && a.getColumn() == column;
    }
}
