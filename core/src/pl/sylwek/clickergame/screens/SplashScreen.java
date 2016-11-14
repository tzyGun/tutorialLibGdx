package pl.sylwek.clickergame.screens;

import com.badlogic.gdx.graphics.Texture;

import pl.sylwek.clickergame.TutorialClickerGame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImage;
	public SplashScreen(TutorialClickerGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		splashImage= new Texture("badlogic.jpg");
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(splashImage, 0, 0);
		spriteBatch.end();
	}

}
