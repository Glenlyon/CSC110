
public class CalendarCanadaSample {

	    private static final String WEEKDAYS = "Su Mo Tu We Th Fr Sa";
	    private static final String NEW_LINE = "\n";
	    private static final String EMPTY_STRING = " ";
	    private static final String TRIPLE_EMPTY_STRING = "   ";

	    public static void main(final String[] args) 
	    {
	        final String calendarString = getFormattedCalendar(4, 6);

	        System.out.println(calendarString);
	    }

	    private static String getFormattedCalendar(final int startDay, final int endDay)
	    {
	        // Create StringBuilder
	        final StringBuilder calendar = new StringBuilder();

	        // Append weekdays to string header
	        calendar.append(WEEKDAYS).append(NEW_LINE);

	        // This will keep track of days
	        int day = 1;

	        for (int i = 1; i <= 5; i++) // Week loop
	        {
	            for (int j = 1; j <= 7; j++) // Weekday loop
	            {
	                // If we are on the last week of the month,
	                // and we've reached the endDay that we specified,
	                // simply return the assembled string
	                if (i == 5 && j == endDay + 1)
	                    return calendar.toString();

	                // These are the empty spaces for the beginning of
	                // the first week
	                if (i == 1 && j < startDay)
	                {
	                    // Just append empty space, then CONTINUE
	                    // to next iteration (j++)
	                    calendar.append(TRIPLE_EMPTY_STRING);
	                    continue;
	                }

	                // Check if the day is a single or double digit
	                if (day / 10 >= 1)
	                    calendar.append(day++).append(EMPTY_STRING);
	                else
	                    // If this is the first week, then it means that
	                    // we have single-digit days. Apply strings on each
	                    // side of the day for proper spacing of digits
	                    calendar.append(EMPTY_STRING).append(day++).append(EMPTY_STRING);
	            }

	            calendar.append(NEW_LINE);
	        }

	        return calendar.toString();
	    }
	}
