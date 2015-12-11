*[Synopsis]
Implementación de dos servicios Rest.
"/PaymetRest/Service/getProductsByClient"
Get--> devuelve uan lista con los productos facturados por el cliente.
"/PaymetRest/Service/saveClient"
Post--> Inserta o actualiza, si ya existiera, un cliente.
La estructura de documentos json:
        Client(Con id propio) --->Lista de Facturas
        Bill(Con id propio) Contiene una lista de productos.
        Producto(Con Id propio)

APIs
Rest-Assured 2.6.0
Spring-Boot 1.2.7.RELEASE
Morphia 1.0.1
Jersey 2.14


Code Example



Motivation



Installation



API Reference



Tests

