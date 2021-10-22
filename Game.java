import java.util.*;

// When created in main the game starts
public class Game{

  private Player[] players;
  private int pot = 0;
  private Deck deck;

  public Game(Player[] players, Deck deck){
    this.players = players;
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
    else System.out.println("bruh");
    
  }
  

  // this is used to remove the money betted 
  // and adds it to the pot
  public void makeBet(Player better, int amount){
    better.removeCash(amount);
    this.pot += amount;

  }


  // This is the highcard game it wipes the console 
  // after every turn
  private void highCard(Scanner scn){
    
    for(int i = 0; i < players.length; i++){
      this.players[i].setCard1(deck.dealCard());
    }
    for(int i = 0; i < players.length; i++){

      players[i].setFold(false);
      System.out.println("Pot: " + pot);

      // This draws the players names, cash, and cards 
      // if its their turn
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

      // This is the code for if a player wants to 
      // bet or fold
      System.out.print("(b)et or (f)old: ");
      char charInput = scn.next().charAt(0);
      while(charInput != 'b' && charInput != 'f'){
        System.out.print("Try again: ");
        charInput = scn.next().charAt(0);
      }
      if(charInput == 'f' || players[i].getCash() == 0){
        players[i].setFold(true);
      }

      // This is the betting, it first checks to see if 
      // the player has cash and if they folded
      if(players[i].getFold() == false){
        System.out.print("Bet: ");
        int userInput = scn.nextInt();

        while(userInput > players[i].getCash()){
          System.out.print("Bet less: ");
          userInput = scn.nextInt();
        }

        makeBet(players[i], userInput);
      }
      System.out.println();

      // This wipes the console
      System.out.print("\033[H\033[2J");  
      System.out.flush(); 
    }

    // Gets a list of players who haven't folded to
    // choose winner
    ArrayList<Player> eligible = new ArrayList<Player>();
    for(int i = 0; i < players.length; i++){
      if(players[i].getFold() == false){
        eligible.add(players[i]);
      }
    }

    highCardWinner(eligible);
    // winner gets card

  }

  public void highCardWinner(ArrayList<Player> eligible){

    // This goes through all the players cards and takes
    // the highest one and thats the winner
    int highCard = eligible.get(0).getValue(1);
    Player winner = eligible.get(0);
    Player tie = null;
    for(int i = 1; i < players.length; i++){

      if(eligible.get(i).getValue(1) == highCard){
        tie = eligible.get(i);
      }
      if(eligible.get(i).getValue(1) > highCard){
        highCard = eligible.get(i).getValue(1);
        winner = eligible.get(i);
      }

    }

    if(tie != null){
      winner.addCash(pot/2);
      tie.addCash(pot/2);
      pot -= pot;
      System.out.println("Its a tie between "
      + winner.getName() + " and " + tie.getName());
    }
    else{
      winner.addCash(pot);
      pot -= pot;
      System.out.println("The Winner is " 
      + winner.getName());
    }
  }
}