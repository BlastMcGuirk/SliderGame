package com.BGuirks.apps.Slider.gameStates;

import com.BGuirks.apps.Slider.graphics.Fireworks;
import com.BGuirks.apps.Slider.graphics.Fonts;
import com.BGuirks.apps.Slider.saves.SaveManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class GameStateManager {

    public static final int LOGOSTATE = 0;
    public static final int MENUSTATE = 1;
    public static final int RECORDSSTATE = 2;
    public static int THREEGAME = 3;
    public static int FOURGAME = 4;
    public static int FIVEGAME = 5;

    private ArrayList<GameState> gameStates;
    private int currentState;

    public static SaveManager records;

    protected Fireworks fireworks;
    protected Fonts fonts;

    public GameStateManager(){
        records = new SaveManager(false, "recordssave");

        if (records.isEmpty()){
            records.saveDataValue("three", "0:00");
            records.saveDataValue("four", "0:00");
            records.saveDataValue("five", "0:00");
        }

        gameStates = new ArrayList<GameState>();
        gameStates.add(new LogoState(this));
        gameStates.add(new MenuState(this));
        gameStates.add(new RecordsState(this));

        currentState = LOGOSTATE;
    }

    public void loadLaterStates(){
        gameStates.add(new ThreeState(this));
        gameStates.add(new FourState(this));
        gameStates.add(new FiveState(this));
        fireworks = new Fireworks();
        fonts = new Fonts();
    }

    public void setState(int state){
        currentState = state;
        init();
    }

    public static SaveManager getRSM(){
        return records;
    }

    public void beginMusic(){((MenuState)(gameStates.get(MENUSTATE))).startMusic(); }

    public void init(){
        gameStates.get(currentState).init();
    }

    public void render(){
        gameStates.get(currentState).render();
    }

    public void draw(SpriteBatch sb){
        gameStates.get(currentState).draw(sb);
    }

    public void touchDown(int x, int y){
        gameStates.get(currentState).touchDown(x, Gdx.graphics.getHeight() - y);
    }

    public void touchUp(int x, int y) {
        gameStates.get(currentState).touchUp(x, y);
    }

    public void touchDragged(int x, int y) {
        gameStates.get(currentState).touchDragged(x, y);
    }

    public void dispose(){
        gameStates.get(currentState).dispose();
    }

}
