package com.BGuirks.apps.Slider.graphics;

public class Clock {

    private long start, dt;
    private boolean paused, stopped;

    public void startClock(){
        start = System.currentTimeMillis();
        stopped = false;
        paused = false;
        dt = 0;
    }

    public void update(){
        if (!stopped)
            dt = System.currentTimeMillis() - start;
    }

    public void stopClock(){
        stopped = true;
    }

    public boolean isPaused(){
        return paused;
    }

    public void pause(){
        paused = true;
    }

    public void unpause(){
        paused = false;
    }

    public String getTime(){
        String time = "";
        int seconds = (int)(dt/1000.0) % 60;
        int minutes = ((int)(dt/1000) / 60) % 360;
        time += minutes + ":";
        if (seconds < 10)
            time += "0" + seconds;
        else
            time += seconds;
        return time;
    }

}
