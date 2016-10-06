package com.djdarkside.quincy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.djdarkside.quincy.Application;

/**
 * @author djdarkside * 
 * Quincy-core MainMenuScreen.java
 *
 * Created By Mitchell Baptist on Oct 5, 2016
 * 
 */
public class MainMenuScreen implements Screen {

	private final Application app;
	
	private ShapeRenderer shapeRenderer;
	
	private Stage stage;
	private Skin skin;
	
	public MainMenuScreen(final Application app) {
		this.app = app;
		this.stage = new Stage(new StretchViewport(Application.V_WIDTH, Application.V_HEIGHT));
		this.shapeRenderer = new ShapeRenderer();
		
		// Sets default font in json file
		this.skin = new Skin();
		this.skin.addRegions(app.assets.get("ui/uiskin.atlas", TextureAtlas.class));
		this.skin.add("default-font", app.font24);
		this.skin.load(Gdx.files.internal("ui/uiskins.json"));

	}	
		
	@Override
	public void show() {
		System.out.println("MAIN MENU");
	}

	private void update(float delta) {
	
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		update(delta);
		
		app.batch.begin();
		app.font24.draw(app.batch, "MAIN MENU", app.V_WIDTH / 2 - 24, 54);
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
		stage.dispose();
		shapeRenderer.dispose();	
	}
}
