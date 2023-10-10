package co.novu.api.notifications;

import co.novu.api.layouts.LayoutApi;
import co.novu.api.layouts.responses.CreateLayoutResponse;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationGraphStatsResponse;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.api.notifications.responses.NotificationsResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class NotificationHandler {

    private final RestHandler restHandler;
    private final NotificationApi notificationApi;

    public NotificationHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.notificationApi = restHandler.buildRetrofit().create(NotificationApi.class);
    }

    public NotificationsResponse getNotifications(NotificationRequest request) throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (request.getChannels() != null) params.put("channels", request.getChannels());
        if (request.getTemplates() != null)params.put("templates", request.getTemplates());
        if (request.getEmails() != null)params.put("emails", request.getEmails());
        if (request.getSearch() != null)params.put("search", request.getSearch());
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getTransactionId() != null) params.put("transactionId", request.getTransactionId());
        return restHandler.extractResponse(notificationApi.getNotifications(params).execute());
    }

    public NotificationStatsResponse getNotificationsStats() throws IOException, NovuNetworkException {
        return restHandler.extractResponse(notificationApi.getNotificationsStats().execute());
    }

    public NotificationGraphStatsResponse getNotificationGraphStats() throws IOException, NovuNetworkException {
        return restHandler.extractResponse(notificationApi.getNotificationGraphStats().execute());
    }

    public NotificationResponse getNotification(String notificationId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(notificationApi.getNotification(notificationId).execute());
    }
}