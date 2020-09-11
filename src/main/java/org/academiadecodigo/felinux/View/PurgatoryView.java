package org.academiadecodigo.felinux.View;

import org.academiadecodigo.felinux.GameObjects.map.MapType;
import org.academiadecodigo.felinux.GameObjects.map.Purgatory;
import org.academiadecodigo.felinux.View.extras.HighnessMeter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.felinux.Services.GameCycle.activeMap;
import static org.academiadecodigo.felinux.Services.GameCycle.imageMap;

public class PurgatoryView extends View{

    public PurgatoryView() {
        super(new Purgatory());
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
                player.setImage(new Picture(602, 442, "/img/chars/oldLady/OLD_IDLE_FRONT.png"));
                player.getImage().draw();
                hm.getMeterBar().draw();
                hm.getRectangle().fill();
                firstTime = false;
            }

            hm.animate();
            map.animate();
            player.move();

            //check interactio with water or fire
            if(player.interact(player.getImage(), ((Purgatory)map).getFire().getImage())){

                ((Purgatory)map).getWater().getImage().delete();
                ((Purgatory)map).getFire().getImage().delete();

                player.setDecision(false);
                break;
            }

            if(player.interact(player.getImage(), ((Purgatory)map).getWater().getImage())){

                ((Purgatory)map).getWater().getImage().delete();
                ((Purgatory)map).getFire().getImage().delete();

                player.setDecision(true);
                break;
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        imageMap.delete();
        player.getImage().delete();
        hm.getRectangle().delete();
        hm.getMeterBar().delete();
        background.getRectangle().delete();
    }
}
