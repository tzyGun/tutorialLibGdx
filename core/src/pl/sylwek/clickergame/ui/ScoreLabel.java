package pl.sylwek.clickergame.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreLabel extends Label{

	public ScoreLabel(){
		super("Score: ",prepareLabelStyle());
		
		
		init();
		
	}

	private void init() {
		this.setX(50);
		this.setY(650);
	}

	private static LabelStyle prepareLabelStyle() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font= new BitmapFont();
		labelStyle.fontColor=Color.BLACK;
		return labelStyle;
	}
	
}
