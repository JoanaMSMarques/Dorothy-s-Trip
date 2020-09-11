package org.academiadecodigo.felinux.GameObjects.mapObjects;

import org.academiadecodigo.felinux.GameObjects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Fire extends GameObject {

    private int counter = 0;

    public Fire(){
        image = new Picture(185,170, "/img/element/fire/fire_1.png");
    }

    public void animate(){

        if(counter == 0) {
            image.draw();
        }
        counter++;
        if(counter == 15){
            counter = 1;
        }
        image.load("/img/element/fire/fire_" + counter + ".png");
    }
}
