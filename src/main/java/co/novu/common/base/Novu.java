package co.novu.common.base;

import co.novu.api.events.EventsHandler;
import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.integrations.IntegrationsHandler;
import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import co.novu.api.notifications.NotificationHandler;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationGraphStatsResponse;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.api.notifications.responses.NotificationsResponse;
import co.novu.api.topics.TopicHandler;
import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.RenameTopicRequest;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.TopicResponse;
import co.novu.api.topics.responses.SubscriberAdditionResponse;
import co.novu.api.topics.responses.FilterTopicsResponse;
import co.novu.api.subscribers.SubscribersHandler;
import co.novu.api.subscribers.requests.MarkMessageActionAsSeenRequest;
import co.novu.api.subscribers.requests.MarkSubscriberFeedAsRequest;
import co.novu.api.subscribers.responses.SubscriberNotificationResponse;
import co.novu.api.common.SubscriberRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberCredentialsRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberOnlineStatusRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberPreferenceRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.BulkSubscriberResponse;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.api.subscribers.responses.SubscriberDeleteResponse;
import co.novu.api.subscribers.responses.SubscriberPreferenceResponse;
import co.novu.api.subscribers.responses.UnseenNotificationsCountResponse;
import co.novu.common.rest.RestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

@Slf4j
public class Novu {

    private final NovuConfig novuConfig;
    private final RestHandler restHandler;
    private EventsHandler eventsHandler;
    private NotificationHandler notificationHandler;

    private TopicHandler topicHandler;

    private SubscribersHandler subscribersHandler;

    private IntegrationsHandler integrationsHandler;


    public Novu(String apiKey) {
        this(new NovuConfig(apiKey));
    }

    public Novu(NovuConfig novuConfig) {
        this.novuConfig = novuConfig;
        this.restHandler = new RestHandler();
        this.eventsHandler = new EventsHandler(restHandler);
        this.notificationHandler = new NotificationHandler(restHandler);
        this.topicHandler = new TopicHandler(restHandler);
        this.subscribersHandler = new SubscribersHandler(restHandler);
        this.integrationsHandler = new IntegrationsHandler(restHandler, novuConfig);
    }

    protected Novu(NovuConfig novuConfig, RestHandler restHandler) {
        this.novuConfig = novuConfig;
        this.restHandler = restHandler;
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

    public BulkSubscriberResponse getSubscribers(@Nullable Integer page, @Nullable Integer limit) {
        try {
            return subscribersHandler.getSubscribers(novuConfig, page, limit);
        } catch (Exception e) {
            log.error("Error getting Subscribers", e);
            throw e;
        }
    }

    public CreateSubscriberResponse createSubscriber(SubscriberRequest request) {
        try {
            return subscribersHandler.createSubscriber(request, novuConfig);
        } catch (Exception e) {
            log.error("Error creating Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse getSubscriber(String subscriberId) {
        try {
            return subscribersHandler.getSubscriber(novuConfig, subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriber(UpdateSubscriberRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriber(request, subscriberId, novuConfig);
        } catch (Exception e) {
            log.error("Error updating Subscriber", e);
            throw e;
        }
    }

    public SubscriberDeleteResponse deleteSubscriber(String subscriberId) {
        try {
            return subscribersHandler.deleteSubscriber(novuConfig, subscriberId);
        } catch (Exception e) {
            log.error("Error deleting Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriberCredentials(UpdateSubscriberCredentialsRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriberCredentials(request, subscriberId, novuConfig);
        } catch (Exception e) {
            log.error("Error updating Subscriber Credentials", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriberOnlineStatus(UpdateSubscriberOnlineStatusRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriberOnlineStatus(request, subscriberId, novuConfig);
        } catch (Exception e) {
            log.error("Error updating Subscriber Online Status", e);
            throw e;
        }
    }

    public SubscriberPreferenceResponse getSubscriberPreferences(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberPreferences(novuConfig, subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber Preferences", e);
            throw e;
        }
    }

    public SubscriberPreferenceResponse updateSubscriberPreferences(UpdateSubscriberPreferenceRequest request, String subscriberId, String templateId) {
        try {
            return subscribersHandler.updateSubscriberPreferences(request, subscriberId, templateId, novuConfig);
        } catch (Exception e) {
            log.error("Error updating Subscriber Preferences", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse getSubscriberNotificationsFeed(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberNotificationsFeed(novuConfig, subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber Notifications Feed", e);
            throw e;
        }
    }

    public UnseenNotificationsCountResponse getSubscriberUnseenNotificationsCount(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberUnseenNotificationsCount(novuConfig, subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber unseen Notifications Count", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse markSubscriberMessageFeedAs(MarkSubscriberFeedAsRequest request, String subscriberId) {
        try {
            return subscribersHandler.markSubscriberMessageFeedAs(request, subscriberId, novuConfig);
        } catch (Exception e) {
            log.error("Error marking Subscriber Message Feed", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse markMessageActionAsSeen(MarkMessageActionAsSeenRequest request, String subscriberId, String messageId, String type) {
        try {
            return subscribersHandler.markMessageActionAsSeen(request, subscriberId, messageId, type, novuConfig);
        } catch (Exception e) {
            log.error("Error marking Message Action as seen", e);
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
    public TopicResponse checkTopicSubscriber(String topicKey, String externalSubscriberId) {
        try {
            return topicHandler.checkTopicSubscriber(topicKey,externalSubscriberId, novuConfig);
        } catch (Exception e) {
            log.error("Error checking topic subscriber", e);
            throw e;
        }
    }


    public Void removeSubscriberFromTopic(SubscriberAdditionRequest request, String topicKey) {
        try {
            return topicHandler.removeSubscriberFromTopic(request,topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error removing subscriber from Topic", e);
            throw e;
        }
    }

    public Void deleteTopic(String topicKey) {
        try {
            return topicHandler.deleteTopic(topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error Deleting Topic", e);
            throw e;
        }
    }


    public TopicResponse getTopic(String topicKey) {
        try {
            return topicHandler.getTopic(topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error Getting Topic", e);
            throw e;
        }
    }

    public TopicResponse renameTopic(RenameTopicRequest request,String topicKey) {
        try {
            return topicHandler.renameTopic(request,topicKey, novuConfig);
        } catch (Exception e) {
            log.error("Error renaming Topic", e);
            throw e;
        }
    }

    public BulkIntegrationResponse getIntegrations() {
        try {
            return integrationsHandler.getIntegrations();
        } catch (Exception e) {
            log.error("Error getting Integrations", e);
            throw e;
        }
    }

    public SingleIntegrationResponse createIntegration(IntegrationRequest request) {
        try {
            return integrationsHandler.createIntegration(request);
        } catch (Exception e) {
            log.error("Error creating Integrations", e);
            throw e;
        }
    }

    public BulkIntegrationResponse getActiveIntegrations() {
        try {
            return integrationsHandler.getActiveIntegrations();
        } catch (Exception e) {
            log.error("Error getting active Integrations", e);
            throw e;
        }
    }

    public ProviderWebhookStatusResponse getProviderWebhookStatus(String providerId) {
        try {
            return integrationsHandler.getProviderWebhookStatus(providerId);
        } catch (Exception e) {
            log.error("Error getting Provider Webhook Status", e);
            throw e;
        }
    }

    public SingleIntegrationResponse updateIntegration(String integrationId, IntegrationRequest request) {
        try {
            return integrationsHandler.updateIntegration(integrationId, request);
        } catch (Exception e) {
            log.error("Error updating Integration", e);
            throw e;
        }
    }

    public BulkIntegrationResponse deleteIntegration(String integrationId) {
        try {
            return integrationsHandler.deleteIntegration(integrationId);
        } catch (Exception e) {
            log.error("Error deleting Integration", e);
            throw e;
        }
    }
}