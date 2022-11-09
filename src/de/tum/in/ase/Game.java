package de.tum.in.ase;

import java.util.Scanner;

public class Game {
    private GameBoard gameBoard;
    private Hero hero;
    //TODO: implement the constructor, getters and setters for all the attributes

    public Game(int x, int y) {
        this.gameBoard = new GameBoard(x, y);
        this.hero = new Hero();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    //TODO: implement the move methods
    public void moveLeft() {
//        check whether the next move will be out of bound
        if (this.hero.getPosX() - 1 < 0) {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        } else {
//            System.out.println("moving left");
//            reset the original boardMatrix to empty '_'
            this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), '_');
//            set hero's x position
            this.hero.setPosX(this.hero.getPosX() - 1);
//            set hero's new boardMatrix to 'H'
            this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), 'H');
        }
    }

    public void moveRight() {
//        check whether the next move will be out of bound
        if (this.hero.getPosX() + 1 > this.gameBoard.getSizeX() - 1) {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        } else {
//            System.out.println("moving right");
            this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), '_');
            this.hero.setPosX(this.hero.getPosX() + 1);
            this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), 'H');
        }
    }

    public void moveUp() {
        if (this.hero.getPosY() - 1 < 0) {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        } else {
//            System.out.println("moving up");
            this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), '_');
            this.hero.setPosY(this.hero.getPosY() - 1);
            this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), 'H');
        }
    }

    public void moveDown() {
        if (this.hero.getPosY() + 1 > this.gameBoard.getSizeY() - 1) {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        } else {
//            System.out.println("moving down");
            this.gameBoard.set(hero.getPosX(), hero.getPosY(), '_');
            this.hero.setPosY(hero.getPosY() + 1);
            this.gameBoard.set(hero.getPosX(), hero.getPosY(), 'H');
        }
    }

    //TODO: implement a boolean method "isWon()" which checks if the game has ended (the player has won)
    public boolean isWon() {
//        System.out.println("checking if hero wins");
        return (this.hero.getPosX() == this.gameBoard.getSizeX() - 1) && (this.hero.getPosY() == this.gameBoard.getSizeY() - 1);
    }

    //TODO: finally runGame()
    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        while (!isWon()) {
//            System.out.printf("Hero: %d, %d%n", hero.getPosX(), hero.getPosY());
//            System.out.printf("gameboard size: %d, %d%n", gameBoard.getSizeX(), gameBoard.getSizeY());

//            System.out.println("in while loop before printing game board");
//            Print the gameboard onto the console.
            this.gameBoard.printGameBoard();
            System.out.println("Please enter the first letter of the desired direction:");
//            try catch?
            String user_input_string = scanner.nextLine().toLowerCase();
            char user_input = 0;
            if (user_input_string.length() > 1) {
                System.out.println("This input is not recognized, please enter again!");
            } else {
                user_input = user_input_string.charAt(0);
                switch (user_input) {
                    case 'd' -> moveDown();
                    case 'u' -> moveUp();
                    case 'l' -> moveLeft();
                    case 'r' -> moveRight();
                    default -> System.out.println("This input is not recognized, please enter again!");
                }
                isWon();
            }
        }
        System.out.println("Hero has reached the goal!");
    }
    //You can run your game on main after you've implemented runGame()
    public static void main(String[] args) {
        Game game = new Game(5, 6);
        game.runGame();
    }
}



