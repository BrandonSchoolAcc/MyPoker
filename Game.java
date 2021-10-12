public class Game{

  private Player[] players;
  private int winner;

  public Game(Player[] players, int winner){
    this.players = players;
    this.winner = winner;
    System.out.println("Winner is " + this.players[this.winner]);
  }

  public Player getWinner(){
    return this.players[this.winner];
  }

}