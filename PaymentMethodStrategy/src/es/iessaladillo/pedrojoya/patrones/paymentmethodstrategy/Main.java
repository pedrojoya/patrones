package es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy;

import es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.ShoppingCart;
import es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.item.HardDrive;
import es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.item.Laptop;
import es.iessaladillo.pedrojoya.patrones.paymentmethodstrategy.model.paymentmethod.ByPaypal;

class Main {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        // Agregamos varios artículos al carrito de la compra.
        shoppingCart.addItem(new Laptop("Manzana a medio comer", 2156.23f));
        shoppingCart.addItem(new HardDrive("Disco duro sólido 500GB", 170.48f));
        // En tiempo de ejecución podemos decidir cómo pagar el carrito.
        // Por ejemplo con con Paypal.
        shoppingCart.pay(new ByPaypal("miemail@ejemplo.com", "mipassword"));
        // Pero podríamos hacerlo también con tarjeta de crédito.
        // shoppingCart.pay(new ByCreditCard("MiNombre", "1234567890123456", "444", "12/17"));
    }

}