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
