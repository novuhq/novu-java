# ActivityNotificationSubscriberResponseDto


## Fields

| Field                                                | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `firstName`                                          | *JsonNullable\<String>*                              | :heavy_minus_sign:                                   | First name of the subscriber                         |
| `subscriberId`                                       | *String*                                             | :heavy_check_mark:                                   | External unique identifier of the subscriber         |
| `id`                                                 | *String*                                             | :heavy_check_mark:                                   | Internal to Novu unique identifier of the subscriber |
| `lastName`                                           | *JsonNullable\<String>*                              | :heavy_minus_sign:                                   | Last name of the subscriber                          |
| `email`                                              | *JsonNullable\<String>*                              | :heavy_minus_sign:                                   | Email address of the subscriber                      |
| `phone`                                              | *JsonNullable\<String>*                              | :heavy_minus_sign:                                   | Phone number of the subscriber                       |