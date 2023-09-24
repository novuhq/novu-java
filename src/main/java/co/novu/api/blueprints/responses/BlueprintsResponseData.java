package co.novu.api.blueprints.responses;
import co.novu.api.blueprints.pojos.General;
import co.novu.api.blueprints.pojos.Popular;
import lombok.Data;

import java.util.List;

@Data
public class BlueprintsResponseData {
   private List<General> general;
   private Popular popular;
}