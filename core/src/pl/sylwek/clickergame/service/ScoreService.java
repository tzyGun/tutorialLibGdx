package pl.sylwek.clickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {

	public final static String GAME_PREFS="package pl.sylwek.prefsgame";
	public final static String GAME_SCORE="package pl.sylwek.prefsgame.score";
	public final static String GAME_PASSIVE_INCOME="package pl.sylwek.prefsgame.passiveincome";
	
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
		updateScoreAndPassiveIncomeInPrefs();
	}
	public void addPoint(){
		points++;
		updateScoreAndPassiveIncomeInPrefs();
	}
	

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}
	

	public void addPoints(int i) {
		points+=i;
		updateScoreAndPassiveIncomeInPrefs();
	}

	private void updateScoreAndPassiveIncomeInPrefs() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
		prefs.flush();
	}

	public void addPassiveIncome() {
		passiveIncome++;
		System.out.println("passive income :"+passiveIncome);
		updateScoreAndPassiveIncomeInPrefs();
		
	}
	
	
	public int getPassiveIncome() {
		return passiveIncome;
	}

	public int getPoints() {
		return points;
	}
	
}
