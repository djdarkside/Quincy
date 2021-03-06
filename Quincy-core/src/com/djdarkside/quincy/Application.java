package com.djdarkside.quincy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.djdarkside.quincy.screens.LoadingScreen;
import com.djdarkside.quincy.screens.MainMenuScreen;
import com.djdarkside.quincy.screens.PlayScreen;
import com.djdarkside.quincy.screens.SplashScreen;

public class Application extends Game {
	
	public static final String TITLE = "Quincy";
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = V_WIDTH / 16 * 9;
	public static final int SCALE = 1;
	public static final String VERSION = "0.1";
	
	public OrthographicCamera cam;
	public SpriteBatch batch;
	public SplashScreen screen;
	public BitmapFont font24;
	
	public AssetManager assets;
	
	public LoadingScreen lScreen;
	public SplashScreen sScreen;
	public MainMenuScreen menuScreen;
	public PlayScreen playScreen;
	
	@Override
	public void create () {
		assets = new AssetManager();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		batch = new SpriteBatch();
		
		initFonts();
		
		lScreen = new LoadingScreen(this);
		sScreen = new SplashScreen(this);
		menuScreen = new MainMenuScreen(this);
		playScreen = new PlayScreen(this);
		
		this.setScreen(lScreen);
	}

	@Override
	public void render () {
		super.render();
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font24.dispose();
		assets.dispose();
		lScreen.dispose();
		sScreen.dispose();
		menuScreen.dispose();
	}
	
	private void initFonts() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Coopbl.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
		
		params.size = 24;
		params.color = Color.BLACK;
		font24 = generator.generateFont(params);
	}
}
