package com.java.codegeek;

/**
 *
 */
public class Place {

    static final public int NONE = 0;
    static final public int P1 = 1;
    static final public int P2 = 2;
    static final public int BOTH = 3;

    public int index;
    public int curLandPlayer;

    public Place(int index, int curLandPlayer) {
        this.index = index;
        this.curLandPlayer = curLandPlayer;
    }

    public Place(){
        this.index = 0;
        this.curLandPlayer = NONE;
    }


}
