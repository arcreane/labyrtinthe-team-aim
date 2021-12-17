package com.coding.labyrtintheteamaim;

public class Chrono {

    //variables
    private long tempsDepart=0;
    private long tempsFin=0;
    private long pauseDepart=0;
    private long pauseFin=0;
    private long duree=0;

    public void start()
    {
        //start fonction that will start the chrono
        tempsDepart=System.currentTimeMillis();
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
    }

    public void pause()
    {
        //pause
        if(tempsDepart==0) {return;}
        pauseDepart=System.currentTimeMillis();
    }

    public void resume()
    {
        //resume
        if(tempsDepart==0) {return;}
        if(pauseDepart==0) {return;}
        pauseFin=System.currentTimeMillis();
        tempsDepart=tempsDepart+pauseFin-pauseDepart;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
    }

    public void stop()
    {
        //function stop that will stop the chrono if it even started
        if(tempsDepart==0) {return;}
        tempsFin=System.currentTimeMillis();
        duree=(tempsFin-tempsDepart) - (pauseFin-pauseDepart);
        tempsDepart=0;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
    }

    //get the time in seconds ms and txt
    public long getDureeSec()
    {
        return duree/1000;
    }

    public long getDureeMs()
    {
        return duree;
    }

    public String getDureeTxt()
    {
        return timeToHMS(getDureeSec());
    }

    public static String timeToHMS(long tempsS) {

        // IN : (long) temps en seconds
        // OUT : (String) temps au format text : "1 h 26 min 3 s"

        //we need to do this to convert in seconds and ms
        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);

        String r="";

        //print
        if(h>0) {r+=h+" h ";}
        if(m>0) {r+=m+" min ";}
        if(s>0) {r+=s+" s";}
        if(h<=0 && m<=0 && s<=0) {r="0 s";}

        return r;
    }

}