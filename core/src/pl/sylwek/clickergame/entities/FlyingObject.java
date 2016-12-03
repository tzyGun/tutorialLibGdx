package pl.sylwek.clickergame.entities;

import com.badlogic.gdx.graphics.Texture;
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
	private final static int STARTING_X=0;
	private final static int STARTING_Y=-100;
	
	
	public final static String MONEY="money.png";
	public final static String PASSIVE="passive.png";
	private FlyingObjectType type;
	private TutorialClickerGame game;
	
	public  FlyingObject (FlyingObjectType type,TutorialClickerGame game){
		super(getImageDimensions(new Texture(getTextureType(type))));
		
		this.game=game;
		this.type=type;
		
		this.setOrigin(WIDTH/2,HEIGHT/2);
		this.setSize(WIDTH,HEIGHT);
		
		//starting position
		this.setPosition(STARTING_X, STARTING_Y);
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				reactOnClick();
				return super.touchDown(event, x, y, pointer, button);
			}

		
		});
	
		
		
}
	
	private  static Texture getImageDimensions(Texture texture){
		WIDTH=texture.getWidth();
		HEIGHT=texture.getHeight();
		return texture;
	}
	
	
	private void reactOnClick() {
		if(FlyingObjectType.MONEY.equals(type)){
			game.addPoints(50);
		}else if(FlyingObjectType.PASSIVE.equals(type)){
			game.addPassiveIncome();
		}
		
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
		
		Action a = Actions.parallel(
				Actions.moveBy(300, 200, 5),
				Actions.rotateBy(360, 5)
				);
		
		Action b = Actions.parallel(
				Actions.moveBy(-500, 900, 3),
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
