package com.stakater.nordmart.rest;

import com.stakater.nordmart.model.ShoppingCart;
import com.stakater.nordmart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;


@RestController
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
@Path("/cart")
public class CartEndpoint implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(CartEndpoint.class);

    /**
     *
     */
    private static final long serialVersionUID = -7227732980791688773L;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GET
    @Path("/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart getCart(@PathParam("cartId") String cartId) {
        LOG.info("Rest request to get cart with id {}", cartId);
        return shoppingCartService.getShoppingCart(cartId);
    }

    @POST
    @Path("/{cartId}/{itemId}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart add(@PathParam("cartId") String cartId,
                            @PathParam("itemId") String itemId,
                            @PathParam("quantity") int quantity) throws Exception {
        LOG.info("Rest request to add cartId {}, itemId {}, quantity {}", cartId, itemId, quantity);
        return shoppingCartService.addItem(cartId, itemId, quantity);
    }

    @POST
    @Path("/{cartId}/{tmpId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart set(@PathParam("cartId") String cartId,
                            @PathParam("tmpId") String tmpId) throws Exception {
        LOG.info("Rest request to set cartId {}, tmpId {}", cartId, tmpId);
        return shoppingCartService.set(cartId, tmpId);
    }

    @DELETE
    @Path("/{cartId}/{itemId}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart delete(@PathParam("cartId") String cartId,
                               @PathParam("itemId") String itemId,
                               @PathParam("quantity") int quantity) throws Exception {
        LOG.info("Rest request to delete cartId {}, itemId {}, quantity {}", cartId, itemId, quantity);
        return shoppingCartService.deleteItem(cartId, itemId, quantity);
    }

    @POST
    @Path("/checkout/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart checkout(@PathParam("cartId") String cartId) {
        // TODO: register purchase of shoppingCart items by specific user in session
        LOG.info("Rest request to checkout cartId {}", cartId);
        return shoppingCartService.checkout(cartId);
    }
}
