import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class otchuzhdenieGUI extends JFrame implements ActionListener{
	JPanel mainPanel;
	JButton button_done;
	JLabel dayLabel1, monthLabel1, yearLabel1,dayLabel2, monthLabel2;
	JTextField dayText1, monthText1, yearText1, dayText2, monthText2;
	
	JLabel naryadLabel, bumagaLabel;
	JTextField naryadText, bumagaText;
	
	static JLabel info_second;
	
	String firstDay = null;
	String firstMonth = null;
	String year = null;
	
	String secondDay = null;
	String secondMonth = null;
	
	String naryad = null;
	String bumaga = null;
	
	private Container cp;
	
	public otchuzhdenieGUI() {
		
		cp = getContentPane();
		//mainPanel = new JPanel();
		cp.setLayout(null);
		
		button_done = new JButton("Готово");
		button_done.setBounds(10,220,200,50);
		
		dayLabel1 = new JLabel("День :");//-------------
		dayLabel1.setBounds(10, 20, 50, 30);
		
		dayText1 = new JTextField();
		dayText1.setBounds(60, 25, 100, 25);
		
		monthLabel1 = new JLabel("Месяц :");
		monthLabel1.setBounds(10, 70, 50, 30);
		
		monthText1 = new JTextField();
		monthText1.setBounds(60, 75, 100, 25);
		
		dayLabel2 = new JLabel("День :");//------------
		dayLabel2.setBounds(200, 20, 50, 30);
		
		dayText2 = new JTextField();
		dayText2.setBounds(250, 25, 100, 25);
		
		monthLabel2 = new JLabel("Месяц :");
		monthLabel2.setBounds(200, 70, 50, 30);
		
		monthText2 = new JTextField();
		monthText2.setBounds(250, 75, 100, 25);
		
		yearLabel1 = new JLabel("Год :");
		yearLabel1.setBounds(10, 120, 50, 30);
		
		yearText1 = new JTextField();
		yearText1.setBounds(60, 125, 100, 25);
		
		naryadLabel = new JLabel("Наряд :");
		naryadLabel.setBounds(390, 20, 50, 30);
		
		naryadText = new JTextField();
		naryadText.setBounds(460, 25, 100, 25);
		
		bumagaLabel = new JLabel("Упаковка :");
		bumagaLabel.setBounds(390, 70, 80, 30);
		
		bumagaText = new JTextField();
		bumagaText.setBounds(460, 75, 100, 25);
		
		info_second = new JLabel("-");
		info_second.setOpaque(true);
		info_second.setForeground(Color.red);
		info_second.setBounds(300, 220 , 400, 50);
		
		cp.add(button_done);
		cp.add(dayText1);
		cp.add(dayLabel1);
		cp.add(monthText1);
		cp.add(monthLabel1);
		cp.add(dayText2);
		cp.add(dayLabel2);
		cp.add(monthText2);
		cp.add(monthLabel2);
		cp.add(yearText1);
		cp.add(yearLabel1);
		cp.add(info_second);
		cp.add(naryadText);
		cp.add(naryadLabel);
		cp.add(bumagaText);
		cp.add(bumagaLabel);
		
		button_done.addActionListener(this);
		
		setTitle("Отчуждение");
		setLocation(500,100);
		setVisible(true);
		setBounds(550, 250, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_done) {
			firstDay = dayText1.getText();
			firstMonth = monthText1.getText();
			year = yearText1.getText();
			
			secondDay = dayText2.getText();
			secondMonth = monthText2.getText();
			
			naryad = naryadText.getText();
			bumaga = bumagaText.getText();
			
			if(GUI.numberChecker(firstDay, firstMonth, year)) {
				if(GUI.numberChecker(secondDay, secondMonth, year)) {
					if(GUI.numberChecker(naryad, bumaga, year)) {
						int firstDayNum = Integer.parseInt(firstDay);
						int firstMonthNum = Integer.parseInt(firstMonth);
						int secondDayNum = Integer.parseInt(secondDay);
						int secondMonthNum = Integer.parseInt(secondMonth);
						int yearNum = Integer.parseInt(year);
						
						if(dateChecker(firstDayNum, firstMonthNum, yearNum)) {
							if(dateChecker(secondDayNum, secondMonthNum, yearNum)) {
								int firstdays = GUI.dayCounter(firstDay, firstMonth, year);
								int seconddays = GUI.dayCounter(secondDay, secondMonth, year);
								if(firstdays < seconddays) {
									try {
										createfile(year, firstdays, seconddays, naryad, bumaga);
										JOptionPane.showMessageDialog(null, "Добавлено!");
									} catch (IOException e1) {
										info_second.setText("Не получилось, проверьте данные");
									}
								} else info_second.setText("Неверно введены даты");
							}
						}
					}else info_second.setText("Введите число");
				}else info_second.setText("Введите число");
			}else info_second.setText("Введите число");
		}
	}
	
	public static void createfile(String year, int firstdays, int seconddays, String naryad, String bumaga) throws IOException {
		
		if(Integer.parseInt(year) < 2020) {
			File directory = new File("C:\\Public\\NotariusDB\\otchuzhdenie\\20142019");
			int fileCount = directory.list().length + 1;
			FileWriter writehandle = new FileWriter("C:\\Public\\NotariusDB\\otchuzhdenie\\20142019\\"+ fileCount +".txt");
			BufferedWriter writer = new BufferedWriter(writehandle);
			writer.write(firstdays + "_" + seconddays + "_" + bumaga + "_" + naryad);
			writer.close();
			writehandle.close();
		} else {
			File directory = new File("C:\\Public\\NotariusDB\\otchuzhdenie\\20202029");
			int fileCount = directory.list().length + 1;
			FileWriter writehandle = new FileWriter("C:\\Public\\NotariusDB\\otchuzhdenie\\20202029\\"+ fileCount +".txt");
			BufferedWriter writer = new BufferedWriter(writehandle);
			writer.write(firstdays + "_" + seconddays + "_" + bumaga + "_" + naryad);
			writer.close();
			writehandle.close();
		}
		
	}

	public static boolean dateChecker(int day, int month, int year) {
		if(year < 2014) 
		{
			info_second.setText("Укажите год больше 2014");
			return false;
		}
		
		if(month < 1|| month > 12) 
		{
			info_second.setText("Укажите правильный месяц");
			return false;
		}
		
		if (day <= 0 || day >= 32) 
		{
			info_second.setText("Укажите правильный день");
			return false;
		}
		
		if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) 
		{
			info_second.setText("Укажите правильный день");
			return false;
		}
		if(month == 2 && day >= 30) 
		{
			info_second.setText("Укажите правильный день для февраля ");
			return false;
		}
		
		if (year % 4 != 0 && (month == 2 && day == 29)) 
		{
			info_second.setText("Укажите правильный день");
			return false;
		}
		
		return true;
	}
}
