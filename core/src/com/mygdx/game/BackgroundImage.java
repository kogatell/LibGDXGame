package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class BackgroundImage{
    Vector3 position;
    int speed;
    public boolean remove;
    Texture background1, background2;
    SpriteBatch batch;
    public  float yMax, yCoordBg1, yCoordBg2;
    final int BACKGROUND_MOVE_SPEED = 3;
    BackgroundImage(float z)
    {
        background1 = new Texture(Gdx.files.internal("prev-Space-Background-1.jpg"));
        background2 = new Texture(Gdx.files.internal("prev-Space-Background-1.jpg")); // identical
        yMax = 15;
        yCoordBg1 = yMax*(-1); yCoordBg2 = 0;
    }
    /*public void Update(float deltaTime)
    {
        backgroundImg.yCoordBg1 += backgroundImg.BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
        backgroundImg.yCoordBg2 = backgroundImg.yCoordBg1 + backgroundImg.yMax;  // We move the background, not the camera
        if (backgroundImg.yCoordBg1 >= 0) {
            backgroundImg.yCoordBg1 = backgroundImg.yMax*(-1); backgroundImg.yCoordBg2 = 0;
        }
        batch.begin();
        batch.draw(backgroundImg.background1, 0, backgroundImg.yCoordBg1);
        batch.draw(backgroundImg.background2, 0, backgroundImg.yCoordBg2);
        batch.end();
    }*/
}
