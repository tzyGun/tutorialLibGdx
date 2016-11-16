package pl.sylwek.clickergame.screens;

import pl.sylwek.clickergame.TutorialClickerGame;
import pl.sylwek.clickergame.entities.Player;

public class GamePlayScreen extends AbstractScreen{
	
	private Player player;
	public GamePlayScreen(TutorialClickerGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		init();
		
	}

	private void initPlayer() {
		player = new Player();
		
	}

	private void init() {
		initPlayer();
		stage.addActor(player);
		
	}
	@Override
	public void render(float delta) {
		
		super.render(delta);
		update();
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act();
		
	}

}
