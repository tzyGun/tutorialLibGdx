 package pl.sylwek.clickergame;

import com.badlogic.gdx.Game;

import pl.sylwek.clickergame.screens.SplashScreen;
import pl.sylwek.clickergame.service.PassiveIncomeService;
import pl.sylwek.clickergame.service.ScoreService;
import pl.sylwek.clickergame.service.SoundService;

public class TutorialClickerGame extends  Game {
	
	public final static int WIDTH=480;
	public final static int HEIGHT=700;
	public final static String GAME_NAME="Tutorial Clicker";
	
	
	
	
	private SoundService soundService;
	
	private ScoreService scoreService;
	
	private PassiveIncomeService passiveIncomeService;
	
	
	public PassiveIncomeService getPassiveIncomeService() {
		return passiveIncomeService;
	}


	private boolean paused;
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
		init();
	}
	
	private void init() {
		
		
		initSoundService();
		initScoreService();
		initPassiveIncomeService();
		
	}
	
	
	
	

	public boolean isPaused() {
		return paused;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	private void initScoreService() {
		scoreService= new ScoreService();
		
	}

	private void initSoundService() {
		soundService= new SoundService();
		
	}
	
	private void initPassiveIncomeService() {
		passiveIncomeService = new PassiveIncomeService(this.scoreService);
		passiveIncomeService.start();
	}
	
	

	public SoundService getSoundService() {
		return soundService;
	}
	

	public ScoreService getScoreService() {
		return scoreService;
	}
	
	

	
	
	
}
