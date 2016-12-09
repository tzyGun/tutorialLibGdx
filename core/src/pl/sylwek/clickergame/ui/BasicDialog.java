package pl.sylwek.clickergame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BasicDialog extends Image{

	private static final String DIALOG= "img//dialog.png";
	
	private GameLabel gameLabel;
	
	private  static int WIDTH;
	private  static int HEIGHT;
	public BasicDialog(){
		super(getTextureDimensions(new Texture(DIALOG)));
		
		this.setOrigin(WIDTH/2,HEIGHT/2);
		this.setSize(WIDTH,HEIGHT);
		
		this.setPosition(60, 200);
		gameLabel = new GameLabel();
		gameLabel.setPosition(100	, 400);
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				fadeOutDialog();
				return super.touchDown(event, x, y, pointer, button);
			}

			
		});
		
	}
	public void initContent(String text){
		gameLabel.setText(text);
		this.getStage().addActor(gameLabel);
	}
	
	private void fadeOutDialog() {

		SequenceAction sequence = Actions.sequence();
		sequence.addAction(Actions.fadeOut(1.5f));
		sequence.addAction(new Action(){

			@Override
			public boolean act(float delta) {
				BasicDialog.this.remove();
				gameLabel.remove();
				return false;
			}
			
		});
		this.addAction(sequence);
		gameLabel.addAction(Actions.fadeOut(1.5f));
	}
	
	private static Texture getTextureDimensions(Texture texture) {
		WIDTH= texture.getWidth();
		HEIGHT= texture.getHeight();
		return texture;
	}
	
}
