package BJGUIMenus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import BJGUIConstant.BJConstant.EFileMenuItems;
import BJGUIFrame.BJPanel;


public class BJMenuFile extends JMenu {

	private BJPanel blackJackPanel;
	private FileMenuHandler fileMenuHandler;

	public BJMenuFile(String label) {
		super(label);
		this.setMnemonic(KeyEvent.VK_F);
		fileMenuHandler = new FileMenuHandler();
		for (EFileMenuItems btn : EFileMenuItems.values()) {
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(fileMenuHandler);
			menuItem.setActionCommand(btn.toString());
			setACC(menuItem);
			this.add(menuItem);
		}
	}

	public void init(BJPanel blackJackPanel) {
		this.blackJackPanel = blackJackPanel; 
		//operationOpen();
	}

	private void newFile() {
	}

	@SuppressWarnings("unchecked")
	public void open() {
		JFileChooser fileDialog = new JFileChooser(new File("."));
		fileDialog.showOpenDialog(null);
		File file = fileDialog.getSelectedFile();
		ObjectInputStream in = null;
		if (file != null) {
			try {
				in = new ObjectInputStream(new BufferedInputStream(
						new FileInputStream(file)));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null)
						in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void save() {
		JFileChooser fileDialog = new JFileChooser(new File("."));
		fileDialog.showSaveDialog(null);
		File file = fileDialog.getSelectedFile();
		ObjectOutputStream out = null;
		if (file != null) {
			try {
				out = new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream(file)));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null)
						out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void othersave() {
		JFileChooser fileDialog = new JFileChooser(new File("."));
		fileDialog.showSaveDialog(null);
		File file = fileDialog.getSelectedFile();
		ObjectOutputStream out = null;
		if (file != null) {
			try {
				out = new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream(file)));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null)
						out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void exitsave() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream("saveall")));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void operationOpen() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream("saveall")));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void close() {
		JFrame f = new JFrame();
		int chk = JOptionPane.showConfirmDialog(f, "정말로 종료하시겠습니까?", "종료확인", 1);
		if (chk == 0) {
			JOptionPane.showMessageDialog(f, "종료합니다.");
			exitsave();
			System.exit(0);
		}
	}

	private class FileMenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (EFileMenuItems.valueOf(e.getActionCommand())) {
			/*case 새로만들기:
				newFile();
				break; //
			case 열기:
				open();
				break; //
			case 저장:
				save();
				break; //
			case 다른이름으로저장:
				othersave();
				break; //*/
			case 종료:
				close();
				break;
			}
		}
	}

	public void setACC(JMenuItem item) {
		if (item.getActionCommand().equals("종료")) {
			this.addSeparator();
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
					InputEvent.CTRL_DOWN_MASK));
			// Exit 단축키 설정
		}
	}
}