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
import java.math.BigDecimal;

/**
 *
 * @author dylan
 */
public class Earning extends BaseNanopoolSchema {

    private final BigDecimal coins;
    private final BigDecimal bitcoins;
    private final BigDecimal dollars;
    private final BigDecimal yuan;
    private final BigDecimal euros;
    private final BigDecimal rubles;

    @JsonCreator
    public Earning(@JsonProperty("coins") BigDecimal coins,
            @JsonProperty("bitcoins") BigDecimal bitcoins,
            @JsonProperty("dollars") BigDecimal dollars,
            @JsonProperty("yuan") BigDecimal yuan,
            @JsonProperty("euros") BigDecimal euros,
            @JsonProperty("rubles") BigDecimal rubles) {
        this.coins = coins;
        this.bitcoins = bitcoins;
        this.dollars = dollars;
        this.yuan = yuan;
        this.euros = euros;
        this.rubles = rubles;
    }

    public BigDecimal getCoins() {
        return coins;
    }

    public BigDecimal getBitcoins() {
        return bitcoins;
    }

    public BigDecimal getDollars() {
        return dollars;
    }

    public BigDecimal getYuan() {
        return yuan;
    }

    public BigDecimal getEuros() {
        return euros;
    }

    public BigDecimal getRubles() {
        return rubles;
    }

}
