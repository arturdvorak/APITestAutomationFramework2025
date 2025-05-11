package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(exclude = {"id", "position", "created", "updated"})
public class Suite {
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("parent_id")
    private int parentId;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("preconditions")
    private String preconditions;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("created")
    private String created;
    @Expose
    @SerializedName("updated")
    private String updated;
}

