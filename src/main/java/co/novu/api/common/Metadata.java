package co.novu.api.common;

import lombok.Data;

@Data
public class Metadata {
    private Long amount;
    private String unit;
    private String digestKey;
    private String delayPath;
    private String type;
    private String backoffUnit;
    private Long backoffAmount;
    private Boolean updateMode;
}