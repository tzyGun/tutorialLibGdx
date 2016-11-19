package pl.sylwek.clickergame.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import pl.sylwek.clickergame.TutorialClickerGame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImage;
	public SplashScreen(final TutorialClickerGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		init();
		Timer.schedule(new Task(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				game.setScreen(new GamePlayScreen(game));
			}
			
		}, 1);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(splashImage, 0, 0);
		spriteBatch.end();
	}

	@Override
	protected void init() {
		splashImage= new Texture("splash.png");
		
	}

}
