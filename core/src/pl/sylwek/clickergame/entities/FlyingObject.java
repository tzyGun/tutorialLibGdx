package pl.sylwek.clickergame.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.sylwek.clickergame.TutorialClickerGame;

public  class FlyingObject extends Image{

	public enum FlyingObjectType {
		MONEY,PASSIVE
		
	}
	private  static int WIDTH;
	private  static int HEIGHT;
	private final static int STARTING_X1=0;
	private final static int STARTING_X2=TutorialClickerGame.WIDTH;
	private final static int STARTING_Y=-100;
	
	
	public final static String MONEY="img//money.png";
	public final static String PASSIVE="img//passive.png";
	private FlyingObjectType type;
	private TutorialClickerGame game;
	private int startingX;
	public  FlyingObject (FlyingObjectType type,TutorialClickerGame game){
		super(getImageDimensions(new Texture(getTextureType(type))));
		
		this.game=game;
		this.type=type;
		playSound();
		this.setOrigin(WIDTH/2,HEIGHT/2);
		this.setSize(WIDTH,HEIGHT);
		
		//starting position
		startingX=MathUtils.randomBoolean()?STARTING_X1:STARTING_X2;
		this.setPosition(startingX, STARTING_Y);
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				reactOnClick();
				return super.touchDown(event, x, y, pointer, button);
			}

		
		});
	
		
		
}
	private void playSound(){
		if(FlyingObjectType.MONEY.equals(type)){
			game.getSoundService().playMoneySound();
		}
		if(FlyingObjectType.PASSIVE.equals(type)){
			game.getSoundService().playBookSound();
		}
		
	}
	
	private  static Texture getImageDimensions(Texture texture){
		WIDTH=texture.getWidth();
		HEIGHT=texture.getHeight();
		return texture;
	}
	
	
	private void reactOnClick() {
		if(FlyingObjectType.MONEY.equals(type)){
			game.getScoreService().addPoints(50);
			
		}else if(FlyingObjectType.PASSIVE.equals(type)){
			game.getScoreService().addPassiveIncome();
		}
		game.getSoundService().playPickSound();
		System.out.println("Touched");
		FlyingObject.this.remove();
	}
	
	private static String getTextureType(FlyingObjectType type) {
		if(FlyingObjectType.MONEY.equals(type)){
			return MONEY;
		}else if(FlyingObjectType.PASSIVE.equals(type)){
			return PASSIVE;
		}
		return "";
	}

	public void fly(){
		int direction=0;
		if(startingX==STARTING_X1){
			direction=1;
			
		}else {
			direction=-1;
		}
		
		int time1=MathUtils.random(2,4);
		Action a = Actions.parallel(
				Actions.moveBy(direction* 300+MathUtils.random(-200,200), 200, time1),
				Actions.rotateBy(360, 5)
				);
		
		Action b = Actions.parallel(
				Actions.moveBy(direction*500+MathUtils.random(-200,200), 900, time1),
				Actions.rotateBy(360, 3)
				);
		
		Action c = Actions.run(new Runnable() {
			
			@Override
			public void run() {
				FlyingObject.this.remove();
			}
		});
		
		this.addAction(Actions.sequence(a,b,c));
		
		
	}
	
}
