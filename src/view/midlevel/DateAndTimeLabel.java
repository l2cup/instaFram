package view.midlevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class DateAndTimeLabel extends JLabel implements ActionListener {

	private Timer timer;
	private SimpleDateFormat sdf;

	public DateAndTimeLabel() {
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		timer = new Timer(1000, this);
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setText(sdf.format(new Date()));
	}

}
