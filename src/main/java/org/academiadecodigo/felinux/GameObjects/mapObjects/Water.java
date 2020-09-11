package org.academiadecodigo.felinux.GameObjects.mapObjects;

import org.academiadecodigo.felinux.GameObjects.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Water extends GameObject {

    private int counter = 0;
    private final String src = "/img/element/water/water_1.png";


    public Water(){
        image = new Picture(480,240, src);

    }

    public void animate(){

        this.image.delete();
        counter++;
        if(counter == 9){
            counter = 1;
            image = new Picture(480,240, "/img/element/water/water_" + counter + ".png");
            image.draw();
            return;
        }
        image = new Picture(480,284, "/img/element/water/water_" + counter + ".png");
        image.draw();
    }

    /**
     * Creates movement for water
     */


    }

