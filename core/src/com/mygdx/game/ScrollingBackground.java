package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.Constants;



public class ScrollingBackground {

    public static final int DEFAULT_SPEED = 100;
    public static final int ACCELERATION = 100;
    public static final int GOAL_REACH_ACCELERATION = 100;

    Texture image;
    float y1, y2;
    int speed;
    int goalSpeed;
    float imageScale;
    boolean speedFixed;

    public ScrollingBackground () {
        image = new Texture("stars_background.png");

        y1 = 0;
        y2 = image.getHeight();
        speed = 0;
        goalSpeed = DEFAULT_SPEED;
        imageScale = Constants.VIEWPORT_WIDTH / image.getWidth();
        speedFixed = true;
    }

    public void updateAndRender (float deltaTime, SpriteBatch batch) {

        speed += GOAL_REACH_ACCELERATION * deltaTime;


        y1 -= speed * deltaTime;
        y2 -= speed * deltaTime;


        if (y1 + image.getHeight() * imageScale <= 0)
            y1 = y2 + image.getHeight() * imageScale;

        if (y2 + image.getHeight() * imageScale <= 0)
            y2 = y1 + image.getHeight() * imageScale;

        batch.draw(image, 0, y1, Constants.VIEWPORT_WIDTH, image.getHeight() * imageScale);
        batch.draw(image, 0, y2, Constants.VIEWPORT_WIDTH, image.getHeight() * imageScale);
        batch.draw(image, -Constants.VIEWPORT_WIDTH, y1, Constants.VIEWPORT_WIDTH, image.getHeight() * imageScale);
        batch.draw(image, -Constants.VIEWPORT_WIDTH, y2, Constants.VIEWPORT_WIDTH, image.getHeight() * imageScale);
    }

    public void setSpeed (int goalSpeed) {
        this.goalSpeed = goalSpeed;
    }

    public void setSpeedFixed (boolean speedFixed) {
        this.speedFixed = speedFixed;
    }

}