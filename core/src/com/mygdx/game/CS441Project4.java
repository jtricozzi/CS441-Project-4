package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class CS441Project4 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, rectImg;
	Sprite mainSprite, flyingObject;
	ArrayList<Sprite> obstacleList = new ArrayList<Sprite>();



	float x, y, dx, dy;
	float w, h;

	Rectangle rect;
	Circle mainCir;
	private boolean moving;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		rectImg = new Texture("rectangleImage.png");
		mainSprite = new Sprite(img);
		flyingObject = new Sprite(rectImg);

		//for(int i = 0; )

		x = 0;
		y = 0;
		dx = 0;
		dy = 0;



		mainCir = new Circle(x, y, mainSprite.getWidth() / 2);

		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override public boolean keyDown (int keycode) {
				if(keycode == Input.Keys.RIGHT){
					moving = true;
					dy = 20;
				}else if(keycode == Input.Keys.LEFT){
					moving = true;
					dy = -20;
				}else if(keycode == Input.Keys.UP){
					moving = true;
					dx = -20;
				}else if(keycode == Input.Keys.DOWN){
					moving = true;
					dx = 20;
				}
				return true;
			}
			@Override public boolean keyUp (int keycode) {
				if(keycode == Input.Keys.RIGHT){
					moving = false;
					dy = 0;
				}else if(keycode == Input.Keys.LEFT){
					moving = false;
					dy = 0;
				}else if(keycode == Input.Keys.UP){
					moving = false;
					dx = 0;
				}else if(keycode == Input.Keys.DOWN){
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
		//y = y + dy;

		mainCir.x = x;
		mainCir.y = y;

		if(moving){
			x = x + dx;
			y = y + dy;
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
