package com.work.work.infra.swaggerConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Carrito de Compras",
                description = "Api de carrito de compras v1.0.0 con clientes y producto con opcion de modificar eliminar y crear.",
                version = "v1.0.0",
                contact = @Contact(
                        name = "Edwin Castro",
                        email = "Castromaradiaga@hotmail.com",
                        url = "www.EDTecnology.com"
                ),
                license = @License(
                        name = "libre de uso",
                        url = "www.EDTecnology.com"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "SERVER DE DESARROLLO"
                )
        }

)

public class SwaggerConfig {
}
