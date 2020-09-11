package org.academiadecodigo.felinux.GameObjects.map;

/**
 * This class stores all maps
 */
public enum MapType {
    ROOM("/img/mansion/room.png"),
    ATRIUM("/img/mansion/atrium/atriumScareCrow.png"),
    HALL("/img/mansion/hall/hall.png"),
    HEAVEN("/img/mansion/heaven/heaven.png"),
    HELL("img/mansion/hell/hell.png"),
    PURGATORY("/img/mansion/purgatory/purgatory.png");

    private String source;

    MapType(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
