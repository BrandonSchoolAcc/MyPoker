import java.util.*;
import java.awt.*;

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

  public int getValue(){
    if(this.heldCard.getRank() == 0){
      return 14;
    }
    else{
      return this.heldCard.getRank();
    }
    
  }

  public String getCardRank(){
    switch(this.heldCard.getRank()){
      case 0:
        return "A";
      case 10:
        return "J";
      case 11:
        return "Q";
      case 12:
        return "K";
      default:
        return ""+(this.heldCard.getRank() + 1);
    }
  }

  public void setCard(Card givenCard){
    this.heldCard = givenCard;
  }

  public String getCardSymbol(){
    String suitSymbol = "";
    switch(heldCard.getSuit()){
      case(0):
        suitSymbol = "♣";
        break;
      case(1):
        suitSymbol = "♥";
        break;
      case(2):
        suitSymbol = "♠";
        break;
      case(3):
        suitSymbol = "♦";
        break;
    }
    return suitSymbol;
  }

  public void addCash(int amount){
    this.cash += amount;
  }

  public void removeCash(int amount){
    this.cash -= amount;
  }

}