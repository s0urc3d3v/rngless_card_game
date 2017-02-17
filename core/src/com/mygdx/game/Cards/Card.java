package com.mygdx.game.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Pool;

public abstract class Card implements Pool.Poolable {
    //The unique identifier of the card
    private int cardHash;
    //The name of the image to use on for the card texture
    private String textureName;
    private int target;
    private int cost;
    private int manaPoisoning;
    private static TextureAtlas cardAtlas;

    static {
        //Load all the cards into one texture atlas that was pre-packed before the program started.
        cardAtlas = new TextureAtlas(Gdx.files.internal("packed_textures/cards/allcards.atlas"));
    }

    //Default Constructor
    public Card() {
        target = 0;
        cost = 0;
        manaPoisoning = 0;
    }

    //cardHash will help to find the card in the xml files.
    public void init(int cardHash) {
        this.cardHash = cardHash;
    }

    private void loadCard() {

    }

    public TextureAtlas.AtlasRegion getTexture() {
        return cardAtlas.findRegion(textureName);
    }

    @Override
    public abstract void reset();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onAnimate();

    public abstract void render();

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
