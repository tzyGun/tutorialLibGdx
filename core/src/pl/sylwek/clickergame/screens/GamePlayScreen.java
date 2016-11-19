package pl.sylwek.clickergame.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import pl.sylwek.clickergame.TutorialClickerGame;
import pl.sylwek.clickergame.entities.Player;
import pl.sylwek.clickergame.ui.IClickCallBack;
import pl.sylwek.clickergame.ui.PlayerButton;
import pl.sylwek.clickergame.ui.ResetButton;
import pl.sylwek.clickergame.ui.ScoreLabel;

public class GamePlayScreen extends AbstractScreen{
	
	private Player player;
	
	private PlayerButton playerButton;
	
	private ResetButton resetButton;
	
	private ScoreLabel scoreLabel;
	
	private Texture backGround;
	
	public GamePlayScreen(TutorialClickerGame game) {
		super(game);
		
		
		
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
		
		//Drawing background
		spriteBatch.begin();
		spriteBatch.draw(backGround,0,0);
		spriteBatch.end();
		
		//Drawing entities
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
		backGround = new Texture("bg.png");
		initPlayer();
		initPlayerButton();
		initResetButton();
		initScoreLabel();
		
	}

	private void initResetButton() {
		resetButton = new ResetButton(new IClickCallBack() {
			
			@Override
			public void onClick() {
				game.resetGameScore();
			}
		});
		stage.addActor(resetButton);
		
	}

	private void initScoreLabel() {
		scoreLabel =new ScoreLabel();
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
