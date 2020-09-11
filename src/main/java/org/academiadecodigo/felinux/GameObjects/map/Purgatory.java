package org.academiadecodigo.felinux.GameObjects.map;
import org.academiadecodigo.felinux.GameObjects.drugs.Shroom;
import org.academiadecodigo.felinux.GameObjects.mapObjects.Fire;
import org.academiadecodigo.felinux.GameObjects.mapObjects.Water;

import static org.academiadecodigo.felinux.GameObjects.map.MapType.*;

public class Purgatory extends Map{

    private Fire fire;
    private Water water;

    public Purgatory() {
        super(PURGATORY);
        fire = new Fire();
        water = new Water();
        purgatoryShrooms = new Shroom(this);
    }

    public void animate() {
        fire.animate();
        water.animate();
        purgatoryShrooms.spawnShroom();
        super.animate();
    }

    public Water getWater() {
        return water;
    }

    public Fire getFire() {
        return fire;
    }
}
