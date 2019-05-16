package rubiks_cube;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CubeSolverApp {
	private static JFrame frame;
	private static JPanel cubePanel, solutionPanel;
	private final Dimension D = Toolkit.getDefaultToolkit().getScreenSize();
	private final int WIDTH = (int) D.getWidth();
	private final int HEIGHT = (int) (D.getHeight() * 0.94);
	private final String TITLE = "Rubik's Cube Solver";

	public CubeSolverApp() {
		prepareCubePanel();
		prepareSolutionPanel();
		prepareFrame();
		showFrame();
	}

	private void prepareCubePanel() {
		cubePanel = new JPanel();
		cubePanel.setBounds(0, 0, WIDTH / 2, HEIGHT);
		cubePanel.setBackground(Color.RED);
	}

	private void prepareSolutionPanel() {
		solutionPanel = new JPanel();
		solutionPanel.setBounds(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
		solutionPanel.setBackground(Color.GREEN);
	}

	private void prepareFrame() {
		frame = new JFrame(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(cubePanel);
		frame.add(solutionPanel);
	}

	private void showFrame() {
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new CubeSolverApp();
	}
}