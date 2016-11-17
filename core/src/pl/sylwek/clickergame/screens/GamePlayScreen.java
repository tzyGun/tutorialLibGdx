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

public class GamePlayScreen extends AbstractScreen{
	
	private Player player;
	
	private Button playerButton;
	
	private Button resetButton;
	
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
		resetButton= new Button(new ButtonStyle());
		resetButton.setX(300);
		resetButton.setY(600);
		resetButton.setWidth(50);
		resetButton.setHeight(50);
		resetButton.setDebug(true);
		stage.addActor(resetButton);
		resetButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.setPoints(0);
				return super.touchDown(event, x, y, pointer, button);
			}
		});
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
		playerButton = new Button(new ButtonStyle());
		playerButton.setWidth(460);
		playerButton.setHeight(360);
		playerButton.setX(10);
		playerButton.setY(170);
		playerButton.setDebug(true);
		stage.addActor(playerButton);
		playerButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				System.out.println("click at x:"+x+"y:"+y+"event:"+event.toString());
				player.reactOnClick();
				game.addPoint();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		
		
	}

}
