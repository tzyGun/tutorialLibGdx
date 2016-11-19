package pl.sylwek.clickergame.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PlayerButton  extends Button{
	
	 
	 public PlayerButton(final IClickCallBack callBack){
		 
		 	super(new ButtonStyle());
		 	init(callBack);
			
	 }

	private void init(final IClickCallBack callBack) {
		this.setWidth(460);
		this.setHeight(360);
		this.setX(10);
		this.setY(170);
		this.setDebug(false);
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				System.out.println("click at x:"+x+"y:"+y+"event:"+event.toString());
				callBack.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
