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
import java.util.List;

/**
 *
 * @author dylan
 */
public class UserInfo extends BaseNanopoolSchema {

    private final String account;
    private final BigDecimal balance;
    private final BigDecimal unconfirmedBalance;
    private final BigDecimal hashrate;
    private final Periods avgHashrate;
    private final List<ExtWorker> workers;

    @JsonCreator
    public UserInfo(
            @JsonProperty("account") String account,
            @JsonProperty("balance") BigDecimal balance,
            @JsonProperty("unconfirmed_balance") BigDecimal unconfirmedBalance,
            @JsonProperty("hashrate") BigDecimal hashrate,
            @JsonProperty("avgHashrate") Periods avgHashrate,
            @JsonProperty("workers") List<ExtWorker> workers) {
        this.account = account;
        this.balance = balance;
        this.unconfirmedBalance = unconfirmedBalance;
        this.hashrate = hashrate;
        this.avgHashrate = avgHashrate;
        this.workers = workers;
    }

    public String getAccount() {
        return account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public BigDecimal getHashrate() {
        return hashrate;
    }

    public Periods getAvgHashrate() {
        return avgHashrate;
    }

    public List<ExtWorker> getWorkers() {
        return workers;
    }

}
