package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Units.Person;

import java.awt.*;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, crossbowman, monk, peasant, pikeman, robber, sniper, wizard;
	Music music;
	Main program;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("life.png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/dendy.mp3"));
		music.setVolume(0.1f);
		music.setLooping(true);
		music.play();
		program = new Main();
		program.init();
		crossbowman = new Texture("pers/Crossbowman.png");
		monk = new Texture("pers/Monk.png");
		peasant = new Texture("pers/Peasant.png");
		pikeman = new Texture("pers/Pikeman.png");
		robber = new Texture("pers/Robber.png");
		sniper = new Texture("pers/Sniper.png");
		wizard = new Texture("pers/Wizard.png");
	}

	@Override
	public void render () {
//		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (Person hero : program.all) {
			if (hero.getHealth()==0) continue;
			float x = hero.getPosition().x * (Gdx.graphics.getWidth() / 10.f);
			float y = hero.getPosition().y * (Gdx.graphics.getHeight() / 5.f);
			switch (hero.getClass().getSimpleName()){
				case "Crossbowman":
					batch.draw(crossbowman, x, y);
					break;
				case "Monk":
					batch.draw(monk, x, y);
					break;
				case "Peasant":
					batch.draw(peasant, x, y);
					break;
				case "Pikeman":
					batch.draw(pikeman, x, y);
					break;
				case "Robber":
					batch.draw(robber, x, y);
					break;
				case "Sniper":
					batch.draw(sniper, x, y);
					break;
				case "Wizard":
					batch.draw(wizard, x, y);
					break;
			}
		}
		batch.end();

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) || Gdx.input.justTouched()) {
			String stepText = program.step();
			if (stepText != null) Gdx.graphics.setTitle(stepText);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		crossbowman.dispose();
		monk.dispose();
		peasant.dispose();
		pikeman.dispose();
		robber.dispose();
		sniper.dispose();
		wizard.dispose();
	}
}
