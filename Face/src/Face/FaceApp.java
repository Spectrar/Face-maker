/**
 * 
 */
package Face;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

/**
*Assignment: A06 Face
*Class: FaceApp.java
*Programmer: Brandon Robinson
*Date: Mar 23, 2017
*/
public class FaceApp extends JFrame {
	
	/**
	 * Icon eyes1 first eye image
	 */
	private Icon eyes1=new ImageIcon(getClass().getResource("eye1.png"));
	/**
	 * Icon eyes2 second eye image
	 */
	private Icon eyes2=new ImageIcon(getClass().getResource("eye2.png"));
	/**
	 * Icon eyes3 third eye image
	 */
	private Icon eyes3=new ImageIcon(getClass().getResource("eye3.png"));
	/**
	 * Icon nose1 first nose image
	 */
	private Icon nose1=new ImageIcon(getClass().getResource("nose1.png"));
	/**
	 * Icon nose2 second nose image
	 */
	private Icon nose2=new ImageIcon(getClass().getResource("nose2.png"));
	/**
	 * Icon nose3 third nose image
	 */
	private Icon nose3=new ImageIcon(getClass().getResource("nose3.png"));
	/**
	 * Icon mouth1 first mouth image
	 */
	private Icon mouth1=new ImageIcon(getClass().getResource("mouth1.png"));
	/**
	 * Icon mouth2 second mouth image
	 */
	private Icon mouth2=new ImageIcon(getClass().getResource("mouth2.png"));
	/**
	 * Icon mouth3 third mouth image
	 */
	private Icon mouth3=new ImageIcon(getClass().getResource("mouth3.png"));
	/**
	 * Icon curEye current eye image being used
	 */
	private Icon curEye=eyes1;
	/**
	 * Icon curNose current nose image being used
	 */
	private Icon curNose=nose1;
	/**
	 * Icon curMouth current mouth image being used
	 */
	private Icon curMouth=mouth1;
	/**
	 * JPanel contentPane
	 */
	private JPanel contentPane;
	/**
	 * JPanel panel_1 side panel used for the check boxes and button
	 */
	private JPanel panel_1;
	/**
	 * JLabel lblEyes label used for the eye images
	 */
	private JLabel lblEyes;
	/**
	 * JLabel lblNose label used for the nose images
	 */
	private JLabel lblNose;
	/**
	 * JLabel lblMouth label used for the mouth images
	 */
	private JLabel lblMouth;
	/**
	 * JCheckBox eyeBox check box for the eyes
	 */
	private JCheckBox eyeBox;
	/**
	 * JCheckBox noseBox check box for the nose
	 */
	private JCheckBox noseBox;
	/**
	 * JCheckBox mouthBox check box for the mouth
	 */
	private JCheckBox mouthBox;
	/**
	 * Head pnlHead paints the head
	 */
	private Head pnlHead;
	/**
	 * Panel facePanel the panel containing all the face elements
	 */
	private Panel facePanel;

	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FaceApp frame = new FaceApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 */
	public FaceApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		createSidePanel(panel_1);
		
		facePanel = new Panel();
		createFacePanel(facePanel);
		
	}

	/**
	 * creates panel containing face elements
	 * @param facePanel 
	 */
	private void createFacePanel(Panel facePanel) {
		facePanel.setBackground(Color.BLUE);
		contentPane.add(facePanel, BorderLayout.CENTER);
		pnlHead = new Head();
		pnlHead.setBackground(Color.BLUE);
		getContentPane().add(pnlHead);
		pnlHead.setLayout(null);
		
		lblEyes = new JLabel("");
		lblEyes.setBounds(189, 104, 350, 100);
		pnlHead.add(lblEyes);
		lblEyes.setIcon(curEye);
		
		lblNose = new JLabel("");
		lblNose.setBounds(189, 164, 350, 100);
		pnlHead.add(lblNose);
		lblNose.setIcon(curNose);
		
		lblMouth = new JLabel("");
		lblMouth.setBounds(189, 242, 350, 100);
		pnlHead.add(lblMouth);
		lblMouth.setIcon(curMouth);
	}

	/**
	 * creates for the check boxes and button
	 * @param panel 
	 */
	private void createSidePanel(JPanel panel) {
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("You Choose...");
		createSideLabel(panel, lblNewLabel);
		
		eyeBox = new JCheckBox("Eyes");
		eyeBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		createEyeBox(panel, eyeBox);
		
		noseBox = new JCheckBox("Nose");
		noseBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		createNoseBox(panel, noseBox);
		
		mouthBox = new JCheckBox("Mouth");
		mouthBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		createMouthBox(panel, mouthBox);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		createUpdateBtn(btnUpdate);
	}

	/**
	 * btn for updating the face image
	 * @param btnUpdate 
	 */
	private void createUpdateBtn(JButton btnUpdate) {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (eyeBox.isSelected()==true) {
					if (curEye == eyes1) {
						curEye = eyes2;
					} else if (curEye == eyes2) {
						curEye = eyes3;
					} else {
						curEye = eyes1;
					} 
				}
				
				if (noseBox.isSelected()==true) {
					if (curNose == nose1) {
						curNose = nose2;
					} else if (curNose == nose2) {
						curNose = nose3;
					} else {
						curNose = nose1;
					} 
				}
				
				if (mouthBox.isSelected()==true) {
					if (curMouth == mouth1) {
						curMouth = mouth2;
					} else if (curMouth == mouth2) {
						curMouth = mouth3;
					} else {
						curMouth = mouth1;
					} 
				}
				if (eyeBox.isSelected()==false && noseBox.isSelected()==false && mouthBox.isSelected()==false)
					pnlHead.changeColor();
					
					
				
				lblEyes.setIcon(curEye);
				lblNose.setIcon(curNose);
				lblMouth.setIcon(curMouth);
				pnlHead.repaint();
			}
		});
		panel_1.add(btnUpdate);
	}

	/**
	 * creates check box for the mouth
	 * @param panel
	 * @param chckbxNewCheckBox_2
	 * 
	 */
	private void createMouthBox(JPanel panel, JCheckBox chckbxNewCheckBox_2) {
		chckbxNewCheckBox_2.setBackground(Color.LIGHT_GRAY);
		panel.add(chckbxNewCheckBox_2);
	}

	/**
	 * creates check box for the nose
	 * @param panel
	 * @param chckbxNewCheckBox_1
	 * 
	 */
	private void createNoseBox(JPanel panel, JCheckBox chckbxNewCheckBox_1) {
		chckbxNewCheckBox_1.setBackground(Color.LIGHT_GRAY);
		panel.add(chckbxNewCheckBox_1);
	}

	/**
	 * creates check box for the eyes
	 * @param panel
	 * @param chckbxNewCheckBox
	 * 
	 */
	private void createEyeBox(JPanel panel, JCheckBox chckbxNewCheckBox) {
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		panel.add(chckbxNewCheckBox);
	}

	/**
	 * creates label for the side panel
	 * @param panel
	 * @param lblNewLabel
	 * 
	 */
	private void createSideLabel(JPanel panel, JLabel lblNewLabel) {
		panel_1.setLayout(new GridLayout(13, 1, 20, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
	}
}
