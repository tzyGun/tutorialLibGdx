package pl.sylwek.clickergame.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class RandomEventController {

	private static final int INTERVAL=30;
	
	public RandomEventController(){
		init();
	}

	private void init() {
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//if(MathUtils.randomBoolean()){
					popUpRandomEvent();
				//}
			}

			
		}, 2,INTERVAL);
	}
	
	private void popUpRandomEvent() {
		System.out.println("Random event occured");
	}
}
