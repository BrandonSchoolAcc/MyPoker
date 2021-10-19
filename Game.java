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
        //highCard(scn);
        texasHoldEm(scn);
        System.out.print("Do you want to play again? ");
        if(scn.next().charAt(0) == 'y'){
        play = true;
        }
        else play = false;
      }
    }
    else System.out.println("bruh");
    
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

    for(int k = 0; k < 4; k++){

      for(int i = 0; i < players.length; i++){

        System.out.println("Pot: " + pot);
        System.out.println();
        switch(k){
          case 0:
            System.out.println("Table:");
            break;
          case 1:
            System.out.print("Table:");
            for(int l = 0; l < 3; l++){
              System.out.print(" " + table[l].getSymbol() 
              + table[l].getRank());
            }
            break;
          case 2:
            System.out.print("Table:");
            for(int l = 0; l < 4; l++){
              System.out.print(" " + table[l].getSymbol() 
              + table[l].getRank());
            }
            break;
          case 3:
            System.out.print("Table:");
            for(int l = 0; l < 5; l++){
              System.out.print(" " + table[l].getSymbol() 
              + table[l].getRank());
            }
            break;
        }
        System.out.println();

        for(int j = 0; j < players.length; j++){
          System.out.println(players[j].getName() 
          + ": $" + players[j].getCash());
          if(i == j){
            System.out.println(players[j].getCardSymbol(1) 
            + players[j].getCardRank(1) + " " 
            + players[j].getCardSymbol(2) 
            + players[j].getCardRank(2));
          }
          else{
            System.out.println("XX XX");
          }
        }

        if(players[i].getCash() > 0){
          System.out.print("Bet: ");
          int userInput = scn.nextInt();

          while(userInput > players[i].getCash()){
            System.out.print("Bet less: ");
            userInput = scn.nextInt();
          }

          makeBet(players[i], userInput);
        }
        System.out.println();

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
      }
    }

      
  }


  private void texasWinner(Card[] table){
    /*
    1-13 higcard 2-A
    13-26 one pair 2-A
    27-39 two pair 2-A
    40-52 three of a kind 2-A
    53-65 straight 2-A
    66-78 flush 2-A
    79-92 full house 2-A
    93-105 4 of a kind 2-A
    106-118 straight flush 2-A
    119 royal flush
    */
    for(int i = 0; i < players.length; i++){



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
          System.out.print("Bet less: ");
          userInput = scn.nextInt();
        }

        makeBet(players[i], userInput);
      }
      System.out.println();

      System.out.print("\033[H\033[2J");  
      System.out.flush(); 
    }

    highCardWinner();
    // winner gets card

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