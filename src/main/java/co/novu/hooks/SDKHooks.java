package co.novu.hooks;

//
// This file is written once by speakeasy code generation and
// thereafter will not be overwritten by speakeasy updates. As a
// consequence any customization of this class will be preserved.
//

public final class SDKHooks {

    private SDKHooks() {
        // prevent instantiation
    }

    public static void initialize(co.novu.utils.Hooks hooks) {
        // Register custom Novu synchronous hooks
        NovuHooks novuHooks = new NovuHooks();
        hooks.registerBeforeRequest(novuHooks);
        hooks.registerAfterSuccess(novuHooks);

        // for more information see
        // https://www.speakeasy.com/docs/additional-features/sdk-hooks
    }

    public static void initialize(co.novu.utils.AsyncHooks asyncHooks) {
        // Register custom Novu async hooks
        NovuAsyncHooks novuAsyncHooks = new NovuAsyncHooks();
        asyncHooks.registerBeforeRequest(novuAsyncHooks);
        asyncHooks.registerAfterSuccess(novuAsyncHooks);

        // for more information see
        // https://www.speakeasy.com/docs/additional-features/sdk-hooks
    }

}
