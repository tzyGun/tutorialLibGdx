package pl.sylwek.clickergame.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.sylwek.clickergame.TutorialClickerGame;
import pl.sylwek.clickergame.controllers.FlyingObjectsController;
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
	
	private Image backGroundImage;
	
	private FlyingObjectsController flyingObjectController;
	
	
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
		
		
	
		
		//Drawing stage
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
		initBackGroundImage();
		initPlayer();
		initPlayerButton();
		initResetButton();
		initScoreLabel();
		initFlyingObjectController();
		startPlayingMusic();
		
		
	}

private void startPlayingMusic() {
	game.getSoundService().playMusic(true);
	}

private void initFlyingObjectController() {
		this.flyingObjectController=new FlyingObjectsController(stage, game);
		
	}



	private void initBackGroundImage() {
		backGroundImage = new Image(new Texture("bg.png"));
		stage.addActor(backGroundImage);
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
				game.getSoundService().playJumpSound();
			}
		});
		stage.addActor(playerButton);
		
		
		
		
	}

}
