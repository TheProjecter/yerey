package com.minimalabs.yerey;

import javax.swing.JFrame;

public class Main {

   /**
    * @param args
    */
   public static void main(String[] args) {
      JFrame p = new TerrainFrame();
      p.pack();
      p.setVisible(true);
      p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}
