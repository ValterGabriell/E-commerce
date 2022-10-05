<h1 align="center">E-Commerce | Backend</h1>
<h4 align="center">
       Project under construction
</h4>

<h1>About</h1>
<p>Backend for a small e-commerce system.
   </br>
<h1>ENDPOINTS</h1>
<p>To get started, you must create a user, either a customer or a salesperson.
<h1>POST<h1>
<h2>Create seller<h2>

```
/seller/signUp
```
<p>The data format that must be passed in the body of the JSON request must be as follows.</p>

```
{
"email":"test@test.com",
"cpf_cnpj":"123456789",
"username":"username",
"password":"hashpassword"
}
```

<p>And you will get the following response.</p>

```
{
"id": 1,
"email": "test@test.com",
"cpf_cnpj": "123456789",
"username": "username"
}
```

<h2>Create customer<h2>

```
/customer/signUp
```
<p>The data format that must be passed in the body of the JSON request must be as follows.</p>

```
{
"email":"test@test.com",
"cpf_cnpj":"123456789",
"username":"username",
"password":"hashpassword"
}
```

<p>And you will get the following response.</p>

```
{
"email": "test@test.com",
"cpf_cnpj": "123456789",
"username": "username",
}
```


<h2>Create product<h2>

```
/product
```
<p>The data format that must be passed in the body of the JSON request must be as follows.</p>

```

{
"name":"product",
"price":4.45,
"seller_id":{
"id":1
}
}

```

<p>Where the ID must be an existing seller ID.</p>

<p>And you will get the following response.</p>

```
{
"id": 1,
"name": "product",
"price": 4.45,
"seller_id": 1
}
```


<h2>Create shopping cart<h2>

```
/cart/product/add
```
<p>The data format that must be passed in the body of the JSON request must be as follows.</p>

```
{
"product":[{
"id":1
}],
"customer":{
"id":1
}
}
```

<p>Where product will be a list of products and costumer must be an existing seller ID.</p>

<p>And you will get the following response.</p>

```
{
"id": 1,
"amount": 4.45,
"product": [
{
"id": 1,
"name": "product",
"price": 4.45
}
],
"customer": {
              "id":1
"email": "test@test.com",
"username": "username"
}
}
```



<h2>Create admin profile<h2>

```
/admin/signUp
```
<p>The data format that must be passed in the body of the JSON request must be as follows.</p>

```
{
"username":"test",
"password":"password",
"cpf":123456789,
"cellphone":123456789,
"email":"test@test.com"
}
```

<p>Where product will be a list of products and costumer must be an existing seller ID.</p>

<p>And you will get the following response.</p>

```
{
"username": "test",
"cpf": 123456789,
"cellphone": 123456789,
"email": "test@test.com"
}
```

<hr>

<h1>GET<h1>
<h2>Retrieve all products<h2>

```
/product
```
<p>The data format that will be received is as follows.</p>

```
[
{
"id": 1,
"name": "water",
"price": 4.0,
"seller_id": {
"id": 1,
"email": "test@hotmail.com",
"cpf_cnpj": "85461324",
"username": "gab",
"password": "ODQ1NDIx"
},
"cartList": [
{
"id": 1,
"amount": 4.0
}
]
},
{
"id": 2,
"name": "fish",
"price": 4.0,
"seller_id": {
"id": 1,
"email": "test@hotmail.com",
"cpf_cnpj": "85461324",
"username": "gab",
"password": "ODQ1NDIx"
},
"cartList": [
{
"id": 2,
"amount": 4.0
}
]
}
]
```

<h2>Retrieve product by id<h2>

```
/product/{id}
```

<p>The data format that will be received is as follows.</p>

```
{
"id": 2,
"name": "fish",
"price": 4.0,
"seller_id": {
"id": 1,
"email": "test@hotmail.com",
"cpf_cnpj": "85461324",
"username": "gab",
"password": "ODQ1NDIx"
},
"cartList": [
{
"id": 1,
"amount": 8.0
},
{
"id": 2,
"amount": 4.0
}
]
}
```


<h2>Retrieve all sellers (admin)<h2>

```
/admin/sellers
```

<p>The data format that will be received is as follows.</p>

```
[
{
"id": 1,
"email": "test@hotmail.com",
"cpf_cnpj": "85461324",
"username": "gab",
"productsList": [
{
"id": 1,
"name": "cafe",
"price": 14.45
},
{
"id": 2,
"name": "water",
"price": 13.45
},
{
"id": 3,
"name": "fish",
"price": 3.45
}
]
}
]
```



<h2>Retrieve seller by id<h2>

```
/admin/sellers/{id}
```

<p>The data format that will be received is as follows.</p>

```
{
"id": 1,
"email": "test@hotmail.com",
"cpf_cnpj": "85461324",
"username": "gab",
"productsList": [
{
"id": 1,
"name": "water",
"price": 4.0
},
{
"id": 2,
"name": "fish",
"price": 4.0
}
]
}
```



<h2>Retrieve cart by customer id<h2>

```
/cart/get/2
```

<p>The data format that will be received is as follows.</p>

```
{
"id": 2,
"amount": 4.0,
"product": [
{
"id": 2,
"name": "fish",
"price": 4.0
}
],
"customer": {
"id": 2,
"email": "test@hotmail.com",
"cpf_cnpj": "85461324",
"username": "gab",
"password": "ODQ1NDIx",
"customer": true,
"card": {
"id": 2,
"amount": 4.0
}
}
}
```














<h1>Credits</h1>

---

<a href="https://www.linkedin.com/in/valter-gabriel">
  <img style="border-radius: 50%;" src="https://user-images.githubusercontent.com/63808405/171045850-84caf881-ee10-4782-9016-ea1682c4731d.jpeg" width="100px;" alt=""/>
  <br />
  <sub><b>Valter Gabriel</b></sub></a> <a href="https://www.linkedin.com/in/valter-gabriel" title="Linkedin">🚀</ a>
 
Made by Valter Gabriel 👋🏽 Contact me!

[![Linkedin Badge](https://img.shields.io/badge/-Gabriel-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/valter-gabriel/ )](https://www.linkedin.com/in/valter-gabriel/)
