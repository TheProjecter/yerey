package com.minimalabs.yerey;

import java.awt.Color;
import java.awt.Dimension;

public class MonoTerrainGenerator  extends TerrainGenerator {   
   private final double colorVal;
   
   public MonoTerrainGenerator(Color color, Dimension size) {
      super(size);
      this.colorVal = convert(color);
   }

   public MonoTerrainGenerator(Color color, int width, int height) {
      this(color, new Dimension(width, height));
   }

   protected Terrain generate() {
      Terrain terrain = new Terrain(size);
      for (int x = 0; x < size.width; x++) {
         for (int y = 0; y < size.height; y++) {
            terrain.set(x, y, colorVal);
         }
      }
      return terrain;
   }

   protected double convert(Color col) {
      int red = col.getRed();
      double i = red / 256.0;
      return i;
   }

}
