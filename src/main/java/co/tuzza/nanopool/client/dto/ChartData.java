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
package co.tuzza.nanopool.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author dylan
 */
public class ChartData {

    private final Date date;
    private final Long shares;
    private final BigDecimal hashrate;

    @JsonCreator
    public ChartData(@JsonProperty("date") Date date,
            @JsonProperty("shares") Long shares,
            @JsonProperty("hashrate") BigDecimal hashrate) {
        this.date = date;
        this.shares = shares;
        this.hashrate = hashrate;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Number of Shares for Last 10 Minutes
     *
     * @return
     */
    public Long getShares() {
        return shares;
    }

    /**
     * Reported Hashrate [H/s]
     *
     * @return
     */
    public BigDecimal getHashrate() {
        return hashrate;
    }

    @Override
    public String toString() {
        return "ChartData{"
                + "date=" + date
                + ", shares=" + shares
                + ", hashrate=" + hashrate
                + "}";
    }

}
