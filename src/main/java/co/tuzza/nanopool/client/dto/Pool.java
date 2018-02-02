package co.tuzza.nanopool.client.dto;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author dylan
 */
public enum Pool {
    ETHEREUM("eth"),
    ETHEREUM_CLASSIC("etc"),
    SIA_COIN("sia"),
    ZCASH("zec"),
    MONERO("xmr"),
    PASCAL("pasc"),
    ELECTRONEUM("etn");

    private final String code;

    private Pool(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Pool fromValue(String v) {
        if (StringUtils.isNotBlank(v)) {
            v = StringUtils.lowerCase(v).trim();
            switch (v) {
                case "ethereum":
                case "eth": {
                    return ETHEREUM;
                }
                case "ethereum classic":
                case "ethereum_classic":
                case "etc": {
                    return ETHEREUM_CLASSIC;
                }
                case "sia coin":
                case "sia_coin":
                case "sia": {
                    return SIA_COIN;
                }
                case "zcash":
                case "zec": {
                    return ZCASH;
                }
                case "monero":
                case "xmr": {
                    return MONERO;
                }
                case "pascal":
                case "pasc": {
                    return PASCAL;
                }
                case "electroneum":
                case "etn": {
                    return ELECTRONEUM;
                }
            }
        }
        return null;
    }
}
