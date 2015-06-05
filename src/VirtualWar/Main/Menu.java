package VirtualWar.Main;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Menu extends JFrame{    // Your class name
	
	private JFrame options;
	
	public Menu(){
	      super("Virtual War");
	      setSize(700, 500);
	      setResizable(false);
	      setLocation(300,200);
	      
	      GridBagLayout gridBagLayout = new GridBagLayout();
	      gridBagLayout.columnWidths = new int[]{684, 0};
	      gridBagLayout.rowHeights = new int[]{461, 0};
	      gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	      gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
	      getContentPane().setLayout(gridBagLayout);
	      
	      JPanel panel = new JPanel();
	      panel.setBackground(new Color(165, 42, 42));
	      panel.setLayout(null);
	      GridBagConstraints gbc_panel = new GridBagConstraints();
	      gbc_panel.fill = GridBagConstraints.BOTH;
	      gbc_panel.gridx = 0;
	      gbc_panel.gridy = 0;
	      getContentPane().add(panel, gbc_panel);

	      
	      JButton btnPlay = new JButton("PLAY");
	      btnPlay.setBounds(269, 153, 145, 44);
	      btnPlay.addMouseListener(new MouseAdapter() {
	  		
	  		@Override
	  		public void mouseClicked(MouseEvent e) {
	  			// TODO Auto-generated method stub
	  			new Main();
	  		}
	  		});
	      panel.add(btnPlay);
	      
	      JButton btnOptions = new JButton("OPTIONS");
	      btnOptions.setBounds(269, 209, 145, 44);
	      btnOptions.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				options();
			}
		});
	      panel.add(btnOptions);
	      
	      JButton btnQuit = new JButton("QUIT");
	      btnQuit.setBounds(269, 264, 145, 50);
	      btnQuit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	      panel.add(btnQuit);
	      
	      JLabel lblVirtualWar = new JLabel("VirtualWar");
	      lblVirtualWar.setForeground(new Color(255, 255, 255));
	      lblVirtualWar.setFont(new Font("Tahoma", Font.PLAIN, 50));
	      lblVirtualWar.setBounds(223, 63, 260, 55);
	      panel.add(lblVirtualWar);
	      setVisible(true);
	      
	    }
	
	public void options(){
		options = new JFrame();
		options.setTitle("Options");
	    options.setSize(700, 500);
	    options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    options.setResizable(false);
	    options.setLocation(300,200);
	    
	      GridBagLayout gridBagLayout = new GridBagLayout();
	      gridBagLayout.columnWidths = new int[]{684, 0};
	      gridBagLayout.rowHeights = new int[]{461, 0};
	      gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	      gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
	      options.getContentPane().setLayout(gridBagLayout);
	    
	    JButton btnRetour = new JButton("Retour");
	    btnRetour.setBounds(300, 200, 100, 50);
	    btnRetour.addMouseListener(new MouseAdapter(){
	  		public void mouseClicked(MouseEvent e) {
	  			// TODO Auto-generated method stub
	  			options.setVisible(false);
	  		}    	
	    });
	    options.add(btnRetour);
	    
	    
	    options.setVisible(true);
	}
	
	
   public static void main(String[] args) {
      
	   Menu menu = new Menu();
      
    }
}