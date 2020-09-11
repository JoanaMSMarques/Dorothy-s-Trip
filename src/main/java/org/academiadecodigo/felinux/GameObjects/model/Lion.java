package org.academiadecodigo.felinux.GameObjects.model;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Lion extends AbstractModel{

    private Dorothy player;

    public Lion() {
        image = new Picture(350, 250, "/img/chars/lion/move/lionBack.png");
    }

    public void move() {

    }

    public void setPlayer(Dorothy player) {
        this.player = player;
    }
}
