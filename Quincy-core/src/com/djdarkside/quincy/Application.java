package com.djdarkside.quincy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.djdarkside.quincy.screens.LoadingScreen;
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
	public BitmapFont font;
	
	public AssetManager assets;
	
	@Override
	public void create () {
		assets = new AssetManager();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		this.setScreen(new LoadingScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		assets.dispose();
		this.getScreen().dispose();
	}
}
