package com.minimalabs.yerey;

import java.awt.Color;

public class PlainGroundRenderer extends GreenFieldsRenderer {

   private static final float H = 60/360f;
   private static final float S = 60/100f;

   protected Color ground(double value) {
      return Color.getHSBColor(H, S, (float) value);
   }


}
