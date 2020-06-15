package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class WorldRenderer extends WorldController {
    ScrollingBackground background;
    public static OrthographicCamera camera;
    SpriteBatch batch;
    WorldController controller;

    public WorldRenderer(WorldController wc)
    {
        background = new ScrollingBackground();
        this.controller = wc;
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0,0,0);
        camera.update();
        resize(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        //Gdx.graphics.setWindowedMode();
        batch = new SpriteBatch();
        background.setSpeedFixed(true);
        if(wc.gameOver)
        {
            wc.font.draw(batch,"Score: "+wc.score, Constants.VIEWPORT_WIDTH/2, Constants.VIEWPORT_HEIGHT/2);
        }
    }

    public void init()
    {

    }
    /*
     * gdx texture packer
     *   atlas methods
     *
     *
     *
     * */
    public void render()
    {
        long t1 = System.nanoTime();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();


        for(GameObject go: controller.gameObjects) {
            go.getCurrentSprite().setPosition(go.position.x, go.position.y);
            go.getCurrentSprite().setSize(go.width,go.height);
            go.getCurrentSprite().draw(batch);

        }

        for(Bullet bul: controller.bullets) {
            bul.render(batch);
        }
        background.updateAndRender(Gdx.graphics.getDeltaTime(), batch);

        //o el get
        batch.end();
        long t2 = System.nanoTime();
        long delt = t2 - t1;
        //Gdx.app.error("TIME", delt+" ns");
    }

    public void resize(float width, float height)
    {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height)*width;
        camera.update();
    }

    public void dispose()
    {
        batch.dispose();
    }
}