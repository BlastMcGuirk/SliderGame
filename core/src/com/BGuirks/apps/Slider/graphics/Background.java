package com.BGuirks.apps.Slider.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

    private Texture txt;

    public Background(String path){
        txt = new Texture(path);
    }

    public void draw(SpriteBatch sb){
        sb.draw(txt, 0, 0);
    }

    public void dispose(){
        txt.dispose();
    }

}
