import java.awt.*;
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
	protected Vector	data;
	protected Vector	labels;
	protected Vector	colors;

	Choice 		colorSelect;
	TextField	labelSelect;
	TextField	dataSelect;


	BarChart chart;


	protected void initData()
	{
		data = new Vector();
		labels = new Vector();
		colors = new Vector();

		data.addElement(new Integer(90));
		data.addElement(new Integer(40));
		labels.addElement("PPV");
		labels.addElement("phone");
		colors.addElement(Color.red);
		colors.addElement(Color.green);
	}

	public BarChartFrame()
	{
		initData();

		setSize(350,350);
		setLayout(new BorderLayout());

		MenuBar mb = new MenuBar();
		Menu file = new Menu("File");
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