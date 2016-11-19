package pl.sylwek.clickergame.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ResetButton extends Button{
	 public ResetButton(final IClickCallBack callBack){
		 super(new ButtonStyle());
		 init(callBack);
			
			
		 
		 
	 }

	private void init(final IClickCallBack callBack) {
		this.setX(300);
		this.setY(600);
		this.setWidth(50);
		this.setHeight(50);
		this.setDebug(true);
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				callBack.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
