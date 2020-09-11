package org.academiadecodigo.felinux.View;

import org.academiadecodigo.felinux.GameObjects.map.Atrium;
import org.academiadecodigo.felinux.GameObjects.map.MapType;
import org.academiadecodigo.felinux.View.extras.HighnessMeter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.felinux.GameObjects.map.MapType.*;
import static org.academiadecodigo.felinux.Services.GameCycle.activeMap;
import static org.academiadecodigo.felinux.Services.GameCycle.imageMap;

public class AtriumView extends View {


    public AtriumView() {
        super(new Atrium());
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
                player.setImage(new Picture(542, 342, "/img/chars/oldLady/OLD_IDLE_FRONT.png"));
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

            if(player.checkBorder(115,380,30)){
                break;
            }
        }

        player.getImage().delete();
        player.setxPos(player.getPositions()[3][0]);
        player.setyPos(player.getPositions()[3][1]);
        hm.getRectangle().delete();
        hm.getMeterBar().delete();
        activeMap = PURGATORY;
        imageMap.delete();
        imageMap = new Picture(50,50, activeMap.getSource());
    }

}
