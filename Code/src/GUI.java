import java.awt.*;
import javax.swing.*;

public class GUI {
	
	public GUI() {
		JFrame frame = new JFrame();

		JPanel panel = new JPanel(new CardLayout());
		
		panel.setBorder(BorderFactory.createEmptyBorder(20,50,0,50)); 
		
		
		JMenuBar menuBar = new JMenuBar();
		
		Image icon = Toolkit.getDefaultToolkit().getImage("ressource/SmallLogo.png");

		ImageIcon im = new ImageIcon("ressource/BigLogo.png");
		im = scaleImage(im, 250, 250);
		JLabel image = new JLabel(im);
		
		panel.add(image);
		
		JMenu menu = new JMenu("A Menu");
		menu.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Premiere fenetre");
		
		JRadioButton radio1 = new JRadioButton("Visualiser");
		JRadioButton radio2 = new JRadioButton("Comparer");
		panel.add(radio1);
		panel.add(radio2);
		
		JLabel label = new JLabel("Blabla");
		panel.add(label);
		frame.pack();
		frame.setVisible(true);
		frame.setIconImage(icon);    
		frame.setJMenuBar(menuBar);
	}
	
	public ImageIcon scaleImage(ImageIcon icon, int w, int h)
    {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }

	public static void main(String[] args) {
		new GUI();
	}

}
