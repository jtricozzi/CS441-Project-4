package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MyObstacles extends Sprite {
    float x = 0, y = 0, dx = 0, dy = 0, w = 0, h = 0;
    Texture t;

    public MyObstacles(Texture texture) {
        t = texture;
        w = texture.getWidth();
        h = texture.getHeight();;
    }


}
