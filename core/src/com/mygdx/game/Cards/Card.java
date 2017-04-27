package com.mygdx.game.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;

public class Card extends Actor implements Pool.Poolable {
    //The unique identifier of the card
    private String cardHash;
    //The name of the image to use on for the card texture
    private String textureName;
    private int target;

    private int health;
    private int attack;
    private int currentHealth;
    private int full = 0;

    public String getCardHash() {
        return cardHash;
    }

    public void setCardHash(String cardHash) {
        this.cardHash = cardHash;
    }

    public String getTextureName() {
        return textureName;
    }

    public void setTextureName(String textureName) {
        this.textureName = textureName;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setManaPoisoning(int manaPoisoning) {
        this.manaPoisoning = manaPoisoning;
    }

    public static TextureAtlas getCardAtlas() {
        return cardAtlas;
    }

    public static void setCardAtlas(TextureAtlas cardAtlas) {
        Card.cardAtlas = cardAtlas;
    }

    public static XmlReader.Element getRootElementsOfCards() {
        return rootElementsOfCards;
    }

    public static void setRootElementsOfCards(XmlReader.Element rootElementsOfCards) {
        Card.rootElementsOfCards = rootElementsOfCards;
    }

    private int cost;
    private int manaPoisoning;
    private int width, height;
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
        super();
        target = 0;
        cost = 0;
        manaPoisoning = 0;
        cardHash = "m0"; //Setting it to an unknown card at first.
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
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

    public void initMinion(int health, int attack){
        this.health = health;
        this.full = health; //Dont touch full it is always full health.
        this.attack = attack;
    }
    //True is up down is false
    public void updateHealth(int currentHealth, int change, boolean dir){
        if (!dir) currentHealth -= change;
        else currentHealth += change;
    }

    public int getCardWidth() {
        return width;
    }

    public int getCardHeight() {
        return height;
    }
}
