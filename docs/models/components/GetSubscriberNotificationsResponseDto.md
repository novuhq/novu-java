# GetSubscriberNotificationsResponseDto


## Fields

| Field                                                                          | Type                                                                           | Required                                                                       | Description                                                                    |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| `data`                                                                         | List\<[InboxNotificationDto](../../models/components/InboxNotificationDto.md)> | :heavy_check_mark:                                                             | Array of notifications                                                         |
| `hasMore`                                                                      | *boolean*                                                                      | :heavy_check_mark:                                                             | Indicates if there are more notifications available                            |
| `filter`                                                                       | [Filter](../../models/components/Filter.md)                                    | :heavy_check_mark:                                                             | The filter applied to the notifications                                        |