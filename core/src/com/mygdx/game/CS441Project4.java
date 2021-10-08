package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.ScreenUtils;

public class CS441Project4 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite mainSprite;

	float x, y, dx, dy;
	float w, h;

	Circle mainCir;
	private boolean moving;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		mainSprite = new Sprite(img);

		x = 0;
		y = 0;
		dx = 0;
		dy = 0;

		mainCir = new Circle(x, y, mainSprite.getWidth() / 2);

		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override public boolean keyDown (int keycode) {
				if(keycode == Input.Keys.RIGHT){
					moving = true;
					dx = 15;
				}else if(keycode == Input.Keys.LEFT){

				}
				return true;
			}
			@Override public boolean keyUp (int keycode) {
				if(keycode == Input.Keys.RIGHT){
					moving = false;
					dx = 0;
				}
				return false;
			}
		});

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		//x = x + dx;
		y = y + dy;

		mainCir.x = x;
		mainCir.y = y;

		if(moving){
			x = x + dx;
		}

		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void resize (int width, int height) {
		w = width;
		h = height;
	}
}
