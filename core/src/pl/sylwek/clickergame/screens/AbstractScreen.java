package pl.sylwek.clickergame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import pl.sylwek.clickergame.TutorialClickerGame;

public abstract class AbstractScreen implements Screen {

	protected TutorialClickerGame game;
	
	protected Stage stage;
	
	protected OrthographicCamera camera;
	
	protected SpriteBatch spriteBatch;
	
	public AbstractScreen(TutorialClickerGame game){
		this.game=game;
		createCamera();
		stage = new Stage(new StretchViewport(TutorialClickerGame.WIDTH, TutorialClickerGame.WIDTH,camera));
		spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
	}

	private void createCamera() {
		// TODO Auto-generated method stub
		camera= new OrthographicCamera();
		camera.setToOrtho(false,TutorialClickerGame.WIDTH,TutorialClickerGame.HEIGHT);
		camera.update();
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		clearScreen();
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
	}

	private void clearScreen() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		game.setPaused(false);
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		game.setPaused(true);
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		game.dispose();
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	
}
