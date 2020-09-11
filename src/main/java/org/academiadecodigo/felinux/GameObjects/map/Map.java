package org.academiadecodigo.felinux.GameObjects.map;

import org.academiadecodigo.felinux.GameObjects.GameObject;
import org.academiadecodigo.felinux.GameObjects.drugs.Shroom;
import org.academiadecodigo.felinux.Services.GameCycle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Map {

    private MapType currentMap;
    protected Shroom purgatoryShrooms;
    protected Shroom roomShroom;
    protected Picture tripImage;
    private boolean firstTime;

    public Map(MapType currentMap) {
        this.currentMap = currentMap;
        firstTime = true;
    }


    public MapType getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(MapType currentMap) {
        this.currentMap = currentMap;
    }

    public void draw() {
        GameCycle.imageMap.load(currentMap.getSource());
    }

    public void animate(){

        /*tripImage = new Picture(Math.random() * 500, Math.random() * 500, "img/chars/highNpcs/blueHorse/tile062.png");

        if(firstTime) {
            tripImage.draw();
            firstTime = false;
        }

        if(Math.random()<=0.1) {

            tripImage = new Picture(Math.random() * 500, Math.random() * 500, "img/chars/highNpcs/blueHorse/tile062.png");
            tripImage.draw();
        }

        tripImage.delete();
*/
    };
}
