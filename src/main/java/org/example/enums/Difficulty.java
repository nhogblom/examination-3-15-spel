package org.example.enums;

public enum Difficulty {

    EASY("Easy",2,2),
    MEDIUM("Medium",3,3),
    HARD("Hard",4,4);

    private final String description;
    private final int xRows;
    private final int yRows;

    Difficulty(String description, int xRows, int yRows) {
        this.description = description;
        this.xRows = xRows;
        this.yRows = yRows;
    }

    public String getDescription() {
        return description;
    }

    public int getxRows() {
        return xRows;
    }

    public int getyRows() {
        return yRows;
    }
}
