import java.util.*;
class Dates
{
	public static void main(String args[])
	{
			GregorianCalendar today = new GregorianCalendar();

			System.out.println("It is December 26th, 1997 at 4:48 PM");

			System.out.println(today.get(Calendar.MONTH) + "/" +
				today.get(Calendar.DATE) + "/" + today.get(Calendar.YEAR));

			System.out.println(today.get(Calendar.HOUR) + ":" +
				today.get(Calendar.MINUTE) + ":" + today.get(Calendar.SECOND)
				+ "." + today.get(Calendar.MILLISECOND)
				+ "  " + today.get(Calendar.AM_PM));

			today.add(Calendar.MINUTE, 1);		// one minute later
			today.add(Calendar.HOUR, 24);		// one day later
	}
}
