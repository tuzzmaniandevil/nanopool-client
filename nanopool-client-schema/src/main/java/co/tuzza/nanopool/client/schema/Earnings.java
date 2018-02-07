/* 
 * Copyright 2018 Tuzza.co.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.tuzza.nanopool.client.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author dylan
 */
public class Earnings extends BaseNanopoolSchema {

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

}
