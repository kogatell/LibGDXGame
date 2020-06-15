package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player extends GameObject{
    Collision col;
    public static final float WIDTH = 0.5f;
    public static final float HEIGHT = 0.5f;
    public Player(){
        super();
        InputScreen.player = this;
        this.position.x = 0.0f;
        this.position.y = -1.95f;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.typeOfGO = 3;
        sprites.add(SpriteHelper.spriteFromTexture("spaceship.png", 0 , 0));
        this.col = new Collision(this.position.x, this.position.y, this.width, this.height);
    }
    public Vector2 GetPosition()
    {
        return this.position;
    }
    @Override
    public void update(float deltaTime){
        col.move(this.position.x,this.position.y);
    }
    @Override
    public Collision getCollisionRect () {
        return col;
    }
}
