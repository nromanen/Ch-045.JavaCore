package net.gavrilyuk.dayofweek;

import java.text.DateFormatSymbols;
import java.util.Locale;

/**
 *
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class DayConverter {

    private Locale mLocale;
    private String mDayOfWeek;

    public DayConverter() {
        this(new Locale("en"), 1);//default lang - english day of week - Sunday
    }

    public DayConverter(int dayOfWeek) {
        this(new Locale("en"), dayOfWeek);//default lang - english
    }

    public DayConverter(Locale locale) {
        this(locale, 1); //default  day of week - Sunday
    }

    public DayConverter(Locale locale, int day) {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        mLocale = locale;
        mDayOfWeek = symbols.getWeekdays()[day];
    }

    public String getDayOfWeek() {
        return mDayOfWeek;
    }

    public Locale getLocale() {
        return mLocale;
    }

    public void setLocale(Locale locale) {
        mLocale = locale;
    }
}
