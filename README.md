<div align=center>
<h1>Bienvenidos a la ApiRest De PayGoalOK Products</h1>

<p>Es un servicio de para el Registro, Actualizacion,
Eliminacion y Obtencion de informacion de diversos productos </p>
</br>
<p><b>La implementacion de persistencia  esta desrrollad con H2 - En memoria.</b></p>
<p><i>En esta version Demo (una vez se deje de correr el servidor se eliminara la informacion registrada).</i></p>

</br>
<h3>Para empezar debera registrar sus productos a travez de un Software para pruebas de Api (Imnsomnia).</h3>

<div align=start>
  <h4><strong>Tipos de datos para el registro de sus productos:</strong></h4>
  <p><strong>"Id":</strong> Se asignará automáticamente y podrá verse reflejado en el método GET.</p>
  <p><strong>"name":</strong> Tipo de dato → Debe ser String.</p>
  <p><strong>"description":</strong> Tipo de dato → Debe ser String.</p>
  <p><strong>"price":</strong> Tipo de dato → Debe ser un número, puede tener decimales.</p>
  <p><strong>"quantity":</strong> Tipo de dato → Solo números enteros.</p>
</div>

</br>
<h3>Crear producto - Requiere todos los datos del producto en cuestion.</h3>
<p>Metodo POST</p>
<p>Endpoint: <b> http://localhost:8080/api/product </b></p>
<p>Body: JSON</p>
<div align=start>
<p>{</p>
  <p>"name":"Producto 1",</p>
  <p>"description":"El producto uno es unico en su clase se diferencia de los demas por ser el numero 1",</p>
  <p>"price": 15.1,</p>
  <p>"quantity":10</p>
<p>}</p>
</div>
</br>
<h3>Obtener productos - Por default por ID. (Para ordenamiento utilizar parametros).</h3>
<p>Metodo Get All Products </p>
<p><b>Endpoint: http://localhost:8080/api/products<b></p>
<p><i>*Es el unico endopoint que utiliza products (plural)  en vez de product</i></p>

<p>Podra ver reflejado todos sus productos y conseguir los IDs para futuro manejo de algun producto deseado.</p>

<h3>SORT y ORDER</h3>
<p>Se pueden ordenar productos por precio o por nombre simplemente agregando parametros en su endpoint. </p>
<p><b>Ordenar por nombre:</b></p>
<p>http://localhost:8080/api/products?sortBy=name   </p>
</br>
<p><b>Ordenar por precio:</b></p>
<p>http://localhost:8080/api/products?sortBy=price  </p>
</br>
<p><i>Siempre por default el orden sera Ascendente</i></p>
<p>http://localhost:8080/api/products?sortBy=price&sortOrder=asc</p>
<p>Para afectar el orden y organizarlo en orden Descendente debera utilizar el parametro "&sortOrder=desc"</p>

<p>http://localhost:8080/api/products?sortBy=price&sortOrder=desc</p>
</br>
<h3>Metodo Get Product by ID</h3>
<p>Una vez identificado el ID utilizarlo con el siguiente endpoint:</p>
<p>http://localhost:8080/api/product/2</p>

</br>
<h3>Actualizacion de productos - Requiere ID</h3>
<p>Metodo PUT Requiere el ID para el endpoint.</p>
<p>Endpoint: <b>http://localhost:8080/api/product/1</b></p>
<p>Body: JSON</p>
<div align=start>
<p>{</p>
  <p>"name":"Producto 1",</p>
  <p>"description":"El producto uno es unico en su clase se diferencia de los demas por ser el numero 1",</p>
  <p>"price": 15.1,</p>
  <p>"quantity":10</p>
<p>}</p>
</div>
</br>

<p>Admite modificar todas las propiedades del producto o simplemente modificar una o algunas.</p>
<div align=start>
<p>{</p>
  <p>"name":"Producto 1",</p>
<p>}</p>
</div>
</br>

<h3>Eliminar Producto - Requiere ID del producto.</h3>
<p>Metodo Delete</p> 
<p>Endpoint: http://localhost:8080/api/product/1</p>

<h4>A TENER EN CUENTA: Elimina el producto complemtamente (NO ES BORRADO LOGICO).</h4>

</br>

<h3>TODAS LAS FUNCIONALIDADES MANEJAN ERRORES.</h3>
</div>
</br>
<h3>Futuras Features: Desarrollo de un Frontend.</h3>

