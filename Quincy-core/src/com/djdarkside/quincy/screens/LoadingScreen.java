package com.djdarkside.quincy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.MathUtils;
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
	private float progress;
	
	public LoadingScreen(final Application app) {
		this.app = app;
		this.shapeRenderer = new ShapeRenderer();
	}	
	
	private void queueAssets() {
		app.assets.load("img/splash.png", Texture.class);
		app.assets.load("img/splash1.png", Texture.class);
		app.assets.load("ui/uiskin.atlas", TextureAtlas.class);
		app.assets.load("img/q.png", Texture.class);
		app.assets.load("music/menu.mp3", Music.class);
		app.assets.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		app.assets.load("tile/mapfun.tmx", TiledMap.class);
		
	}
	
	@Override
	public void show() {
		this.progress = 0f;		
		queueAssets();
	}

	private void update(float delta) {
		// a + (b - a) * lerp
		progress = MathUtils.lerp(progress, app.assets.getProgress(), .1f);
		if (app.assets.update() && progress >= app.assets.getProgress() - .01f) {
			app.setScreen(app.sScreen);
		}		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		update(delta);
		// Loading Bar
		// Empty
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.rect(32, app.cam.viewportHeight / 10 - 8, app.cam.viewportWidth - 64, 16);
		//Full - Fills when assets are loaded
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(32, app.cam.viewportHeight / 10 - 8, progress * (app.cam.viewportWidth - 64), 16);
		shapeRenderer.end();
		//End Loading Bar
		
		
		app.batch.begin();
		app.font24.draw(app.batch, "Loading", app.V_WIDTH / 2 - 24, 54);
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
}
