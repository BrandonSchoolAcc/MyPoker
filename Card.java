public class Card{

  private int suit;
  private int rank;
  
  Card(int suit, int rank){
    this.suit = suit;
    this.rank = rank;
  }

  public int getRank(){
    return this.rank;
  }

  public int getSuit(){
    return this.suit;
  }

}