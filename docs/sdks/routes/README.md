# Domains.Routes

## Overview

### Available Operations

* [list](#list) - List routes for a domain
* [create](#create) - Create a route
* [retrieve](#retrieve) - Retrieve a route by address
* [update](#update) - Update a route
* [delete](#delete) - Delete a route
* [test](#test) - Test an inbound route

## list

Returns a paginated list of routes attached to the domain. Optionally filter by an agent identifier to find routes pointing to a specific agent.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_listDomainRoutes" method="get" path="/v1/domains/{domain}/routes" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerListDomainRoutesRequest;
import co.novu.models.operations.DomainsControllerListDomainRoutesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerListDomainRoutesRequest req = DomainsControllerListDomainRoutesRequest.builder()
                .domain("fearless-fishery.com")
                .limit(10d)
                .build();

        DomainsControllerListDomainRoutesResponse res = sdk.domains().routes().list()
                .request(req)
                .call();

        if (res.listDomainRoutesResponseDto().isPresent()) {
            System.out.println(res.listDomainRoutesResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                       | Type                                                                                                            | Required                                                                                                        | Description                                                                                                     |
| --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                       | [DomainsControllerListDomainRoutesRequest](../../models/operations/DomainsControllerListDomainRoutesRequest.md) | :heavy_check_mark:                                                                                              | The request object to use for the request.                                                                      |

### Response

**[DomainsControllerListDomainRoutesResponse](../../models/operations/DomainsControllerListDomainRoutesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Creates a route on the domain that forwards inbound mail addressed to `<address>@<domain>` to either a webhook or an agent. Each address on a domain may only have a single route.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_createDomainRoute" method="post" path="/v1/domains/{domain}/routes" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.DomainRouteDto;
import co.novu.models.components.DomainRouteDtoType;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerCreateDomainRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerCreateDomainRouteResponse res = sdk.domains().routes().create()
                .domain("radiant-solvency.net")
                .body(DomainRouteDto.builder()
                    .address("6581 Birch Road")
                    .type(DomainRouteDtoType.WEBHOOK)
                    .build())
                .call();

        if (res.domainRouteResponseDto().isPresent()) {
            System.out.println(res.domainRouteResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `domain`                                                    | *String*                                                    | :heavy_check_mark:                                          | N/A                                                         |
| `idempotencyKey`                                            | *Optional\<String>*                                         | :heavy_minus_sign:                                          | A header for idempotency purposes                           |
| `body`                                                      | [DomainRouteDto](../../models/components/DomainRouteDto.md) | :heavy_check_mark:                                          | N/A                                                         |

### Response

**[DomainsControllerCreateDomainRouteResponse](../../models/operations/DomainsControllerCreateDomainRouteResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## retrieve

Returns the route bound to `<address>@<domain>`. Use `*` as the address to retrieve the wildcard route for the domain.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_getDomainRoute" method="get" path="/v1/domains/{domain}/routes/{address}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerGetDomainRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerGetDomainRouteResponse res = sdk.domains().routes().retrieve()
                .domain("adolescent-petal.net")
                .address("42531 Green Lane")
                .call();

        if (res.domainRouteResponseDto().isPresent()) {
            System.out.println(res.domainRouteResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `domain`                          | *String*                          | :heavy_check_mark:                | N/A                               |
| `address`                         | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[DomainsControllerGetDomainRouteResponse](../../models/operations/DomainsControllerGetDomainRouteResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Updates the destination of the route bound to `<address>@<domain>`. The address itself is the resource identity and cannot be changed; delete and recreate the route to rename it.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_updateDomainRoute" method="patch" path="/v1/domains/{domain}/routes/{address}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateDomainRouteDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerUpdateDomainRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerUpdateDomainRouteResponse res = sdk.domains().routes().update()
                .domain("cavernous-cycle.com")
                .address("70213 Gerlach Rue")
                .body(UpdateDomainRouteDto.builder()
                    .build())
                .call();

        if (res.domainRouteResponseDto().isPresent()) {
            System.out.println(res.domainRouteResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `domain`                                                                | *String*                                                                | :heavy_check_mark:                                                      | N/A                                                                     |
| `address`                                                               | *String*                                                                | :heavy_check_mark:                                                      | N/A                                                                     |
| `idempotencyKey`                                                        | *Optional\<String>*                                                     | :heavy_minus_sign:                                                      | A header for idempotency purposes                                       |
| `body`                                                                  | [UpdateDomainRouteDto](../../models/components/UpdateDomainRouteDto.md) | :heavy_check_mark:                                                      | N/A                                                                     |

### Response

**[DomainsControllerUpdateDomainRouteResponse](../../models/operations/DomainsControllerUpdateDomainRouteResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Removes the route bound to `<address>@<domain>`. Inbound mail for that address will no longer be processed.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_deleteDomainRoute" method="delete" path="/v1/domains/{domain}/routes/{address}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerDeleteDomainRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerDeleteDomainRouteResponse res = sdk.domains().routes().delete()
                .domain("corrupt-avalanche.biz")
                .address("753 W 4th Avenue")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `domain`                          | *String*                          | :heavy_check_mark:                | N/A                               |
| `address`                         | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[DomainsControllerDeleteDomainRouteResponse](../../models/operations/DomainsControllerDeleteDomainRouteResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## test

Sends a synthetic inbound email through the same delivery path as production (outbound webhooks for webhook routes, signed HTTP to the agent for agent routes). Use `dryRun: true` to preview the payload without delivering.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_testDomainRoute" method="post" path="/v1/domains/{domain}/routes/{address}/test" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.TestDomainRouteDto;
import co.novu.models.components.TestDomainRouteFromDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerTestDomainRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerTestDomainRouteResponse res = sdk.domains().routes().test()
                .domain("exalted-bonfire.com")
                .address("90499 Rowan Close")
                .body(TestDomainRouteDto.builder()
                    .from(TestDomainRouteFromDto.builder()
                        .address("58851 Konopelski Overpass")
                        .build())
                    .subject("<value>")
                    .build())
                .call();

        if (res.testDomainRouteResponseDto().isPresent()) {
            System.out.println(res.testDomainRouteResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `domain`                                                            | *String*                                                            | :heavy_check_mark:                                                  | N/A                                                                 |
| `address`                                                           | *String*                                                            | :heavy_check_mark:                                                  | N/A                                                                 |
| `idempotencyKey`                                                    | *Optional\<String>*                                                 | :heavy_minus_sign:                                                  | A header for idempotency purposes                                   |
| `body`                                                              | [TestDomainRouteDto](../../models/components/TestDomainRouteDto.md) | :heavy_check_mark:                                                  | N/A                                                                 |

### Response

**[DomainsControllerTestDomainRouteResponse](../../models/operations/DomainsControllerTestDomainRouteResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |