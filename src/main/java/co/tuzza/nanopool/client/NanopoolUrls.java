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
package co.tuzza.nanopool.client;

/**
 *
 * @author dylan
 */
public final class NanopoolUrls {

    private static final String BASE_URL = "https://api.nanopool.org/v1/:pool/";

    protected static final String MINER_ACCOUNT_BALANCE= BASE_URL + "balance/:address";
    protected static final String MINER_AVERAGE_HASHRATE = BASE_URL + "avghashrate/:address";
    protected static final String MINER_AVERAGE_HASHRATE_LIMITED = BASE_URL + "avghashratelimited/:address/:hours";
    protected static final String MINER_CHART_DATA = BASE_URL + "hashratechart/:address";
    protected static final String MINER_CHECK_ACCOUNT = BASE_URL + "accountexist/:address";
    protected static final String MINER_CURRENT_HASHRATE = BASE_URL + "hashrate/:address";
    protected static final String MINER_GENERAL_INFO = BASE_URL + "user/:address";
    protected static final String MINER_HASHRATE_HISTORY = BASE_URL + "history/:address";
    protected static final String MINER_BALANCE_HASHRATE = BASE_URL + "balance_hashrate/:address";
    protected static final String MINER_REPORTED_HASHRATE = BASE_URL + "reportedhashrate/:address";
    protected static final String MINER_LIST_WORKERS = BASE_URL + "workers/:address";
    protected static final String MINER_PAYMENTS = BASE_URL + "payments/:address";
    protected static final String MINER_PAYMENTS_DAY = BASE_URL + "paymentsday/:address";
    protected static final String MINER_SHARE_RATE_HISTORY = BASE_URL + "shareratehistory/:address";
    protected static final String MINER_WORKERS_AVERAGE_HASHRATE_LIMITED = BASE_URL + "avghashrateworkers/:address/:hours";
    protected static final String MINER_WORKERS_AVERAGE_HASHRATE = BASE_URL + "avghashrateworkers/:address";
    protected static final String MINER_WORKERS_LAST_REPORTED_HASHRATE = BASE_URL + "reportedhashrates/:address";

    protected static final String NETWORK_AVERAGE_BLOCK_TIME = BASE_URL + "network/avgblocktime";
    protected static final String NETWORK_BLOCKS_STATS = BASE_URL + "block_stats/:offset/:count";
    protected static final String NETWORK_BLOCKS = BASE_URL + "blocks/:offset/:count";
    protected static final String NETWORK_LAST_BLOCK_NUMBER = BASE_URL + "network/lastblocknumber";
    protected static final String NETWORK_TIME_TO_NEXT_EPOCH = BASE_URL + "network/timetonextepoch";

    protected static final String OTHER_CALCULATOR = BASE_URL + "approximated_earnings/:hashrate";
    protected static final String OTHER_PRICES = BASE_URL + "prices";

    protected static final String POOL_ACTIVE_MINERS = BASE_URL + "pool/activeminers";
    protected static final String POOL_ACTIVE_WORKERS = BASE_URL + "pool/activeworkers";
    protected static final String POOL_HASHRATE = BASE_URL + "pool/hashrate";
    protected static final String POOL_TOP_MINERS = BASE_URL + "pool/topminers";

    protected static final String USER_SETTINGS = BASE_URL + "usersettings/:address";

    protected static final String WORKER_AVERAGE_HASHRATE_LIMITED = BASE_URL + "avghashratelimited/:address/:worker/:hours";
    protected static final String WORKER_AVERAGE_HASHRATE = BASE_URL + "avghashrate/:address/:worker";
    protected static final String WORKER_CHART_DATA = BASE_URL + "hashratechart/:address/:worker";
    protected static final String WORKER_CURRENT_HASHRATE = BASE_URL + "balance/:address";
    protected static final String WORKER_HASHRATE_HISTORY = BASE_URL + "history/:address/:worker";
    protected static final String WORKER_REPORTED_HASH_RATE = BASE_URL + "reportedhashrate/:address/:worker";
    protected static final String WORKER_SHARE_RATE_HISTORY = BASE_URL + "shareratehistory/:address/:worker";
}
