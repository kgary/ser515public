import java.awt.*;
class Main
{
	public static void main(String args[])
	{
		Frame f = new BarChartFrame();
	}
}

class BarChartFrame extends Frame
{
	int		data[] = {90, 40, 80, 60, 70, 30};
	String	labels[] = {"PPV", "phone", "rent", "gas", "electric", "cable"};
	Color	colors[] = {Color.red, Color.green, Color.blue,
						Color.magenta, Color.gray, Color.orange};

	Choice 		colorSelect;
	TextField	labelSelect;
	TextField	dataSelect;


	BarChart chart;


	public BarChartFrame()
	{
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
//		add(chart, "North");
//		chart.repaint();
		chart.setVisible(true);
		chart.repaint();
		setVisible(true);
	}
}
