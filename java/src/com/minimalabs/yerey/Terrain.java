package com.minimalabs.yerey;

import java.awt.Dimension;

public class Terrain {

   private final Dimension size;
   private double[][] data;

   public Terrain(Dimension size) {
      this.size = size;
      this.data = new double[size.width][size.height];
   }

   public Dimension getSize() {
      return size;
   }

   public void set(int x, int y, double value) {
      if(x<size.width && y<size.height)
         data[x][y] = value;
   }

   public double get(int x, int y) {
      if(x<size.width && y<size.height)
         return data[x][y];
      return -1;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      for (int x = 0; x < size.height; x++) {
         for (int y = 0; y < size.width; y++) {
            builder.append("[").append(data[x][y]).append("]");
         }
         builder.append("\n");
      }
      return builder.toString();
   }


   
}
