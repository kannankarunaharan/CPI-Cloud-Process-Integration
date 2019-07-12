import java.util.*
import java.text.SimpleDateFormat;

def outFirstLastdatarray = firstlastDateofMonth("july", 2019)
println(outFirstLastdatarray)

ArrayList firstlastDateofMonth(String monthNameinp, Integer yearValue) {
    Calendar cal = Calendar.getInstance();
    def monthName = monthNameinp; // German for march
    Date date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(monthName);
    cal.setTime(date);
    def monthNo = cal.get(Calendar.MONTH);
    def yearSub = yearValue - cal.get(Calendar.YEAR)

    cal.add(Calendar.YEAR, yearSub);
    cal.add(Calendar.MONTH, 0);
    cal.set(Calendar.DATE, 1);
    Date firstDateOfPreviousMonth = cal.getTime();

    cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE)); // changed calendar to cal

    Date lastDateOfPreviousMonth = cal.getTime();

    def RunstartDate = firstDateOfPreviousMonth.format('yyyy-MM-dd')
    def RunendDate = lastDateOfPreviousMonth.format('yyyy-MM-dd')

    return [RunstartDate, RunendDate]
}


//output
//[2019-07-01, 2019-07-31]