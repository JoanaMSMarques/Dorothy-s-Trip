package org.academiadecodigo.felinux.GameObjects.loadScreen;

import org.academiadecodigo.felinux.GameObjects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HallLoadScreen extends GameObject {

    public void init() {
        image = new Picture(10,10, "/img/loadscreen/hallLoadScree.png");
        image.draw();
    }
}
