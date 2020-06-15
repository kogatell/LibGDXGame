package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Singleton {
    private static Singleton instance = null;
    TextureAtlas atlas = null;
    TextureRegion region;
    private Singleton() {
        atlas = new TextureAtlas("test.atlas");
        region = atlas.findRegion("");
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    } }
