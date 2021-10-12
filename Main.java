import java.util.*;

class Main {
  public static void main(String[] args) {
    
    Random myCards = new Random();
    int myWinner = myCards.nextInt(4);

    //collect players

    Player p1 = new Player();
    Player p2 = new Player();
    Player p3 = new Player();
    Player p4 = new Player();

    Player[] myArrayOfPlayers = {p1,p2,p3,p4};

    Game myGame = new Game(myArrayOfPlayers, myWinner);

  }
}