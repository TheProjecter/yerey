package com.minimalabs.yerey;

import java.awt.Dimension;

public abstract class TerrainGenerator {

   protected final Dimension size;
   
   private Terrain terrain;

   public TerrainGenerator(Dimension size) {
      super();
      this.size = size;
   }

   public Dimension getSize() {
      return size;
   }

   public Terrain getTerrain() {
      if (terrain == null) {
         terrain = nextTerrain();
      }
      return terrain;
   }

   public Terrain nextTerrain() {
      terrain = generate();
      return terrain;
   }
   
   protected abstract Terrain generate();

}
