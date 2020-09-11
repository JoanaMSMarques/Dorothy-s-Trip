package org.academiadecodigo.felinux.GameObjects.map;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.felinux.GameObjects.map.MapType.HELL;

public class Hell extends Map{

private int counter=0;
private Picture image;

    public Hell() {
        super(HELL);
        image = new Picture(10,10,"/img/mansion/hell/hell0.png");

    }
    public void animate(){

        if(counter == 0) {
            image.draw();
        }
        counter++;
        if(counter == 7){
            counter = 0;
        }
        image.load("/img/mansion/hell/hell" + counter + ".png");
    }
}
