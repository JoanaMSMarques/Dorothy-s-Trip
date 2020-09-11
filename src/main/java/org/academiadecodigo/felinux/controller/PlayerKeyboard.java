package org.academiadecodigo.felinux.controller;
import org.academiadecodigo.felinux.GameObjects.map.MapType;
import org.academiadecodigo.felinux.GameObjects.model.Dorothy;
import org.academiadecodigo.felinux.Services.GameCycle;
import org.academiadecodigo.felinux.View.extras.HighnessMeter;
import org.academiadecodigo.felinux.tools.DirectionType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.felinux.tools.DirectionType.*;
/**
 * Keyboard Handler for Player Ingame
 */
public class PlayerKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Dorothy player;
    private float moveSpeed = 4f;
    private float lateralMove = 2.6f;


    public PlayerKeyboard(Dorothy player){
        this.player = player;
        keyboard = new Keyboard(this);
        init();
    }

    /**
     * Initialize Keyboard for player movement
     */
    private void init(){
        /**
         * Key pressed
         */
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftArrow = new KeyboardEvent();
        leftArrow.setKey(KeyboardEvent.KEY_LEFT);
        leftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightArrow = new KeyboardEvent();
        rightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upArrow = new KeyboardEvent();
        upArrow.setKey(KeyboardEvent.KEY_UP);
        upArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downArrow = new KeyboardEvent();
        downArrow.setKey(KeyboardEvent.KEY_DOWN);
        downArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent interact = new KeyboardEvent();
        interact.setKey(KeyboardEvent.KEY_E);
        interact.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent mapSwap = new KeyboardEvent();
        mapSwap.setKey(KeyboardEvent.KEY_SPACE);
        mapSwap.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent changeMap = new KeyboardEvent();
        changeMap.setKey(KeyboardEvent.KEY_K);
        changeMap.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent q = new KeyboardEvent();
        q.setKey(KeyboardEvent.KEY_Q);
        q.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_E);
        e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent c = new KeyboardEvent();
        c.setKey(KeyboardEvent.KEY_C);
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent z = new KeyboardEvent();
        z.setKey(KeyboardEvent.KEY_Z);
        z.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(q);
        keyboard.addEventListener(e);
        keyboard.addEventListener(c);
        keyboard.addEventListener(z);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(leftArrow);
        keyboard.addEventListener(rightArrow);
        keyboard.addEventListener(upArrow);
        keyboard.addEventListener(downArrow);
        keyboard.addEventListener(interact);
        keyboard.addEventListener(mapSwap);
        keyboard.addEventListener(changeMap);
        /*
         * Key Released
         */
        KeyboardEvent stopLeft = new KeyboardEvent();
        stopLeft.setKey(KeyboardEvent.KEY_A);
        stopLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopLeftArrow = new KeyboardEvent();
        stopLeftArrow.setKey(KeyboardEvent.KEY_LEFT);
        stopLeftArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopRightArrow = new KeyboardEvent();
        stopRightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        stopRightArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopUpArrow = new KeyboardEvent();
        stopUpArrow.setKey(KeyboardEvent.KEY_UP);
        stopUpArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopDownArrow = new KeyboardEvent();
        stopDownArrow.setKey(KeyboardEvent.KEY_DOWN);
        stopDownArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopRight = new KeyboardEvent();
        stopRight.setKey(KeyboardEvent.KEY_D);
        stopRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopUp = new KeyboardEvent();
        stopUp.setKey(KeyboardEvent.KEY_W);
        stopUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopDown = new KeyboardEvent();
        stopDown.setKey(KeyboardEvent.KEY_S);
        stopDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        KeyboardEvent qr = new KeyboardEvent();
        qr.setKey(KeyboardEvent.KEY_Q);
        qr.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent er = new KeyboardEvent();
        er.setKey(KeyboardEvent.KEY_E);
        er.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent cr = new KeyboardEvent();
        cr.setKey(KeyboardEvent.KEY_C);
        cr.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent zr = new KeyboardEvent();
        zr.setKey(KeyboardEvent.KEY_Z);
        zr.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(qr);
        keyboard.addEventListener(er);
        keyboard.addEventListener(cr);
        keyboard.addEventListener(zr);
        keyboard.addEventListener(stopLeft);
        keyboard.addEventListener(stopRight);
        keyboard.addEventListener(stopUp);
        keyboard.addEventListener(stopDown);
        keyboard.addEventListener(stopLeftArrow);
        keyboard.addEventListener(stopRightArrow);
        keyboard.addEventListener(stopUpArrow);
        keyboard.addEventListener(stopDownArrow);
    }
    /**
     * KeyboardEvent Handler for Player actions on key press
     *
     * @param keyboardEvent self explanatory
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        player.setDx(0);
        player.setDy(0);

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_A||keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            player.setDx(player.getDx()-moveSpeed);
            player.setDirection(LEFT);
            player.setIdle(false);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_D||keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            player.setDx(player.getDx()+moveSpeed);
            player.setDirection(RIGHT);
            player.setIdle(false);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_W||keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            player.setDy(player.getDy()-moveSpeed);
            player.setDirection(BACK);
            player.setIdle(false);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_S||keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            player.setDy(player.getDy()+moveSpeed);
            player.setDirection(FRONT);
            player.setIdle(false);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){

            player.setDy(player.getDy()-lateralMove);
            player.setDx(player.getDx()-lateralMove);
            player.setDirection(LEFT);
            player.setIdle(false);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_C){
            player.setDy(player.getDy()+lateralMove);
            player.setDx(player.getDx()+lateralMove);
            player.setDirection(RIGHT);
            player.setIdle(false);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_E){
            player.setDy(player.getDy()-lateralMove);
            player.setDx(player.getDx()+lateralMove);
            player.setDirection(BACK);
            player.setIdle(false);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Z){
            player.setDy(player.getDy()+lateralMove);
            player.setDx(player.getDx()-lateralMove);
            player.setDirection(FRONT);
            player.setIdle(false);
        }
       // if(keyboardEvent.getKey() == KeyboardEvent.KEY_E){
       //     player.interact();
       // }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_K) {
            GameCycle.activeMap = null;
        }



        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){

        }
    }
    /**
     * KeyboardEvent Handler for Player actions on key released
     *
     * @param keyboardEvent self explanatory
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_A)||(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT)){
            player.setDx(0f);
            player.setIdle(true);
        }
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_D)||(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT)){
            player.setDx(0f);
            player.setIdle(true);
        }
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_W)||(keyboardEvent.getKey() == KeyboardEvent.KEY_UP)){
            player.setDy(0f);
            player.setIdle(true);
        }
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_S)||(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN)){
            player.setDy(0f);
            player.setIdle(true);
        }
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_Q)){
            player.setDy(0f);
            player.setDx(0f);
            player.setIdle(true);
        }
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_Z)){
            player.setDy(0f);
            player.setDx(0f);
            player.setIdle(true);
        }
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_C)){
            player.setDy(0f);
            player.setDx(0f);
            player.setIdle(true);
        }
        if((keyboardEvent.getKey() == KeyboardEvent.KEY_E)){
            player.setDy(0f);
            player.setDx(0f);
            player.setIdle(true);
        }
    }
}


