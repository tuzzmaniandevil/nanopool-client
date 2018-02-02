package co.tuzza.nanopool.client;

import co.tuzza.nanopool.client.dto.Earnings;
import co.tuzza.nanopool.client.dto.NanopoolBaseResponse;
import co.tuzza.nanopool.client.dto.Pool;
import co.tuzza.nanopool.client.dto.Prices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
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

        return doGET(url);
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

        return doGET(url);
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

        return doGET(url);
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

        return doGET(url);
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
    public NanopoolBaseResponse<Earnings> getCalculator(Pool pool, String hashrate) throws IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("pool is not allowed to be null");
        }
        if (StringUtils.isBlank(hashrate)) {
            throw new IllegalArgumentException("hashrate is not allowed to be null");
        }

        Map<String, String> params = parseParameters(pool, null);
        params.put("hashrate", hashrate);

        String url = parseUrl(NanopoolUrls.OTHER_CALCULATOR, params);

        return doGET(url);
    }

    private <T> NanopoolBaseResponse<T> doGET(String s) throws IOException {
        URL url = new URL(s);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Nanopool-java-sdk/1.0.0");
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            ObjectMapper m = new ObjectMapper();

            return m.readValue(in, new TypeReference<NanopoolBaseResponse<T>>() {
            });
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
