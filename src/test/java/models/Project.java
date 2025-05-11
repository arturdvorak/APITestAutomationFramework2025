package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("code")
    private String code;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("access")
    private String access;
    @Expose
    @SerializedName("group")
    private String group;
}
