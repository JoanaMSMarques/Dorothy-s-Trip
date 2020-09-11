package org.academiadecodigo.felinux.View;

import org.academiadecodigo.felinux.GameObjects.map.Hall;
import org.academiadecodigo.felinux.GameObjects.map.MapType;
import org.academiadecodigo.felinux.View.extras.HighnessMeter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.felinux.GameObjects.map.MapType.*;
import static org.academiadecodigo.felinux.Services.GameCycle.activeMap;
import static org.academiadecodigo.felinux.GameObjects.map.MapType.*;
import static org.academiadecodigo.felinux.Services.GameCycle.activeMap;
import static org.academiadecodigo.felinux.Services.GameCycle.imageMap;

public class HallView extends View {


    public HallView() {
        super(new Hall());
    }

    public void init(HighnessMeter hm, MapType mapType) {


        while (player.isAlive() && activeMap == mapType) {

            if (HighnessMeter.meter > 75) {

                background.setHighEffect();
            } else {
                background.setHighEffect();
            }

            if (firstTime) {
                imageMap.draw();
                player.setxPos(player.getPositions()[1][0]);
                player.setyPos(player.getPositions()[1][1]);
                player.setImage(new Picture(234, 406, "/img/chars/oldLady/OLD_IDLE_FRONT.png"));
                player.getImage().draw();
                hm.getMeterBar().draw();
                hm.getRectangle().fill();
                firstTime = false;
            }

            hm.animate();
            map.animate();
            player.move();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(player.checkBorder(440,400,30)){
                break;
            }

        }

        activeMap = ATRIUM;
        imageMap.delete();
        imageMap = new Picture(50,50, activeMap.getSource());
        player.getImage().delete();
        player.setxPos(player.getPositions()[1][0]);
        player.setyPos(player.getPositions()[1][1]);
        //player.setImage(new Picture(player.getPositions()[2][0], player.getPositions()[2][1]));
        hm.getRectangle().delete();
        hm.getMeterBar().delete();
    }
}


