# aLavadeira API
A Java API implementation following the documentation developed by codus tecnologia.

REST API to retrieve and update aLavadeira's deliverables and visits, used as a part of the final project of the Specialization in Multi-platform Development powered by SENAI, JPMORGAN and ENDEAVOR.

## Authenticate

###Requesting an authentication
To access other web services you need to have the access token returned by this end point.

**POST** AlavadeiraAPI/rest/authenticate

Content type: JSON

Field      | Type   | Description       | Example
---------- | ------ | ----------------- | --------------------------------
email\*    | String | Driver's email    | `"email": "motorista@email.com"`
password\* | String | Driver's password | `"password": "*******"`
profile_type\* | String | Profile to be authenticated (driver, admin, operator) | `"profile_type": "driver"`
\*required

```json
{
  "email": "motorista@email.com",
  "password": "*******",
  "profile_type": "driver"
}
```

####Response of authentication
Success:

Field   | Type   | Description                         | Example
------- | ------ | ----------------------------------- | ----------------------
message | String | Response message                    | `"message": "Success"`
data    | Object | Data response                       | `"data": {}`

Data Object

Field  | Type   | Description                         | Example
------ | ------ | ----------------------------------- | ------------------
token  | String | Access token to make other requests | `"token": "token"`
driver | Object | Driver details                      | `"driver": {}`
profile| Object | Basic profile details               | `"profile": {}`

Profile Object:

Field        | Type   | Description                    | Example
------------ | ------ | ------------------------------ | ------------------------------------
email        | String | Profile's email                 | `"email": "profile@email.com"`


Driver Object:

Field        | Type   | Description                            | Example
------------ | ------ | ---------------------------------------| ------------------------------------
id           | Number | Driver's ID                            | `"id": 0`
name         | String | Driver's name                          | `"name": "Motorista"`
car_plate    | String | Car plate                              | `"car_plate": "ACB1234"`
trajectories | Array  | Array of driver's trajectories Objects | `"trajectories": [{}, {}]`

Trajectory Object:

Field        | Type   | Description                            | Example
------------ | ------ | -------------------------------------- | ------------------------------------
trajectoryId        | Number | Trajectory's ID                 | `"id": 1`
name        | String | Trajectory's name                       | `"name": "A1"`

```json
{
  "message": "Success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJici5jb20uYWxhdmFkZWlyYWFwaS5kb21haW4uRHJpdmVyQDZjMDdlMjM1In0.KJY01JSCI-G1opysVRsVRMR7_8nrmy6gu_YZDTOcbWo",
    "profile": {
      "email": "motorista@email.com"
    },
    "driver": {
      "id": 1,
      "name": "Motorista",
      "car_plate": "ABC1234",
      "trajectories": [
        {
          "id": 1,
          "name": "A0"
        },
        {
          "id": 2,
          "name": "B0"
        } 
      ]
    }
  }
},
status: 200
```

Error:

Field   | Type   | Description      | Example
------- | ------ | ---------------- | ------------------------------------------------------
message | String | Response message | `"message": "Invalid login or password"`


Sending a wrong email/password combination:

```json
{
  "message": "Invalid login or password"
},
status: 401
```


Sending a wrong profile type (fake_profile):

Request:

```json
{
  "email": "motorista@email.com",
  "password": "*******",
  "profile_type": "invalid_profile"
}
```

Response:
```json
{
  "message": "Profile type (invalid_profile) is not accepted."
},
status: 422
```

###Using the authentication token
Send the token as a header parameter named "X-API-TOKEN" on all requests, except authentication.

####Response with missing or invalid authentication token

Error:

Field   | Type   | Description      | Example
------- | ------ | ---------------- | ----------------------------------------
message | String | Response message | `"message": "Missing or invalid access token"`

```json
{
  "message": "Missing or invalid access token"
},
status: 401
```

## Visits

###Requesting visits by driver
Retrieve visits by driver's ID and scheduled visit date.

If the scheduled_for parameter is omitted, then it will return today's scheduled visits.

**GET** /visits

Parameters:

Param         | Description
------------- | ---------------------------
id_driver\*   | Driver's ID
scheduled_for | Scheduled date _yyyy-mm-dd_
\*required

`AlavadeiraAPI/rest/visits/1/2017-03-02`

####Response of visits by driver

Success:

Field   | Type   | Description      | Example
------- | ------ | ---------------- | ----------------------
message | String | Response message | `"message": "Success"`
data    | Object | Data response    | `"data": {}`

Data Object:

Field         | Type   | Description                 | Example
------------- | ------ | --------------------------- | -------------------------------
id_driver     | Number | Driver's ID                 | `"driver_id": 1`
scheduled_for | String | Scheduled date _yyyy-mm-dd_ | `"scheduled_for": "2017-03-02"`
visits        | Array  | Array of visits             | `"visits": [{}, {}, {}]`

Visit Object:

Field                    | Type   | Description                                     | Example
------------------------ | ------ | ----------------------------------------------- | ----------------------------------------
id                       | Number | Visit's ID                                      | `"id": 1`
trajectory               | String | Visit's trajectory                              | `"trajectory": "A0"`
priority                 | Number | Visit's priority within a trajectory            | `"priority": 1`
visited_at<sup>1</sup>   | String | Visit's date and time _MMM dd, yyyy HH:mm:ss a_ | `"visited_at": "Mar 2, 2017 9:45:00 AM"`
address                  | Object | Address details                                 | `"address": {}`
customer                 | Object | Customer details                                | `"customer": {}`
deliverables<sup>2</sup> | Array  | Array of deliverables                           | `"deliverables": [{}, {}, {}]`
<sup>1</sup>If visited_at field ins't show, then the visit is pending.

<sup>2</sup>If deliverables array is empty, then the visit is only to collect.

Address Object:

Field        | Type   | Description        | Example
------------ | ------ | ------------------ | ------------------------------
street       | String | Address location   | `"street": "Avenida Paulista"`
number       | Number | Address number     | `"number": 575`
complement   | String | Address complement | `"complement": "Conjunto 1211"`
neighborhood | String | Neighborhood       | `"neighborhood": "Bela Vista"`
cep          | String | Postal code        | `"cep": "01311911"`
city         | String | City               | `"city": "São Paulo"`
state        | String | State              | `"state": "SP"`
latitude     | String | Address latitude   | `"latitude": "-23.568149"`
longitude    | String | Address longitude  | `"longitude": "-46.6492278"`

Customer Object:

Field | Type   | Description                              | Example
----- | ------ | ---------------------------------------- | ----------------------------------
id    | Number | Customer's ID                            | `"id": 123`
name  | String | Customer's full name                     | `"name": "Cliente"`
phone | String | Customer's telephone or cellphone number | `"phone": "(00) 1234-5678"`
delivery_notes | String | Custom notes filled by an admin | `"delivery_notes": "Entregar chamando sempre o João"`

Deliverable Object:

Field   | Type   | Description                     | Example
------- | ------ | ------------------------------- | -------------------------
barcode | String | Barcode to confirm delivery     | `"barcode": "0000000001"`
type    | String | Deliverable's type (bag, hanger, other) | `"type": "hanger"`

```json
{
  "message": "Success",
  "data": {
    "id_driver": 1,
    "scheduled_for": "2017-03-02",
    "visits": [
      {
        "id": 1,
        "trajectory": "A0",
        "priority": 1,
        "visited_at": "Mar 2, 2017 9:45:00 AM",
        "address": {
          "street": "Avenida Paulista",
          "number": 575,
          "complement": "Conjunto 1211",
          "neighborhood": "Bela Vista",
          "CEP": "01311911",
          "city": "São Paulo",
          "state": "SP",
          "latitude": -23.568149,
          "longitude": -46.6492278
        },
        "customer": {
          "id": 1,
          "name": "Cliente A",
          "phone": "(00) 1234-5678",
          "delivery_notes": "Informações importantes"
        },
        "deliverables": [
          {
            "barcode": "0000000001",
            "type": "bag"
          },
          {
            "barcode": "0000000010",
            "type": "hanger"
          }
        ]
      },
      {
        "id": 2,
        "trajectory": "A2",
        "priority": 1,
        "address": {
          "street": "Avenida Paulista",
          "number": 575,
          "complement": "Conjunto 1711",
          "neighborhood": "Bela Vista",
          "CEP": "01311911",
          "city": "São Paulo",
          "state": "SP",
          "latitude": -23.568149,
          "longitude": -46.6492278
        },
        "customer": {
          "id": 2,
          "name": "Cliente B",
          "phone": "(00) 98765-4321",
          "delivery_notes": "Informações importantes"
        },
        "deliverables": [
          {
            "barcode": "0000000100",
            "type": "bag"
          },
          {
            "barcode": "0000000101",
            "type": "hanger"
          },
          {
            "barcode": "0000000110",
            "type": "bag"
          }
        ]
      },
      {
        "id": 3,
        "trajectory": "A2",
        "priority": 1,
        "address": {
          "street": "Alameda Barão de Limeira",
          "number": 539,
          "complement": "Escola SENAI de Informática",
          "neighborhood": "Santa Cecilia",
          "CEP": "01202-001",
          "city": "São Paulo",
          "state": "SP",
          "latitude": -23.5365517,
          "longitude": -46.6463026
        },
        "customer": {
          "id": 3,
          "name": "Cliente C",
          "phone": "(00) 4321-5678",
          "delivery_notes": "Informações importantes"
        },
        "deliverables": []
      }
    ]
  }
},
status: 200
```

Error:

Field   | Type   | Description      | Example
------- | ------ | ---------------- | ----------------------------------------------
message | String | Response message | `"message": "Invalid parameters"`

```json
{
  "message": "Invalid parameters"
},
status: 400
```