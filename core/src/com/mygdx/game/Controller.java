package com.mygdx.game;

import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Commander;
import com.mygdx.game.Views.ViewSwitchListener;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public enum playTurnStages {

        playOne,
        Attack,
        Protect,
        playTwo,
        End
    }
    private static playTurnStages currentTurnState = playTurnStages.playOne;
    private static boolean playerOneTurn = true;
    private static boolean shouldChangePlayer = false;
    private static Player[] players = new Player[2];
    public Controller(){
        players[0] = new Player(new Commander(), new Pool<Card>() {
        @Override
        protected Card newObject() {
            return null; //This will deck be!
        }});
        players[1] = new Player(new Commander(), new Pool<Card>() {
                @Override
                protected Card newObject() {
                    return null; //This will deck be!
                }});
    }

    private static List<ViewSwitchListener> viewSwitchListeners = new ArrayList<>();

    public static void attachListener(ViewSwitchListener viewSwitchListener) {
        viewSwitchListeners.add(viewSwitchListener);
    }

    public static void callViewSwitch(int switchingToIndex) {
        for(ViewSwitchListener vsl: viewSwitchListeners) {
            vsl.onSwitch(switchingToIndex);
        }
    }

    /*

     */

    /**
     * Handles game events removing the requirement to have a main loop hogging resources.
     * @param advanceTurnState tells weather the game state (shown below) is required
     *
     * 1. Turn begin (get mana poisoning)
     * 2. Play minion
     * 3. Attack
     * 4. Protect (block)
     * 5. play minions
     * 6. End
     */
    public static void actionPerformed(boolean advanceTurnState){
        //Call when you do things always
        playTurnStages[] turnStages = playTurnStages.values();
        if (shouldChangePlayer) {
            playerOneTurn = !playerOneTurn;
            shouldChangePlayer = false;
        }
        if (playerOneTurn){
            players[0].setHealth(players[0].getMana() + 1);
        }
        else{
            players[1].setHealth(players[1].getMana() + 1);
        }
        if (advanceTurnState) {
            int currentStateIndex = 0;
            for (int i = 0; i < turnStages.length; i++) {
                if (currentTurnState.equals(turnStages[i]))
                    currentStateIndex = i;
            }
            currentTurnState = turnStages[currentStateIndex + 1];
        }
    }

    public Player getCurrentPlayer(){
        if (playerOneTurn) return players[0];
        else return players[1];
    }
    public Player get_player_one(){
        return players[0];
    }
    public Player get_player_two(){
        return players[1];
    }

}
