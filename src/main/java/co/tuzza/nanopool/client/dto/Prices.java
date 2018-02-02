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
