package com.mygdx.game;

import com.mygdx.game.Views.ViewSwitchListener;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public enum playTurnStages{
        playOne,
        Attack,
        Protect,
        playTwo,
        End
    }
    private playTurnStages currentTurnState = playTurnStages.playOne;
    private boolean playerOneTurn = true;
    private boolean shouldChangePlayer = false;

    private static List<ViewSwitchListener> viewSwitchListeners = new ArrayList<>();

    public static void attachListener(ViewSwitchListener viewSwitchListener) {
        viewSwitchListeners.add(viewSwitchListener);
    }

    public static void callViewSwitch() {
        for(ViewSwitchListener vsl: viewSwitchListeners) {
            vsl.onSwitch();
        }
    }

    /*
    * 1.Turn begin (get mana poisoning)
    * 2. Play minion
    * 3. Attack
    * 4. Protect (block)
    * 5. play minions
    * 6. End
     */
    public void actionPerformed(boolean advanceTurnState){
        //Call when you do things
        playTurnStages[] turnStages = playTurnStages.values();
        if (shouldChangePlayer) {
            playerOneTurn = !playerOneTurn;
            shouldChangePlayer = false;
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


}
