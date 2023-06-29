package co.novu.common.base;

import co.novu.api.events.EventsHandler;
import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.notifications.NotificationHandler;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationGraphStatsResponse;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.api.notifications.responses.NotificationsResponse;
import co.novu.api.topics.TopicHandler;
import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.*;
import co.novu.common.rest.RestHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Novu {

    private final NovuConfig novuConfig;
    private final RestHandler restHandler;
    private final EventsHandler eventsHandler;
    private final NotificationHandler notificationHandler;

    private final TopicHandler topicHandler;

    public Novu(String apiKey) {
        this(new NovuConfig(apiKey));
    }

    public Novu(NovuConfig novuConfig) {
        this.novuConfig = novuConfig;
        this.restHandler = new RestHandler();
        this.eventsHandler = new EventsHandler(restHandler);
        this.notificationHandler = new NotificationHandler(restHandler);
        this.topicHandler = new TopicHandler(restHandler);
    }

    protected Novu(NovuConfig novuConfig, RestHandler restHandler, EventsHandler eventsHandler, NotificationHandler notificationHandler, TopicHandler topicHandler) {
        this.novuConfig = novuConfig;
        this.restHandler = restHandler;
        this.eventsHandler = eventsHandler;
        this.notificationHandler = notificationHandler;
        this.topicHandler = topicHandler;
    }

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) {
        try {
            return eventsHandler.triggerEvent(request, novuConfig);
        }catch (Exception e){
            log.error("Error triggering event", e);
            throw e;
        }
    }

    public BulkTriggerEventResponse bulkTriggerEvent(BulkTriggerEventRequest request) {
        try {
            return eventsHandler.bulkTriggerEvent(request, novuConfig);
        } catch (Exception e) {
            log.error("Error Triggering Event", e);
            throw e;
        }
    }

    public TriggerEventResponse broadcastEvent(TriggerEventRequest request) {
        try {
            return eventsHandler.broadcastEvent(request, novuConfig);
        } catch (Exception e) {
            log.error("Error BroadCasting Event", e);
            throw e;
        }
    }

    public CancelEventResponse cancelTriggeredEvent(String transactionId) {
        try {
            return eventsHandler.cancelTriggeredEvent(novuConfig, transactionId);
        } catch (Exception e) {
            log.error("Error Canceling Event", e);
            throw e;
        }
    }

    public NotificationsResponse getNotifications(NotificationRequest request) {
        try {
            return notificationHandler.getNotifications(request, novuConfig);
        } catch (Exception e) {
            log.error("Error Getting Notification", e);
            throw e;
        }
    }

    public NotificationStatsResponse getNotificationsStats() {
        try {
            return notificationHandler.getNotificationsStats(novuConfig);
        } catch (Exception e) {
            log.error("Error Getting Notifications Stats", e);
            throw e;
        }
    }

    public NotificationGraphStatsResponse getNotificationGraphStats() {
        try {
            return notificationHandler.getNotificationGraphStats(novuConfig);
        } catch (Exception e) {
            log.error("Error Getting Notifications Graph Stats", e);
            throw e;
        }
    }

    public NotificationResponse getNotification(String notificationId) {
        try {
            return notificationHandler.getNotification(novuConfig, notificationId);
        } catch (Exception e) {
            log.error("Error Getting Notification", e);
            throw e;
        }
    }

    public TopicResponse createTopic(TopicRequest request) {
        try {
            return topicHandler.createTopic(request, novuConfig);
        } catch (Exception e) {
            log.error("Error Creating Topic", e);
            throw e;
        }
    }
    public FilterTopicsResponse filterTopics(FilterTopicsRequest request) {
        try {
            return topicHandler.filterTopics(request, novuConfig);
        } catch (Exception e) {
            log.error("Error filtering Topic", e);
            throw e;
        }
    }

    public SubscriberAdditionResponse addSubscriberToTopic(SubscriberAdditionRequest request, String topicKey) {
        try {
            return topicHandler.addSubscriberToTopic(request,topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error adding subscriber to Topic", e);
            throw e;
        }
    }


    public CheckTopicSubscriberResponse checkTopicSubscriber(String topicKey, String externalSubscriberId) {
        try {
            return topicHandler.checkTopicSubscriber(topicKey,externalSubscriberId, novuConfig);
        } catch (Exception e) {
            log.error("Error checking topic subscriber", e);
            throw e;
        }
    }

    public SubscriberRemovalResponse removeSubscriberFromTopic(SubscriberAdditionRequest request, String topicKey) {
        try {
            return topicHandler.removeSubscriberFromTopic(request,topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error removing subscriber from Topic", e);
            throw e;
        }
    }

    public DeleteTopicResponse deleteTopic(String topicKey) {
        try {
            return topicHandler.deleteTopic(topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error Deleting Topic", e);
            throw e;
        }
    }

    public GetTopicResponse getTopic(String topicKey) {
        try {
            return topicHandler.getTopic(topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error Deleting Topic", e);
            throw e;
        }
    }





}