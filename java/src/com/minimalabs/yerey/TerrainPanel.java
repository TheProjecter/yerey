package com.minimalabs.yerey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TerrainPanel extends JPanel {

   private TerrainGenerator terrainGenerator;
   private TerrainRenderer renderer;
   private final double scale;

   public TerrainPanel(TerrainGenerator terrainGenerator, TerrainRenderer renderer, double scale) {
      setTerrainGenerator(terrainGenerator);
      this.renderer = renderer;
      this.scale = scale;
      reset();
   }

   public void reset() {
      Dimension size = terrainGenerator.getSize();
      int width = (int) Math.ceil(size.width * scale);
      int height = (int) Math.ceil(size.height * scale);
      Dimension scaled = new Dimension(width, height);
      setMinimumSize(scaled);
      setPreferredSize(scaled);
   }
   
   public TerrainGenerator getTerrainGenerator() {
      return terrainGenerator;
   }

   public void setTerrainGenerator(TerrainGenerator terrainGenerator) {
      this.terrainGenerator = terrainGenerator;
   }

   public void paint(Graphics g) {
      Terrain terrain = terrainGenerator.getTerrain();
      Dimension size = terrain.getSize();
      Color color;
      int rw = (int) Math.ceil(scale);
      int rh = (int) Math.ceil(scale);
      for (int x = 0; x < size.width; x++) {
         for (int y = 0; y < size.height; y++) {
            double value = terrain.get(x,y);
            color = renderer.render(value);
            g.setColor(color);
            int rx = (int) Math.ceil(x * scale);
            int ry = (int) Math.ceil(y * scale);
            g.fillRect(rx, ry, rw, rh);
         }
      }
   }

   
}
