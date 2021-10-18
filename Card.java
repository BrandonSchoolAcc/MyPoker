public class Card{

  private int suit;
  private int rank;
  
  Card(int suit, int rank){
    this.suit = suit;
    this.rank = rank;
  }

  public String getRank(){
    switch(this.rank){
      case 0:
        return "A";
      case 10:
        return "J";
      case 11:
        return "Q";
      case 12:
        return "K";
      default:
        return ""+(this.rank + 1);
    }
  }

  public int getSuit(){
    return this.suit;
  }

  public String getSymbol(){
    String symbol = "SUIT NOT SET";
    
    switch(this.suit){
      case 0:
        symbol = "♣";
        break;
      case 1:
        symbol = "♥";
        break;
      case 2:
        symbol = "♠";
        break;
      case 3:
        symbol = "♦";
        break;
    }

    return symbol;
  }

  public int getValue(){
    switch(rank){
      case 0:
        return 14;
      default:
        return rank + 1;
    }
  }

}