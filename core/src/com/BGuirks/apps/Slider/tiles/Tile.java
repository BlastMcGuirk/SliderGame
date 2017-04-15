package com.BGuirks.apps.Slider.tiles;

import com.BGuirks.apps.Slider.MainGame;
import com.BGuirks.apps.Slider.graphics.colBox;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

    private int value;
    private Texture txt;

    public Tile(int value, int gridSize){
        this.value = value;
        txt = new Texture("tiles/Tile" + gridSize + "" + value + ".png");
    }

    public int getValue() {
        return value;
    }

    public Texture getTxt() {
        return txt;
    }

    public void dispose(){
        txt.dispose();
    }

}
