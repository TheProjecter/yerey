package com.minimalabs.yerey;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TerrainFrame extends JFrame {

   private TerrainPanel terrainPanel;
   private int size = (1<<6)+1;
   private double scale = 10;
   Dimension dimension = new Dimension(size, size);
   private TerrainGenerator terrainGenerator = createGenerator();
   private final TerrainRenderer terrainRenderer = new PlainGroundRenderer();

   public TerrainFrame() throws HeadlessException {
      super();
      JPanel p = getTerrainPanel();
      getContentPane().add(p);
   }

   public JPanel getTerrainPanel() {
      if (terrainPanel == null) {
         TerrainRenderer renderer = getRenderer();
         TerrainGenerator generator = getTerrainGenerator();
         terrainPanel = new TerrainPanel(generator, renderer, scale);
         addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               terrainPanel.setTerrainGenerator(createGenerator());
               terrainPanel.repaint();
            }

         });
      }
      return terrainPanel;
   }

   protected TerrainRenderer getRenderer() {
      return terrainRenderer;
   }

   protected TerrainGenerator createGenerator() {
      //return new GradientTerrainGenerator(dimension);
      return new FractalTerrainGenerator(dimension);
   }

   public TerrainGenerator getTerrainGenerator() {
      return terrainGenerator;
   }

   
}
