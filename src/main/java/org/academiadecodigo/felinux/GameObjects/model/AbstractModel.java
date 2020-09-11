package org.academiadecodigo.felinux.GameObjects.model;

import org.academiadecodigo.felinux.GameObjects.GameObject;
import org.academiadecodigo.felinux.tools.DirectionType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractModel extends GameObject {

    protected DirectionType direction;
    protected boolean talking;

    public AbstractModel() {
    }

    public boolean isTalking() {
        return talking;
    }

    public void setTalking(boolean talking) {
        this.talking = talking;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }
}
