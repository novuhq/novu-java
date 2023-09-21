package co.novu.api.subscribers.responses;

import lombok.Data;

import java.util.List;

@Data
public class CreateBulkSubscriberResponse {
    private List<String> updated;
    private List<String> created;
    private List<Failed> failed;

    @Data
    public static class Failed {
        private String message;
        private String subscriberId;
    }
}