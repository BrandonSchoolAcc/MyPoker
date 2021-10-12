

public class Cards{
  
  public String suit;
  public String rank;

  public Cards(String CardType){

    this.suit = CardType.substring(0, 1);
    this.rank = CardType.substring(1, 3);

  }

  

  public String getCard(){

    String suitClub = "♣";
    String suitHeart = "♥";
    String suitSpade = "♠";
    String suitDiamond = "♦";

    String cardSuit = "SUIT NOT SET";
    String cardRank = "RANK NOT SET";

    switch(suit){
      case "0":
        cardSuit = suitClub;
      case "1":
        cardSuit = suitHeart;
      case "2":
        cardSuit = suitSpade;
      case "3":
        cardSuit = suitDiamond;
    }

    switch(rank){
      case "01":
        cardRank = "A";
      case "11":
        cardRank = "J";
      case "12":
        cardRank = "Q";
      case "13":
        cardRank = "K";
    }

    return cardSuit + cardRank;

  }


}