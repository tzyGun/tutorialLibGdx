package pl.sylwek.clickergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pl.sylwek.clickergame.screens.SplashScreen;

public class TutorialClickerGame extends  Game {
	
	public final static int WIDTH=480;
	public final static int HEIGHT=700;
	public final static String GAME_NAME="Tutorial Clicker";
	public final static String GAME_PREFS="package pl.sylwek.prefsgame";
	public final static String GAME_SCORE="package pl.sylwek.prefsgame.score";
	
	private Preferences prefs;
	private int points;
	
	private boolean paused;
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
		init();
	}
	
	private void init() {
		prefs= Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
	}

	private void loadScore() {
		points= prefs.getInteger(GAME_SCORE);
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points){
		this.points=points;
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}
	public void addPoint(){
		points++;
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	
}
