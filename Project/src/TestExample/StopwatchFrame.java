package TestExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchFrame extends JFrame {
	private JLabel timeLabel;
	private JButton startButton;
	private JButton pauseButton;
	private Timer timer;
	private long startTime;
	private long pausedTime;
	private boolean isRunning;

	public StopwatchFrame() {
		setTitle("스탑워치");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		timeLabel = new JLabel("00:00:00");
		timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(timeLabel);

		startButton = new JButton("시작");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startStopwatch();
			}
		});
		panel.add(startButton);

		pauseButton = new JButton("일시정지");
		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseStopwatch();
			}
		});
		panel.add(pauseButton);

		add(panel);
	}

	private void startStopwatch() {
		if (!isRunning) {
			startTime = System.currentTimeMillis() - pausedTime;
			timer.start();
			isRunning = true;
			startButton.setEnabled(false);
			pauseButton.setEnabled(true);
		}
	}

	private void pauseStopwatch() {
		if (isRunning) {
			timer.stop();
			pausedTime = System.currentTimeMillis() - startTime;
			isRunning = false;
			startButton.setEnabled(true);
			pauseButton.setEnabled(false);
		}
	}

	private void updateTimerLabel() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		long milliseconds = (elapsedTime % 1000) / 10;
		long seconds = (elapsedTime / 1000) % 60;
		long minutes = (elapsedTime / 1000 / 60) % 60;
		String timeText = String.format("%02d:%02d:%02d", minutes, seconds, milliseconds);
		timeLabel.setText(timeText);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StopwatchFrame frame = new StopwatchFrame();

				frame.timer = new Timer(10, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.updateTimerLabel();
					}
				});

				frame.startButton.setEnabled(true);
				frame.pauseButton.setEnabled(false);

				frame.setVisible(true);
			}
		});
	}
}