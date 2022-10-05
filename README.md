<h1 align="center">E-Commerce | Backend</h1>
<h4 align="center">
       Project under construction
</h4>

table of contents
===================
<!--ts-->
    * [About](#About)
    * [Credits](#Credits)
<!--te-->

<h1>About</h1>
<p>Backend for a small e-commerce system.
   </br>
<h1>ENDPOINTS</h1>
<p>Para começar, você deve criar um usuário, seja ele cliente ou vendedor.
<h1>POST<h1>
<h2>Criar vendedor<h2>

```
/seller/signUp
```
<p>O formato de dados que deve ser passado no corpo da requisição JSON deve ser da seguinte maneira.</p>

```
{
	"email":"teste@teste.com",
	"cpf_cnpj":"123456789",
	"username":"username",
	"password":"hashpassword"
}
```

<p>E você irá ter a seguinte resposta.</p>

```
{
	"id": 1,
	"email": "teste@teste.com",
	"cpf_cnpj": "123456789",
	"username": "username"
}
```

<h2>Criar cliente<h2>

```
/costumer/signUp
```
<p>O formato de dados que deve ser passado no corpo da requisição JSON deve ser da seguinte maneira.</p>

```
{
	"email":"teste@teste.com",
	"cpf_cnpj":"123456789",
	"username":"username",
	"password":"hashpassword"
}
```

<p>E você irá ter a seguinte resposta.</p>

```
{
	"email": "teste@teste.com",
	"cpf_cnpj": "123456789",
	"username": "username",
}
```


<h2>Criar produto<h2>

```
/product
```
<p>O formato de dados que deve ser passado no corpo da requisição JSON deve ser da seguinte maneira.</p>

```

{
	"name":"produto",
	"price":4.45,
	"seller_id":{
		"id":1
	}
}

```

<p>Onde o ID deve ser um ID de seller existente.</p>

<p>E você irá ter a seguinte resposta.</p>

```
{
	"id": 1,
	"name": "produto",
	"price": 4.45,
	"seller_id": 1
}
```


<h2>Criar carrinho de compra<h2>

```
/cart/product/add
```
<p>O formato de dados que deve ser passado no corpo da requisição JSON deve ser da seguinte maneira.</p>

```
{
	"product":[{
	"id":1
}],
	"costumer":{
		"id":1
	}
}
```

<p>Onde o product será uma lista de produtos e costumer deve ser um ID de seller existente.</p>

<p>E você irá ter a seguinte resposta.</p>

```
{
	"id": 1,
	"amount": 4.45,
	"product": [
		{
			"id": 1,
			"name": "produto",
			"price": 4.45
		}
	],
	"costumer": {
              "id":1
		"email": "teste@teste.com",
		"username": "username"
	}
}
```



<h2>Criar perfil de administrador<h2>

```
/admin/signUp
```
<p>O formato de dados que deve ser passado no corpo da requisição JSON deve ser da seguinte maneira.</p>

```
{
	"username":"teste",
	"password":"password",
	"cpf":123456789,
	"cellphone":123456789,
	"email":"teste@teste.com"
}
```

<p>Onde o product será uma lista de produtos e costumer deve ser um ID de seller existente.</p>

<p>E você irá ter a seguinte resposta.</p>

```
{
	"username": "teste",
	"cpf": 123456789,
	"cellphone": 123456789,
	"email": "teste@teste.com"
}
```

<hr>

<h1>GET<h1>
<h2>Recuperar todos os produtos<h2>

```
/product
```
<p>O formato de dados que será recebido se dá da seguinte maneira.</p>

```
[
	{
		"id": 1,
		"name": "agua",
		"price": 4.0,
		"seller_id": {
			"id": 1,
			"email": "teste@hotmail.com",
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
		"name": "peixe",
		"price": 4.0,
		"seller_id": {
			"id": 1,
			"email": "teste@hotmail.com",
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

<h2>Recuperar produto por id<h2>

```
/product/{id}
```

<p>O formato de dados que será recebido se dá da seguinte maneira.</p>

```
{
	"id": 2,
	"name": "peixe",
	"price": 4.0,
	"seller_id": {
		"id": 1,
		"email": "teste@hotmail.com",
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


<h2>Recuperar todos os vendedores (admin)<h2>

```
/admin/sellers
```

<p>O formato de dados que será recebido se dá da seguinte maneira.</p>

```
[
	{
		"id": 1,
		"email": "teste@hotmail.com",
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
				"name": "agua",
				"price": 13.45
			},
			{
				"id": 3,
				"name": "peixe",
				"price": 3.45
			}
		]
	}
]
```



<h2>Recuperar vendedor por id<h2>

```
/admin/sellers/{id}
```

<p>O formato de dados que será recebido se dá da seguinte maneira.</p>

```
{
	"id": 1,
	"email": "teste@hotmail.com",
	"cpf_cnpj": "85461324",
	"username": "gab",
	"productsList": [
		{
			"id": 1,
			"name": "agua",
			"price": 4.0
		},
		{
			"id": 2,
			"name": "peixe",
			"price": 4.0
		}
	]
}
```



<h2>Recuperar carrinho por id de cliente<h2>

```
/cart/get/2
```

<p>O formato de dados que será recebido se dá da seguinte maneira.</p>

```
{
	"id": 2,
	"amount": 4.0,
	"product": [
		{
			"id": 2,
			"name": "peixe",
			"price": 4.0
		}
	],
	"costumer": {
		"id": 2,
		"email": "teste@hotmail.com",
		"cpf_cnpj": "85461324",
		"username": "gab",
		"password": "ODQ1NDIx",
		"costumer": true,
		"cart": {
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
