package com.minimalabs.yerey;

import java.awt.Color;

public class GreyscaleRenderer implements TerrainRenderer {

   public Color render(double value) {
      int r = (int) (255 * value);
      return new Color(r, r,r);
   }

}
