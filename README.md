# fsk_service
Micro service for loading vocabularies and other stuff in FSK-Lab.

An embedded H2 databased create at the user folder with name test is exposed by a Java REST API at port 8000.

## Endpoints

| Path | Description |
| ---- | ----------- |
| /api/availability | Return all the availabilities in DB. |
| /api/availability?id=:id | Return the availability with passed id. |
| /api/rights | Return all the rights in DB. |
| /api/rights?id=:id | Return the right with passed id. |
| /api/sources | Return all sources in DB. |
| /api/sources?id=:id | Return the source with passed id. |