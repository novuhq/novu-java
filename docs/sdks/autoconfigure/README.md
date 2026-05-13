# Domains.AutoConfigure

## Overview

### Available Operations

* [retrieve](#retrieve) - Retrieve auto-configuration availability
* [start](#start) - Start DNS auto-configuration

## retrieve

Returns whether DNS auto-configuration (Domain Connect) is available for this domain. When `available` is `false`, `manualRecords` lists the DNS records the customer must add manually.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_getDomainAutoConfigure" method="get" path="/v1/domains/{domain}/auto-configure" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerGetDomainAutoConfigureResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerGetDomainAutoConfigureResponse res = sdk.domains().autoConfigure().retrieve()
                .domain("hidden-subsidy.info")
                .call();

        if (res.domainConnectStatusResponseDto().isPresent()) {
            System.out.println(res.domainConnectStatusResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `domain`                          | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[DomainsControllerGetDomainAutoConfigureResponse](../../models/operations/DomainsControllerGetDomainAutoConfigureResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## start

Generates a signed redirect URL the customer can follow to apply Novu DNS records at their DNS provider. After the provider completes the flow, it redirects back to `redirectUri`.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_startDomainAutoConfigure" method="post" path="/v1/domains/{domain}/auto-configure/start" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateDomainConnectApplyUrlDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerStartDomainAutoConfigureResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerStartDomainAutoConfigureResponse res = sdk.domains().autoConfigure().start()
                .domain("criminal-other.name")
                .body(CreateDomainConnectApplyUrlDto.builder()
                    .build())
                .call();

        if (res.domainConnectApplyUrlResponseDto().isPresent()) {
            System.out.println(res.domainConnectApplyUrlResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `domain`                                                                                    | *String*                                                                                    | :heavy_check_mark:                                                                          | N/A                                                                                         |
| `idempotencyKey`                                                                            | *Optional\<String>*                                                                         | :heavy_minus_sign:                                                                          | A header for idempotency purposes                                                           |
| `body`                                                                                      | [CreateDomainConnectApplyUrlDto](../../models/components/CreateDomainConnectApplyUrlDto.md) | :heavy_check_mark:                                                                          | N/A                                                                                         |

### Response

**[DomainsControllerStartDomainAutoConfigureResponse](../../models/operations/DomainsControllerStartDomainAutoConfigureResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |