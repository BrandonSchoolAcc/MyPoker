import java.util.*;
import java.awt.*;

public class Player{
  int cash;
  String name;
  Card heldCard1;
  Card heldCard2;
  int score;
  
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

  public int getValue(int card){
    if(card == 1){
      return heldCard1.getValue();
    }
    else{
      return heldCard2.getValue();
    }
  }

  public String getCardRank(int card){
    if(card == 1){
      return heldCard1.getRank();
    }
    else{
      return heldCard2.getRank();
    }
  }

  public void setCard1(Card givenCard){
    this.heldCard1 = givenCard;
  }

  public void setCard2(Card givenCard){
    this.heldCard2 = givenCard;
  }

  public String getCardSymbol(int card){
    if(card == 1){
      return heldCard1.getSymbol();
    }
    else{
      return heldCard2.getSymbol();
    }
  }

  public void addCash(int amount){
    this.cash += amount;
  }

  public void removeCash(int amount){
    this.cash -= amount;
  }

  public void setScore(int givenScore){
    this.score = givenScore;
  }

  public int getScore(){
    return this.score;
  }

}