package com.BGuirks.apps.Slider.gameStates;

import com.BGuirks.apps.Slider.graphics.Background;
import com.BGuirks.apps.Slider.graphics.Clock;
import com.BGuirks.apps.Slider.graphics.colBox;
import com.BGuirks.apps.Slider.tiles.TileMap;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FiveState extends GameState {

    private TileMap tm;
    private Clock c;

    private colBox reset, quit;
    private boolean displayFireworks;

    private Sound yay;

    public FiveState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bg = new Background("backgrounds/FiveBG.png");
        reset = new colBox(220, 75, 210, 210);
        quit = new colBox(650, 75, 210, 210);
        c = new Clock();

        yay = Gdx.audio.newSound(Gdx.files.internal("sounds/yay.mp3"));

        init();
    }

    public void init() {
        tm = new TileMap(5);
        c.startClock();
        c.pause();
        displayFireworks = false;
    }

    public void render() {
        if (!c.isPaused())
            c.update();
    }

    public void draw(SpriteBatch sb) {
        bg.draw(sb);
        tm.draw(sb);
        gsm.fonts.bf.draw(sb, c.getTime(), 360, 450);
        if (displayFireworks){
            gsm.fonts.win.draw(sb, "NEW RECORD!", 30, 600);
            gsm.fireworks.pe1.update(Gdx.graphics.getDeltaTime());
            gsm.fireworks.pe2.update(Gdx.graphics.getDeltaTime());
            gsm.fireworks.pe1.draw(sb);
            gsm.fireworks.pe2.draw(sb);
            gsm.fireworks.pe1.getEmitters().get(0).draw(sb);
            gsm.fireworks.pe2.getEmitters().get(0).draw(sb);
        }
    }

    public void touchDown(int x, int y) {
        if (c.isPaused() && !tm.isCompleted())
            c.startClock();
        if(reset.contains(x, y))
            init();
        if(quit.contains(x, y))
            gsm.setState(GameStateManager.MENUSTATE);
        if (!tm.isCompleted()) tm.touchDown(x, y);
        if (tm.isCompleted()){
            String best = GameStateManager.getRSM().loadDataValue("five");
            if (beats(c.getTime(), best) || best.equals("0:00")){
                GameStateManager.getRSM().saveDataValue("five", c.getTime());
                displayFireworks = true;
                if (!c.isPaused()) {
                    yay.play();
                }
                gsm.fireworks.pe1.start();
                gsm.fireworks.pe2.start();
            }
            c.pause();
        }
    }

    private boolean beats(String fir, String sec){
        int firM = (int)fir.charAt(0);
        int secM = (int)fir.charAt(0);
        int firS = Integer.parseInt(fir.substring(2));
        int secS = Integer.parseInt(sec.substring(2));
        return (firM <= secM && firS < secS);
    }

    public void touchUp(int x, int y) {

    }

    public void touchDragged(int x, int y) {

    }

    public void dispose() {
        bg.dispose();
        tm.dispose();
        gsm.fonts.bf.dispose();
        gsm.fireworks.pe1.dispose();
        gsm.fireworks.pe2.dispose();
        gsm.fonts.win.dispose();
        yay.dispose();
    }
}
