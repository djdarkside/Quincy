package com.djdarkside.quincy.actors;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * @author djdarkside * 
 * Quincy-core SlideButton.java
 *
 * Created By Mitchell Baptist on Oct 9, 2016
 * 
 */
public class SlideButton extends TextButton {

	private int id;
	
	public SlideButton(String text, Skin skin, String style, int id) {
		super(text, skin, style);
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
}
