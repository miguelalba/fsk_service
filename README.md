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
| /api/publicationtype | Return all the publication types. |
| /api/publicationtype?id=:id | Return the publication type with passed id. |
| /api/right | Return all the rights in DB. |
| /api/right?id=:id | Return the right with passed id. |
| /api/source | Return all sources in DB. |
| /api/source?id=:id | Return the source with passed id. |

## TODO
- [model class](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1154676235)
- [model sub class](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=193246350)
- [basic process](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=381733675)
- [status](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=2062722204)
- [hazard ind-sum](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=225943893)
- [study assay technology type](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=803118524)
- [accreditation procedure ass. tec.](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=2139507382)
- [sampling strategy](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=2011214756)
- [type of sampling program](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=2028201745)
- [method tool to collect data](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=142059694)
- [type of records](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1894621904)
- [food descriptors](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1980509891)
- [laboratory accreditation](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=445151534)
- [parameter classification](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1206772622)
- [parameter unit](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=476984304)
- [parameter data type](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1809954237)
- [parameter source](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1104089172)
- [parameter subject](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1072897671)
- [parameter distribution](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1730313417)
- [model equation class](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=2138403984)
- [fitting procedure](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=626949475)
- [type of exposure](https://docs.google.com/spreadsheets/d/1C6N4-YWX9OMmNStd2rYlSUaVys-aiJGLj00cD44aVc8/edit#gid=1148245676)