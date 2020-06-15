package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class WorldRenderer extends WorldController {
    ScrollingBackground background;
    public static OrthographicCamera camera;
    public static OrthographicCamera camera2;
    SpriteBatch batch;
    WorldController controller;
    BackgroundImage backgroundImg;

    public WorldRenderer(WorldController wc)
    {
        background = new ScrollingBackground();
        backgroundImg = new BackgroundImage(-1);
        this.controller = wc;
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera2 = new OrthographicCamera(Constants.VIEWPORT_WIDTH/5, Constants.VIEWPORT_HEIGHT/5);
        camera2.position.set(0,0,0);

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




        backgroundImg.yCoordBg1 += backgroundImg.BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
        backgroundImg.yCoordBg2 = backgroundImg.yCoordBg1 + backgroundImg.yMax;  // We move the background, not the camera
        if (backgroundImg.yCoordBg1 >= 0) {
            backgroundImg.yCoordBg1 = backgroundImg.yMax*(-1); backgroundImg.yCoordBg2 = 0;
        }
        batch.draw(backgroundImg.background1, -10, backgroundImg.yCoordBg1, 20, 15);
        batch.draw(backgroundImg.background2, -10, backgroundImg.yCoordBg2, 20, 15);

        for(Bullet bul: controller.bullets) {
            bul.render(batch);
        }
        background.updateAndRender(Gdx.graphics.getDeltaTime(), batch);
        for(GameObject go: controller.gameObjects) {
            go.getCurrentSprite().setPosition(go.position.x, go.position.y);
            go.getCurrentSprite().setSize(go.width,go.height);
            go.getCurrentSprite().draw(batch);

        }

        //o el get

        batch.end();
        long t2 = System.nanoTime();
        long delt = t2 - t1;
        //Gdx.app.error("TIME", delt+" ns");
        this.moveCamera(controller.player.position.x);
        camera.update();

    }

    public void resize(float width, float height)
    {
        camera.viewportWidth = (Constants.VIEWPORT_WIDTH/height)*width;
        camera2.viewportWidth = (Constants.VIEWPORT_WIDTH/height/2)*width;
        //camera.viewportHeight= (Constants.VIEWPORT_HEIGHT/width)*height;
        camera.update();
    }

    public void moveCamera(float x)
    {
        camera.position.set(x, 0, 0);
    }

    public void dispose()
    {
        batch.dispose();
    }
}
