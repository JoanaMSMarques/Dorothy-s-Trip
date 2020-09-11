package org.academiadecodigo.felinux.View;

import org.academiadecodigo.felinux.GameObjects.map.MapType;
import org.academiadecodigo.felinux.GameObjects.map.Room;
import org.academiadecodigo.felinux.GameObjects.model.Dorothy;
import org.academiadecodigo.felinux.View.extras.HighnessMeter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.felinux.GameObjects.map.MapType.*;
import static org.academiadecodigo.felinux.Services.GameCycle.activeMap;
import static org.academiadecodigo.felinux.Services.GameCycle.imageMap;

public class RoomView extends View{

    public RoomView() {
        super(new Room());
    }

    @Override
    public void init(HighnessMeter hm, MapType mapType) {
        while (player.isAlive() && activeMap == mapType) {

            if (HighnessMeter.meter > 75) {

                background.setHighEffect();
            } else {
                background.setHighEffect();
            }

            if (firstTime) {
                imageMap.draw();

                Room room = (Room) super.map;
                room.spawnItems();
                player.setImage(new Picture(250,250,"/img/chars/oldLady/OLD_IDLE_FRONT.png"));
                player.getImage().draw();
                firstTime = false;
            }

            hm.animate();
            map.animate();
            player.move();
            Room room = (Room) super.map;
            room.spawnItems();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(player.checkBorder(250,380, 30)){
                break;
            }
        }

        activeMap = HALL;
        imageMap.delete();
        imageMap = new Picture(50,50, activeMap.getSource());
        player.getImage().delete();
        player.setxPos(player.getPositions()[1][0]);
        player.setyPos(player.getPositions()[1][1]);
        //player.setImage(new Picture(player.getPositions()[1][0], player.getPositions()[1][1], "/img/chars/girl/IDLE_FRONT.png"));
        hm.getRectangle().delete();
        hm.getMeterBar().delete();
    }
}
