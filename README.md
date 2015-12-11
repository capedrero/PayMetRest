*[Synopsis](#Synopsis)

This text was recognized by the built-in Ocrad engine. A better transcription may be attained by right clicking on the selection and changing the OCR engine to "Tesseract" (under the "Language" menu). This message can be removed in the future by unchecking "OCR Disclaimer" (under the Options menu). More info: http://projectnaptha.com/ocrad
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

