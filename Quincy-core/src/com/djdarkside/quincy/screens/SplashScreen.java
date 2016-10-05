package com.djdarkside.quincy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.djdarkside.quincy.Application;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

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

	}
	
	@Override
	public void show() {
		System.out.println("Showing");	
		Gdx.input.setInputProcessor(stage);
		
		Texture splashTex = app.assets.get("img/splash1.png", Texture.class);
		splashImg = new Image(splashTex);
		splashImg.setOrigin(splashImg.getWidth() / 2, splashImg.getHeight() / 2);
		splashImg.setPosition(stage.getWidth() / 2 - 32, stage.getHeight() + 32);
		splashImg.addAction(sequence(alpha(0), scaleTo(.1f, .1f), 
				parallel(fadeIn(2f, Interpolation.pow2), 
						scaleTo(2f, 2f, 2.5f, Interpolation.pow5),
						moveTo(stage.getWidth() / 2 - 32, stage.getHeight() / 2 - 32, 2f, Interpolation.swing)),
				delay(1.5f), parallel(Actions.rotateTo(2160, 2f), fadeOut(2f))));		
		
		stage.addActor(splashImg);		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(delta);
		stage.draw();
		app.batch.begin();
		app.font.draw(app.batch, "Where's Quincy?", app.V_WIDTH / 2 - 24, 100);
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
		stage.dispose();
		
	}

}
