package com.mygdx.game.Tests;

import com.mygdx.game.Controller;
import junit.framework.TestCase;


/**
 * Created by matthewelbing on 15.02.17.
 */

public class TestGameLoop extends TestCase {
    public void testGameLoop() {
        Controller controller  = new Controller();
        controller.actionPerformed(true);
    }
}
