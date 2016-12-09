package pl.sylwek.clickergame.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.sylwek.clickergame.TutorialClickerGame;
import pl.sylwek.clickergame.controllers.FlyingObjectsController;
import pl.sylwek.clickergame.controllers.RandomEventController;
import pl.sylwek.clickergame.entities.Player;
import pl.sylwek.clickergame.ui.BasicDialog;
import pl.sylwek.clickergame.ui.GameLabel;
import pl.sylwek.clickergame.ui.IClickCallBack;
import pl.sylwek.clickergame.ui.PlayerButton;
import pl.sylwek.clickergame.ui.ResetButton;

public class GamePlayScreen extends AbstractScreen{
	
	private Player player;
	
	private PlayerButton playerButton;
	
	private ResetButton resetButton;
	
	private GameLabel scoreLabel;
	
	private Image backGroundImage;
	
	private FlyingObjectsController flyingObjectController;
	
	private RandomEventController randomEventController;
	
	
	
	
	
	
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
		scoreLabel.setText("Score: "+String.valueOf(game.getScoreService().getPoints()));
	}

	@Override
	protected void init() {
		initBackGroundImage();
		initPlayer();
		initPlayerButton();
		initResetButton();
		initScoreLabel();
		initFlyingObjectController();
		initRandomEventController();
		startPlayingMusic();
		initPassiveIncomeDialog();
		
		
	}

private void initRandomEventController() {
		randomEventController= new RandomEventController(game,stage);
	}



private void initPassiveIncomeDialog() {
	if(game.getPassiveIncomeService().getPointsToAdd()>0){
		BasicDialog basicDialog = new BasicDialog();
		basicDialog.showDialog(stage,"Passive income added :"+
				game.getPassiveIncomeService().getPointsToAdd());
	}
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
				game.getScoreService().resetGameScore();
			}
		});
		stage.addActor(resetButton);
		
	}

	private void initScoreLabel() {
		scoreLabel =new GameLabel();
		stage.addActor(scoreLabel);
	}

	private void initPlayerButton() {
		playerButton= new PlayerButton(new IClickCallBack() {
			
			@Override
			public void onClick() {
				player.reactOnClick();
				game.getScoreService().addPoint();
				game.getSoundService().playJumpSound();
			}
		});
		stage.addActor(playerButton);
		
		
		
		
	}
	
	@Override
	public void pause() {
		super.pause();
	
		game.getScoreService().saveCurrentGamestate();
	}

}
