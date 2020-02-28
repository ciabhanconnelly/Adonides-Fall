package com.example.adonidesfall;

public class Mood {
    private int happySad;
    private int passivePushy;
    private int excitedCalm;
    private int truth;

    public Mood(int hs, int pp, int ec, int t){
        happySad=hs;
        passivePushy=pp;
        excitedCalm=ec;
        truth=t;
    }

    public int getHappySad() {
        return happySad;
    }

    public void setHappySad(int happySad) {
        this.happySad = happySad;
    }

    public int getPassivePushy() {
        return passivePushy;
    }

    public void setPassivePushy(int passivePushy) {
        this.passivePushy = passivePushy;
    }

    public int getExcitedCalm() {
        return excitedCalm;
    }

    public void setExcitedCalm(int excitedCalm) {
        this.excitedCalm = excitedCalm;
    }

    public int getTruth() {
        return truth;
    }

    public void setTruth(int truth) {
        this.truth = truth;
    }



}
