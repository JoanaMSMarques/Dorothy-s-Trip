package org.academiadecodigo.felinux.tools;

public enum DirectionType {

    FRONT(new String[]{"/img/chars/girl/WALK_FRONT_1.png", "/img/chars/girl/WALK_FRONT_2.png", "/img/chars/girl/WALK_FRONT_3.png", "/img/chars/girl/WALK_FRONT_4.png"},new String[]{"/img/chars/oldLady/OLD_FRONT_1.png", "/img/chars/oldLady/OLD_FRONT_2.png", "/img/chars/oldLady/OLD_FRONT_3.png", "/img/chars/oldLady/OLD_FRONT_4.png"}),
    BACK(new String[]{"/img/chars/girl/WALK_BACK_1.png", "/img/chars/girl/WALK_BACK_2.png", "/img/chars/girl/WALK_BACK_3.png", "/img/chars/girl/WALK_BACK_4.png"},new String[]{"/img/chars/oldLady/OLD_BACK_1.png", "/img/chars/oldLady/OLD_BACK_2.png", "/img/chars/oldLady/OLD_BACK_3.png", "/img/chars/oldLady/OLD_BACK_4.png"}),
    LEFT(new String[]{"/img/chars/girl/WALK_LEFT_1.png", "/img/chars/girl/WALK_LEFT_2.png", "/img/chars/girl/WALK_LEFT_3.png", "/img/chars/girl/WALK_LEFT_4.png"},new String[]{"/img/chars/oldLady/OLD_LEFT_1.png", "/img/chars/oldLady/OLD_LEFT_2.png", "/img/chars/oldLady/OLD_LEFT_3.png", "/img/chars/oldLady/OLD_LEFT_4.png"}),
    RIGHT(new String[]{"/img/chars/girl/WALK_RIGHT_1.png", "/img/chars/girl/WALK_RIGHT_2.png", "/img/chars/girl/WALK_RIGHT_3.png", "/img/chars/girl/WALK_RIGHT_4.png"},new String[]{"/img/chars/oldLady/OLD_RIGHT_1.png", "/img/chars/oldLady/OLD_RIGHT_2.png", "/img/chars/oldLady/OLD_RIGHT_3.png", "/img/chars/oldLady/OLD_RIGHT_4.png"}),
    ;

    private String[] images;
    private String[] oldImages;

    DirectionType(String[] images, String[] oldImages) {
        this.images = images;
        this.oldImages = oldImages;
    }

    public String getImage(int position){
        return this.images[position];
    }

    public String getOldImages(int position) {
        return oldImages[position];
    }
}
