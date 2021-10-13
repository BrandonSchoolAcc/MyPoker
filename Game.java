import java.util.*;

public class Game{

  private Player[] players;
  private int winner;
  private int pot = 0;
  private Deck deck;

  public Game(Player[] players, int winner, Deck deck){
    this.players = players;
    this.winner = winner;
    this.deck = deck;
    Scanner scn = new Scanner(System.in);
    

    
  }

  public void makeBet(Player better, int amount){
    int playerCash = better.getCash();
    better.removeCash(amount);
    this.pot += amount;

  }

  private void highcardGame(Scanner scn){

    for(int i = 0; i < players.length; i++){
      this.players[i].setCard(deck.dealCard());
      System.out.println("How much is " + this.players[i].getName() + " betting? ");
      
      int userInput = scn.nextInt();
      makeBet(players[i], userInput);
    }

    this.players[this.winner].addCash(this.pot);

    System.out.println("Winner is " + this.players[this.winner].getName()); 

  } 

  public Player getWinner(){
    return this.players[this.winner];
  }

}