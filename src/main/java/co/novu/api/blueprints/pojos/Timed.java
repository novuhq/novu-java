package co.novu.api.blueprints.pojos;

import lombok.Data;

import java.util.List;

@Data
public class Timed {
   private List<String> weekDays;
   private List<String> monthDays;
}