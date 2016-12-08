package pl.sylwek.clickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundService {

	
	private Sound moneySound;
	
	private Sound jumpSound;
	
	private Sound pickSound;
	
	private Sound bookSound;
	
	private Music music;
	public SoundService(){
		init();
		
	}
	private void init() {
		moneySound = Gdx.audio.newSound(Gdx.files.internal("sounds/money1.mp3"));
		jumpSound = Gdx.audio.newSound(Gdx.files.internal("sounds/jump.wav"));
		pickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/pick.mp3"));
		bookSound = Gdx.audio.newSound(Gdx.files.internal("sounds/book.wav"));
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
	}
	public void playMoneySound(){
		moneySound.play();
	}
	
	public void playMusic(boolean looped){
		music.play();
		music.setLooping(looped);
	}
	
	
	public void playJumpSound(){
		jumpSound.play();
	}
	
	public void playPickSound(){
		pickSound.play();
	}
	
	public void playBookSound(){
		bookSound.play();
	}
	
	
}
