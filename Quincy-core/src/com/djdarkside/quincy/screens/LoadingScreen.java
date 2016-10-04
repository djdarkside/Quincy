package com.djdarkside.quincy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.djdarkside.quincy.Application;

/**
 * @author djdarkside * 
 * Quincy-core LoadingScreen.java
 *
 * Created By Mitchell Baptist on Oct 4, 2016
 * 
 */
public class LoadingScreen implements Screen {

	private final Application app;
	private ShapeRenderer shapeRenderer;
	
	public LoadingScreen(final Application app) {
		this.app = app;
		this.shapeRenderer = new ShapeRenderer();
		queueAssets();
	}
	
	@Override
	public void show() {
		
	}

	private void update(float delta) {
		if (app.assets.update()) {
			app.setScreen(new SplashScreen(app));
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(delta);
		
		app.batch.begin();
		app.font.draw(app.batch, "Loading", app.V_WIDTH / 2 - 24, 100);
		app.batch.end();
	}

	@Override
	public void resize(int width, int height) {

		
	}

	@Override
	public void pause() {

		
	}

	@Override
	public void resume() {

		
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();
		
	}
	
	private void queueAssets() {
		app.assets.load("img/splash.png", Texture.class);
		app.assets.load("img/splash1.png", Texture.class);
	}

}
