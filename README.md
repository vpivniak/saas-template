# Software Engineering Course project template

# API
* list of all endpoint
```
http://<host>/application.wadl
```
* get all contacts
```
curl -v -X GET http://<host>/api/v1/contacts
```
* get contact by id
```
curl -v -X GET http://<host>/api/v1/contacts/1
```
* create contact
```
curl -v -X POST -H "Content-Type: application/json" -d '{"email":"first_name.last_name@gmail.com","firstName":"first_name","lastName":"last_name"}' http://<host>/api/v1/contacts
```
* delete contact by id
```
curl -v -X DELETE http://<host>/api/v1/contacts/3
```
