package com.BGuirks.apps.Slider.gameStates;

import com.BGuirks.apps.Slider.graphics.Background;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameState {

    protected GameStateManager gsm;
    protected Background bg;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void init();
    public abstract void render();
    public abstract void draw(SpriteBatch sb);
    public abstract void touchDown(int x, int y);
    public abstract void touchUp(int x, int y);
    public abstract void touchDragged(int x, int y);
    public abstract void dispose();

}
