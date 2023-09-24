package co.novu.api.blueprints.pojos;
import lombok.Data;

import java.util.List;

@Data
public class Filters {
   private List<String> children;
   private String _id;
}