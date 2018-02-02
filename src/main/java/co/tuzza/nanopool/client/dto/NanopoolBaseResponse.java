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
