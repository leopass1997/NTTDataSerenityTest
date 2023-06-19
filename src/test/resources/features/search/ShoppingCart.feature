#language: es
#Automatizador: Leonardo
#Funcional: NTTData
#Comando Ejecutar: mvn clean install

@FeatureCompletoShoppingCart
Característica: Compra de Productos en Swag Labs

  COMO usuario de la plataforma Swag Labs
  QUIERO realizar la compra de productos
  PARA evidenciar la compra correcta de productos online

  @FlujoComprasProductos
  Esquema del escenario: Flujo de compras dentro de Swag Labs
    Dado Leonardo ingresa a la aplicacion Swag Labs
    Cuando ingresa <usuario> y <password> en formulario de login
    Y hace clic en boton Login
    Y hace clic en boton agregar a carrito de <productoUno> y <productoDos>
    Y se hace clic en boton carrito de compras para visualizar los productos agregados
    Y se hace clic en boton verificar
    Y se ingresa <nombre>, <apellido> y <codigoPostal> del comprador, se hace clic en boton continuar
    Entonces se hace clic en boton finalizar, se valida compra exitosa, se regresa a pagina principal

    Ejemplos:
      | usuario         | password       | productoUno           | productoDos                         | nombre     | apellido | codigoPostal |
      | "standard_user" | "secret_sauce" | "Sauce Labs Backpack" | "Test.allTheThings() T-Shirt (Red)" | "Leonardo" | "Paez"   | "171168"     |




