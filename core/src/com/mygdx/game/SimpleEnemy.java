package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;


public class SimpleEnemy extends GameObject{

    public static final int SPEED = 5;
    public static final int WIDTH = 1;
    public static final int HEIGHT = 1;
    private static Sprite texture;

    float x, y;
    Collision col;
    public boolean remove = false;

    public SimpleEnemy (float x) {
        this.position.x = x;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.position.y = Constants.VIEWPORT_HEIGHT;
        this.col = new Collision(x, y, WIDTH, HEIGHT);
        this.texture = new Sprite(new Texture("Asteroid.png"));
        this.sprites.add(SpriteHelper.spriteFromTexture("Asteroid.png", 0 , 0));
        this.typeOfGO = 1;
    }
    @Override
    public void update (float deltaTime) {
        this.position.y -= SPEED * deltaTime;
        if (y < -HEIGHT)
            remove = true;
        Gdx.app.error("Sprite", this.position.y +"Posicion");
        col.move(this.position.x, this.position.y);
    }


    public void render (SpriteBatch batch) {

        texture.setPosition(this.position.x, this.position.y);
        texture.draw(batch);
    }
    @Override
    public Collision getCollisionRect () {
        return col;
    }

    public float getX () {
        return this.position.x;
    }

    public float getY () {
        return this.position.y;
    }

}