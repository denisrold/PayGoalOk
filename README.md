<div align=center>
Bienvenidos a la ApiRest De PayGoalOK Products

Es un servicio de para el Registro, Actualizacion,
Eliminacion y Obtencion de informacion de diversos productos
Gracias a la implementacion de persistencia con H2 - En memoria.

Esta es una version Demo (Una vez se deje de correr el servidor se eliminara la informacion registrada.).

Para empezar debera registrar sus productos a travez de un programa pueda ser por ejemplo: Imnsomnia.

-----------------------------------------------------------
Tipos de datos para el Registro de sus productos.
  "Id": Se asignara automaticamente y podra verse reflejado en el metodo get. 
  "name": Tipo de dato -> Debe ser String
  "description":Tipo de dato -> Debe ser String,
  "price": Tipo de dato -> Debe ser un numero, puede tener decimales,
  "quantity":Tipo de dato -> Solo numeros enteros.
-----------------------------------------------------------

Crear producto - Requiere todos los datos del producto en cuestion.
Metodo POST
Endpoint: http://localhost:8080/api/product
Body: JSON
{
  "name":"Producto 1",
  "description":"El producto uno es unico en su clase se diferencia de los demas por ser el numero 1",
  "price": 15.1,
  "quantity":10
}

Obtener productos - Por default por ID. (Para ordenamiento utilizar parametros).
Metodo Get All Products 
Endpoint: http://localhost:8080/api/products
*Es el unico endopoint que utiliza products (plural)  en vez de product

Donde podra ver reflejado todos sus productos y conseguir los IDs para futuro manejo de algun producto deseado.
 
La particularidad del metodo GetAll 

SORT y ORDER
Se pueden ordenar productos por precio o por nombre simplemente agregando parametros en su endpoint.  

http://localhost:8080/api/products?sortBy=name  (Ordenara por nombre)
http://localhost:8080/api/products?sortBy=price (Ordenara por precio)

Siempre por default el orden sera Ascendente
Para afectar el orden y organizarlo en orden Descendente debera utilizar el parametro "&sortOrder=desc"

http://localhost:8080/api/products?sortBy=price&sortOrder=desc

Metodo Get Product by ID
Conociendo el ID a travez del endpoint de getAll deber utilizarlo con el siguiente endpoint:
http://localhost:8080/api/product/2


Actualizacion de productos
Metodo PUT Requiere el ID para el endpoint.
Endpoint: http://localhost:8080/api/product/1

{
   "name":"Producto 1",
    "description":"El producto uno es unico en su clase se diferencia de los demas por ser el numero 1",
   "price": 15.1,
   "quantity":10
}

Admite modificar todas las propiedades del producto o simplemente modificar una o algunas.

{
   "name":"Producto 1"
}

Eliminar Producto - Requiere ID del producto. 
Metodo Delete 
Endpoint: http://localhost:8080/api/product/1

Elimina el producto complemtamente (NO ES BORRADO LOGICO).


TODAS LAS FUNCIONALIDADES MANEJAN ERRORES.
</div>
Futuras Features: Desarrollo de un Frontend.

