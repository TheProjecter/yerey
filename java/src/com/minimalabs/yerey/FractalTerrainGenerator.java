package com.minimalabs.yerey;

import java.awt.Dimension;
import java.util.Random;

public class FractalTerrainGenerator extends TerrainGenerator {

   private final Random random = new Random();

   public FractalTerrainGenerator(Dimension size) {
      super(size);
   }

   @Override
   protected Terrain generate() {
      Terrain terrain = new Terrain(size);
      int len = Math.min(size.width, size.height);
      seed(terrain, 0, 0, len);
      perform(terrain, 0, 0, len, 0);
      return terrain;
   }

   protected void perform(Terrain terrain, int x, int y, int size, int i) {
      int halfSize = size / 2;
      int xHalf = x + halfSize;
      int yHalf = y + halfSize;
      int s = size - 1;
      double val;

      // diamond
      double x0y0 = terrain.get(x, y);
      double x0y1 = terrain.get(x, y + s);
      double x1y0 = terrain.get(x + s, y);
      double x1y1 = terrain.get(x + s, y + s);
      double x0Avg = (x0y0 + x0y1) / 2.0;
      double x1Avg = (x1y0 + x1y1) / 2.0;
      double avg = (x0Avg + x1Avg) / 2.0;
      double displacement = displacement(i);
      val = avg + displacement;
      if (val > 1 || val < 0)
         val = avg;
      terrain.set(xHalf, yHalf, val);

      // square
      double y0Avg = (x0y0 + x1y0) / 2.0;
      double y1Avg = (x0y1 + x1y1) / 2.0;
      terrain.set(xHalf, y, y0Avg);
      terrain.set(xHalf, y + s, y1Avg);
      terrain.set(x, yHalf, x0Avg);
      terrain.set(x + s, yHalf, x1Avg);

      if (halfSize > 1) {
         i++;
         int halfSizePlus = halfSize + 1;
         perform(terrain, x, y, halfSizePlus, i);
         perform(terrain, xHalf, y, halfSizePlus, i);
         perform(terrain, x, yHalf, halfSizePlus, i);
         perform(terrain, xHalf, yHalf, halfSizePlus, i);
      }
   }

   protected void seed(Terrain terrain, int x, int y, int size) {
      int s = size - 1;
      terrain.set(x, y, random.nextDouble());
      terrain.set(x, y + s, random.nextDouble());
      terrain.set(x + s, y, random.nextDouble());
      terrain.set(x + s, y + s, random.nextDouble());
   }

   private double displacement(int i) {
      double val = random.nextDouble();
      val = ((val * 2) - 1) / (1 << (i + 1));
      return val;
   }

}
