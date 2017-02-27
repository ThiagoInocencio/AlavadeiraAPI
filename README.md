# aLavadeira API
A Java implementation API following the documentation developed by codus tecnologia.

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
trajectoryId        | Number | Trajectory's ID                 | `"trajectoryId": 1`
name        | String | Trajectory's name                       | `"name": "A1"`

```json
{
  "message": "Success",
  "data": {
    "token": "token",
    "profile": {
      "email": "motorista@email.com"
    },
    "driver": {
      "id": 0,
      "name": "Motorista",
      "car_plate": "ABC1234",
      "trajectories": [
        {
          "trajectoryId": 1,
          "name": "A1"
        },
        {
          "trajectoryId": 2,
          "name": "B1"
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

