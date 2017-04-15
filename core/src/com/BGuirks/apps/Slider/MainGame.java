package com.BGuirks.apps.Slider;

import com.BGuirks.apps.Slider.gameStates.GameStateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainGame extends ApplicationAdapter implements InputProcessor {

    private SpriteBatch sb;
    private static OrthographicCamera cam;
    private static FitViewport fv;

    private GameStateManager gsm;

    public static float scale;

    @Override
    public void create () {
        scale = (Gdx.graphics.getWidth() / 1080.0f);

        sb = new SpriteBatch();

        Gdx.input.setInputProcessor(this);

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        fv = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        fv.setWorldWidth(1080);
        fv.setWorldHeight(1920);
        fv.apply(true);

        gsm = new GameStateManager();
    }

    public static Vector2 translateVector(Vector2 cur, boolean screenToWorld){
        if (screenToWorld) return new Vector2(cur.x/scale, cur.y/scale);
        else return new Vector2(cur.x*scale, cur.y*scale);
    }

    public static FitViewport getFV(){
        return fv;
    }

    @Override
    public void resize(int width, int height){
        fv.update(width, height);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        sb.setProjectionMatrix(cam.combined);

        gsm.render();

        sb.begin();
        gsm.draw(sb);
        sb.end();

    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        gsm.touchDown(screenX, screenY);
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        gsm.touchUp(screenX, screenY);
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        gsm.touchDragged(screenX, screenY);
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void dispose(){
        sb.dispose();
        gsm.dispose();
    }
}
