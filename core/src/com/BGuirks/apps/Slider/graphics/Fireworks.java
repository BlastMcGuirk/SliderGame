package com.BGuirks.apps.Slider.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

public class Fireworks {

    public ParticleEffect pe1, pe2;

    public Fireworks(){
        pe1 = new ParticleEffect();
        pe2 = new ParticleEffect();
        pe1.load(Gdx.files.internal("effects/fireworksRWB1.p"), Gdx.files.internal("effects/"));
        pe2.load(Gdx.files.internal("effects/fireworksRWB2.p"), Gdx.files.internal("effects/"));
        pe1.getEmitters().get(0).setPosition(350, 1250);
        pe1.getEmitters().get(1).setPosition(350, 1250);
        pe1.getEmitters().get(2).setPosition(350, 1250);
        pe2.getEmitters().get(0).setPosition(800, 1500);
        pe2.getEmitters().get(1).setPosition(800, 1500);
        pe2.getEmitters().get(2).setPosition(800, 1500);
    }

}
