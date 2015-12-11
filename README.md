<h1>Synopsis</h1>

Implementación de dos servicios Rest.<br>
"/PaymetRest/Service/getProductsByClient"<br>
Get--> devuelve uan lista con los productos facturados por el cliente.<br>
"/PaymetRest/Service/saveClient"<br>
Post--> Inserta o actualiza, si ya existiera, un cliente.<br>
La estructura de documentos json:<br>
        Client(Con id propio) --->Lista de Facturas<br>
        Bill(Con id propio) Contiene una lista de productos.<br>
        Producto(Con Id propio)<br>

APIs<br>
Rest-Assured 2.6.0<br>
Spring-Boot 1.2.7.RELEASE<br>
Morphia 1.0.1<br>
Jersey 2.14<br>


Code Example



Motivation



Installation



API Reference



Tests

