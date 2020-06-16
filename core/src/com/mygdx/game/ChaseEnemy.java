package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ChaseEnemy extends  GameObject{
    public int SPEED = 2;
    public static final float DEFAULT_Y = -1.75f;
    public static final float WIDTH = 2;
    public static final float HEIGHT = 2;
    private static Sprite texture;
    private float targetx;
    private Vector2 targ;
    float angle;


    float x, y;
    Collision col;
    public boolean remove = false;
    public ChaseEnemy (float x, Vector2 target){
        this.position.x = x;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.position.y = Constants.VIEWPORT_HEIGHT;
        this.col = new Collision(x, y, WIDTH, HEIGHT);
        targ = target;

        //targetx = target.position.x;
        float targetX;


        this.texture = new Sprite(new Texture("ufo.png"));
        this.sprites.add(SpriteHelper.spriteFromTexture("ufo.png", 0 , 0));
        //angle = this.lookAt(target);
        this.typeOfGO = 7;
    }
    public void update (float deltaTime) {
        this.position.y -= SPEED * deltaTime;
        //this.position.x += angle;

        //this.position.x += this._x * 0.1f;
        //this.position.x -= SPEED * deltaTime  - target.x;
        //double ang = Math.atan2(target.y - position.y, target.x - position.x) * 180f / Math.PI; //Check
        //getCurrentSprite().setRotation((float) ang);
        if (this.position.y > Gdx.graphics.getHeight())
            remove = true;

        col.move(this.position.x,this.position.y);
    }
    public void render (SpriteBatch batch) {

        texture.setPosition(this.position.x, this.position.y);
        texture.draw(batch);
    }
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
