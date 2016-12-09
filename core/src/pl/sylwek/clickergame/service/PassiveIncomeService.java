package pl.sylwek.clickergame.service;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PassiveIncomeService {

	private static final int DURATION = Integer.MAX_VALUE;
	private ScoreService scoreService;
	public PassiveIncomeService(ScoreService service){
		this.scoreService=service;
		
	}
	
	public void start(){
		Timer.schedule(new Task(){

			@Override
			public void run() {
				scoreService.addPoints(scoreService.getPassiveIncome());
				
			}
			
		},1,1 ,DURATION);
	}
}
