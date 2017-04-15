package com.BGuirks.apps.Slider.graphics;

import com.BGuirks.apps.Slider.MainGame;

public class colBox {

    private int x, y, width, height;

    public colBox(int x, int y, int width, int height){
        this.x = (int) (x * MainGame.scale);
        this.y = (int) ((MainGame.getFV().getWorldHeight() - (y + height)) * MainGame.scale);
        this.width = (int) (width * MainGame.scale);
        this.height = (int) (height * MainGame.scale);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean contains(int ox, int oy){
        if (ox > x && ox < x + width && oy > y && oy < y + height)
            return true;
        return false;
    }

}
