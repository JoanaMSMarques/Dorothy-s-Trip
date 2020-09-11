package org.academiadecodigo.felinux.GameObjects.model;

import org.academiadecodigo.felinux.GameObjects.map.Map;
import org.academiadecodigo.felinux.View.extras.HighnessMeter;
import org.academiadecodigo.felinux.tools.DirectionType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Dorothy extends AbstractModel {

    private float dx;
    private float dy;
    private boolean alive;
    private int moveCounter;
    private boolean idle;
    private DirectionType prevDirection;
    private String lastSprite = "/img/chars/oldLady/OLD_IDLE_FRONT.png";
    private int[][] positions;
    private int xPos = 250;
    private int yPos = 250;
    private boolean decision;
    private Picture tripImage;
    private boolean trip;


    public Dorothy() {
        this.prevDirection = DirectionType.BACK;
        direction = DirectionType.BACK;
        alive = true;
        setPositions();
        image = new Picture(xPos,yPos, "img/chars/girl/IDLE_BACK.png");
        idle = true;
    }

    public void setPositions() {
        positions = new int[][] {
                new int[]{250, 250},
                new int[]{234, 406},
                new int[]{542, 342},
                new int[]{602, 442}
        };
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    /**
     * Moves player
     */
    public void move(){

        if(HighnessMeter.meter <=1|| HighnessMeter.meter >= 259){
            alive= false;
            killDorothy();
            return;
        }

//        if(trip)
//
//            tripImage.delete();
//            trip = false;
//        }
//
//        if(!trip){
//
//            if(Math.random()<=0.1){
//
//                tripImage = new Picture(Math.random()*650,Math.random()*650,"img/chars/highNpcs/blueHorse/tile062.png");
//                tripImage.draw();
//                System.out.println(tripImage);
//                trip=true;
//            }
//        }
//
        if(idle){
            super.image.load((HighnessMeter.meter<=65)?"/img/chars/oldLady/OLD_IDLE_"+ direction +".png"
                    :"/img/chars/girl/IDLE_" + direction +".png");
            return;
        }
        if(moveCounter >= 3 || prevDirection != super.direction){
            moveCounter = 0;
        } else {
            moveCounter++;
        }

        System.out.println(image.getX() + " "+ image.getY());
        super.image.load((HighnessMeter.meter<=65)?direction.getOldImages(moveCounter):direction.getImage(moveCounter));

        super.image.translate(dx,dy);
        prevDirection = direction;
    }

    private void killDorothy() {

        image.load("img/chars/girl/DEAD_LEFT_1.png");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkBorder(int x, int y, int distance) {

        int xA = ((super.image.getX())*2+super.image.getWidth())/2;
        int yA = ((super.image.getY())*2+super.image.getHeight())/2;

        return getDistance(xA,yA,x,y)<=distance;
    }

    /**
     * Interacts with random objects
     * @param player receives the player image (Picture)
     * @param interactable receives the interactable object image (Picture)
     */
    public boolean interact(Picture player, Picture interactable) {

        int xA = ((player.getX())*2+player.getWidth())/2;
        int yA = ((player.getY())*2+player.getHeight())/2;

        int xB = (interactable.getX()*2+interactable.getWidth())/2;
        int yB = (interactable.getY()*2+interactable.getHeight())/2;

        int distance = ( interactable.getWidth()+player.getWidth() )/2;
        return getDistance(xA,yA,xB,yB)<=distance;
    }

    /**
     * Almighty God, calculator of distance, ruler of the maths
     * @param xA
     * @param yA
     * @param xB
     * @param yB
     * @return the distance between 2 points
     */
    private static double getDistance(double xA, double yA, double xB, double yB){

        return Math.sqrt(Math.pow((xA-xB),2)+Math.pow((yA-yB),2));
    }
    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean status) {
        this.idle = status;
    }

    public DirectionType getPrevDirection() {
        return prevDirection;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int[][] getPositions() {
        return positions;
    }

    public boolean isDecision() {
        return decision;
    }
}


