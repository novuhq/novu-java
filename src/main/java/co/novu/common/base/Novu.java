package co.novu.common.base;

import java.io.IOException;

import co.novu.api.blueprints.BlueprintsHandler;
import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.blueprints.responses.BlueprintsByCategoryResponse;
import co.novu.api.changes.ChangeHandler;
import co.novu.api.changes.request.ApplyChangesRequest;
import co.novu.api.changes.request.GetChangesRequest;
import co.novu.api.changes.responses.ApplyChangesResponse;
import co.novu.api.changes.responses.ChangeCountResponse;
import co.novu.api.changes.responses.GetChangesResponse;
import co.novu.api.common.SubscriberRequest;
import co.novu.api.environments.EnvironmentHandler;
import co.novu.api.environments.requests.CreateEnvironmentRequest;
import co.novu.api.environments.requests.UpdateEnvironmentRequest;
import co.novu.api.environments.responses.ApiKeyResponse;
import co.novu.api.environments.responses.BulkEnvironmentResponse;
import co.novu.api.environments.responses.SingleEnvironmentResponse;
import co.novu.api.events.EventsHandler;
import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.executivedetails.ExecutiveDetailsHandler;
import co.novu.api.executivedetails.responses.ExecutiveDetailsResponse;
import co.novu.api.feeds.FeedsHandler;
import co.novu.api.feeds.request.FeedRequest;
import co.novu.api.feeds.response.BulkFeedsResponse;
import co.novu.api.feeds.response.FeedResponse;
import co.novu.api.inboundparse.InboundParseHandler;
import co.novu.api.inboundparse.responses.ValidateMxRecordResponse;
import co.novu.api.integrations.IntegrationsHandler;
import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import co.novu.api.layouts.LayoutHandler;
import co.novu.api.layouts.requests.FilterLayoutRequest;
import co.novu.api.layouts.requests.LayoutRequest;
import co.novu.api.layouts.responses.CreateLayoutResponse;
import co.novu.api.layouts.responses.DeleteLayoutResponse;
import co.novu.api.layouts.responses.FilterLayoutResponse;
import co.novu.api.layouts.responses.GetLayoutResponse;
import co.novu.api.layouts.responses.SetDefaultLayoutResponse;
import co.novu.api.messages.MessageHandler;
import co.novu.api.messages.requests.MessageRequest;
import co.novu.api.messages.responses.DeleteMessageResponse;
import co.novu.api.messages.responses.MessageResponse;
import co.novu.api.notifications.NotificationHandler;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationGraphStatsResponse;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.api.notifications.responses.NotificationsResponse;
import co.novu.api.organizations.OrganizationHandler;
import co.novu.api.organizations.requests.CreateOrganizationRequest;
import co.novu.api.organizations.requests.UpdateMemberRoleRequest;
import co.novu.api.organizations.requests.UpdateOrganizationBrandRequest;
import co.novu.api.organizations.requests.UpdateOrganizationNameRequest;
import co.novu.api.organizations.responses.MemberResponse;
import co.novu.api.organizations.responses.OrganizationResponse;
import co.novu.api.organizations.responses.FetchOrganizationResponse;
import co.novu.api.organizations.responses.FetchMembersResponse;
import co.novu.api.organizations.responses.UpdateOrganizationBrandResponse;
import co.novu.api.organizations.responses.UpdateOrganizationNameResponse;
import co.novu.api.subscribers.SubscribersHandler;
import co.novu.api.subscribers.requests.BulkSubscriberRequest;
import co.novu.api.subscribers.requests.MarkAllMessagesRequest;
import co.novu.api.subscribers.requests.MarkMessageActionAsSeenRequest;
import co.novu.api.subscribers.requests.MarkSubscriberFeedAsRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberCredentialsRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberOnlineStatusRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberPreferenceRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.BulkSubscriberResponse;
import co.novu.api.subscribers.responses.CreateBulkSubscriberResponse;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.DeleteCredentialsResponse;
import co.novu.api.subscribers.responses.SingleSubscriberPrefResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.api.subscribers.responses.SubscriberDeleteResponse;
import co.novu.api.subscribers.responses.SubscriberNotificationResponse;
import co.novu.api.subscribers.responses.SubscriberPreferenceResponse;
import co.novu.api.subscribers.responses.UnseenNotificationsCountResponse;
import co.novu.api.tenants.TenantsHandler;
import co.novu.api.tenants.requests.GetTenantRequest;
import co.novu.api.tenants.requests.TenantRequest;
import co.novu.api.tenants.responses.BulkTenantResponse;
import co.novu.api.tenants.responses.DeleteTenantResponse;
import co.novu.api.tenants.responses.TenantResponse;
import co.novu.api.topics.TopicHandler;
import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.RenameTopicRequest;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.CheckTopicSubscriberResponse;
import co.novu.api.topics.responses.DeleteTopicResponse;
import co.novu.api.topics.responses.FilterTopicsResponse;
import co.novu.api.topics.responses.SubscriberAdditionResponse;
import co.novu.api.topics.responses.SubscriberRemovalResponse;
import co.novu.api.topics.responses.TopicResponse;
import co.novu.api.workflowgroups.WorkflowGroupHandler;
import co.novu.api.workflowgroups.request.WorkflowGroupRequest;
import co.novu.api.workflowgroups.responses.DeleteWorkflowGroup;
import co.novu.api.workflowgroups.responses.GetWorkflowGroupsResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponse;
import co.novu.api.workflowoverrides.WorkflowOverrideHandler;
import co.novu.api.workflowoverrides.request.CreateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.request.GetWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.request.UpdateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.response.BulkWorkflowOverridesResponse;
import co.novu.api.workflowoverrides.response.DeleteWorkflowOverrideResponse;
import co.novu.api.workflowoverrides.response.WorkflowOverrideResponse;
import co.novu.api.workflows.WorkflowHandler;
import co.novu.api.workflows.requests.UpdateWorkflowRequest;
import co.novu.api.workflows.requests.UpdateWorkflowStatusRequest;
import co.novu.api.workflows.requests.WorkflowRequest;
import co.novu.api.workflows.responses.BulkWorkflowResponse;
import co.novu.api.workflows.responses.DeleteWorkflowResponse;
import co.novu.api.workflows.responses.SingleWorkflowResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * Main entry point for initialising and accessing the functionalities provided in the SDK.
 * This class provides two constructors. It can be constructed either by providing an API key
 * (gotten from <a href="https://web.novu.co/settings">the web portal</a>) or by providing
 * an instance of {@link NovuConfig}.
 *
 * <p>
 * For example:
 * <pre><code>
 * // Using an API key only
 * Novu novu = new Novu("apiKey");
 * </code></pre>
 *
 * <pre><code>
 * // Using NovuConfig
 * NovuConfig novuConfig = new NovuConfig("apiKey");
 * Novu novu = new Novu(novuConfig);
 * </code></pre>
 *
 * @author Joseph Olugbohunmi <a href="https://github.com/mayorJAY">link</a>
 * @author Mukhtar Onifade <a href="https://github.com/Basfar">link</a>
 */
@Slf4j
public final class Novu {

    private final NovuConfig novuConfig;

    private final EventsHandler eventsHandler;

    private final NotificationHandler notificationHandler;

    private final TopicHandler topicHandler;

    private final SubscribersHandler subscribersHandler;

    private final IntegrationsHandler integrationsHandler;

    private final LayoutHandler layoutHandler;

    private final WorkflowHandler workflowHandler;

    private final WorkflowGroupHandler workflowGroupHandler;

    private final ChangeHandler changeHandler;

    private final EnvironmentHandler environmentHandler;

    private final InboundParseHandler inboundParseHandler;

    private final FeedsHandler feedsHandler;

    private final MessageHandler messageHandler;

    private final ExecutiveDetailsHandler executiveDetailsHandler;

    private final BlueprintsHandler blueprintsHandler;

    private final TenantsHandler tenantsHandler;

    private final OrganizationHandler organizationHandler;

    private final WorkflowOverrideHandler workflowOverrideHandler;


    /**
     * Primary constructor for initialising Novu.
     * @param apiKey API Key gotten from <a href="https://web.novu.co/settings">Settings</a>
     */
    public Novu(final String apiKey) {
        this(new NovuConfig(apiKey));
    }

    /**
     * Secondary constructor for initialising Novu.
     * @param config an instance of {@link NovuConfig}, used to provide configurations to the SDK.
     */
    public Novu(final NovuConfig config) {
        RestHandler restHandler = new RestHandler(config);
        this.novuConfig = config;
        this.eventsHandler = new EventsHandler(restHandler);
        this.notificationHandler = new NotificationHandler(restHandler);
        this.subscribersHandler = new SubscribersHandler(restHandler);
        this.topicHandler = new TopicHandler(restHandler);
        this.integrationsHandler = new IntegrationsHandler(restHandler);
        this.layoutHandler = new LayoutHandler(restHandler);
        this.workflowHandler = new WorkflowHandler(restHandler);
        this.workflowGroupHandler = new WorkflowGroupHandler(restHandler);
        this.changeHandler = new ChangeHandler(restHandler);
        this.environmentHandler = new EnvironmentHandler(restHandler);
        this.inboundParseHandler = new InboundParseHandler(restHandler);
        this.feedsHandler = new FeedsHandler(restHandler);
        this.messageHandler = new MessageHandler(restHandler);
        this.executiveDetailsHandler = new ExecutiveDetailsHandler(restHandler);
        this.blueprintsHandler = new BlueprintsHandler(restHandler);
        this.tenantsHandler = new TenantsHandler(restHandler);
        this.organizationHandler = new OrganizationHandler(restHandler);
        this.workflowOverrideHandler = new WorkflowOverrideHandler(restHandler);
    }

    /**
     * Trigger an event such as sending notification to subscribers.
     * @param request an instance of {@link TriggerEventRequest}
     * @return {@link TriggerEventResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public TriggerEventResponse triggerEvent(final TriggerEventRequest request)
            throws IOException, NovuNetworkException {
        try {
            return eventsHandler.triggerEvent(request);
        } catch (Exception e) {
            logException("Error triggering event", e);
            throw e;
        }
    }

    /**
     * Trigger multiple events in a single transaction.
     * @param request an instance of {@link BulkTriggerEventRequest}
     * @return {@link BulkTriggerEventResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkTriggerEventResponse bulkTriggerEvent(final BulkTriggerEventRequest request)
            throws IOException, NovuNetworkException {
        try {
            return eventsHandler.bulkTriggerEvent(request);
        } catch (Exception e) {
            logException("Error Triggering Event", e);
            throw e;
        }
    }

    /**
     * Broadcast an event to all existing subscribers.
     * @param request an instance of {@link TriggerEventRequest}
     * @return {@link TriggerEventResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public TriggerEventResponse broadcastEvent(final TriggerEventRequest request)
            throws IOException, NovuNetworkException {
        try {
            return eventsHandler.broadcastEvent(request);
        } catch (Exception e) {
            logException("Error BroadCasting Event", e);
            throw e;
        }
    }

    /**
     * Cancel a running event.
     * @param transactionId the transaction ID of the running event
     * @return {@link CancelEventResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public CancelEventResponse cancelTriggeredEvent(final String transactionId)
            throws IOException, NovuNetworkException {
        try {
            return eventsHandler.cancelTriggeredEvent(transactionId);
        } catch (Exception e) {
            logException("Error Canceling Event", e);
            throw e;
        }
    }

    /**
     * Retrieve all notifications ever sent with the API key provided. This function supports
     * pagination.
     * @param request an instance of {@link NotificationRequest}
     * @return {@link NotificationsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public NotificationsResponse getNotifications(final NotificationRequest request)
            throws IOException, NovuNetworkException {
        try {
            return notificationHandler.getNotifications(request);
        } catch (Exception e) {
            logException("Error Getting Notification", e);
            throw e;
        }
    }

    /**
     * Retrieve the statistics of all notifications ever sent with the API key provided.
     * @return {@link NotificationStatsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public NotificationStatsResponse getNotificationsStats()
            throws IOException, NovuNetworkException {
        try {
            return notificationHandler.getNotificationsStats();
        } catch (Exception e) {
            logException("Error Getting Notifications Stats", e);
            throw e;
        }
    }

    /**
     * Retrieve the statistics of notifications graph associated with the API key provided.
     * @return {@link NotificationGraphStatsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public NotificationGraphStatsResponse getNotificationGraphStats()
            throws IOException, NovuNetworkException {
        try {
            return notificationHandler.getNotificationGraphStats();
        } catch (Exception e) {
            logException("Error Getting Notifications Graph Stats", e);
            throw e;
        }
    }

    /**
     * Retrieve a particular Notification.
     * @param notificationId the ID of the Notification to be retrieved
     * @return {@link NotificationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public NotificationResponse getNotification(final String notificationId)
            throws IOException, NovuNetworkException {
        try {
            return notificationHandler.getNotification(notificationId);
        } catch (Exception e) {
            logException("Error Getting Notification", e);
            throw e;
        }
    }

    /**
     * Retrieve all Subscribers associated with the API key provided. This function supports pagination.
     * @param page the page number to be retrieved
     * @param limit the number of items to be retrieved
     * @return {@link BulkSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkSubscriberResponse getSubscribers(final Integer page, final Integer limit)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.getSubscribers(page, limit);
        } catch (Exception e) {
            logException("Error getting Subscribers", e);
            throw e;
        }
    }

    /**
     * Create a Subscriber.
     * @param request an instance of {@link SubscriberRequest}
     * @return {@link CreateSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public CreateSubscriberResponse createSubscriber(final SubscriberRequest request)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.createSubscriber(request);
        } catch (Exception e) {
            logException("Error creating Subscriber", e);
            throw e;
        }
    }

    /**
     * Create multiple Subscribers in a single transaction.
     * @param request an instance of {@link BulkSubscriberRequest}
     * @return {@link CreateBulkSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public CreateBulkSubscriberResponse createSubscriberBulk(final BulkSubscriberRequest request)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.createSubscriberBulk(request);
        } catch (Exception e) {
            logException("Error creating bulk Subscribers", e);
            throw e;
        }
    }

    /**
     * Retrieve a particular Subscriber.
     * @param subscriberId the ID of the Subscriber to be retrieved
     * @return {@link SingleSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleSubscriberResponse getSubscriber(final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.getSubscriber(subscriberId);
        } catch (Exception e) {
            logException("Error getting Subscriber", e);
            throw e;
        }
    }

    /**
     * Update a Subscriber.
     * @param request an instance of {@link UpdateSubscriberRequest}
     * @param subscriberId the ID of the Subscriber to be updated
     * @return {@link SingleSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleSubscriberResponse updateSubscriber(final UpdateSubscriberRequest request, final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.updateSubscriber(request, subscriberId);
        } catch (Exception e) {
            logException("Error updating Subscriber", e);
            throw e;
        }
    }

    /**
     * Delete a Subscriber.
     * @param subscriberId the ID of the Subscriber to be deleted
     * @return {@link SubscriberDeleteResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SubscriberDeleteResponse deleteSubscriber(final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.deleteSubscriber(subscriberId);
        } catch (Exception e) {
            logException("Error deleting Subscriber", e);
            throw e;
        }
    }

    /**
     * Update a Subscriber's credentials.
     * @param request an instance of {@link UpdateSubscriberCredentialsRequest}
     * @param subscriberId the ID of the Subscriber to be updated
     * @return {@link SingleSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleSubscriberResponse updateSubscriberCredentials(final UpdateSubscriberCredentialsRequest request,
                                                                final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.updateSubscriberCredentials(request, subscriberId);
        } catch (Exception e) {
            logException("Error updating Subscriber Credentials", e);
            throw e;
        }
    }

    /**
     * Delete a Subscriber's credentials.
     * @param subscriberId the ID of the Subscriber to be deleted
     * @param providerId the ID of the Provider linked to the Subscriber
     * @return {@link DeleteCredentialsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public DeleteCredentialsResponse deleteSubscriberCredentials(final String subscriberId, final String providerId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.deleteSubscriberCredentials(subscriberId, providerId);
        } catch (Exception e) {
            logException("Error deleting Subscriber Credentials", e);
            throw e;
        }
    }

    /**
     * Update a Subscriber's online status.
     * @param request an instance of {@link UpdateSubscriberOnlineStatusRequest}
     * @param subscriberId the ID of the Subscriber to be updated
     * @return {@link SingleSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleSubscriberResponse updateSubscriberOnlineStatus(final UpdateSubscriberOnlineStatusRequest request,
                                                                 final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.updateSubscriberOnlineStatus(request, subscriberId);
        } catch (Exception e) {
            logException("Error updating Subscriber Online Status", e);
            throw e;
        }
    }

    /**
     * Retrieve a Subscriber's preferences.
     * @param subscriberId the ID of the Subscriber whose preference is to be retrieved
     * @return {@link SubscriberPreferenceResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SubscriberPreferenceResponse getSubscriberPreferences(final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.getSubscriberPreferences(subscriberId);
        } catch (Exception e) {
            logException("Error getting Subscriber Preferences", e);
            throw e;
        }
    }

    /**
     * Update a Subscriber's preferences.
     * @param request an instance of {@link UpdateSubscriberPreferenceRequest}
     * @param subscriberId the ID of the Subscriber to be updated
     * @param templateId the ID of the Template linked to the Subscriber
     * @return {@link SingleSubscriberPrefResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleSubscriberPrefResponse updateSubscriberPreferences(final UpdateSubscriberPreferenceRequest request,
                                                                    final String subscriberId, final String templateId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.updateSubscriberPreferences(request, subscriberId, templateId);
        } catch (Exception e) {
            logException("Error updating Subscriber Preferences", e);
            throw e;
        }
    }

    /**
     * Retrieve all Notifications feed associated with a Subscriber. This function supports pagination.
     * @param subscriberId the ID of the Subscriber whose Notifications feed is to be retrieved
     * @return {@link SubscriberNotificationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SubscriberNotificationResponse getSubscriberNotificationsFeed(final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.getSubscriberNotificationsFeed(subscriberId);
        } catch (Exception e) {
            logException("Error getting Subscriber Notifications Feed", e);
            throw e;
        }
    }

    /**
     * Retrieve a Subscriber's unseen Notifications count.
     * @param subscriberId the ID of the Subscriber whose count is to be retrieved
     * @return {@link UnseenNotificationsCountResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public UnseenNotificationsCountResponse getSubscriberUnseenNotificationsCount(final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.getSubscriberUnseenNotificationsCount(subscriberId);
        } catch (Exception e) {
            logException("Error getting Subscriber unseen Notifications Count", e);
            throw e;
        }
    }

    /**
     * Update a particular Subscriber's Message feed (either read or seen).
     * @param request an instance of {@link MarkSubscriberFeedAsRequest}
     * @param subscriberId the ID of the Subscriber whose Message feed is to be updated
     * @return {@link SubscriberNotificationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SubscriberNotificationResponse markSubscriberMessageFeedAs(final MarkSubscriberFeedAsRequest request,
                                                                      final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.markSubscriberMessageFeedAs(request, subscriberId);
        } catch (Exception e) {
            logException("Error marking Subscriber Message Feed", e);
            throw e;
        }
    }

    /**
     * Update all the Message feeds associated to a Subscriber.
     * @param request an instance of {@link MarkAllMessagesRequest}
     * @param subscriberId the ID of the Subscriber whose Message feeds is to be updated
     * @return {@link Long}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public Long markAllSubscriberMessagesFeedAs(final MarkAllMessagesRequest request, final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.markAllSubscriberMessagesFeedAs(request, subscriberId);
        } catch (Exception e) {
            logException("Error marking all Subscriber Messages Feed", e);
            throw e;
        }
    }

    /**
     * Update the action of a Message associated to a Subscriber.
     * @param request an instance of {@link MarkMessageActionAsSeenRequest}
     * @param subscriberId the ID of the Subscriber whose Message action is to be updated
     * @param messageId the ID of the Message to be updated
     * @param type the type of action to be performed
     * @return {@link SubscriberNotificationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SubscriberNotificationResponse markMessageActionAsSeen(final MarkMessageActionAsSeenRequest request,
                                                                  final String subscriberId, final String messageId,
                                                                  final String type)
            throws IOException, NovuNetworkException {
        try {
            return subscribersHandler.markMessageActionAsSeen(request, subscriberId, messageId, type);
        } catch (Exception e) {
            logException("Error marking Message Action as seen", e);
            throw e;
        }
    }

    /**
     * Create a Topic.
     * @param request an instance of {@link TopicRequest}
     * @return {@link TopicResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public TopicResponse createTopic(final TopicRequest request) throws IOException, NovuNetworkException {
        try {
            return topicHandler.createTopic(request);
        } catch (Exception e) {
            logException("Error Creating Topic", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Topics filtered by a Topic key. This function supports pagination.
     * @param request an instance of {@link FilterTopicsRequest}
     * @return {@link FilterTopicsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public FilterTopicsResponse filterTopics(final FilterTopicsRequest request)
            throws IOException, NovuNetworkException {
        try {
            return topicHandler.filterTopics(request);
        } catch (Exception e) {
            logException("Error filtering Topic", e);
            throw e;
        }
    }

    /**
     * Add a Subscriber to a Topic.
     * @param request an instance of {@link SubscriberAdditionRequest}
     * @param topicKey the key of the Topic which the Subscriber should be added to
     * @return {@link SubscriberAdditionResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SubscriberAdditionResponse addSubscriberToTopic(final SubscriberAdditionRequest request,
                                                           final String topicKey)
            throws IOException, NovuNetworkException {
        try {
            return topicHandler.addSubscriberToTopic(request, topicKey);
        } catch (Exception e) {
            logException("Error adding subscriber to Topic", e);
            throw e;
        }
    }

    /**
     * Check if a Subscriber belongs to a Topic.
     * @param topicKey the key of the Topic to be checked
     * @param externalSubscriberId the ID of the Subscriber
     * @return {@link CheckTopicSubscriberResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public CheckTopicSubscriberResponse checkTopicSubscriber(final String topicKey, final String externalSubscriberId)
            throws IOException, NovuNetworkException {
        try {
            return topicHandler.checkTopicSubscriber(topicKey, externalSubscriberId);
        } catch (Exception e) {
            logException("Error checking topic subscriber", e);
            throw e;
        }
    }

    /**
     * Remove a Subscriber from a Topic.
     * @param request an instance of {@link SubscriberAdditionRequest}
     * @param topicKey the key of the Topic which the Subscriber should be removed from
     * @return {@link SubscriberRemovalResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SubscriberRemovalResponse removeSubscriberFromTopic(final SubscriberAdditionRequest request,
                                                               final String topicKey)
            throws IOException, NovuNetworkException {
        try {
            return topicHandler.removeSubscriberFromTopic(request, topicKey);
        } catch (Exception e) {
            logException("Error removing subscriber from Topic", e);
            throw e;
        }
    }

    /**
     * Delete a Topic.
     * @param topicKey the key of the Topic to be deleted
     * @return {@link DeleteTopicResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public DeleteTopicResponse deleteTopic(final String topicKey) throws IOException, NovuNetworkException {
        try {
            return topicHandler.deleteTopic(topicKey);
        } catch (Exception e) {
            logException("Error Deleting Topic", e);
            throw e;
        }
    }

    /**
     * Retrieve a Topic.
     * @param topicKey the key of the Topic to be retrieved
     * @return {@link TopicResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public TopicResponse getTopic(final String topicKey) throws IOException, NovuNetworkException {
        try {
            return topicHandler.getTopic(topicKey);
        } catch (Exception e) {
            logException("Error Getting Topic", e);
            throw e;
        }
    }

    /**
     * Rename a Topic.
     * @param request an instance of {@link RenameTopicRequest}
     * @param topicKey the key of the Topic to be renamed
     * @return {@link TopicResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public TopicResponse renameTopic(final RenameTopicRequest request, final String topicKey)
            throws IOException, NovuNetworkException {
        try {
            return topicHandler.renameTopic(request, topicKey);
        } catch (Exception e) {
            logException("Error renaming Topic", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Integrations associated with the API key provided.
     * @return {@link BulkIntegrationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkIntegrationResponse getIntegrations() throws IOException, NovuNetworkException {
        try {
            return integrationsHandler.getIntegrations();
        } catch (Exception e) {
            logException("Error getting Integrations", e);
            throw e;
        }
    }

    /**
     * Create an Integration.
     * @param request an instance of {@link IntegrationRequest}
     * @return {@link SingleIntegrationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleIntegrationResponse createIntegration(final IntegrationRequest request)
            throws IOException, NovuNetworkException {
        try {
            return integrationsHandler.createIntegration(request);
        } catch (Exception e) {
            logException("Error creating Integrations", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of active Integrations associated with the API key provided.
     * @return {@link BulkIntegrationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkIntegrationResponse getActiveIntegrations() throws IOException, NovuNetworkException {
        try {
            return integrationsHandler.getActiveIntegrations();
        } catch (Exception e) {
            logException("Error getting active Integrations", e);
            throw e;
        }
    }

    /**
     * Retrieve the status of a Provider's Webhook.
     * @param providerId the ID of the Provider whose status is to be retrieved
     * @return {@link ProviderWebhookStatusResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ProviderWebhookStatusResponse getProviderWebhookStatus(final String providerId)
            throws IOException, NovuNetworkException {
        try {
            return integrationsHandler.getProviderWebhookStatus(providerId);
        } catch (Exception e) {
            logException("Error getting Provider Webhook Status", e);
            throw e;
        }
    }

    /**
     * Update an Integration.
     * @param integrationId the ID of the Integration to be updated
     * @param request an instance of {@link IntegrationRequest}
     * @return {@link SingleIntegrationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleIntegrationResponse updateIntegration(final String integrationId, final IntegrationRequest request)
            throws IOException, NovuNetworkException {
        try {
            return integrationsHandler.updateIntegration(integrationId, request);
        } catch (Exception e) {
            logException("Error updating Integration", e);
            throw e;
        }
    }

    /**
     * Delete an Integration.
     * @param integrationId the ID of the Integration to be deleted
     * @return {@link BulkIntegrationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkIntegrationResponse deleteIntegration(final String integrationId)
            throws IOException, NovuNetworkException {
        try {
            return integrationsHandler.deleteIntegration(integrationId);
        } catch (Exception e) {
            logException("Error deleting Integration", e);
            throw e;
        }
    }

    /**
     * Set a particular Integration as the primary Integration.
     * @param integrationId the ID of the Integration to be set as primary
     * @return {@link SingleIntegrationResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleIntegrationResponse setIntegrationAsPrimary(final String integrationId)
            throws IOException, NovuNetworkException {
        try {
            return integrationsHandler.setIntegrationAsPrimary(integrationId);
        } catch (Exception e) {
            logException("Error setting Integration as primary", e);
            throw e;
        }
    }

    /**
     * Create a Layout.
     * @param request an instance of {@link LayoutRequest}
     * @return {@link CreateLayoutResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public CreateLayoutResponse createLayout(final LayoutRequest request) throws IOException, NovuNetworkException {
        try {
            return layoutHandler.createLayout(request);
        } catch (Exception e) {
            logException("Error creating Layout", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Layouts. This function supports pagination.
     * @param request an instance of {@link FilterLayoutRequest}
     * @return {@link FilterLayoutResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public FilterLayoutResponse filterLayout(final FilterLayoutRequest request)
            throws IOException, NovuNetworkException {
        try {
            return layoutHandler.filterLayouts(request);
        } catch (Exception e) {
            logException("Error filtering Layout", e);
            throw e;
        }
    }

    /**
     * Retrieve a Layout.
     * @param layoutId the ID of the Layout to be retrieved
     * @return {@link GetLayoutResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public GetLayoutResponse getLayout(final String layoutId) throws IOException, NovuNetworkException {
        try {
            return layoutHandler.getLayout(layoutId);
        } catch (Exception e) {
            logException("Error getting Layout", e);
            throw e;
        }
    }

    /**
     * Delete a Layout.
     * @param layoutId the ID of the Layout to be deleted
     * @return {@link DeleteLayoutResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public DeleteLayoutResponse deleteLayout(final String layoutId) throws IOException, NovuNetworkException {
        try {
            return layoutHandler.deleteLayout(layoutId);
        } catch (Exception e) {
            logException("Error Deleting Layout", e);
            throw e;
        }
    }

    /**
     * Update a Layout.
     * @param layoutId the ID of the Layout to be updated
     * @param request an instance of {@link LayoutRequest}
     * @return {@link GetLayoutResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public GetLayoutResponse updateLayout(final String layoutId, final LayoutRequest request)
            throws IOException, NovuNetworkException {
        try {
            return layoutHandler.updateLayout(layoutId, request);
        } catch (Exception e) {
            logException("Error updating Layout", e);
            throw e;
        }
    }

    /**
     * Set a Layout as the default Layout.
     * @param layoutId the ID of the Layout to be set as default
     * @return {@link SetDefaultLayoutResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SetDefaultLayoutResponse setDefaultLayout(final String layoutId) throws IOException, NovuNetworkException {
        try {
            return layoutHandler.setDefaultLayout(layoutId);
        } catch (Exception e) {
            logException("Error Setting Default Layout", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Workflows. This function supports pagination.
     * @param page the page number to be retrieved
     * @param limit the number of items to be retrieved
     * @return {@link BulkWorkflowResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkWorkflowResponse getWorkflows(final Integer page, final Integer limit)
            throws IOException, NovuNetworkException {
        try {
            return workflowHandler.getWorkflows(page, limit);
        } catch (Exception e) {
            logException("Error getting Workflows", e);
            throw e;
        }
    }

    /**
     * Create a Workflow.
     * @param request an instance of {@link WorkflowRequest}
     * @return {@link SingleWorkflowResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleWorkflowResponse createWorkflow(final WorkflowRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowHandler.createWorkflow(request);
        } catch (Exception e) {
            logException("Error creating Workflow", e);
            throw e;
        }
    }

    /**
     * Update a Workflow.
     * @param workflowId the ID of the Workflow to be updated
     * @param request an instance of {@link UpdateWorkflowRequest}
     * @return {@link SingleWorkflowResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleWorkflowResponse updateWorkflow(final String workflowId, final UpdateWorkflowRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowHandler.updateWorkflow(workflowId, request);
        } catch (Exception e) {
            logException("Error updating Workflow", e);
            throw e;
        }
    }

    /**
     * Delete a Workflow.
     * @param workflowId the ID of the Workflow to be deleted
     * @return {@link DeleteWorkflowResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public DeleteWorkflowResponse deleteWorkflow(final String workflowId) throws IOException, NovuNetworkException {
        try {
            return workflowHandler.deleteWorkflow(workflowId);
        } catch (Exception e) {
            logException("Error deleting Workflow", e);
            throw e;
        }
    }

    /**
     * Retrieve a Workflow.
     * @param workflowId the ID of the Workflow to be retrieved
     * @return {@link SingleWorkflowResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleWorkflowResponse getWorkflow(final String workflowId) throws IOException, NovuNetworkException {
        try {
            return workflowHandler.getWorkflow(workflowId);
        } catch (Exception e) {
            logException("Error getting Workflow", e);
            throw e;
        }
    }

    /**
     * Update the status of a Workflow.
     * @param workflowId the ID of the Workflow to be updated
     * @param request an instance of {@link UpdateWorkflowStatusRequest}
     * @return {@link SingleWorkflowResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleWorkflowResponse updateWorkflowStatus(final String workflowId,
                                                       final UpdateWorkflowStatusRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowHandler.updateWorkflowStatus(workflowId, request);
        } catch (Exception e) {
            logException("Error updating Workflow status", e);
            throw e;
        }
    }

    /**
     * Create a Workflow group.
     * @param request an instance of {@link WorkflowGroupRequest}
     * @return {@link WorkflowGroupResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public WorkflowGroupResponse createWorkflowGroup(final WorkflowGroupRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowGroupHandler.createWorkflowGroup(request);
        } catch (Exception e) {
            logException("Error creating workflow group", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Workflow groups.
     * @return {@link GetWorkflowGroupsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public GetWorkflowGroupsResponse getWorkflowGroups() throws IOException, NovuNetworkException {
        try {
            return workflowGroupHandler.getWorkflowGroups();
        } catch (Exception e) {
            logException("Error getting workflow groups", e);
            throw e;
        }
    }

    /**
     * Retrieve a Workflow group.
     * @param id the ID of the Workflow group to be retrieved
     * @return {@link WorkflowGroupResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public WorkflowGroupResponse getWorkflowGroup(final String id) throws IOException, NovuNetworkException {
        try {
            return workflowGroupHandler.getWorkflowGroup(id);
        } catch (Exception e) {
            logException("Error getting workflow group", e);
            throw e;
        }
    }

    /**
     * Update a Workflow group.
     * @param id the ID of the Workflow group to be updated
     * @param request an instance of {@link WorkflowGroupRequest}
     * @return {@link WorkflowGroupResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public WorkflowGroupResponse updateWorkflowGroup(final String id, final WorkflowGroupRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowGroupHandler.updateWorkflowGroup(id, request);
        } catch (Exception e) {
            logException("Error updating workflow group", e);
            throw e;
        }
    }

    /**
     * Delete a Workflow group.
     * @param id the ID of the Workflow group to be deleted
     * @return {@link DeleteWorkflowGroup}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public DeleteWorkflowGroup deleteWorkflowGroup(final String id) throws IOException, NovuNetworkException {
        try {
            return workflowGroupHandler.deleteWorkflowGroup(id);
        } catch (Exception e) {
            logException("Error deleting workflow group", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Changes. This function supports pagination.
     * @param request an instance of {@link GetChangesRequest}
     * @return {@link GetChangesResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public GetChangesResponse getChanges(final GetChangesRequest request) throws IOException, NovuNetworkException {
        try {
            return changeHandler.getChanges(request);
        } catch (Exception e) {
            logException("Error getting changes", e);
            throw e;
        }
    }

    /**
     * Retrieve the count of all available Changes.
     * @return {@link ChangeCountResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ChangeCountResponse getChangesCount() throws IOException, NovuNetworkException {
        try {
            return changeHandler.getChangesCount();
        } catch (Exception e) {
            logException("Error getting changes count", e);
            throw e;
        }
    }

    /**
     * Apply a list of Changes.
     * @param request an instance of {@link ApplyChangesRequest}
     * @return {@link ApplyChangesResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ApplyChangesResponse applyChanges(final ApplyChangesRequest request)
            throws IOException, NovuNetworkException {
        try {
            return changeHandler.applyChanges(request);
        } catch (Exception e) {
            logException("Error applying changes", e);
            throw e;
        }
    }

    /**
     * Apply a particular Change.
     * @param changeId the ID of the Change to be applied
     * @return {@link ApplyChangesResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ApplyChangesResponse applyChange(final String changeId) throws IOException, NovuNetworkException {
        try {
            return changeHandler.applyChange(changeId);
        } catch (Exception e) {
            logException("Error applying change", e);
            throw e;
        }
    }

    /**
     * Retrieve the data of the current Environment.
     * @return {@link SingleEnvironmentResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleEnvironmentResponse getCurrentEnvironment() throws IOException, NovuNetworkException {
        try {
            return environmentHandler.getCurrentEnvironment();
        } catch (Exception e) {
            logException("Error getting current Environment", e);
            throw e;
        }
    }

    /**
     * Create an Environment.
     * @param request an instance of {@link CreateEnvironmentRequest}
     * @return {@link SingleEnvironmentResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleEnvironmentResponse createEnvironment(final CreateEnvironmentRequest request)
            throws IOException, NovuNetworkException {
        try {
            return environmentHandler.createEnvironment(request);
        } catch (Exception e) {
            logException("Error creating Environment", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Environments.
     * @return {@link BulkEnvironmentResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkEnvironmentResponse getEnvironments() throws IOException, NovuNetworkException {
        try {
            return environmentHandler.getEnvironments();
        } catch (Exception e) {
            logException("Error getting Environments", e);
            throw e;
        }
    }

    /**
     * Update an Environment.
     * @param environmentId the ID of the Environment to be updated
     * @param request an instance of {@link UpdateEnvironmentRequest}
     * @return {@link SingleEnvironmentResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public SingleEnvironmentResponse updateEnvironmentById(final String environmentId,
                                                           final UpdateEnvironmentRequest request)
            throws IOException, NovuNetworkException {
        try {
            return environmentHandler.updateEnvironmentById(environmentId, request);
        } catch (Exception e) {
            logException("Error updating Environment by ID", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of API Keys.
     * @return {@link ApiKeyResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ApiKeyResponse getApiKeys() throws IOException, NovuNetworkException {
        try {
            return environmentHandler.getApiKeys();
        } catch (Exception e) {
            logException("Error getting Api Keys", e);
            throw e;
        }
    }

    /**
     * Regenerate API Keys.
     * @return {@link ApiKeyResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ApiKeyResponse regenerateApiKeys() throws IOException, NovuNetworkException {
        try {
            return environmentHandler.regenerateApiKeys();
        } catch (Exception e) {
            logException("Error regenerating Api Keys", e);
            throw e;
        }
    }

    /**
     * Validate the mx record setup for the inbound parse functionality.
     * @return {@link ValidateMxRecordResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ValidateMxRecordResponse validateMxRecordSetupForInboundParse() throws IOException, NovuNetworkException {
        try {
            return inboundParseHandler.validateMxRecordSetupForInboundParse();
        } catch (Exception e) {
            logException("Error validating Mx record setup", e);
            throw e;
        }
    }

    /**
     * Create a Feed.
     * @param request an instance of {@link FeedRequest}
     * @return {@link FeedResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public FeedResponse createFeed(final FeedRequest request) throws IOException, NovuNetworkException {
        try {
            return feedsHandler.createFeed(request);
        } catch (Exception e) {
            logException("Error creating feed", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Feeds.
     * @return {@link BulkFeedsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkFeedsResponse getFeeds() throws IOException, NovuNetworkException {
        try {
            return feedsHandler.getFeeds();
        } catch (Exception e) {
            logException("Error getting feed", e);
            throw e;
        }
    }

    /**
     * Delete a Feed.
     * @param feedId the ID of the Feed to be deleted
     * @return {@link BulkFeedsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public BulkFeedsResponse deleteFeed(final String feedId) throws IOException, NovuNetworkException {
        try {
            return feedsHandler.deleteFeed(feedId);
        } catch (Exception e) {
            logException("Error deleting feed", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Messages. This function supports pagination.
     * @param request an instance of {@link MessageRequest}
     * @return {@link MessageResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public MessageResponse getMessages(final MessageRequest request) throws IOException, NovuNetworkException {
        try {
            return messageHandler.getMessages(request);
        } catch (Exception e) {
            logException("Error getting Messages", e);
            throw e;
        }
    }

    /**
     * Delete a Message.
     * @param messageId the ID of the Message to be deleted
     * @return {@link DeleteMessageResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public DeleteMessageResponse deleteMessage(final String messageId) throws IOException, NovuNetworkException {
        try {
            return messageHandler.deleteMessage(messageId);
        } catch (Exception e) {
            logException("Error deleting Message", e);
            throw e;
        }
    }

    /**
     * Retrieve a list of Execution Details.
     * @param notificationId the ID of a Notification
     * @param subscriberId the ID of a Subscriber
     * @return {@link ExecutiveDetailsResponse}
     * @throws IOException if a problem occurred talking to the server
     * @throws NovuNetworkException if there is a connection error
     */
    public ExecutiveDetailsResponse getExecutionDetails(final String notificationId, final String subscriberId)
            throws IOException, NovuNetworkException {
        try {
            return executiveDetailsHandler.getExecutionDetails(notificationId, subscriberId);
        } catch (Exception e) {
            logException("Error getting Execution Details", e);
            throw e;
        }
    }

    public BlueprintsByCategoryResponse getBlueprintsByCategory() throws IOException, NovuNetworkException {
        try {
            return blueprintsHandler.getBlueprintsByCategory();
        } catch (Exception e) {
            logException("Error getting Blueprints by Category", e);
            throw e;
        }
    }

    public Blueprint getBlueprint(final String templateId) throws IOException, NovuNetworkException {
        try {
            return blueprintsHandler.getBlueprint(templateId);
        } catch (Exception e) {
            logException("Error getting Blueprint", e);
            throw e;
        }
    }

    public BulkTenantResponse getTenants(final GetTenantRequest request) throws IOException, NovuNetworkException {
        try {
            return tenantsHandler.getTenants(request);
        } catch (Exception e) {
            logException("Error getting Tenants", e);
            throw e;
        }
    }

    public TenantResponse createTenant(final TenantRequest request) throws IOException, NovuNetworkException {
        try {
            return tenantsHandler.createTenant(request);
        } catch (Exception e) {
            logException("Error creating Tenant", e);
            throw e;
        }
    }

    public TenantResponse getTenant(final String identifier) throws IOException, NovuNetworkException {
        try {
            return tenantsHandler.getTenant(identifier);
        } catch (Exception e) {
            logException("Error getting Tenant", e);
            throw e;
        }
    }

    public TenantResponse updateTenant(final TenantRequest request, final String identifier)
            throws IOException, NovuNetworkException {
        try {
            return tenantsHandler.updateTenant(request, identifier);
        } catch (Exception e) {
            logException("Error updating Tenant", e);
            throw e;
        }
    }

    public DeleteTenantResponse deleteTenant(final String identifier) throws IOException, NovuNetworkException {
        try {
            return tenantsHandler.deleteTenant(identifier);
        } catch (Exception e) {
            logException("Error deleting Tenant", e);
            throw e;
        }
    }

    public OrganizationResponse createOrganization(final CreateOrganizationRequest request)
            throws IOException, NovuNetworkException {
        try {
            return organizationHandler.createOrganization(request);
        } catch (Exception e) {
            logException("Error creating Organization", e);
            throw e;
        }
    }

    public FetchOrganizationResponse fetchAllOrganizations() throws IOException, NovuNetworkException {
        try {
            return organizationHandler.fetchAllOrganizations();
        } catch (Exception e) {
            logException("Error fetching Organizations", e);
            throw e;
        }
    }

    public UpdateOrganizationNameResponse updateOrganizationName(final UpdateOrganizationNameRequest request)
            throws IOException, NovuNetworkException {
        try {
            return organizationHandler.updateOrganizationName(request);
        } catch (Exception e) {
            logException("Error Updating Organization Name", e);
            throw e;
        }
    }

    public OrganizationResponse fetchCurrentOrganization() throws IOException, NovuNetworkException {
        try {
            return organizationHandler.fetchCurrentOrganization();
        } catch (Exception e) {
            logException("Error Fetching Current Organization", e);
            throw e;
        }
    }

    public MemberResponse removeMemberWithId(final String memberId) throws IOException, NovuNetworkException {
        try {
            return organizationHandler.removeMemberWithId(memberId);
        } catch (Exception e) {
            logException("Error Removing Member With MemberId", e);
            throw e;
        }
    }

    public MemberResponse updateMemberRole(final String memberId, final UpdateMemberRoleRequest request)
            throws IOException, NovuNetworkException {
        try {
            return organizationHandler.updateMemberRole(memberId, request);
        } catch (Exception e) {
            logException("Error Updating Member Role", e);
            throw e;
        }
    }

    public FetchMembersResponse fetchMembersOfOrganization() throws IOException, NovuNetworkException {
        try {
            return organizationHandler.fetchMembersOfOrganization();
        } catch (Exception e) {
            logException("Error Fetching Organization Members", e);
            throw e;
        }
    }

    public UpdateOrganizationBrandResponse updateOrganizationBrand(final UpdateOrganizationBrandRequest request)
            throws IOException, NovuNetworkException {
        try {
            return organizationHandler.updateOrganizationBrand(request);
        } catch (Exception e) {
            logException("Error Updating Organization Brand", e);
            throw e;
        }
    }

    public WorkflowOverrideResponse createWorkflowOverride(final CreateWorkflowOverrideRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowOverrideHandler.createWorkflowOverride(request);
        } catch (Exception e) {
            logException("Error creating Workflow-Override", e);
            throw e;
        }
    }

    public BulkWorkflowOverridesResponse getWorkflowOverrides(final GetWorkflowOverrideRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowOverrideHandler.getWorkflowOverrides(request);
        } catch (Exception e) {
            logException("Error fetching bulk Workflow-Override", e);
            throw e;
        }
    }

    public WorkflowOverrideResponse getWorkflowOverride(final String workflowId, final String tenantId)
            throws IOException, NovuNetworkException {
        try {
            return workflowOverrideHandler.getWorkflowOverride(workflowId, tenantId);
        } catch (Exception e) {
            logException("Error fetching Workflow-Override", e);
            throw e;
        }
    }

    public WorkflowOverrideResponse getWorkflowOverrideById(final String overrideId)
            throws IOException, NovuNetworkException {
        try {
            return workflowOverrideHandler.getWorkflowOverrideById(overrideId);
        } catch (Exception e) {
            logException("Error fetching Workflow-Override by id", e);
            throw e;
        }
    }

    public WorkflowOverrideResponse updateWorkflowOverrideById(final String overrideId,
                                                               final UpdateWorkflowOverrideRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowOverrideHandler.updateWorkflowOverrideById(overrideId, request);
        } catch (Exception e) {
            logException("Error updating Workflow-Override by id", e);
            throw e;
        }
    }

    public WorkflowOverrideResponse updateWorkflowOverride(final String workflowId, final String tenantId,
                                                           final UpdateWorkflowOverrideRequest request)
            throws IOException, NovuNetworkException {
        try {
            return workflowOverrideHandler.updateWorkflowOverride(workflowId, tenantId, request);
        } catch (Exception e) {
            logException("Error updating Workflow-Override", e);
            throw e;
        }
    }

    public DeleteWorkflowOverrideResponse deleteWorkflowOverride(final String overrideId)
            throws IOException, NovuNetworkException {
        try {
            return workflowOverrideHandler.deleteWorkflowOverride(overrideId);
        } catch (Exception e) {
            logException("Error deleting Workflow-Override", e);
            throw e;
        }
    }

    private void logException(final String message, final Exception e) {
        if (!novuConfig.isEnableLogging()) {
            return;
        }
        log.error(message, e);
    }
}
