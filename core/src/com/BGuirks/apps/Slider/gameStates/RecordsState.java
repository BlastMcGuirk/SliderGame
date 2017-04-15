package com.BGuirks.apps.Slider.gameStates;

import com.BGuirks.apps.Slider.graphics.Background;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class RecordsState extends GameState {

    private String[] records;

    private BitmapFont bf;

    public RecordsState(GameStateManager gameStateManager) {
        super(gameStateManager);

        bg = new Background("backgrounds/RecordsBG.png");

        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/RobotoLight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter par = new FreeTypeFontGenerator.FreeTypeFontParameter();
        par.color = Color.valueOf("232B43");
        par.size = 130;

        bf = gen.generateFont(par);

        records = new String[3];
        init();
    }

    public void init() {
        records[0] = GameStateManager.getRSM().loadDataValue("three");
        records[1] = GameStateManager.getRSM().loadDataValue("four");
        records[2] = GameStateManager.getRSM().loadDataValue("five");
    }

    public void render() {

    }

    public void draw(SpriteBatch sb) {
        bg.draw(sb);
        for (int i = 0; i < records.length; i++){
            bf.draw(sb, records[i], 570, 1350 - (i * 261));
        }
    }

    public void touchDown(int x, int y) {
        gsm.setState(GameStateManager.MENUSTATE);
    }

    public void touchUp(int x, int y) {

    }

    public void touchDragged(int x, int y) {

    }

    public void dispose() {
        bg.dispose();
        bf.dispose();
    }
}
