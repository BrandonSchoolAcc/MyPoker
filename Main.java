import java.util.*;

class Main {
  public static void main(String[] args) {
    
    Random myCards = new Random();
    int myWinner = myCards.nextInt(4);
    Deck mydeck = new Deck();

    //collect players

    Player p1 = new Player("dog",40);
    Player p2 = new Player("cat",40);
    Player p3 = new Player("fish",40);
    Player p4 = new Player("duck",40);

    Player[] myArrayOfPlayers = {p1,p2,p3,p4};


    Game myGame = new Game(myArrayOfPlayers, myWinner, mydeck);

  }
}