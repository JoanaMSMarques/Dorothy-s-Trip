package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.Services.GameCycle;
import org.academiadecodigo.felinux.sound.GameSound;

public class Main {

    public static void main(String[] args) {
        GameSound sound = new GameSound("/sounds/Depressed_Somewhere_Over_the_Rainbow_OLD.wav");
        sound.play(true);
        GameCycle game = new GameCycle();
        game.setupGame();
        game.start();
    }
}
