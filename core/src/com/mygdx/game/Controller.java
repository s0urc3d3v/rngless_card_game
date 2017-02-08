package com.mygdx.game;

import com.mygdx.game.Views.ViewSwitchListener;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static List<ViewSwitchListener> viewSwitchListeners = new ArrayList<>();

    public static void attachListener(ViewSwitchListener viewSwitchListener) {
        viewSwitchListeners.add(viewSwitchListener);
    }

    public static void callViewSwitch() {
        for(ViewSwitchListener vsl: viewSwitchListeners) {
            vsl.onSwitch();
        }
    }
}
