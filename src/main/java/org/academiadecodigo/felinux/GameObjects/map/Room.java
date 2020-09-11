package org.academiadecodigo.felinux.GameObjects.map;
import org.academiadecodigo.felinux.GameObjects.drugs.Shroom;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.felinux.GameObjects.map.MapType.*;

public class Room extends Map {

    private Picture bed = new Picture(350,270, "/img/objects/bed.png");

    public Room() {
        super(ROOM);
        roomShroom = new Shroom(this);
    }
    public void animate() {
        roomShroom.spawnShroom();
        super.animate();
    }
    public void spawnItems(){
        bed.draw();
    }
}
