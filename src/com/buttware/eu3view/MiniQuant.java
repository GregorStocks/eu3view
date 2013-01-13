package com.buttware.eu3view;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author Kurper <kurper@gmail.com>
 */
public class MiniQuant {
    protected static final int numColors = 256;
    private byte[] pic;
    private int len;
    private byte[] colorTab;
    private HashMap<Color, Integer> colorHash;
    private int numColorsUsed;
    public MiniQuant(byte[] pic, int len, int sample) {
        // ignore sample, just use that to have same interface as NeuQuant
        this.pic = pic;
        this.len = len;
    }

    public byte[] process() {
        colorTab = new byte[numColors * 3];
        colorHash = new HashMap<Color, Integer>();
        numColorsUsed = 0;

        for(int i = 0; i < len; i+= 3) {
            //just put the first 256 colors in the table, no worries
            //need & 0xff so 11111111 is 256 not -1, etc
            Color c = new Color(pic[i+2] & 0xff, pic[i+1] & 0xff, pic[i] & 0xff);
            if(!colorHash.containsKey(c) && numColorsUsed < numColors) {
                colorHash.put(c, numColorsUsed);
                colorTab[numColorsUsed * 3] = pic[i];
                colorTab[numColorsUsed * 3 + 1] = pic[i + 1];
                colorTab[numColorsUsed * 3 + 2] = pic[i + 2];
                numColorsUsed++;
            }
        }
        return colorTab;
    }

    public int map(int b, int g, int r) {
        Color c = new Color(r, g, b);
        if (colorHash.containsKey(c)) {
            return colorHash.get(c);
        }
        else {
            double bestdist = Integer.MAX_VALUE;
            int bestpos = 0;
            for(int i = 0; i < numColorsUsed; i+= 3) {
                // smallest distance squared
                double dist = Math.pow(b - colorTab[i], 2);
                dist += Math.pow(g - colorTab[i + 1], 2);
                dist += Math.pow(r - colorTab[i + 2], 2);
                if(dist < bestdist) {
                    bestdist = dist;
                    bestpos = i/3;
                }
            }
            colorHash.put(c, bestpos);
            return bestpos;
        }
    }
}
