package co.novu.api.blueprints.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Filters {
   private List<String> children;
   @SerializedName("_id")
   private String id;
}