package models;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Result<T> {
    @Expose
    boolean status;
    @Expose
    T result;
    @Expose
    T errorMessage;
    @Expose
    T errorFields;
}
