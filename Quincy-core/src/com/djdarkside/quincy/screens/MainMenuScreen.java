package com.djdarkside.quincy.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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
	private TextButton buttonPlay, buttonExit;
	private Image menuImage;
	private Music menuMusic;
	
	public MainMenuScreen(final Application app) {
		this.app = app;
		this.stage = new Stage(new StretchViewport(Application.V_WIDTH, Application.V_HEIGHT));
		this.shapeRenderer = new ShapeRenderer();		
	}	
		
	@Override
	public void show() {
		System.out.println("MAIN MENU");
		Gdx.input.setInputProcessor(stage);
		
		// Sets default font in json file
		this.skin = new Skin();
		this.skin.addRegions(app.assets.get("ui/uiskin.atlas", TextureAtlas.class));
		this.skin.add("default-font", app.font24);
		this.skin.load(Gdx.files.internal("ui/uiskin.json"));		
		
		initButtons();
		
		Texture menuTex = app.assets.get("img/q.png", Texture.class);
		menuMusic = app.assets.get("music/menu.mp3", Music.class);
		menuMusic.play();
		menuMusic.setVolume(0.5f);
		menuImage = new Image(menuTex);
		menuImage.setOrigin(0, 0);
		menuImage.setPosition(app.V_WIDTH / 4 + 75, 480);
		menuImage.addAction(forever((sequence(alpha(0), fadeIn(4f), fadeOut(4f), delay(2f)))));
		stage.addActor(menuImage);
		
	}

	private void update(float delta) {
		stage.act(delta);
		if (buttonPlay.isPressed()) {
			System.out.println("Play Game Pressed");
			menuMusic.stop();
			app.setScreen(app.sScreen);
			
		}
		if (buttonExit.isPressed()) {
			System.out.println("Exit Pressed");
			Gdx.app.exit();
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		update(delta);
		
		stage.draw();
		
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
	
	private void initButtons() {
		buttonPlay = new TextButton("Play", skin, "default");
		buttonPlay.setPosition(app.V_WIDTH / 2 - 150, 260);
		buttonPlay.setSize(280, 60);
		
		buttonExit = new TextButton("Exit", skin, "default");
		buttonExit.setPosition(app.V_WIDTH / 2 - 150, 160);
		buttonExit.setSize(280, 60);
			
		stage.addActor(buttonPlay);
		stage.addActor(buttonExit);
	}

	@Override
	public void dispose() {
		stage.dispose();
		shapeRenderer.dispose();	
	}
}
