import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Vector;

class Main
{
	public static void main(String args[])
	{
		Frame f = new BarChartFrame();
		//f.setVisible(true);
	}
}

class BarChartFrame extends Frame
{

	HashMap<String, Color> colorMap = new HashMap<>();

	protected Vector<Integer>	data;
	protected Vector<String>	labels;
	protected Vector<Color>	colors;

	Choice 		colorSelect;
	TextField	labelSelect;
	TextField	dataSelect;


	BarChart chart;

	class BarChartFrameControl implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() instanceof Button)
			{
				labels.addElement(labelSelect.getText());
				data.addElement(Integer.parseInt(dataSelect.getText()));
				colors.addElement(colorMap.get(colorSelect.getSelectedItem()));

				chart.setData(data);
				chart.setColors(colors);
				chart.setLabels(labels);
				chart.repaint();
			}
			else if (e.getSource() instanceof Menu)
			{
				System.exit(0);		// only option at this time
			}
		}
	}


	protected void initData()
	{
		data = new Vector<Integer>();
		labels = new Vector<String>();
		colors = new Vector<Color>();

		colorMap.put("red", Color.red);
		colorMap.put("green", Color.green);
		colorMap.put("blue", Color.blue);
		colorMap.put("magenta", Color.magenta);
		colorMap.put("gray", Color.gray);
		colorMap.put("orange", Color.orange);

		try
		{
			FileReader bridge = new FileReader("graph.txt");
			StreamTokenizer		tokens = new StreamTokenizer(bridge);

			while (tokens.nextToken() != tokens.TT_EOF)
			{
				int number = (int) tokens.nval;
				tokens.nextToken();
				String label = tokens.sval;
				tokens.nextToken();
				Color color = (Color) colorMap.get(tokens.sval);
				
				data.addElement(number);
				labels.addElement(label);
				colors.addElement(color);
			}
		}
		catch (Exception e) {e.printStackTrace();}
	}

	public BarChartFrame()
	{
		BarChartFrameControl control = new BarChartFrameControl();

		initData();

		setSize(350,350);
		setLayout(new BorderLayout());

		MenuBar mb = new MenuBar();
		Menu file = new Menu("File");
		file.addActionListener(control);
		file.add("Exit");
		mb.add(file);
		setMenuBar(mb);
		
		chart = new BarChart();

		chart.setData(data);
		chart.setLabels(labels);
		chart.setColors(colors);

		Panel components = new Panel();
		components.setSize(350,50);
		components.setLayout(new FlowLayout());

		colorSelect = new Choice();
		colorSelect.add ("red");
		colorSelect.add("green");
		colorSelect.add("blue");
		colorSelect.add("magenta");
		colorSelect.add("gray");
		colorSelect.add("orange");
		components.add(colorSelect);
		labelSelect = new TextField("label", 10);
		components.add(labelSelect);
		dataSelect = new TextField("data", 5);
		components.add(dataSelect);

		Button button = new Button("Add Data");
		button.addActionListener(control);
		components.add(button);

		setBackground(Color.lightGray);
		add(components, "South");
		add(chart, "North");
		chart.repaint();
		setVisible(true);
	}
}


class BarChart extends Panel
{			   
	private int		barWidth = 20;
	private Vector	data;
	private Vector	dataLabels;
	private Vector	dataColors;

	public void paint(Graphics g)
	{
		setSize(200,250);
		Image duke = Toolkit.getDefaultToolkit().getImage("duke2.gif");
		g.drawImage(duke, 80, 10, this);

		for (int i = 0; i < data.size(); i++)
		{				  
			int yposition = 100+i*barWidth;

			if (dataColors != null && dataColors.size() > i &&
									  dataColors.elementAt(i) instanceof Color)
				g.setColor((Color) dataColors.elementAt(i));

			int barLength = ((Integer) data.elementAt(i)).intValue();
			g.fillRect(100, yposition, barLength, barWidth);

			g.setColor(Color.black);
			if (dataLabels != null && dataLabels.size() > i &&
									  dataLabels.elementAt(i) instanceof String)
				g.drawString((String) dataLabels.elementAt(i), 20, yposition+10);
		}
	}

	public void setData(Vector dataValues)
	{
		data = dataValues;
	}

	public void setLabels(Vector labels)
	{
		dataLabels = labels;
	}

	public void setColors(Vector colors)
	{
		dataColors = colors;
	}
}
