public class Player{
  int cash;
  String name;
  Card heldCard;
  public Player(String name, int cash){
    this.cash = cash;
    this.name = name;
  }

  public int getCash(){
    return this.cash;
  }

  public String getName(){
    return this.name;
  }

  public int getCardRank(){
    return heldCard.getRank();
  }

  public void setCard(Card givenCard){
    this.heldCard = givenCard;
  }

  public String getCardFace(){
    case(givenCard.get)
  }

  public void addCash(int amount){
    this.cash += amount;
  }

  public void removeCash(int amount){
    this.cash -= amount;
  }

}