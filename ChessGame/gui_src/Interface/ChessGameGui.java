/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LoboAlfa2.0
 */
public class ChessGameGui extends JFrame{
    private final Dimension nativeScreenSize;
    private int xPosition=0, yPosition=0;
    private JPanel mainPanel, boardPanel;
    private JLabel whitePieces, blackPieces;
    private JButton squares[][];
    private GridLayout squaresLayout;
    
    public ChessGameGui(){
        //this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nativeScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainPanel = new JPanel(new BorderLayout());
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        mainPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.decode("#464646")));
        this.getContentPane().setBackground(Color.decode("#282828"));
        whitePieces = new JLabel("BLANCAS");
        mainPanel.add(whitePieces, BorderLayout.NORTH);
        boardPanel = new JPanel();
        GridLayout squaresLayout = new GridLayout(0,8);
        boardPanel.setLayout(squaresLayout);
        mainPanel.add(boardPanel, BorderLayout.CENTER);
        blackPieces = new JLabel("NEGRAS");
        mainPanel.add(blackPieces, BorderLayout.SOUTH);
        squares = new JButton[8][8];
        initializeSquares();
        setPieces();
        this.pack();
        
        xPosition = (int)((nativeScreenSize.getWidth()/2)-(this.getWidth()/2));
        yPosition = (int)((nativeScreenSize.getHeight()/2)-(this.getHeight()/2));
        this.setBounds(xPosition,yPosition,this.getWidth(),this.getHeight());
    }
    
    public void initializeSquares(){
        String pieceColor;
        for(int i=0;i<8;i++){
            if(i%2 == 0)
                pieceColor = "WHITE";
            else
                pieceColor = "BLACK";
            for(int j=0;j<8;j++){
                if(i==-1){
                    squares[i][j] = new JButton(String.valueOf(Character.toChars(65+j)));
                    squares[i][j].setVerticalTextPosition(AbstractButton.TOP);
                    squares[i][j].setHorizontalTextPosition(AbstractButton.CENTER);
                }
                else
                    squares[i][j] = new JButton();
                if(pieceColor.equals("WHITE")){
                    squares[i][j].setBackground(Color.WHITE);
                    squares[i][j].setPreferredSize(new Dimension(75,75));
                    pieceColor = "BLACK";
                    
                }
                else{
                    squares[i][j].setBackground(Color.BLACK);
                    squares[i][j].setPreferredSize(new Dimension(75,75));
                    pieceColor = "WHITE";
                }
                boardPanel.add(squares[i][j]);
            }
        }
    }
    
    public void setPieces(){
        ImageIcon whitePawn = new ImageIcon("gui_src/Images/white/pawn.png");
        ImageIcon whiteRook = new ImageIcon("gui_src/Images/white/rook.png");
        ImageIcon whiteKnight = new ImageIcon("gui_src/Images/white/knight.png");
        ImageIcon whiteBishop = new ImageIcon("gui_src/Images/white/bishop.png");
        ImageIcon whiteQueen = new ImageIcon("gui_src/Images/white/queen.png");
        ImageIcon whiteKing = new ImageIcon("gui_src/Images/white/king.png");
        
        ImageIcon blackPawn = new ImageIcon("gui_src/Images/black/pawn.png");
        ImageIcon blackRook = new ImageIcon("gui_src/Images/black/rook.png");
        ImageIcon blackKnight = new ImageIcon("gui_src/Images/black/knight.png");
        ImageIcon blackBishop = new ImageIcon("gui_src/Images/black/bishop.png");
        ImageIcon blackQueen = new ImageIcon("gui_src/Images/black/queen.png");
        ImageIcon blackKing = new ImageIcon("gui_src/Images/black/king.png");
        
        squares[0][0].setIcon(whiteRook);
        squares[0][7].setIcon(whiteRook);
        squares[0][1].setIcon(whiteKnight);
        squares[0][6].setIcon(whiteKnight);
        squares[0][2].setIcon(whiteBishop);
        squares[0][5].setIcon(whiteBishop);
        squares[0][4].setIcon(whiteQueen);
        squares[0][3].setIcon(whiteKing);
        
        squares[7][0].setIcon(blackRook);
        squares[7][7].setIcon(blackRook);
        squares[7][1].setIcon(blackKnight);
        squares[7][6].setIcon(blackKnight);
        squares[7][2].setIcon(blackBishop);
        squares[7][5].setIcon(blackBishop);
        squares[7][4].setIcon(blackQueen);
        squares[7][3].setIcon(blackKing);
        
        for(int j=0;j<8;j++){
            squares[1][j].setIcon(whitePawn);
            squares[6][j].setIcon(blackPawn);
        }
    }
}
