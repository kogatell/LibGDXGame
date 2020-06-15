package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class ChaseEnemy extends  GameObject{
    public int SPEED = 6;
    public static final float DEFAULT_Y = -1.75f;
    public static final float WIDTH = 0.5f;
    public static final float HEIGHT = 0.5f;
    private static Sprite texture;
    private Vector2 target = new Vector2(0.0f, 0.0f);

    float x, y;
    Collision col;
    public boolean remove = false;
    public ChaseEnemy (float x, float y) {
        this.position.x = x;
        this.position.y = y;
        this.width = WIDTH;
        this.height = HEIGHT;
        texture = new Sprite(new Texture("mega-laser-1.png"));
        this.col = new Collision(this.position.x, this.position.y, WIDTH, HEIGHT);
        this.sprites.add(SpriteHelper.spriteFromTexture("mega-laser-1.png", 0 , 0));
        this.typeOfGO = 7;
        //sprites.add(SpriteHelper.spriteFromTexture("laser.png", 0 , 0));
    }
    public void GetTarget(Vector2 targ)
    {
        target = targ;
    }
    public void update (float deltaTime) {

        this.position.y -= SPEED * deltaTime;
        if (this.position.y > Gdx.graphics.getHeight())
            remove = true;

        col.move(this.position.x,this.position.y);
    }
}
