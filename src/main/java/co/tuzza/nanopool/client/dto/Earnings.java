package co.tuzza.nanopool.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author dylan
 */
public class Earnings {

    private final Earning minute;
    private final Earning hour;
    private final Earning day;
    private final Earning week;
    private final Earning month;

    @JsonCreator
    public Earnings(@JsonProperty("minute") Earning minute,
            @JsonProperty("hour") Earning hour,
            @JsonProperty("day") Earning day,
            @JsonProperty("week") Earning week,
            @JsonProperty("month") Earning month) {
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.week = week;
        this.month = month;
    }

    public Earning getMinute() {
        return minute;
    }

    public Earning getHour() {
        return hour;
    }

    public Earning getDay() {
        return day;
    }

    public Earning getWeek() {
        return week;
    }

    public Earning getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "Earnings{"
                + "minute=" + minute
                + ", hour=" + hour
                + ", day=" + day
                + ", week=" + week
                + ", month=" + month
                + "}";
    }

}
