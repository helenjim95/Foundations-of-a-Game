package de.tum.in.ase;

public class GameBoard {
    // TODO: Implement the GameBoard class
    private int sizeX;
    private int sizeY;
    private char[][] boardMatrix;

    public GameBoard(int sizeX, int sizeY) {
        if (sizeX < 3) {
            this.sizeX = 3;
        } else {
        this.sizeX = sizeX;
        }

        if (sizeY < 3) {
            this.sizeY = 3;
        } else {
        this.sizeY = sizeY;
        }
//        initialize gameBoard
        this.boardMatrix = new char[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                set(i, j, '_');
            }
        }
//        System.out.println("initializing gameboard");
//        printGameBoard();
//        System.out.printf("creating gameBoard with %d, %d size%n", this.sizeX, this.sizeY);
//        set position of H and G
        this.set(0, 0, 'H');
        this.set(sizeX - 1, sizeY - 1, 'G');
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public char[][] getBoardMatrix() {
        return this.boardMatrix;
    }

    public void setBoardMatrix(char[][] boardMatrix) {
        this.boardMatrix = boardMatrix;
    }

    public char get(int x, int y) {
        if (x > this.sizeX - 1 || y > this.sizeY - 1) {
            return '\0';
        } else {
        return this.boardMatrix[x][y];
        }
    }

    public void set(int x, int y, char value) {
        if (x < this.sizeX && y < this.sizeY) {
//            System.out.printf("%d, %d are in bound, assigning %c to the board%n", x, y, value);
            this.boardMatrix[x][y] = value;
        }
    }

    public void printGameBoard() {
//        System.out.println("printing game board");
//        System.out.printf("gameboard size: x: %d, y: %d%n", this.sizeX, this.sizeY);
        for (int i = 0; i < this.sizeX - 1; i++) {
            for (int j = 0; j < this.sizeY - 1; j++) {
                System.out.print(this.boardMatrix[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }
     }

}
