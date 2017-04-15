package com.BGuirks.apps.Slider.gameStates;

import com.BGuirks.apps.Slider.graphics.Background;
import com.BGuirks.apps.Slider.graphics.colBox;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends GameState {

    private Music music;

    private colBox three = new colBox(240, 350, 600, 250);
    private colBox four = new colBox(240, 675, 600, 250);
    private colBox five = new colBox(240, 1000, 600, 250);
    private colBox records = new colBox(240, 1325, 600, 250);

    private Texture volOn, volOff;
    private colBox vol = new colBox(40, 1425, 150, 150);
    private boolean playMus;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bg = new Background("backgrounds/MenuBG.png");
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/songLooped.wav"));
        volOn = new Texture(Gdx.files.internal("soundOn.png"));
        volOff = new Texture(Gdx.files.internal("soundOff.png"));
        playMus = true;
        init();
    }

    public void init() {

    }

    public void render() {

    }

    public void draw(SpriteBatch sb) {
        bg.draw(sb);
        if (playMus)
            sb.draw(volOn, 40, 345);
        else
            sb.draw(volOff, 40, 345);
    }

    public void touchDown(int x, int y) {
        if (three.contains(x, y)){
            gsm.setState(GameStateManager.THREEGAME);
        }
        if (four.contains(x, y)) {
            gsm.setState(GameStateManager.FOURGAME);
        }
        if (five.contains(x, y)) {
            gsm.setState(GameStateManager.FIVEGAME);
        }
        if (records.contains(x, y)) {
            gsm.setState(GameStateManager.RECORDSSTATE);
        }
        if (vol.contains(x, y)){
            if (playMus){
                music.setVolume(0f);
                playMus = false;
            }
            else {
                music.setVolume(1f);
                playMus = true;
            }
        }

    }

    public void startMusic(){
        music.setLooping(true);
        music.play();
    }

    public void touchUp(int x, int y) {

    }

    public void touchDragged(int x, int y) {

    }

    public void dispose() {
        bg.dispose();
        music.dispose();
        volOff.dispose();
        volOn.dispose();
    }
}
