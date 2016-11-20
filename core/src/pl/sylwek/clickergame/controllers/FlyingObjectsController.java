package pl.sylwek.clickergame.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import pl.sylwek.clickergame.TutorialClickerGame;
import pl.sylwek.clickergame.entities.FlyingObject;
import pl.sylwek.clickergame.entities.FlyingObject.FlyingObjectType;

public class FlyingObjectsController {

	private int spawnTime;
	
	
	
	public FlyingObjectsController(Stage stage, TutorialClickerGame game){
		
		init(stage,game);
		
	}

	private void init(final Stage stage, final TutorialClickerGame game) {
		randomizeSpawnTime();
		
		Timer.schedule(new Task(){

			@Override
			public void run() {
				FlyingObject flyingObject=null;
			
				
				if(MathUtils.randomBoolean()){
					flyingObject = new FlyingObject(FlyingObjectType.MONEY,game);
				}else{
					flyingObject = new FlyingObject(FlyingObjectType.PASSIVE,game);
				}
				flyingObject.fly();
				
				stage.addActor(flyingObject);
				randomizeSpawnTime();
				
			}
			
			
			
		}, spawnTime,spawnTime);
		
	}

	private void randomizeSpawnTime() {
		spawnTime= MathUtils.random(2,5);
	}
	
}
