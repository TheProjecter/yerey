package com.minimalabs.yerey;

import java.awt.Color;

public class GreenFieldsRenderer implements TerrainRenderer {

   protected static final double WATER_LEVEL = 0.8;
   protected static final Color WATER_COLOR = new Color(50, 66, 120);

   public Color render(double value) {
      if (value > WATER_LEVEL)
         return WATER_COLOR;
      else {
         return ground(value);
      }
   }

   protected Color ground(double value) {
      int g = (int) (255 * value);
      return new Color(60, g, 0);
   }

}
