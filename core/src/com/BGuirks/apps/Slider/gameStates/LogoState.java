package com.BGuirks.apps.Slider.gameStates;

import com.BGuirks.apps.Slider.MainGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class LogoState extends GameState {

    private Sprite sprite;
    private long start;
    private boolean uppoo, pooup;

    public LogoState(GameStateManager gameStateManager) {
        super(gameStateManager);
        sprite = new Sprite(new Texture("logo.png"));
        Vector2 middleS = new Vector2(Gdx.graphics.getWidth()/2.0f, Gdx.graphics.getHeight()/2.0f);
        middleS = MainGame.translateVector(middleS, true);
        sprite.setCenter(middleS.x, middleS.y);
        init();
    }

    public void init() {
        start = System.currentTimeMillis();
        uppoo = pooup = false;
    }

    public void render() {
        if (uppoo && !pooup){
            gsm.loadLaterStates();
            pooup = true;
        }
        if (System.currentTimeMillis() - start > 3000) {
            gsm.beginMusic();
            gsm.setState(GameStateManager.MENUSTATE);
        }
    }

    public void draw(SpriteBatch sb) {
        sb.draw(sprite, sprite.getX(), sprite.getY());
        if (!uppoo)
            uppoo = true;
    }

    public void touchDown(int x, int y) {

    }

    public void touchUp(int x, int y) {

    }

    public void touchDragged(int x, int y) {

    }

    public void dispose() {
        sprite.getTexture().dispose();
    }
}
