package com.djdarkside.quincy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.djdarkside.quincy.Application;

/**
 * @author djdarkside * 
 * Quincy-core SplashScreen.java
 *
 * Created By Mitchell Baptist on Oct 2, 2016
 * 
 */
public class SplashScreen implements Screen {

	private final Application app;
	private Stage stage;
	
	private Image splashImg;
	
	public SplashScreen(final Application app) {
		this.app = app;
		stage = new Stage(new FitViewport(Application.V_WIDTH, Application.V_HEIGHT, app.cam));
		Gdx.input.setInputProcessor(stage);
		
		Texture splashTex = new Texture(Gdx.files.internal("img/splash.png"));
		splashImg = new Image(splashTex);
		splashImg.setPosition(0, 0);
		stage.addActor(splashImg);		
	}
	
	@Override
	public void show() {
		System.out.println("Showing");		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(delta);
		stage.draw();
		app.batch.begin();
		app.font.draw(app.batch, "Loading", app.V_WIDTH / 2, app.V_HEIGHT / 2);
		app.batch.end();
		
	}
	
	public void update(float delta) {
		stage.act(delta);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);		
	}

	@Override
	public void pause() {
		System.out.println("Paused");
		
	}

	@Override
	public void resume() {
		System.out.println("Resumed");
		
	}

	@Override
	public void hide() {
		System.out.println("Hidden");
		
	}

	@Override
	public void dispose() {
		System.out.println("disposed");
		
	}

}
