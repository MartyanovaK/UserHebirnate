package jm.task.core.jdbc.util;

import sun.awt.image.PixelConverter;

import static sun.awt.image.PixelConverter.UshortGray.instance;

public class Util extends PixelConverter {
    public static Util getInstance() {
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    instance = new PixelConverter();
                }
            }
        }
        return (Util) instance;
    }

}
