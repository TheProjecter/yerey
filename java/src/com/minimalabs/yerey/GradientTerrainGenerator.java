package com.minimalabs.yerey;

import java.awt.Dimension;

public class GradientTerrainGenerator extends TerrainGenerator {

   public GradientTerrainGenerator(Dimension size) {
      super(size);
   }

   protected Terrain generate() {
      Terrain terrain = new Terrain(size);
      for (int x = 0; x < size.width; x++) {
         for (int y = 0; y < size.height; y++) {
            terrain.set(x, y, (x % 256) / 255.0);
         }
      }
      return terrain;
   }

}
