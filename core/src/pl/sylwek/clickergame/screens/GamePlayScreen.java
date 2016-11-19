package pl.sylwek.clickergame.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.sylwek.clickergame.TutorialClickerGame;
import pl.sylwek.clickergame.entities.Player;
import pl.sylwek.clickergame.ui.IClickCallBack;
import pl.sylwek.clickergame.ui.PlayerButton;
import pl.sylwek.clickergame.ui.ResetButton;

public class GamePlayScreen extends AbstractScreen{
	
	private Player player;
	
	private PlayerButton playerButton;
	
	private ResetButton resetButton;
	
	private Label scoreLabel;
	
	public GamePlayScreen(TutorialClickerGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		
		
	}

	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
	}

	
	@Override
	public void render(float delta) {
		
		super.render(delta);
		update();
		System.out.println("Points: "+ game.getPoints());
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act();
		scoreLabel.setText("Score: "+String.valueOf(game.getPoints()));
	}

	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
		initResetButton();
		initScoreLabel();
		
	}

	private void initResetButton() {
		resetButton = new ResetButton(new IClickCallBack() {
			
			@Override
			public void onClick() {
				game.setPoints(0);
			}
		});
		stage.addActor(resetButton);
		
	}

	private void initScoreLabel() {
		LabelStyle labelStyle= new LabelStyle();
		labelStyle.font=new BitmapFont();
		scoreLabel= new Label("Score: "+String.valueOf(game.getPoints()), labelStyle );
		scoreLabel.setX(20);
		scoreLabel.setY(650);
		stage.addActor(scoreLabel);
	}

	private void initPlayerButton() {
		playerButton= new PlayerButton(new IClickCallBack() {
			
			@Override
			public void onClick() {
				player.reactOnClick();
				game.addPoint();
			}
		});
		stage.addActor(playerButton);
		
		
		
		
	}

}
