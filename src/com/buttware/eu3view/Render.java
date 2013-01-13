package com.buttware.eu3view;

import editor.MapPanel;
import editor.mapmode.MapMode;
import eug.specific.eu3.EU3SaveGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Render {
    private static final int YEARPOSX = 10;
    private static final int YEARPOSY = 10;
    
    public static void render(EU3SaveGame save, int startYear, int endYear,
                              int interval, int delay, boolean showBorders,
                              String renderTo, MapMode m, double scale,
                              boolean showDate)
                              throws Exception {
        MapPanel mp = new MapPanel();
        mp.initialize();
        mp.setDataSource(save);
        m.setMapPanel(mp);
        mp.setMode(m);
        mp.setPaintBorders(showBorders);
	
        Dimension d = mp.getPreferredSize();
        mp.setSize(d);
        BufferedImage unfiltered = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
        BufferedImage filtered = new BufferedImage((int)(d.width * scale), (int)(d.height * scale), BufferedImage.TYPE_INT_RGB);
        AffineTransform t = new AffineTransform();
        t.scale(scale, scale);
        
        Graphics2D gUnfiltered = unfiltered.createGraphics();
        Graphics2D gFiltered = filtered.createGraphics();
        gFiltered.setColor(Color.WHITE);
        
        AnimatedGifEncoder gifenc = new AnimatedGifEncoder();
        gifenc.start(renderTo);
        gifenc.setDelay(delay);
        gifenc.setRepeat(0);
        gifenc.setQuality(1);
        for(int i = startYear; i <= endYear; i+= interval)
        {
            mp.getModel().setDate(i + ".1.1");
            mp.repaint();
            mp.paint(gUnfiltered);
            
            gFiltered.drawImage(unfiltered, t, null);
            
            if(showDate) {
                gFiltered.drawString(String.valueOf(i), YEARPOSX, (int)(d.height * scale) -  YEARPOSY);
            }
            
            gifenc.addFrame(filtered);
        }
        //add last frame, with big delay
        mp.getModel().setDate(endYear + ".12.12");
        mp.repaint();
        mp.paint(gUnfiltered);

        gFiltered.drawImage(unfiltered, t, null);
        
        if(showDate) {
            gFiltered.drawString(String.valueOf(endYear), YEARPOSX, (int)(d.height * scale) - YEARPOSY);
        }
        
        gifenc.setDelay(delay * 20);
        gifenc.addFrame(filtered);
        
        gifenc.finish();
    }
}
