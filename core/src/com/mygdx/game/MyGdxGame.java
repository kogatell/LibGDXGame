package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

public class MyGdxGame implements ApplicationListener {
	WorldController controller;
	WorldRenderer renderer;
	InputScreen input;
	
	@Override
	public void create () {
		input = new InputScreen();
		GestureDetector gestDet = new GestureDetector(input);
		Gdx.input.setInputProcessor(gestDet);
		controller = new WorldController();
		renderer = new WorldRenderer(controller);

	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);

	}

	@Override
	public void render () {
		controller.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0,0,0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.render();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		renderer.dispose();
	}
}
