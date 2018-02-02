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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 *
 * @author dylan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prices {

    private final BigDecimal usd;
    private final BigDecimal eur;
    private final BigDecimal rur;
    private final BigDecimal cny;
    private final BigDecimal btc;

    @JsonCreator
    public Prices(@JsonProperty("price_usd") BigDecimal usd,
            @JsonProperty("price_eur") BigDecimal eur,
            @JsonProperty("price_rur") BigDecimal rur,
            @JsonProperty("price_cny") BigDecimal cny,
            @JsonProperty("price_btc") BigDecimal btc) {
        this.usd = usd;
        this.eur = eur;
        this.rur = rur;
        this.cny = cny;
        this.btc = btc;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public BigDecimal getEur() {
        return eur;
    }

    public BigDecimal getRur() {
        return rur;
    }

    public BigDecimal getCny() {
        return cny;
    }

    public BigDecimal getBtc() {
        return btc;
    }

    @Override
    public String toString() {
        return "Prices{\n"
                + "usd=" + usd
                + ", eur=" + eur
                + ", rur=" + rur
                + ", cny=" + cny
                + ", btc=" + btc
                + "}";
    }

}
