package org.schmitt.framework.serial.controller.release;

import java.awt.Graphics2D;

public class DrawServo {

	private static final double TWO_PI = 2.0 * Math.PI;
	
	public static void drawRadius(Graphics2D g2d, double percent,
            int centerX, int centerY, int maxRadius){
        
        percent = percent/360;
        
        double radians = (0.5 - percent) * TWO_PI;
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxMax = centerX + (int) (maxRadius * sine);
        int dyMax = centerY + (int) (maxRadius * cosine);
        g2d.drawLine(centerX, centerY, dxMax, dyMax);
        
    }
	
}
