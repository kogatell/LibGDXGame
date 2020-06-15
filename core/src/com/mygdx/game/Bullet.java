package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;




public class Bullet extends GameObject {

    public int SPEED = 10;
    public static final float DEFAULT_Y = -1.75f;
    public static final float WIDTH = 0.5f;
    public static final float HEIGHT = 0.5f;
    private static Sprite texture;

    float x, y;
    Collision col;
    public boolean remove = false;

    public Bullet (float x) {
        this.position.x = x;
        this.position.y = DEFAULT_Y;
        this.width = WIDTH;
        this.height = HEIGHT;
        texture = new Sprite(new Texture("mega-laser-1.png"));
        this.col = new Collision(this.position.x, this.position.y, WIDTH, HEIGHT);
        this.sprites.add(SpriteHelper.spriteFromTexture("mega-laser-1.png", 0 , 0));
        this.typeOfGO = 0;
        //sprites.add(SpriteHelper.spriteFromTexture("laser.png", 0 , 0));

    }
    @Override
    public void update (float deltaTime) {
        this.position.y += SPEED * deltaTime;
        Gdx.app.error("hola", this.position.y+ "Bullet position");
        if (this.position.y > Gdx.graphics.getHeight())
            remove = true;

        col.move(this.position.x,this.position.y);
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

    public Sprite getCurrentSprite(){
        return sprites.get(spriteIndex);
    }

}
