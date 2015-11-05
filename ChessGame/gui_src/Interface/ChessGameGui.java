/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LoboAlfa2.0
 */
public class ChessGameGui extends JFrame{
    private final Dimension nativeScreenSize;
    private int xPosition=0, yPosition=0;
    private JPanel mainPanel;
    
    public ChessGameGui(){
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nativeScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainPanel = new JPanel();
        this.setContentPane(mainPanel);
    }
    
}
