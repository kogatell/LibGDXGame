package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Shield extends GameObject{
    Collision col;
    public static final float WIDTH = 0.5f;
    public static final float HEIGHT = 0.5f;
    public Shield(float x, float y){
        this.position.x = x;
        this.position.y = y;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.typeOfGO = 6;
        sprites.add(SpriteHelper.spriteFromTexture("spr_shield.png", 0 , 0));
        this.col = new Collision(this.position.x, this.position.y, this.width, this.height);
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