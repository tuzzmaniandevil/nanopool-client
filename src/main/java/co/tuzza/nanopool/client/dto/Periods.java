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

/**
 *
 * @author dylan
 */
public class Periods {

    private final BigDecimal h1;
    private final BigDecimal h3;
    private final BigDecimal h6;
    private final BigDecimal h12;
    private final BigDecimal h24;

    @JsonCreator
    public Periods(@JsonProperty("h1") BigDecimal h1,
            @JsonProperty("h3") BigDecimal h3,
            @JsonProperty("h6") BigDecimal h6,
            @JsonProperty("h12") BigDecimal h12,
            @JsonProperty("h24") BigDecimal h24) {
        this.h1 = h1;
        this.h3 = h3;
        this.h6 = h6;
        this.h12 = h12;
        this.h24 = h24;
    }

    public BigDecimal getH1() {
        return h1;
    }

    public BigDecimal getH3() {
        return h3;
    }

    public BigDecimal getH6() {
        return h6;
    }

    public BigDecimal getH12() {
        return h12;
    }

    public BigDecimal getH24() {
        return h24;
    }

    @Override
    public String toString() {
        return "Periods{"
                + "h1=" + h1
                + ", h3=" + h3
                + ", h6=" + h6
                + ", h12=" + h12
                + ", h24=" + h24
                + "}";
    }

}
