import java.util.*;
public class PropertiesExample
{
	public static void main(String args[])
	{
		Properties props = System.getProperties();
		System.out.println(props.getProperty("os.name"));
		System.out.println(props.getProperty("path.separator"));
		System.out.println(props.getProperty("file.separator"));
		
		Enumeration names = props.propertyNames();

		// print them all
		while (names.hasMoreElements())
		{
			String key = (String) names.nextElement();
			System.out.println(key + "\t:" + props.getProperty(key));
		}
	}
}