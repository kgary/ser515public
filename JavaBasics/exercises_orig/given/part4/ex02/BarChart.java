import java.awt.*;
class BarChart extends Panel
{			   
	private int		barWidth = 20;
	private int		data[];
	private String	dataLabels[];
	private Color	dataColors[];

	public void paint(Graphics g)
	{
		setSize(200,250);
		Image duke = Toolkit.getDefaultToolkit().getImage("duke2.gif");
		g.drawImage(duke, 80, 10, this);

		for (int i = 0; i < data.length; i++)
		{				  
			int yposition = 100+i*barWidth;

			g.setColor(dataColors[i]);
			g.fillRect(100, yposition, data[i], barWidth);

			g.setColor(Color.black);
			g.drawString(dataLabels[i], 20, yposition+10);
		}
	}

	public void setData(int dataValues[])
	{
		data = dataValues;
	}

	public void setLabels(String labels[])
	{
		dataLabels = labels;
	}

	public void setColors(Color colors[])
	{
		dataColors = colors;
	}
}