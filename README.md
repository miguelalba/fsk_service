# fsk_service
Micro service for loading vocabularies and other stuff in FSK-Lab.

An embedded H2 databased create at the user folder with name test is exposed by a Java REST API at port 8000.

## Endpoints

| Path | Description |
| ---- | ----------- |
| /api/availability | Return all the availabilities in DB. |
| /api/availability?id=:id | Return the availability with passed id. |
| /api/format | Return all the formats in DB. |
| /api/format?id=:id | Return the format with passed id. |
| /api/right | Return all the rights in DB. |
| /api/right?id=:id | Return the right with passed id. |
| /api/source | Return all sources in DB. |
| /api/source?id=:id | Return the source with passed id. |