package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Camera {

    private OrthographicCamera cam;
    private StretchViewport viewport;
    public GameObject target;
    public float _height = 0f;
    Vector2 position = Vector2.Zero;
    private float speed;

    public Camera (float width, float height, GameObject target) {
        cam = new OrthographicCamera();
        viewport = new StretchViewport(width, height, cam);
        _height = height;
        viewport.apply();
        cam.position.set(target.position.x , height / 2, 0);
        cam.update();
    }

    public Matrix4 combined() {
        return cam.combined;
    }

    public void resize (int width, int height) {
        viewport.update(width, height);
    }

    public void update()
    {
        position.x += (target.position.x - cam.position.x) * speed * Gdx.graphics.getDeltaTime();
        cam.position.set(position.x,_height/2,0);
        cam.update();
        Gdx.app.log("Camara",cam.position.x  +"o");
    }
    public void LookAt(GameObject targ)
    {
        target = targ;
    }

    public void reSize(float w, float h)
    {

    }
    public Vector2 getInputInGameWorld () {
        Vector3 inputScreen = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);
        Vector3 unprojected = cam.unproject(inputScreen);
        return new Vector2(unprojected.x, unprojected.y);
    }



}