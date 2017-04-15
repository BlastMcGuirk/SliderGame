package com.BGuirks.apps.Slider.tiles;

import com.BGuirks.apps.Slider.MainGame;
import com.BGuirks.apps.Slider.graphics.colBox;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class TileMap {

    private Tile[][] tileMap;
    private colBox[][] colBoxes;

    public TileMap(int size){
        tileMap = new Tile[size][size];
        colBoxes = new colBox[size][size];

        for (int y = 0; y < tileMap.length; y++){
            for (int x = 0; x < tileMap.length; x++){
                if (y != size - 1 || x != size - 1) tileMap[y][x] = new Tile(1 + x + (y * size), size);
                if (size == 3)
                    colBoxes[y][x] = new colBox(84 + (x * 307), 369 + (y * 307), 297, 297);
                if (size == 4)
                    colBoxes[y][x] = new colBox(84 + (x * 230), 369 + (y * 230), 220, 220);
                if (size == 5)
                    colBoxes[y][x] = new colBox(84 + (x * 184), 369 + (y * 184), 174, 174);
            }
        }

        unsolveMap(size - 1, size - 1, 0);
    }

    private boolean unsolveMap(int nullx, int nully, int counter){
        if (counter > 200){
            return true;
        }

        int ran = (int) (Math.random() * 4);
        switch (ran){
            case 0:
                if (nullx > 0){
                    moveTile(nully, --nullx);
                    break;
                }
            case 1:
                if (nullx < tileMap.length - 1){
                    moveTile(nully, ++nullx);
                    break;
                }
            case 2:
                if (nully > 0){
                    moveTile(--nully, nullx);
                    break;
                }
            case 3:
                if (nully < tileMap.length - 1){
                    moveTile(++nully, nullx);
                    break;
                }
            default:
        }

        return unsolveMap(nullx, nully, ++counter);
    }

    private void moveTile(int y, int x){
        if (y > 0 && tileMap[y-1][x] == null){
            tileMap[y-1][x] = tileMap[y][x];
            tileMap[y][x] = null;
        } else
        if (y < tileMap.length-1 && tileMap[y+1][x] == null){
            tileMap[y+1][x] = tileMap[y][x];
            tileMap[y][x] = null;
        } else
        if (x > 0 && tileMap[y][x-1] == null){
            tileMap[y][x-1] = tileMap[y][x];
            tileMap[y][x] = null;
        } else
        if (x < tileMap.length-1 && tileMap[y][x+1] == null){
            tileMap[y][x+1] = tileMap[y][x];
            tileMap[y][x] = null;
        }
    }

    public void draw(SpriteBatch sb){
        for (int y = 0; y < tileMap.length; y++) {
            for (int x = 0; x < tileMap.length; x++) {
                if (tileMap[y][x] == null)
                    continue;
                if (tileMap.length == 3)
                    sb.draw(tileMap[y][x].getTxt(), 84 + (x * 307), MainGame.getFV().getWorldHeight() - 369 - 297 - (y * 307));
                if (tileMap.length == 4)
                    sb.draw(tileMap[y][x].getTxt(), 84 + (x * 230), MainGame.getFV().getWorldHeight() - 369 - 220 - (y * 230));
                if (tileMap.length == 5)
                    sb.draw(tileMap[y][x].getTxt(), 84 + (x * 184), MainGame.getFV().getWorldHeight() - 369 - 174 - (y * 184));
            }
        }
    }

    public void touchDown(int tX, int tY){
        for (int y = 0; y < tileMap.length; y++){
            for (int x = 0; x < tileMap.length; x++){
                if (colBoxes[y][x].contains(tX, tY)){
                    moveTile(y, x);
                }
            }
        }
    }

    public boolean isCompleted(){
        for (int y = 0; y < tileMap.length; y++){
            for (int x = 0; x < tileMap.length; x++){
                if (tileMap[y][x] != null){
                    if (x + (y * tileMap.length) + 1 != tileMap[y][x].getValue())
                        return false;
                }
            }
        }
        return true;
    }

    /*for (int y = 0; y < tileMap.length; y++){
        for (int x = 0; x < tileMap.length; x++){

        }
    }*/

    public void dispose(){
        for (int y = 0; y < tileMap.length; y++){
            for (int x = 0; x < tileMap.length; x++){
                if (tileMap[y][x] != null)
                    tileMap[y][x].dispose();
            }
        }
    }

}
