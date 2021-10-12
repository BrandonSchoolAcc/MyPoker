import java.awt.*;
import java.util.*;

public class Deck{

  public String[][] deck = new String[4][13];

  public Deck(){

    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 12; j++){

        switch(j){
          case 10:
            deck[i][j] = i+"J";
          case 11:
            deck[i][j] = i+"Q";
          case 12:
            deck[i][j] = i+"K";
          case 1:
            deck[i][j] = i+"A";
          default:
            deck[i][j] = ""+i+j;
        }


      }

    }

  }

  public String drawCard(){

    Random rand = new Random();
    int suit = rand.nextInt(4);
    int rank = rand.nextInt(52);

    if(deck[suit][rank])

    return deck[suit][rank];

  }

}