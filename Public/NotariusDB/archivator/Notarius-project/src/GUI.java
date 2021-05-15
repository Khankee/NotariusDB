
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.String;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	
	JPanel mainPanel;
	
	JLabel dayLabel, monthLabel, yearLabel;
	JTextField dayText, monthText, yearText;
	
	JLabel enterinfoLabel, chooseinfoLabel;
	
	JButton otchuzhdenie_GetInfo_button;
	JButton otchuzhdenie_SetInfo_button;
	JLabel otchuzhdenie_info_label;
	
	JButton nasledstvie_GetInfo_button;
	JButton nasledstvie_SetInfo_button;
	JLabel nasledstvie_info_label;
	
	JButton prochee_GetInfo_button;
	JButton prochee_SetInfo_button;
	JLabel prochee_info_label;
	
	JButton zalog_GetInfo_button;
	JButton zalog_SetInfo_button;
	JLabel zalog_info_label;
	
	
	static JLabel info;
	
	String day = "0";
	String month = "0";
	String year = "2014";
	

	int[] range = new int[4];
	
	
	public GUI() {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		enterinfoLabel = new JLabel("Введите дату:");
		enterinfoLabel.setBounds( 30 , 10 , 100 , 30);
		
		dayLabel = new JLabel("День :");
		dayLabel.setBounds(30, 50, 50, 30);
		
		dayText = new JTextField();
		dayText.setBounds(80, 55, 100, 25);
		
		monthLabel = new JLabel("Месяц :");
		monthLabel.setBounds(30, 100, 50, 30);
		
		monthText = new JTextField();
		monthText.setBounds(80, 105, 100, 25);
		
		yearLabel = new JLabel("Год :");
		yearLabel.setBounds(30, 150, 50, 30);
		
		yearText = new JTextField();
		yearText.setBounds(80, 155, 100, 25);
		
		chooseinfoLabel = new JLabel("Выберите документ:                               Информация:                                                    Внести новую информацию: ");
		chooseinfoLabel.setBounds(30, 250 , 800 , 30);
		
		otchuzhdenie_GetInfo_button = new JButton("Отчуждение недвижимости");
		otchuzhdenie_GetInfo_button.setBounds(30,300,200,50);
		
		otchuzhdenie_info_label = new JLabel("-");
		otchuzhdenie_info_label.setBounds(250,300,300,50);
		
		otchuzhdenie_SetInfo_button = new JButton("Добавить в архив");
		otchuzhdenie_SetInfo_button.setBounds(500,300,200,50);
		
		nasledstvie_GetInfo_button = new JButton("Наследственность");
		nasledstvie_GetInfo_button.setBounds(30,400,200,50);
		
		nasledstvie_info_label = new JLabel("-");
		nasledstvie_info_label.setBounds(250,400,300,50);
		
		nasledstvie_SetInfo_button = new JButton("Добавить в архив");
		nasledstvie_SetInfo_button.setBounds(500,400,200,50);
		
		prochee_GetInfo_button = new JButton("Прочие документы");
		prochee_GetInfo_button.setBounds(30,500,200,50);
		
		prochee_info_label = new JLabel("-");
		prochee_info_label.setBounds(250,500,300,50);
		
		prochee_SetInfo_button = new JButton("Добавить в архив");
		prochee_SetInfo_button.setBounds(500,500,200,50);
		
		zalog_GetInfo_button = new JButton("Залог");
		zalog_GetInfo_button.setBounds(30,600,200,50);
		
		zalog_info_label = new JLabel("-");
		zalog_info_label.setBounds(250,600,300,50);
		
		zalog_SetInfo_button = new JButton("Добавить в архив");
		zalog_SetInfo_button.setBounds(500,600,200,50);
		
		info = new JLabel("");
		info.setOpaque(true);
		info.setForeground(Color.red);
		info.setBounds(245, 10 , 400, 30);	
		
		
		add(mainPanel);
		mainPanel.add(zalog_SetInfo_button);
		mainPanel.add(zalog_GetInfo_button);
		mainPanel.add(zalog_info_label);
		mainPanel.add(prochee_SetInfo_button);
		mainPanel.add(prochee_GetInfo_button);
		mainPanel.add(prochee_info_label);
		mainPanel.add(nasledstvie_GetInfo_button);
		mainPanel.add(nasledstvie_SetInfo_button);
		mainPanel.add(nasledstvie_info_label);
		mainPanel.add(otchuzhdenie_info_label);
		mainPanel.add(chooseinfoLabel);
		mainPanel.add(enterinfoLabel);
		mainPanel.add(otchuzhdenie_GetInfo_button);
		mainPanel.add(dayText);
		mainPanel.add(dayLabel);
		mainPanel.add(monthText);
		mainPanel.add(monthLabel);
		mainPanel.add(yearText);
		mainPanel.add(yearLabel);
		mainPanel.add(info);
		mainPanel.add(otchuzhdenie_SetInfo_button);
		
		otchuzhdenie_GetInfo_button.addActionListener(this);
		otchuzhdenie_SetInfo_button.addActionListener(this);
		nasledstvie_GetInfo_button.addActionListener(this);
		nasledstvie_SetInfo_button.addActionListener(this);
		prochee_GetInfo_button.addActionListener(this);
		prochee_SetInfo_button.addActionListener(this);
		zalog_GetInfo_button.addActionListener(this);
		zalog_SetInfo_button.addActionListener(this);
		
		
		
		setTitle("Информация");
		setLocation(300,100);
		setVisible(true);
		setBounds(100, 50, 750, 730);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if(e.getSource() == otchuzhdenie_SetInfo_button) {
			new otchuzhdenieGUI();
		}
		if(e.getSource() == nasledstvie_SetInfo_button) {
			new nasledstvieGUI();
		}
		if(e.getSource() == prochee_SetInfo_button) {
			new procheeGUI();
		}
		if(e.getSource() == zalog_SetInfo_button) {
			new zalogGUI();
		}
		
		if(e.getSource() == otchuzhdenie_GetInfo_button) {
			day = dayText.getText();
			month = monthText.getText();
			year = yearText.getText();
			if(numberChecker(day, month, year)) {
				int day_num = Integer.parseInt(day);
				int month_num = Integer.parseInt(month);
				int year_num = Integer.parseInt(year);
				if(dateChecker(day_num, month_num, year_num)) {
					String otchuzhdenie = "otchuzhdenie";
					File directory;
					int days = dayCounter(day, month, year);
					if(year_num < 2020) directory = new File("C:\\Public\\NotariusDB\\" + otchuzhdenie + "\\20142019");
					else directory = new File("C:\\Public\\NotariusDB\\" + otchuzhdenie + "\\20202029");
					int fileCount = directory.list().length;
					for(int i = 1; i <= fileCount; i++) {
				    	try {
							range = readFile(year, i, otchuzhdenie);
							if(days >= range[0] && days <= range[1]) {
								otchuzhdenie_info_label.setText("Упаковка - " + range[2] + "    Наряд - " + range[3] + "    Год : " + year);
								break;
							}
						}
						catch(Exception d) {
							otchuzhdenie_info_label.setText("Не существует");
							break;
						}
				    	otchuzhdenie_info_label.setText("Не существует");
				    }
					try {
						clickcounter(); 
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else info.setText("Введите число");
		}
		
		if(e.getSource() == nasledstvie_GetInfo_button) {
			day = dayText.getText();
			month = monthText.getText();
			year = yearText.getText();
			if(numberChecker(day, month, year)) {
				int day_num = Integer.parseInt(day);
				int month_num = Integer.parseInt(month);
				int year_num = Integer.parseInt(year);
				if(dateChecker(day_num, month_num, year_num)) {
					String nasledstvie = "nasledstvie";
					File directory;
					int days = dayCounter(day, month, year);
					if(year_num < 2020) directory = new File("C:\\Public\\NotariusDB\\" + nasledstvie + "\\20142019");
					else directory = new File("C:\\Public\\NotariusDB\\" + nasledstvie + "\\20202029");
					int fileCount = directory.list().length;
					for(int i = 1; i <= fileCount; i++) {
				    	try {
							range = readFile(year, i, nasledstvie);
							if(days >= range[0] && days <= range[1]) {
								nasledstvie_info_label.setText("Упаковка - " + range[2] + "    Наряд - " + range[3] + "    Год : " + year);
								break;
							}
						}
						catch(Exception d) {
							nasledstvie_info_label.setText("Не существует");
							break;
						}
				    	nasledstvie_info_label.setText("Не существует");
				    }
					try {
						clickcounter();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else info.setText("Введите число");
		}
		
		if(e.getSource() == prochee_GetInfo_button) {
			day = dayText.getText();
			month = monthText.getText();
			year = yearText.getText();
			if(numberChecker(day, month, year)) {
				int day_num = Integer.parseInt(day);
				int month_num = Integer.parseInt(month);
				int year_num = Integer.parseInt(year);
				if(dateChecker(day_num, month_num, year_num)) {
					String prochee = "prochee";
					File directory;
					int days = dayCounter(day, month, year);
					if(year_num < 2020) directory = new File("C:\\Public\\NotariusDB\\" + prochee + "\\20142019");
					else directory = new File("C:\\Public\\NotariusDB\\" + prochee + "\\20202029");
					int fileCount = directory.list().length;
					for(int i = 1; i <= fileCount; i++) {
				    	try {
							range = readFile(year, i, prochee);
							if(days >= range[0] && days <= range[1]) {
								prochee_info_label.setText("Упаковка - " + range[2] + "    Наряд - " + range[3] + "    Год : " + year);
								break;
							}
						}
						catch(Exception d) {
							prochee_info_label.setText("Не существует");
							break;
						}
				    	prochee_info_label.setText("Не существует");
				    }
					try {
						clickcounter();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else info.setText("Введите число");
		}
		
		if(e.getSource() == zalog_GetInfo_button) {
			day = dayText.getText();
			month = monthText.getText();
			year = yearText.getText();
			if(numberChecker(day, month, year)) {
				int day_num = Integer.parseInt(day);
				int month_num = Integer.parseInt(month);
				int year_num = Integer.parseInt(year);
				if(dateChecker(day_num, month_num, year_num)) {
					String zalog = "zalog";
					File directory;
					int days = dayCounter(day, month, year);
					if(year_num < 2020) directory = new File("C:\\Public\\NotariusDB\\" + zalog + "\\20142019");
					else directory = new File("C:\\Public\\NotariusDB\\" + zalog + "\\20202029");
					int fileCount = directory.list().length;
					for(int i = 1; i <= fileCount; i++) {
				    	try {
							range = readFile(year, i, zalog);
							if(days >= range[0] && days <= range[1]) {
								zalog_info_label.setText("Упаковка - " + range[2] + "    Наряд - " + range[3] + "    Год : " + year);
								break;
							}
						}
						catch(Exception d) {
							zalog_info_label.setText("Не существует");
							break;
						}
				    	zalog_info_label.setText("Не существует");
				    }
					try {
						clickcounter();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else info.setText("Введите число");
		}
		
		
	}
	
	
	private void clickcounter() throws IOException{
		FileReader readhandle = new FileReader("C:\\Public\\NotariusDB\\counter.txt");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(readhandle);
		
		String count = reader.readLine();
		int temp = Integer.parseInt(count) + 1;
		
		FileWriter writehandle = new FileWriter("C:\\Public\\NotariusDB\\counter.txt");
		BufferedWriter writer = new BufferedWriter(writehandle);
		
		count = "" + temp;
		writer.write(count);
		writer.close();
		writehandle.close();
	}

	public static boolean dateChecker(int day, int month, int year) {
		if(year < 2014) 
		{
			info.setText("Укажите год больше 2014");
			return false;
		}
		
		if(year > 2030) {
			info.setText("Укажите правильный год");
			return false;
		}
		
		if(month < 1|| month > 12) 
		{
			info.setText("Укажите правильный месяц");
			return false;
		}
		
		if (day <= 0 || day >= 32) 
		{
			info.setText("Укажите правильный день");
			return false;
		}
		
		if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) 
		{
			info.setText("Укажите правильный день");
			return false;
		}
		if(month == 2 && day >= 30) 
		{
			info.setText("Укажите правильный день для февраля ");
			return false;
		}
		
		if (year % 4 != 0 && (month == 2 && day == 29)) 
		{
			info.setText("Укажите правильный день");
			return false;
		}
		
		return true;
	}
	
	public static boolean numberChecker(String day, String month, String year) {
		try {
			int day_num = Integer.parseInt(day);
			int month_num = Integer.parseInt(month);
			int year_num = Integer.parseInt(year);
			
			day_num = day_num + month_num + year_num;
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static int dayCounter(String day, String month, String year) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		if(Integer.parseInt(day) < 10) {
			day = "0" + day;
		}
		if(Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		
		String first = "01 01 2014";
		
		if(Integer.parseInt(year) >= 2020) {
			first = "01 01 2020";
		}
		
		String second = day + " " + month + " " + year;
		final LocalDate firstDate = LocalDate.parse(first, formatter);
        final LocalDate secondDate = LocalDate.parse(second, formatter);
        final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
		return (int) (days + 1);
		
	}
	
	public int[] readFile(String year, int i, String fileDirectory) throws FileNotFoundException {
		
		if(Integer.parseInt(year) < 2020) year = "20142019";			
		else year = "20202029";
		
		int[] startAndEnd = new int[4];
		FileReader readhandle = new FileReader("C:\\Public\\NotariusDB\\" + fileDirectory + "\\" + year + "\\" + i +".txt");
		
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(readhandle);
		
		try {
			String[] array = reader.readLine().split("_");
			startAndEnd[0] = Integer.parseInt(array[0]);
			startAndEnd[1] = Integer.parseInt(array[1]);
			startAndEnd[2] = Integer.parseInt(array[2]);
			startAndEnd[3] = Integer.parseInt(array[3]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return startAndEnd;
	}
}
