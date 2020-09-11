package org.academiadecodigo.felinux.GameObjects;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    protected Picture image;

    public GameObject() {
    }

    public Picture getImage() {
        return image;
    }

    public void setImage(Picture image) {
        this.image = image;
        image.draw();
    }
}
