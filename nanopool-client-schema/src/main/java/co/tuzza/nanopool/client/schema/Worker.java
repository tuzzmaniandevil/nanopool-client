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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author dylan
 */
public class Worker extends BaseNanopoolSchema {

    private final long uid;
    private final String id;
    private final BigDecimal hashrate;
    @JsonDeserialize(converter = DateFromEpochConverter.class)
    private final Date lastShare;
    private final BigDecimal rating;

    @JsonCreator
    public Worker(
            @JsonProperty("uid") long uid,
            @JsonProperty("id") String id,
            @JsonProperty("hashrate") BigDecimal hashrate,
            @JsonProperty("lastshare") Date lastShare,
            @JsonProperty("rating") BigDecimal rating) {
        this.uid = uid;
        this.id = id;
        this.hashrate = hashrate;
        this.lastShare = lastShare;
        this.rating = rating;
    }

    public long getUid() {
        return uid;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getHashrate() {
        return hashrate;
    }

    public Date getLastShare() {
        return lastShare;
    }

    public BigDecimal getRating() {
        return rating;
    }

    @Override
    public String toString() {
//        return "Worker{"
//                + "uid=" + uid
//                + ", id='" + id + "'"
//                + ", hashrate=" + hashrate
//                + ", lastshare=" + lastShare
//                + ", rating=" + rating
//                + "}";
        return SchemaUtils.writeToString(this);
    }

}
