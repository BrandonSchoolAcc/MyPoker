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


    boolean play = false;
    System.out.print("Do (y)ou want to play or (n)ot? ");
    if(scn.next().charAt(0) == 'y'){
      play = true;
    }

    if(play){
      while(play == true){
        highCard(scn);
        System.out.print("Do you want to play again? ");
        if(scn.next().charAt(0) == 'y'){
        play = true;
        }
        else play = false;
      }
    }
    else System.out.println("sadge");
    
  }

  public void makeBet(Player better, int amount){
    int playerCash = better.getCash();
    better.removeCash(amount);
    this.pot += amount;

  }

  public void texasHoldEm(Scanner scn){
    Card[] table = new Card[5];
    for(int i = 0; i < table.length; i++){
      table[i] = deck.dealCard();
    }

    for(int i = 0; i < players.length; i++){
      this.players[i].setCard1(deck.dealCard());
      this.players[i].setCard2(deck.dealCard());
    }

    
  }

  private void highCard(Scanner scn){
    
    for(int i = 0; i < players.length; i++){
      this.players[i].setCard1(deck.dealCard());
    }
    for(int i = 0; i < players.length; i++){

      System.out.println("Pot: " + pot);

      for(int j = 0; j < players.length; j++){
        System.out.println(players[j].getName() 
        + ": $" + players[j].getCash());
        if(i == j){
          System.out.println(players[j].getCardSymbol(1) 
          + players[j].getCardRank(1));
        }
        else{
          System.out.println("XX");
        }
      }

      if(players[i].getCash() > 0){
        System.out.print("Bet: ");
        int userInput = scn.nextInt();

        while(userInput > players[i].getCash()){
          System.out.print("Bet less shitass: ");
          userInput = scn.nextInt();
        }

        makeBet(players[i], userInput);
      }
      System.out.println();

      System.out.print("\033[H\033[2J");  
      System.out.flush(); 
    }

    highCardWinner();

  }

  public void highCardWinner(){
    //Player[] winner = new Player[players.length];
    //for(int i = 0; i < players.length; i++){
      //winner[i] = players[i];
    //}
    //Arrays.sort(winner.getValue());
    //return winner[winner.length - 1];

    int highCard = players[0].getValue(1);
    Player winner = players[0];
    for(int i = 0; i < players.length; i++){

      if(players[i].getValue(1) > highCard){
        highCard = players[i].getValue(1);
        winner = players[i];
      }

    }

    winner.addCash(pot);
    pot -= pot;
    System.out.println("The Winner is " + winner.getName());
    
  }

}