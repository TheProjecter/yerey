package com.minimalabs.yerey;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class ColorfulTerrainGenerator  extends MonoTerrainGenerator {   
   
   private Random random = new Random();
   
   public ColorfulTerrainGenerator(Dimension size) {
      super(Color.BLACK, size);
   }

   protected Terrain generate() {
      Terrain terrain = new Terrain(size);
      for (int x = 0; x < size.width; x++) {
         for (int y = 0; y < size.height; y++) {
            double value = random.nextInt(0xff)/(double)(0xff);
            terrain.set(x, y, value);
         }
      }
      return terrain;
   }

}
