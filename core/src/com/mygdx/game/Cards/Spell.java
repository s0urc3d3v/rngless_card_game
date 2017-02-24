package com.mygdx.game.Cards;

import com.badlogic.gdx.utils.XmlReader;

public class Spell extends Card {


    public Spell() {
        super();
    }

    @Override
    public void init(String cardHash) {
        super.init(cardHash);
    }

    @Override
    void loadSubCardAttribs(XmlReader.Element cardAttributeElement) {
        //load our custom attributes.
    }


    @Override
    public void reset() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onAnimate() {

    }

    @Override
    public void render() {

    }

}
