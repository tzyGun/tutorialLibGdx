package pl.sylwek.clickergame.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import pl.sylwek.clickergame.TutorialClickerGame;
import pl.sylwek.clickergame.ui.BasicDialog;

public class RandomEventController {

	private static final int INTERVAL=10;
	
	private TutorialClickerGame game;
	
	private Stage stage;
	
	public RandomEventController(TutorialClickerGame game, Stage stage){
		init();
		this.game= game;
		this.stage=stage;
	}

	private void init() {
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			if(MathUtils.randomBoolean()){
					popUpRandomEvent();
			}
			}

			
		}, 3,INTERVAL);
	}
	
	private void popUpRandomEvent() {
		
		int randomEvent = MathUtils.random(1,3);
		switch(randomEvent){
		case 1:{
			System.out.println("Money Event occured");
			moneyEvent();
		}
			break;
			
		case 2:{
			System.out.println("Lose Money Event occured");
			loseMoneyEvent();
		}
			break;
			
		case 3:{
			System.out.println("Passive income  Event occured");
			passiveIncomeEvent();
		}
			break;	
			default :
				break;
		}
		
		
	}

	private void moneyEvent() {
		game.getScoreService().addPoints(200);
		BasicDialog dialog= new BasicDialog();
		dialog.showDialog(stage, "You get additional money");
		
	}
	
	private void loseMoneyEvent() {
		game.getScoreService().addPoints(-50);
		BasicDialog dialog= new BasicDialog();
		dialog.showDialog(stage, "You are losing money");
		
	}
	
	private void passiveIncomeEvent(){
		game.getScoreService().addPassiveIncome();
		BasicDialog dialog= new BasicDialog();
		dialog.showDialog(stage, "Your passive income increased");
	}
}
