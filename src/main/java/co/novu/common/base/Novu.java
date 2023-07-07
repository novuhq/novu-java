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
import co.novu.api.layouts.LayoutHandler;
import co.novu.api.layouts.requests.FilterLayoutRequest;
import co.novu.api.layouts.requests.LayoutRequest;
import co.novu.api.layouts.responses.FilterLayoutResponse;
import co.novu.api.layouts.responses.GetLayoutResponse;
import co.novu.api.layouts.responses.CreateLayoutResponse;
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
import co.novu.api.workflows.WorkflowHandler;
import co.novu.api.workflows.requests.UpdateWorkflowStatusRequest;
import co.novu.api.workflows.requests.WorkflowRequest;
import co.novu.api.workflows.responses.BulkWorkflowResponse;
import co.novu.api.workflows.responses.DeleteWorkflowResponse;
import co.novu.api.workflows.responses.SingleWorkflowResponse;
import co.novu.common.rest.RestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

@Slf4j
public class Novu {

    private final RestHandler restHandler;
    private EventsHandler eventsHandler;
    private NotificationHandler notificationHandler;

    private TopicHandler topicHandler;

    private SubscribersHandler subscribersHandler;

    private IntegrationsHandler integrationsHandler;

    private LayoutHandler layoutHandler;

    private WorkflowHandler workflowHandler;


    public Novu(String apiKey) {
        this(new NovuConfig(apiKey));
    }

    public Novu(NovuConfig novuConfig) {
        this.restHandler = new RestHandler();
        this.eventsHandler = new EventsHandler(restHandler, novuConfig);
        this.notificationHandler = new NotificationHandler(restHandler, novuConfig);
        this.subscribersHandler = new SubscribersHandler(restHandler, novuConfig);
        this.topicHandler = new TopicHandler(restHandler, novuConfig);
        this.integrationsHandler = new IntegrationsHandler(restHandler, novuConfig);
        this.layoutHandler = new LayoutHandler(restHandler, novuConfig);
        this.workflowHandler = new WorkflowHandler(restHandler, novuConfig);
    }

    // For Tests purpose
    protected Novu(RestHandler restHandler) {
        this.restHandler = restHandler;
    }

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) {
        try {
            return eventsHandler.triggerEvent(request);
        }catch (Exception e){
            log.error("Error triggering event", e);
            throw e;
        }
    }

    public BulkTriggerEventResponse bulkTriggerEvent(BulkTriggerEventRequest request) {
        try {
            return eventsHandler.bulkTriggerEvent(request);
        } catch (Exception e) {
            log.error("Error Triggering Event", e);
            throw e;
        }
    }

    public TriggerEventResponse broadcastEvent(TriggerEventRequest request) {
        try {
            return eventsHandler.broadcastEvent(request);
        } catch (Exception e) {
            log.error("Error BroadCasting Event", e);
            throw e;
        }
    }

    public CancelEventResponse cancelTriggeredEvent(String transactionId) {
        try {
            return eventsHandler.cancelTriggeredEvent(transactionId);
        } catch (Exception e) {
            log.error("Error Canceling Event", e);
            throw e;
        }
    }

    public NotificationsResponse getNotifications(NotificationRequest request) {
        try {
            return notificationHandler.getNotifications(request);
        } catch (Exception e) {
            log.error("Error Getting Notification", e);
            throw e;
        }
    }

    public NotificationStatsResponse getNotificationsStats() {
        try {
            return notificationHandler.getNotificationsStats();
        } catch (Exception e) {
            log.error("Error Getting Notifications Stats", e);
            throw e;
        }
    }

    public NotificationGraphStatsResponse getNotificationGraphStats() {
        try {
            return notificationHandler.getNotificationGraphStats();
        } catch (Exception e) {
            log.error("Error Getting Notifications Graph Stats", e);
            throw e;
        }
    }

    public NotificationResponse getNotification(String notificationId) {
        try {
            return notificationHandler.getNotification(notificationId);
        } catch (Exception e) {
            log.error("Error Getting Notification", e);
            throw e;
        }
    }

    public BulkSubscriberResponse getSubscribers(@Nullable Integer page, @Nullable Integer limit) {
        try {
            return subscribersHandler.getSubscribers(page, limit);
        } catch (Exception e) {
            log.error("Error getting Subscribers", e);
            throw e;
        }
    }

    public CreateSubscriberResponse createSubscriber(SubscriberRequest request) {
        try {
            return subscribersHandler.createSubscriber(request);
        } catch (Exception e) {
            log.error("Error creating Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse getSubscriber(String subscriberId) {
        try {
            return subscribersHandler.getSubscriber(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriber(UpdateSubscriberRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriber(request, subscriberId);
        } catch (Exception e) {
            log.error("Error updating Subscriber", e);
            throw e;
        }
    }

    public SubscriberDeleteResponse deleteSubscriber(String subscriberId) {
        try {
            return subscribersHandler.deleteSubscriber(subscriberId);
        } catch (Exception e) {
            log.error("Error deleting Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriberCredentials(UpdateSubscriberCredentialsRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriberCredentials(request, subscriberId);
        } catch (Exception e) {
            log.error("Error updating Subscriber Credentials", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriberOnlineStatus(UpdateSubscriberOnlineStatusRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriberOnlineStatus(request, subscriberId);
        } catch (Exception e) {
            log.error("Error updating Subscriber Online Status", e);
            throw e;
        }
    }

    public SubscriberPreferenceResponse getSubscriberPreferences(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberPreferences(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber Preferences", e);
            throw e;
        }
    }

    public SubscriberPreferenceResponse updateSubscriberPreferences(UpdateSubscriberPreferenceRequest request, String subscriberId, String templateId) {
        try {
            return subscribersHandler.updateSubscriberPreferences(request, subscriberId, templateId);
        } catch (Exception e) {
            log.error("Error updating Subscriber Preferences", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse getSubscriberNotificationsFeed(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberNotificationsFeed(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber Notifications Feed", e);
            throw e;
        }
    }

    public UnseenNotificationsCountResponse getSubscriberUnseenNotificationsCount(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberUnseenNotificationsCount(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber unseen Notifications Count", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse markSubscriberMessageFeedAs(MarkSubscriberFeedAsRequest request, String subscriberId) {
        try {
            return subscribersHandler.markSubscriberMessageFeedAs(request, subscriberId);
        } catch (Exception e) {
            log.error("Error marking Subscriber Message Feed", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse markMessageActionAsSeen(MarkMessageActionAsSeenRequest request, String subscriberId, String messageId, String type) {
        try {
            return subscribersHandler.markMessageActionAsSeen(request, subscriberId, messageId, type);
        } catch (Exception e) {
            log.error("Error marking Message Action as seen", e);
            throw e;
        }
    }

    public TopicResponse createTopic(TopicRequest request) {
        try {
            return topicHandler.createTopic(request);
        } catch (Exception e) {
            log.error("Error Creating Topic", e);
            throw e;
        }
    }

    public FilterTopicsResponse filterTopics(FilterTopicsRequest request) {
        try {
            return topicHandler.filterTopics(request);
        } catch (Exception e) {
            log.error("Error filtering Topic", e);
            throw e;
        }
    }

    public SubscriberAdditionResponse addSubscriberToTopic(SubscriberAdditionRequest request, String topicKey) {
        try {
            return topicHandler.addSubscriberToTopic(request, topicKey);
        } catch (Exception e) {
            log.error("Error adding subscriber to Topic", e);
            throw e;
        }
    }

    public TopicResponse checkTopicSubscriber(String topicKey, String externalSubscriberId) {
        try {
            return topicHandler.checkTopicSubscriber(topicKey, externalSubscriberId);
        } catch (Exception e) {
            log.error("Error checking topic subscriber", e);
            throw e;
        }
    }

    public Void removeSubscriberFromTopic(SubscriberAdditionRequest request, String topicKey) {
        try {
            return topicHandler.removeSubscriberFromTopic(request, topicKey);
        } catch (Exception e) {
            log.error("Error removing subscriber from Topic", e);
            throw e;
        }
    }

    public Void deleteTopic(String topicKey) {
        try {
            return topicHandler.deleteTopic(topicKey);
        } catch (Exception e) {
            log.error("Error Deleting Topic", e);
            throw e;
        }
    }

    public TopicResponse getTopic(String topicKey) {
        try {
            return topicHandler.getTopic(topicKey);
        } catch (Exception e) {
            log.error("Error Getting Topic", e);
            throw e;
        }
    }

    public TopicResponse renameTopic(RenameTopicRequest request, String topicKey) {
        try {
            return topicHandler.renameTopic(request, topicKey);
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

    public CreateLayoutResponse createLayout(LayoutRequest request) {
        try {
            return layoutHandler.createLayout(request);
        } catch (Exception e) {
            log.error("Error creating Layout", e);
            throw e;
        }
    }

    public FilterLayoutResponse filterLayout(FilterLayoutRequest request) {
        try {
            return layoutHandler.filterLayouts(request);
        } catch (Exception e) {
            log.error("Error filtering Layout", e);
            throw e;
        }
    }

    public GetLayoutResponse getLayout(String layoutId) {
        try {
            return layoutHandler.getLayout(layoutId);
        } catch (Exception e) {
            log.error("Error getting Layouts", e);
            throw e;
        }
    }

    public Void deleteLayout(String layoutId) {
        try {
            return layoutHandler.deleteLayout(layoutId);
        } catch (Exception e) {
            log.error("Error Deleting Layout", e);
            throw e;
        }
    }

    public GetLayoutResponse updateIntegration(String layoutId, LayoutRequest request) {
        try {
            return layoutHandler.updateLayout(layoutId, request);
        } catch (Exception e) {
            log.error("Error updating Layout", e);
            throw e;
        }
    }

    public Void setDefaultLayout(String layoutId) {
        try {
            return layoutHandler.setDefaultLayout(layoutId);
        } catch (Exception e) {
            log.error("Error Setting Default Layout", e);
            throw e;
        }
    }

    public BulkWorkflowResponse getWorkflows(@Nullable Integer page, @Nullable Integer limit) {
        try {
            return workflowHandler.getWorkflows(page, limit);
        } catch (Exception e) {
            log.error("Error getting Workflows", e);
            throw e;
        }
    }

    public SingleWorkflowResponse createWorkflow(WorkflowRequest request) {
        try {
            return workflowHandler.createWorkflow(request);
        } catch (Exception e) {
            log.error("Error creating Workflow", e);
            throw e;
        }
    }

    public SingleWorkflowResponse updateWorkflow(String workflowId, WorkflowRequest request) {
        try {
            return workflowHandler.updateWorkflow(workflowId, request);
        } catch (Exception e) {
            log.error("Error updating Workflow", e);
            throw e;
        }
    }

    public DeleteWorkflowResponse deleteWorkflow(String workflowId) {
        try {
            return workflowHandler.deleteWorkflow(workflowId);
        } catch (Exception e) {
            log.error("Error deleting Workflow", e);
            throw e;
        }
    }

    public SingleWorkflowResponse getWorkflow(String workflowId) {
        try {
            return workflowHandler.getWorkflow(workflowId);
        } catch (Exception e) {
            log.error("Error getting Workflow", e);
            throw e;
        }
    }

    public SingleWorkflowResponse updateWorkflowStatus(String workflowId, UpdateWorkflowStatusRequest request) {
        try {
            return workflowHandler.updateWorkflowStatus(workflowId, request);
        } catch (Exception e) {
            log.error("Error updating Workflow status", e);
            throw e;
        }
    }
}