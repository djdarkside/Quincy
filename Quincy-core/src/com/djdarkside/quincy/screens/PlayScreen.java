package com.djdarkside.quincy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.djdarkside.quincy.Application;
import com.djdarkside.quincy.actors.SlideButton;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/**
 * @author djdarkside * 
 * Quincy-core PlayScreen.java
 *
 * Created By Mitchell Baptist on Oct 9, 2016
 * 
 */
public class PlayScreen implements Screen {

	private final Application app;
	private Stage stage;
	private Skin skin;
	
	private int boardSize = 4;
	private int holeX, holeY;
	
	private TextButton buttonBack;
	private SlideButton[][] buttonGrid;
	
	public PlayScreen(final Application app) {
		this.app = app;
		this.stage = new Stage(new StretchViewport(Application.V_WIDTH, Application.V_HEIGHT));
	}
	
	@Override
	public void show() {
		System.out.println("PLAY SCREEN");
		Gdx.input.setInputProcessor(stage);
		stage.clear();
		
		this.skin = new Skin();
		this.skin.addRegions(app.assets.get("ui/uiskin.atlas", TextureAtlas.class));
		this.skin.add("default-font", app.font24);
		this.skin.load(Gdx.files.internal("ui/uiskin.json"));	
		
		initNavigationButtonss();
		initGrid();		
	}

	public void update(float delta) {
		stage.act(delta);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		update(delta);
		
		stage.draw();
		
		app.batch.begin();
		app.font24.draw(app.batch, "PLAY SCREEN", app.V_WIDTH / 2 - 24, 54);
		app.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();	
	}
	
	private void initNavigationButtonss() {
		buttonBack = new TextButton("Back", skin, "default");
		buttonBack.setPosition(20, app.cam.viewportHeight - 70);
		buttonBack.setSize(100, 25);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				app.setScreen(app.menuScreen);
			}	
		});
		
		stage.addActor(buttonBack);
	}
	
	private void initGrid() {
		holeX = 3;
		holeY = 3;
		buttonGrid = new SlideButton[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				int id = j + 1 + (i * boardSize);
				buttonGrid[i][j] = new SlideButton(id + "", skin, "default", id);
				buttonGrid[i][j].setPosition((app.cam.viewportWidth / 7) * 2 + 101 * j, (app.cam.viewportHeight / 5) * 3 - 101 * i);
				buttonGrid[i][j].setSize(100, 100);
				
				buttonGrid[i][j].addAction(sequence(alpha(0), delay(id / 20f), parallel(fadeIn(.5f), 
						moveBy(0, -10, .25f, Interpolation.pow5Out))));
				
				stage.addActor(buttonGrid[i][j]);
			}
		}
	}

}
