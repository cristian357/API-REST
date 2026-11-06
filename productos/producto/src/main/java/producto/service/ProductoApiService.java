package producto.service;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import producto.model.Producto;

public class ProductoApiService {

    private final String url = "http://localhost:8080/api";

    
    public Producto guardarProducto(Producto p) {
        Client cliente = ClientBuilder.newClient();
        try {
            WebTarget webTarget = cliente.target(url).path("producto");
            Response response = webTarget
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(p, MediaType.APPLICATION_JSON));

            if (esExitosa(response)) {
                return response.readEntity(Producto.class);
            }
            int status = response.getStatus();
            response.close();
            throw new RuntimeException("Error al guardar. Código HTTP: " + status);
        } finally {
            cliente.close();
        }
    }

    
    public Producto consultarProducto(long id) {
        Client cliente = ClientBuilder.newClient();
        try {
            WebTarget webTarget = cliente.target(url).path("producto").path(String.valueOf(id));
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

            if (esExitosa(response)) {
                return response.readEntity(Producto.class);
            }
            int status = response.getStatus();
            response.close();
            if (status == Response.Status.NOT_FOUND.getStatusCode()) {
                return null; 
            }
            throw new RuntimeException("Error al consultar. Código HTTP: " + status);
        } finally {
            cliente.close();
        }
    }


    public List<Producto> listarProductos() {
        Client cliente = ClientBuilder.newClient();
        try {
            WebTarget webTarget = cliente.target(url).path("producto");
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

            if (esExitosa(response)) {
                return response.readEntity(new GenericType<List<Producto>>() {});
            }
            int status = response.getStatus();
            response.close();
            throw new RuntimeException("Error al listar. Código HTTP: " + status);
        } finally {
            cliente.close();
        }
    }

 
    public Producto actualizarProducto(long id, Producto p) {
        Client cliente = ClientBuilder.newClient();
        try {
            WebTarget webTarget = cliente.target(url).path("producto").path(String.valueOf(id));
            Response response = webTarget
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity(p, MediaType.APPLICATION_JSON));

            if (esExitosa(response)) {
                return response.readEntity(Producto.class);
            }
            int status = response.getStatus();
            response.close();
            if (status == Response.Status.NOT_FOUND.getStatusCode()) {
                return null; 
            }
            throw new RuntimeException("Error al actualizar. Código HTTP: " + status);
        } finally {
            cliente.close();
        }
    }

 
    public boolean eliminarProducto(long id) {
        Client cliente = ClientBuilder.newClient();
        try {
            WebTarget webTarget = cliente.target(url).path("producto").path(String.valueOf(id));
            Response response = webTarget.request().delete();
            boolean ok = esExitosa(response);   
            response.close();
            return ok;
        } finally {
            cliente.close();
        }
    }

  
    private boolean esExitosa(Response response) {
        return response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL;
    }
}