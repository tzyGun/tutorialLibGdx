package pl.sylwek.clickergame.service;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PassiveIncomeService {

	private static final int DURATION = Integer.MAX_VALUE;
	private ScoreService scoreService;
	
	private int pointsToAdd;
	public int getPointsToAdd() {
		return pointsToAdd;
	}

	public PassiveIncomeService(ScoreService service){
		this.scoreService=service;
		calculateTimeStampForOffIncome();
		
	}
	
	public void start(){
		Timer.schedule(new Task(){

			@Override
			public void run() {
				scoreService.addPoints(scoreService.getPassiveIncome());
				
			}
			
		},1,1 ,DURATION);
	}
	
	private void calculateTimeStampForOffIncome() {
		long timePassed = this.scoreService.getTimeStamp();
		if(timePassed>0){
			long millisPassed = TimeUtils.timeSinceMillis(timePassed);
			long seconds = TimeUnit.MILLISECONDS.toSeconds(millisPassed);
			System.out.println("Time since last time : "+seconds);
			addPointsBasedOnTimestamp(seconds);
		}else{
			
		}
	}
	
	private void addPointsBasedOnTimestamp(long seconds){
		if(seconds>0){
			pointsToAdd = (int) (seconds* this.scoreService.getPassiveIncome());
			pointsToAdd/=4;
			scoreService.addPoints(pointsToAdd);
		}
		
	}
}
