package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.XmlReader;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Minion;
import com.mygdx.game.Cards.Spell;
import com.sun.org.apache.xerces.internal.util.XML11Char;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cardsInPlay;
    private Pool<Card> cardPool;

    public Deck(Pool<Card> cardPool) {
        cardsInPlay = new ArrayList<Card>();
        this.cardPool = cardPool;
    }

    public int getCurrentDeckSize(){
        return cardsInPlay.size();
    }

    public void addCard(String hash, String playerSignature){
        Card card = cardPool.obtain();
        //Initialize the card.
        card.init(hash);
        card.sign(playerSignature);
        cardsInPlay.add(card);
    }

    public void destroyCard(int index){
        cardsInPlay.remove(index);
    }
    public void shuffleDeck(){
        //puts random cardsInPlay at the end of the deck 30 size times
        Random random = new Random();
        int low = 0;
        int high = cardsInPlay.size();

        for (int i = 0; i < high; i++) {
            int x = random.nextInt(high - low) + low;
            Card card = cardsInPlay.get(x);
            cardsInPlay.remove(x);
            cardsInPlay.add(card);

        }
    }

    public void sortByCost(){
        int startSize = cardsInPlay.size();
        for (int i = 0; i < cardsInPlay.size(); i++) {
            int x = cardsInPlay.get(i).getCost();
            int y = cardsInPlay.get(i + 1).getCost();
            if (x > y){
                Card card = cardsInPlay.get(i + 1);
                cardsInPlay.add(i + 1, cardsInPlay.get(i));
                cardsInPlay.add(i, card);
            }
            if (!(cardsInPlay.size() == startSize)){
                System.out.println("Error in sort, cardsInPlay where added in process");
            }
        }
    }

    public void loadAllCards() {
        XmlReader reader = new XmlReader();
        try {
            //Get the card XML file
            XmlReader.Element cardXML = reader.parse(Gdx.files.internal("xml/card_defs/cards.xml"));
            //Loop through all the children and add them to the deck
            for(int i = 0; i < cardXML.getChildCount(); i++) {
                //Use generic Deck Selector Signature
                addCard(cardXML.getChild(i).getName(), "DECK_SELECTOR_SIG");
            }
        } catch (IOException e) {
            System.err.println("Could not load all card definitions.");
            e.printStackTrace();
        };
    }

    public List<Card> getCardsInPlay() {
        return cardsInPlay;
    }
}
