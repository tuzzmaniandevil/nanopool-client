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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author dylan
 */
public class NanopoolBaseResponse<T> {

    private final boolean status;
    private final String error;
    private final T data;

    @JsonCreator
    public NanopoolBaseResponse(@JsonProperty("status") boolean status, @JsonProperty("error") String error, @JsonProperty("data") T data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "NanopoolBaseResponse{"
                + "status=" + status
                + ", data=" + data
                + ", error='" + error + "'"
                + "}";
    }

}
