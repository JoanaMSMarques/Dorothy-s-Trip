package org.academiadecodigo.felinux.View.extras;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.HashMap;
import java.util.Map;


public class HighnessMeter {

    //MIN = 0     MAX = 260
    //25% = 65   ;  50% = 130   ;   75% = 195
    public static int meter = 260;

    private Picture meterBar = new Picture(5, 20 + 465, "/meter/meter.png");
    private Rectangle rectangle = new Rectangle(109, 73 + 465, meter, 36);
    private int counter = 15;

    private boolean goingRight = false;

    public HighnessMeter() {
        rectangle.setColor(new Color(10, 10, 255));

    }

    public void animate() {

        if(counter > 15){
            counter--;
            return;
        }

        counter = 30;

        if (meter > 259) {
            goingRight = false;
        } else if (meter <= 0) {
            goingRight = true;
        }
        //Depressed
        if (meter <= 65) {
            rectangle.setColor(new Color(57, 77, 255));
        } //Normal
        else if (meter > 65 && meter <= 165) {
            rectangle.setColor(new Color(250, 194, 27));
        } //High
        else if (meter > 165) {
            rectangle.setColor(new Color(250, 27, 27));
        }
        if (goingRight) {
            this.rectangle.translate(1, 0);
            this.rectangle.grow(1, 0);
            this.meter += 2;
            //System.out.println(rectangle.getX() + " " + rectangle.getY());
        } else {
            this.rectangle.translate(-1, 0);
            this.rectangle.grow(-1, 0);
            this.meter -= 2;
        }
        meterBar.draw();
        rectangle.fill();
    }

    public Picture getMeterBar() {
        return meterBar;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
