import java.util.*;

// Makes an arraylist of cards and deals them
public class Deck{

  private ArrayList<Card> cards = new ArrayList<Card>();

  Deck(){

    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 13; j++){
        this.cards.add(new Card(i,j));

      }
    }
  }

  // Takes a random card from the deck
  // no need for the deck to be random
  public Card dealCard(){
    Random rand = new Random();
    int temp = rand.nextInt(cards.size());
    Card givenCard = cards.get(temp);
    cards.remove(temp);
    return givenCard;
  }

  // Throws away the deck and makes a new one
  public void shuffle(){
    this.cards.clear();
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 13; j++){
        this.cards.add(new Card(i,j));
      }
    }
  }

  // 52 cards from 4 suits
  // keep track of what cards inside
  // shuffle Deck
  // deal cards?

}