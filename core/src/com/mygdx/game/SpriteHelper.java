package com.mygdx.game;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class SpriteHelper {

    static TextureAtlas atlas;

    public static Sprite spriteFromTexture(String imageName,int x, int y)
    {
        Texture t = new Texture(Gdx.files.internal(imageName));
        Sprite s = new Sprite(t);
        s.setPosition(x, y);
        s.setSize(1,1);
        s.setOrigin(0.5f,0.5f);
        return s;
    }

    public static Sprite getProceduralSprite()
    {
        Pixmap pm = new Pixmap(50, 50, Pixmap.Format.RGBA8888);

        pm.setColor(1.0f, 0.0f, 0.4f, 1.0f);
        pm.fillRectangle(0, 0, 50,50);
        pm.setColor(0.0f, 0.0f, 1.0f, 1.0f);
        pm.drawRectangle(0,0,50,50);

        Texture t = new Texture(pm);

        pm.dispose();

        Sprite s = new Sprite(t);
        s.setSize(1,1);
        s.setPosition(0,0);
        s.setOrigin(0.5f,0.5f);
        return s;
    }

    public static Sprite getSpriteFromAtlas(){

        if(atlas == null){
            atlas = new TextureAtlas("test.atlas");
        }
        Array<TextureAtlas.AtlasRegion> regions = atlas.getRegions();
        int index = MathUtils.random(0, regions.size - 1);
        //TextureRegion tr = atlas.findRegion("towers/torre_boceto");
        Sprite s = new Sprite(regions.get(index));
        s.setSize(1,1);
        s.setPosition(0,0);
        s.setOrigin(0.5f,0.5f);
        return s;
    }

}
