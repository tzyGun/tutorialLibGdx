package pl.sylwek.clickergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;

import pl.sylwek.clickergame.screens.SplashScreen;
import pl.sylwek.clickergame.service.SoundService;

public class TutorialClickerGame extends  Game {
	
	public final static int WIDTH=480;
	public final static int HEIGHT=700;
	public final static String GAME_NAME="Tutorial Clicker";
	public final static String GAME_PREFS="package pl.sylwek.prefsgame";
	public final static String GAME_SCORE="package pl.sylwek.prefsgame.score";
	
	private Preferences prefs;
	private int points;
	
	private SoundService soundService;
	
	
	public SoundService getSoundService() {
		return soundService;
	}

	private boolean paused;
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
		init();
	}
	
	private void init() {
		prefs= Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		initSoundService();
		
	}


	private void initSoundService() {
		soundService= new SoundService();
		
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
	
	public void resetGameScore(){
		this.points=0;
		updateScoreInPrefs();
	}
	public void addPoint(){
		points++;
		updateScoreInPrefs();
	}
	

	

	public void addPoints(int i) {
		points+=i;
		updateScoreInPrefs();
	}

	private void updateScoreInPrefs() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	public void addPassiveIncome() {
		System.out.println("passive income");
	}
	
}
