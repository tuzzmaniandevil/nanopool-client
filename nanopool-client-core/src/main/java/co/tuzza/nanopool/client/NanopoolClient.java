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

import co.tuzza.nanopool.client.schema.ChartData;
import co.tuzza.nanopool.client.schema.Earnings;
import co.tuzza.nanopool.client.schema.Periods;
import co.tuzza.nanopool.client.schema.Pool;
import co.tuzza.nanopool.client.schema.Prices;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author dylan
 */
public class NanopoolClient {

    /**
     * Returns account balance
     *
     * @param pool
     * @param address
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public NanopoolBaseResponse<BigDecimal> getAccountBalance(Pool pool, String address) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("address is not allowed to be null");
        }

        String url = parseUrl(NanopoolUrls.MINER_ACCOUNT_BALANCE, pool, address);

        return doGET(url, BigDecimal.class);
    }

    /**
     * Returns average hashrate for the specified period
     *
     * @param pool
     * @param address
     * @param hours
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public NanopoolBaseResponse<BigDecimal> getAverageHashrate(Pool pool, String address, long hours) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("address is not allowed to be null");
        }

        Map<String, String> params = parseParameters(pool, address);
        params.put("hours", Long.toString(hours));

        String url = parseUrl(NanopoolUrls.MINER_AVERAGE_HASHRATE_LIMITED, params);

        return doGET(url, BigDecimal.class);
    }

    /**
     * Returns average hashrate for some periods
     *
     * @param pool
     * @param address
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public NanopoolBaseResponse<Periods> getAverageHashrate(Pool pool, String address) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("address is not allowed to be null");
        }

        String url = parseUrl(NanopoolUrls.MINER_AVERAGE_HASHRATE, pool, address);

        return doGET(url, Periods.class);
    }

    /**
     * Returns history of share rate and reported hashrate for the account
     *
     * @param pool
     * @param address
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public NanopoolBaseResponse<List<ChartData>> getChartData(Pool pool, String address) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("address is not allowed to be null");
        }

        String url = parseUrl(NanopoolUrls.MINER_CHART_DATA, pool, address);

        TypeFactory f = TypeFactory.defaultInstance();

        JavaType inner = f.constructParametricType(List.class, ChartData.class);
        JavaType type = f.constructParametricType(NanopoolBaseResponse.class, inner);

        return doGET(url, type);
    }

    /**
     * Returns status 'true' if account exist and 'false' otherwise
     *
     * @param pool
     * @param address
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public NanopoolBaseResponse<String> checkMinerAccount(Pool pool, String address) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("address is not allowed to be null");
        }

        String url = parseUrl(NanopoolUrls.MINER_CHECK_ACCOUNT, pool, address);

        return doGET(url, String.class);
    }

    /**
     * Returns prices
     *
     * @param pool
     * @return
     * @throws IOException
     */
    public NanopoolBaseResponse<Prices> getPrices(Pool pool) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }

        String url = parseUrl(NanopoolUrls.OTHER_PRICES, pool);

        return doGET(url, Prices.class);
    }

    /**
     * Returns approximated earnings
     *
     * @param pool
     * @param hashrate
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public NanopoolBaseResponse<Earnings> getCalculator(Pool pool, BigDecimal hashrate) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }
        if (hashrate == null) {
            throw new IllegalArgumentException("hashrate is not allowed to be null");
        }

        Map<String, String> params = parseParameters(pool, null);
        params.put("hashrate", hashrate.toPlainString());

        String url = parseUrl(NanopoolUrls.OTHER_CALCULATOR, params);

        return doGET(url, Earnings.class);
    }

    private <T> NanopoolBaseResponse<T> doGET(String s, Class<T> cls) throws IOException {

        TypeFactory f = TypeFactory.defaultInstance();

        JavaType type = f.constructParametricType(NanopoolBaseResponse.class, cls);

        return doGET(s, type);
    }

    private <T> NanopoolBaseResponse<T> doGET(String s, JavaType javaType) throws IOException {
        URL url = new URL(s);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Nanopool-java-sdk/1.0.0");
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            ObjectMapper m = new ObjectMapper();

            String rateLimit_Limit = urlConnection.getHeaderField("X-RateLimit-Limit");
            String rateLimit_Remaining = urlConnection.getHeaderField("X-RateLimit-Remaining");

            NanopoolBaseResponse<T> resp = m.readValue(in, javaType);

            if (StringUtils.isNotBlank(rateLimit_Limit)) {
                try {
                    Integer rll = Integer.valueOf(rateLimit_Limit);
                    resp.setRateLimit(rll);
                } catch (NumberFormatException ex) {
                }
            }

            if (StringUtils.isNotBlank(rateLimit_Remaining)) {
                try {
                    Integer rlr = Integer.valueOf(rateLimit_Remaining);
                    resp.setRateLimitRemaining(rlr);
                } catch (NumberFormatException ex) {
                }
            }

            return resp;
        } catch (IOException ex) {
            throw ex;
        } finally {
            urlConnection.disconnect();
        }
    }

    private Map<String, String> parseParameters(Pool pool, String address) {
        Map<String, String> params = new HashMap();
        params.put("pool", pool.getCode());

        if (StringUtils.isNotBlank(address)) {
            params.put("address", address);
        }

        return params;
    }

    private String parseUrl(String url, Pool pool) {
        Map<String, String> params = parseParameters(pool, null);

        return parseUrl(url, params);
    }

    private String parseUrl(String url, Pool pool, String address) {
        Map<String, String> params = parseParameters(pool, address);

        return parseUrl(url, params);
    }

    private String parseUrl(String url, Map<String, String> params) {
        if (params != null) {
            String newUrl = url;

            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (StringUtils.contains(newUrl, ":" + entry.getKey())) {
                    newUrl = StringUtils.replace(newUrl, ":" + entry.getKey(), entry.getValue());
                }
            }

            return newUrl;
        } else {
            return url;
        }
    }

}
