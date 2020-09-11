package org.academiadecodigo.felinux.View;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HeavenView {

    Picture image = new Picture(10, 10, "/img/mansion/heaven/heaven.png");


    public void init() {
        image.draw();
        timer();
    }


    public void timer() {
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

