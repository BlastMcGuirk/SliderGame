package com.BGuirks.apps.Slider.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Fonts {

    public BitmapFont bf, win;

    public Fonts(){
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/RobotoLight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter par = new FreeTypeFontGenerator.FreeTypeFontParameter();
        par.color = Color.valueOf("232B43");
        par.size = 200;

        bf = gen.generateFont(par);

        par.color = Color.valueOf("DD457A");
        par.size = 160;

        win = gen.generateFont(par);
    }

}
