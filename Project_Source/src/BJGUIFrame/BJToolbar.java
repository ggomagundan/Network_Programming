package BJGUIFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import BJGUIConstant.BJConstant;
import BJGUIConstant.BJConstant.EToolBarButtons;


public class BJToolbar extends JToolBar {

	private ButtonGroup buttonGroup;
	private BJPanel drawingPanel;
	private GEToolBarHandler shapeToolBarHandler;

	public BJToolbar(String label) {
		super(label);
		buttonGroup = new ButtonGroup();
		JRadioButton rButton = null;
		shapeToolBarHandler = new GEToolBarHandler();
		for (EToolBarButtons btn : EToolBarButtons.values()) {
			rButton = new JRadioButton();
			rButton.setIcon(new ImageIcon(BJConstant.IMG_URL + btn.toString()
					+ BJConstant.SUFFIX_TOOLBAR_BTN));

			rButton.setSelectedIcon(new ImageIcon(BJConstant.IMG_URL
					+ btn.toString() + BJConstant.SUFFIX_TOOLBAR_BTN_SLT));
			rButton.addActionListener(shapeToolBarHandler);
			rButton.setActionCommand(btn.toString());
			this.add(rButton);
			buttonGroup.add(rButton);
		}
	}

	public void init(BJPanel dp) {
		drawingPanel = dp;
		setSize(BJConstant.WIDTH_SHAPETOOLBAR, BJConstant.HEIGHT_SHAPETOOLBAR);
		
	}
	
	
	private class GEToolBarHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JRadioButton button = (JRadioButton) e.getSource();
			if (button.getActionCommand().equals(
					EToolBarButtons.New.toString())) {
					JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f, "새로 만들기.");
			} else if (button.getActionCommand().equals(
					EToolBarButtons.Open.toString())) {
						JFileChooser fileDialog = new JFileChooser(new File("."));
					fileDialog.showOpenDialog(null);
					File file = fileDialog.getSelectedFile();
					ObjectInputStream in = null;
				if (file != null) {
					try {
						in = new ObjectInputStream(new BufferedInputStream(
								new FileInputStream(file)));
						Object obj = in.readObject();
					} catch (IOException e2) {
						e2.printStackTrace();
					} catch (ClassNotFoundException e2) {
						e2.printStackTrace();
					} finally {
						try {
							if (in != null)
								in.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
				}
			} else if (button.getActionCommand().equals(
					EToolBarButtons.Save.toString())) {
				JFileChooser fileDialog = new JFileChooser(new File("."));
				fileDialog.showSaveDialog(null);
				File file = fileDialog.getSelectedFile();
				ObjectOutputStream out = null;
				if (file != null) {
					try {
						out = new ObjectOutputStream(new BufferedOutputStream(
								new FileOutputStream(file)));
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						try {
							if (out != null)
								out.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
				}
			}
		}
	}
}
