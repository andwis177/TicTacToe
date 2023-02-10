package org.games.domains;

public class XYDirectory  {
    private int row;
    private int column;

    public XYDirectory() {
        this.row = 0;
        this.column = 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
