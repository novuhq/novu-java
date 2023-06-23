package co.novu.common.base;

public class Novu {

    private final NovuConfig novuConfig;

    public Novu(String apiKey) {
        NovuConfig config = new NovuConfig();
        config.setApiKey(apiKey);
        this.novuConfig = config;
    }

    public Novu(NovuConfig novuConfig) {
        this.novuConfig = novuConfig;
    }

    public void triggerEvent() {
        //Delegate action to EventsHandler
    }

    public void getNotification() {
        //Delegate action to NotificationsHandler
    }
}