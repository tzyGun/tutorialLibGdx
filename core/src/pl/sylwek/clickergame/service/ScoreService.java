package pl.sylwek.clickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.TimeUtils;

public class ScoreService {

	public final static String GAME_PREFS="package pl.sylwek.prefsgame";
	public final static String GAME_SCORE="package pl.sylwek.prefsgame.score";
	public final static String GAME_PASSIVE_INCOME="package pl.sylwek.prefsgame.passiveincome";
	public final static String GAME_SAVED_TIMESTAMP="package pl.sylwek.prefsgame.gamesavetimestamp";

	
	private Preferences prefs;
	private int points;
	
	private int passiveIncome;
	
	public ScoreService(){
		init();
		
	}
	
	
	
	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		loadPassiveIncome();
		
		
	}
	
	

	



	private void loadPassiveIncome() {
		passiveIncome= prefs.getInteger(GAME_PASSIVE_INCOME);
	}

	public void resetGameScore(){
		this.points=0;
		this.passiveIncome=0;
	}
	public void addPoint(){
		points++;
	}
	

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}
	

	public void addPoints(int i) {
		points+=i;
		
	}


	public void addPassiveIncome() {
		passiveIncome++;
		System.out.println("passive income :"+passiveIncome);
		
		
	}
	
	
	public int getPassiveIncome() {
		return passiveIncome;
	}

	public int getPoints() {
		return points;
	}


	public long getTimeStamp(){
		return prefs.getLong(GAME_SAVED_TIMESTAMP);
	}





	public void saveCurrentGamestate() {
		
		prefs.putLong(GAME_SAVED_TIMESTAMP, TimeUtils.millis());
		prefs.putInteger(GAME_SCORE, points);
		prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
		prefs.flush();
	}
	
}
