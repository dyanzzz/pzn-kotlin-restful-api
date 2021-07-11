<!--
    readme.md (markdown)
-->

# API Spec Documentation Markdown

## Authentication

All Api must use this authentication

Request :
- Header :
  - X-Api-Key : "your secret api key"

## Create Product
Request :
- Method : POST
- Endpoint : `/api/product`
- Header : 
  - Content-Type : application/json
  - Accept : application/json
- Body : 
```json
{
  "id" : "String, unique",
  "name" : "String",
  "price" : "Long",
  "quantity" : "Integer"
}
```
  
Response :
```json
{
  "code" : "Int",
  "status" : "String",
  "data" : {
    "id" : "String, unique",
    "name" : "String",
    "price" : "Long",
    "quantity" : "Integer",
    "createdAt" : "Date",
    "updatedAt" : "Date"
  }
}
```

## Get Product
Request :
- Method : GET
- Endpoint : `/api/product/{id}`
- Header :
    - Accept : application/json
    
Response :
```json
{
  "code" : "Int",
  "status" : "String",
  "data" : {
    "id" : "String, unique",
    "name" : "String",
    "price" : "Long",
    "quantity" : "Integer",
    "createdAt" : "Date",
    "updatedAt" : "Date"
  }
}
```

## Update Product
Request :
- Method : PUT
- Endpoint : `/api/product/{id}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "name" : "String",
  "price" : "Long",
  "quantity" : "Integer"
}
```

Response :
```json
{
  "code" : "Int",
  "status" : "String",
  "data" : {
    "id" : "String, unique",
    "name" : "String",
    "price" : "Long",
    "quantity" : "Integer",
    "createdAt" : "Date",
    "updatedAt" : "Date"
  }
}
```

## List Product
Request :
- Method : GET
- Endpoint : `/api/products`
- Header :
    - Accept : application/json
- Query Param :
    - size : number
    - page : number

Response :
```json
{
  "code" : "Int",
  "status" : "String",
  "data" : [
    {
      "id": "String, unique",
      "name": "String",
      "price": "Long",
      "quantity": "Integer",
      "createdAt": "Date",
      "updatedAt": "Date"
    },{
      "id": "String, unique",
      "name": "String",
      "price": "Long",
      "quantity": "Integer",
      "createdAt": "Date",
      "updatedAt": "Date"
    }
  ]
}
```

## Delete Product
Request :
- Method : DELETE
- Endpoint : `/api/product/{id}`
- Header :
    - Accept : application/json

Response :
```json
{
  "code" : "Int",
  "status" : "String"
}
```