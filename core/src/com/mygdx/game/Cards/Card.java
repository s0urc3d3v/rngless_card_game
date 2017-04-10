package com.mygdx.game.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;

public class Card implements Pool.Poolable {
    //The unique identifier of the card
    private String cardHash;
    //The name of the image to use on for the card texture
    private String textureName;
    private int target;
    private int cost;
    private int manaPoisoning;
    private static TextureAtlas cardAtlas;
    //The XML File containing all of the card definitions
    private static XmlReader.Element rootElementsOfCards;

    static {
        //Load all the cards into one texture atlas that was pre-packed before the program started.
        cardAtlas = new TextureAtlas(Gdx.files.internal("packed_textures/cards/allcards.atlas"));
        //Load the Card definitions into the XML Element root element
        XmlReader xmlReader = new XmlReader();
        try {
            rootElementsOfCards = xmlReader.parse(Gdx.files.internal("xml/card_defs/cards.xml"));
        } catch (IOException e) {
            throw new CardDefParseError();
        }
    }

    //Default Constructor
    public Card() {
        target = 0;
        cost = 0;
        manaPoisoning = 0;
        cardHash = "m0"; //Setting it to an unknown card at first.
    }

    //cardHash will help to find the card in the xml files.
    public void init(String cardHash) {
        this.cardHash = cardHash;
        loadCard();
    }

    private void loadCard() {
        //Gets the rootAttributeElement from the XML file based on this speciic cards hash.
        XmlReader.Element cardAttributeElement = rootElementsOfCards.getChildByName(cardHash).getChildByName("attribs");
        //Getting the specific card attributes using the get method on the cardAttributeElement.
        cost = Integer.parseInt(cardAttributeElement.get("cost"));
        manaPoisoning = Integer.parseInt(cardAttributeElement.get("mp"));
        textureName = cardAttributeElement.get("textureName");
        loadSubCardAttribs(cardAttributeElement);
    }

    void loadSubCardAttribs(XmlReader.Element cardAttributeElement) {

    }

    public TextureAtlas.AtlasRegion getTexture() {
        return cardAtlas.findRegion(textureName);
    }

    @Override
    public  void reset(){
        return;
    };

    public  void onCreate(){
        return;
    }

    public  void onDestroy(){
        return;
    }

    public  void onAnimate(){
        return;
    }

    public  void render(){
        return;
    }

    public int attackable() {
        return target;
    }


    public int getCost() {
        return cost;
    }

    public int getManaPoisoning() {
        return manaPoisoning;
    }



}
