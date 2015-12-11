<h1>Synopsis</h1>

Implementación de dos servicios Rest con base de datos MongoDb.<br>
"/PaymetRest/Service/getProductsByClient"<br>
Get--> devuelve uan lista con los productos facturados por el cliente.<br>
"/PaymetRest/Service/saveClient"<br>
Post--> Inserta o actualiza, si ya existiera, un cliente, actualizando así sus facturas según el enunciado<br>
La estructura de documentos json:<br>
        Client(Con id propio) --->Lista de Facturas<br>
        Bill(Con id propio) Contiene una lista de productos.<br>
        Producto(Con Id propio)<br>

API Reference<br>
Rest-Assured 2.6.0<br>
Spring-Boot 1.2.7.RELEASE(Integra Jackson-FasterXML)<br>
Morphia 1.0.1<br>
Jersey 2.14<br>


<h1>Installation</h1>

Base de Datos con MongoDb, con un datasource llamado dbpaymet, se puede arrancar con datos de prueba ejecutando el test:<br>
        <i>com.paymet.rest.test.TestMorphia.initDB();<i/><br>
Se incorporan también unos scripts de prueba en la carpeta "scripts mongo".<br>      
        

API Reference

<h1>Test</h1>
<u>Solo es necesario arrancar un servidor mongo para su ejecución.<u/><br>
Cada ejecuión ya prepara la base de datos a un estado incial de prueba.<br>
com.paymet.rest.test.TestServiceGet;<br>
com.paymet.rest.test.TestServicePost;

