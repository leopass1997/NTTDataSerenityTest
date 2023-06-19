package starter.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Displayed;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ShoppingCartStepDefinition {

    @Cuando("ingresa {string} y {string} en formulario de login")
    public void ingresa_y_en_formulario_de_login(String usuario, String contrasena) {
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Displayed.of
                (Target.the("Username").locatedBy("//input[@id='user-name']")))).isTrue());
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Displayed.of
                (Target.the("Password").locatedBy("//input[@id='password']")))).isTrue());
        theActorInTheSpotlight().attemptsTo(Enter.theValue(usuario).into
                (Target.the("Username").locatedBy("//input[@id='user-name']")));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(contrasena).into
                (Target.the("Password").locatedBy("//input[@id='password']")));
    }

    @Cuando("hace clic en boton Login")
    public void hace_clic_en_boton_login() {
        theActorInTheSpotlight().attemptsTo(Click.on
                (Target.the("Login").located(By.id("login-button"))));
        Target inventory = Target.the("Inventario").located(By.xpath
                ("//div[@id='inventory_container' and @class='inventory_container']"));
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(inventory))).
                isTrue());
    }

    @Cuando("hace clic en boton agregar a carrito de {string} y {string}")
    public void hace_clic_en_boton_agregar_a_carrito_de_y(String productoUno, String productoDos) {
        Target producto1 = Target.the("Producto Uno Add").located(By.xpath
                ("//div[contains(text(),'" + productoUno + "')]" +
                        "//ancestor::div[@class='inventory_item_description']//button[contains(text(),'Add to cart')]"));
        Target producto2 = Target.the("Producto Dos Add").located(By.xpath
                ("//div[contains(text(),'" + productoDos + "')]" +
                        "//ancestor::div[@class='inventory_item_description']//button[contains(text(),'Add to cart')]"));
        theActorInTheSpotlight().attemptsTo(Click.on(producto1));
        theActorInTheSpotlight().attemptsTo(Click.on(producto2));
        producto1 = Target.the("Producto Uno Remove").located(By.xpath
                ("//div[contains(text(),'" + productoUno + "')]" +
                        "//ancestor::div[@class='inventory_item_description']//button[contains(text(),'Remove')]"));
        producto2 = Target.the("Producto Dos Remove").located(By.xpath
                ("//div[contains(text(),'" + productoDos + "')]" +
                        "//ancestor::div[@class='inventory_item_description']//button[contains(text(),'Remove')]"));
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Displayed.of(producto1))).isTrue());
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Displayed.of(producto2))).isTrue());
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Text.of(By.
                xpath("//div[@id='shopping_cart_container']//span[@class='shopping_cart_badge']"))))
                .isNotEqualTo("0"));
    }

    @Cuando("se hace clic en boton carrito de compras para visualizar los productos agregados")
    public void se_hace_clic_en_boton_carrito_de_compras_para_visualizar_los_productos_agregados() {
        Target carritoCompras = Target.the("Carrito Compras").located(By.xpath
                ("//div[@id='shopping_cart_container']/a[@class='shopping_cart_link']"));
        theActorInTheSpotlight().attemptsTo(Click.on(carritoCompras));
        WebElement gridProductosCarro = BrowseTheWeb.as(theActorInTheSpotlight()).$(By.
                xpath("//div[@class='cart_list']"));
        List<WebElement> cantidadProducto = gridProductosCarro.findElements(By.
                xpath("//div[@class='cart_item']"));
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Text.of(By.
                        xpath("//div[@id='shopping_cart_container']//span[@class='shopping_cart_badge']"))))
                .isEqualTo(String.valueOf(cantidadProducto.size())));
    }

    @Cuando("se hace clic en boton verificar")
    public void se_hace_clic_en_boton_verificar() {
        theActorInTheSpotlight().attemptsTo(Click.on
                (Target.the("Verificar").located(By.id("checkout"))));
    }

    @Cuando("se ingresa {string}, {string} y {string} del comprador, se hace clic en boton continuar")
    public void se_ingresa_y_del_comprador_se_hace_clic_en_boton_continuar(String nombre, String apellido, String codigoPostal) {
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Displayed.of
                (Target.the("Primer Nombre").locatedBy("//input[@id='first-name']")))).isTrue());
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Displayed.of
                (Target.the("Apellido").locatedBy("//input[@id='last-name']")))).isTrue());
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Displayed.of
                (Target.the("Codigo Postal").locatedBy("//input[@id='postal-code']")))).isTrue());
        theActorInTheSpotlight().attemptsTo(Enter.theValue(nombre).into
                (Target.the("Primer Nombre").locatedBy("//input[@id='first-name']")));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(apellido).into
                (Target.the("Apellido").locatedBy("//input[@id='last-name']")));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(codigoPostal).into
                (Target.the("Codigo Postal").locatedBy("//input[@id='postal-code']")));
        theActorInTheSpotlight().attemptsTo(Click.on
                (Target.the("Continuar").located(By.id("continue"))));
    }

    @Entonces("se hace clic en boton finalizar, se valida compra exitosa, se regresa a pagina principal")
    public void se_hace_clic_en_boton_finalizar_se_valida_compra_exitosa_se_regresa_a_pagina_principal() {
        theActorInTheSpotlight().attemptsTo(Click.on
                (Target.the("Finalizar Compra").located(By.id("finish"))));
        theActorInTheSpotlight().attemptsTo(Ensure.that(theActorInTheSpotlight().asksFor(Text.of(By.
                        xpath("//h2[@class='complete-header']"))))
                .isEqualTo("Thank you for your order!"));
        theActorInTheSpotlight().attemptsTo(Click.on
                (Target.the("Back Home").located(By.id("back-to-products"))));
    }
}
