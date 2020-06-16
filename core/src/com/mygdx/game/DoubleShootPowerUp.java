package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class DoubleShootPowerUp extends GameObject{

    public static final float SPEED = 2;
    public static final float WIDTH = 3f;
    public static final float HEIGHT = 3f;
    private static Sprite texture;

    float x, y;
    Collision col;
    public boolean remove = false;

    public DoubleShootPowerUp (float x, float y) {
        this.position.x = x;
        this.position.y = y;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.position.y = Constants.VIEWPORT_HEIGHT;
        this.col = new Collision(x, y, WIDTH, HEIGHT);
        this.texture = new Sprite(new Texture("DoubleShot.png"));
        this.sprites.add(SpriteHelper.spriteFromTexture("DoubleShot.png", 0 , 0));
        this.typeOfGO = 2;
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
        Gdx.app.error("cojones", this.position.x + this.position.y + "posicion");
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
