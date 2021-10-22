import java.util.*;

class Main {
  public static void main(String[] args) {
    
    Random myCards = new Random();
    Deck mydeck = new Deck();

    //collect players

    Player p1 = new Player("Robert",40);
    Player p2 = new Player("Brandon",40);
    Player p3 = new Player("Player 3",40);
    Player p4 = new Player("Player 4",40);

    Player[] myArrayOfPlayers = {p1,p2};


    Game myGame = new Game(myArrayOfPlayers, mydeck);

  }
}