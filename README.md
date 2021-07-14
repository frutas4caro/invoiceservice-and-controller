# invoiceservice-and-controller service


### ---Instructions for Running the service locally---

###Maven Instructions
***You need to have Maven and Java installed to navigate these instructions***

[1]
`git clone https://github.com/frutas4caro/invoiceservice-and-controller.git`

[2] `cd invoiceservice-and-controller/`

[3] `mvn install`

[4] `java -jar target/invoiceservice-and-controller-0.0.1-SNAPSHOT.jar`

[5] Go to browser

`http://localhost:8080/invoices/1`

Verify the output: 


###Docker Instructions

***You will need to have docker installed locally to navigate these instructions***

[1] `docker build --tag=invoiceservice:latest .`

[2] `docker run -p8887:8080 invoiceservice:latest`

[3] Go to the browser
`http://localhost:8887/invoices/1`

Verify the output:

## Documentation

All positive responses will return a 200 Status code

### Get Invoice

#### *Request* :
`http://localhost:{port}/invoices/{id}`
 
`port` - designated port based on the instructions you followed above. i.e. `8080` or `8887`

`id` - the invoice id. i.e. `6`

#### *Response* :

```
{
"id": 6,
"customerId": 4,
"invoiceNumber": "1022321",
"vendorName": "Staplesss",
"amount": 2365.65,
"invoiceDescription": "Printing Paper"
}
```

### Post - Create an Invoice

#### *Request* :
`http://localhost:{port}/invoices`

Body:
```
{
"customerId": 4,
"invoiceNumber": "1022321",
"vendorName": "Staplesss",
"amount": 2365.65,
"invoiceDescription": "Printing Paper"
}
```

#### *Response* :

```
{
"id": 6,
"customerId": 4,
"invoiceNumber": "1022321",
"vendorName": "Staplesss",
"amount": 2365.65,
"invoiceDescription": "Printing Paper"
}
```


### Put - Update an Invoice

Every field but the invoice id can be updated.

#### *Request* :

`http://localhost:{port}/invoices/{id}`

Body:

```
{
"customerId": 4,
"invoiceNumber": "1022321",
"vendorName": "Staples - Cambridge Location",
"amount": 2365.65,
"invoiceDescription": "Printing Paper"
}
```


#### *Response* :

```
{
"id": 6,
"customerId": 4,
"invoiceNumber": "1022321",
"vendorName": "Staples - Cambridge Location",
"amount": 2365.65,
"invoiceDescription": "Printing Paper"
}
```


### Delete Invoice

#### *Request* :

`http://localhost:{port}/invoices/1`

#### *Response* :
**200** Status Code

