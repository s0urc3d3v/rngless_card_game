package com.mygdx.game.Core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by matthewelbing on 20.03.17.
 */
public class DB_tool {
    private Preferences prefs;

    public DB_tool() {
        prefs = Gdx.app.getPreferences("game_settings");
    }

    /**
     * Assigns hashmap position and writes to file
     * NOTE: Object must be an Object style so Integer not int
     *
     * @param key Key for getting preferance
     * @param o   Object of Integer, Boolean, or String
     */
    public void addPref(String key, Object o) {
        if (o instanceof String) {
            prefs.putString(key, ((String) o));
        } else if (o instanceof Integer) {
            prefs.putInteger(key, ((Integer) o));
        } else if (o instanceof Boolean) {
            prefs.putBoolean(key, ((Boolean) o));
        } else {
            System.out.println("Invalid input type for prefs");
        }
        prefs.flush();

    }

    public Object getPref(String key, String type){
        if (type.equals("string")) {
            return prefs.getString(key);
        }
        else if (type.equals("Integer")){
            return prefs.getInteger(key);
        }
        else if (type.equals("Boolean")){
            return prefs.getBoolean(key);
        }
        else {
            return null;
        }
    }
}
