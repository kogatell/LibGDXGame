package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public class WorldRenderer extends WorldController {
    ScrollingBackground background;
    public static Camera camera;
    public static Camera camera2;
    public static SpriteBatch batch;
    WorldController controller;
    BackgroundImage backgroundImg;
    Controller cont;
    Player player;

    public WorldRenderer(WorldController wc)
    {
        background = new ScrollingBackground();
        backgroundImg = new BackgroundImage(-1);
        this.controller = wc;
        camera = new Camera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT, wc.player);
        //camera2 = new Camera(Constants.VIEWPORT_WIDTH/5, Constants.VIEWPORT_HEIGHT/5);
        player = wc.player;
        camera.LookAt(player);

        resize(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

        //Gdx.graphics.setWindowedMode();
        batch = new SpriteBatch();
        //cont = new Controller(camera, this);
        background.setSpeedFixed(true);
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
        batch.setProjectionMatrix(camera.combined());
        //batch.setProjectionMatrix(camera2.combined);
        batch.begin();
        backgroundImg.yCoordBg1 += backgroundImg.BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
        backgroundImg.yCoordBg2 = backgroundImg.yCoordBg1 + backgroundImg.yMax;  // We move the background, not the camera
        if (backgroundImg.yCoordBg1 >= 0) {
            backgroundImg.yCoordBg1 = backgroundImg.yMax*(-1); backgroundImg.yCoordBg2 = 0;
        }
        batch.draw(backgroundImg.background1, -10, backgroundImg.yCoordBg1, Constants.VIEWPORT_WIDTH * 2, Constants.VIEWPORT_HEIGHT * 2);
        batch.draw(backgroundImg.background2, -10, backgroundImg.yCoordBg2, Constants.VIEWPORT_HEIGHT * 2, Constants.VIEWPORT_WIDTH * 2);

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
        //camera.LookAt(controller.player);
        camera.update();
        batch.end();
        long t2 = System.nanoTime();
        long delt = t2 - t1;
        //Gdx.app.error("TIME", delt+" ns");

        //camera2.update();
        //cont.draw();
    }

    public void resize(int width, int height)
    {
        //camera.viewportWidth = (Constants.VIEWPORT_WIDTH/height)*width;
        //camera.viewportHeight= (Constants.VIEWPORT_HEIGHT/width)*height;
        //camera.update();
        //cont.resize(width, height);
    }


    public void dispose()
    {
        batch.dispose();
    }
}
