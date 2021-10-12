import java.util.*;

public class Deck{

  private ArrayList<Card> cards = new ArrayList<Card>

  Deck(){

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