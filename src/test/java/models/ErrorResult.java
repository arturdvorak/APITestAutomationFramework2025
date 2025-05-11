package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;

@Data
@Builder
public class ErrorResult {
    @Expose
    boolean status;
    @Expose
    ArrayList<ErrorFields> errorFields;
}
