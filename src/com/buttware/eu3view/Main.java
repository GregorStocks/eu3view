package com.buttware.eu3view;

import eug.shared.FilenameResolver;

public class Main {
    public static final FilenameResolver filenameResolver =
            new FilenameResolver(new java.io.File("config.txt"));
    
    public static void main(String[] args) {
        new EU3View().setVisible(true);
    }
}
