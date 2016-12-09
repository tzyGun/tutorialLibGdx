package pl.sylwek.clickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {

	public final static String GAME_PREFS="package pl.sylwek.prefsgame";
	public final static String GAME_SCORE="package pl.sylwek.prefsgame.score";
	
	private Preferences prefs;
	private int points;
	
	public ScoreService(){
		init();
	}
	
	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		
	}

	public void resetGameScore(){
		this.points=0;
		updateScoreInPrefs();
	}
	public void addPoint(){
		points++;
		updateScoreInPrefs();
	}
	

	private void loadScore() {
		points = prefs.getInteger("GAME_SCORE");
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
	
	public int getPoints() {
		return points;
	}
	
}
