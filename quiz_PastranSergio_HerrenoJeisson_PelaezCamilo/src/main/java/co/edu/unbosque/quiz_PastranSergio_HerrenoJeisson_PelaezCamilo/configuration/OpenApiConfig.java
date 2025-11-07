package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		String mainDescription = "<h2>Guía para la API de Noticias</h2><p>Esta API proporciona funcionalidades para gestionar noticias y autenticación mediante JWT.</p>";

		String securityDescription = "Autenticación mediante JWT (JSON Web Token).<p>Para autenticarte, sigue estos pasos:</p><ol><li>Obtén un token JWT usando el endpoint <code>/auth/login</code></li><li>Copia el token recibido en la respuesta</li><li>Haz clic en el botón \"Authorize\" en la parte superior de esta página</li><li>En el campo \"Value\", escribe: <code>Bearer tu_token_jwt</code></li><li>Haz clic en \"Authorize\" y luego en \"Close\"</li></ol><p>Ahora podrás acceder a los endpoints protegidos.</p>";

		Info info = new Info().title("API de Noticias").version("1.0").description(mainDescription)
				.contact(new Contact().name("Equipo de Desarrollo").email("soporte@ejemplo.com")
						.url("https://github.com/tu-usuario/NoticiasAppJWT"))
				.license(new License().name("Licencia MIT").url("https://opensource.org/licenses/MIT"));

		SecurityScheme securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
				.bearerFormat("JWT").description(securityDescription);

		return new OpenAPI().info(info).addSecurityItem(new SecurityRequirement().addList("bearerAuth")).components(
				new Components().addSecuritySchemes("bearerAuth", securityScheme).addResponses("UnauthorizedError",
						new ApiResponse().description("No autenticado - Token JWT inválido o expirado")
								.content(new Content().addMediaType("application/json",
										new MediaType().addExamples("error", new Example().value(
												"{\"error\": \"No autorizado\", \"mensaje\": \"Token inválido o expirado\"}")))))
						.addResponses("ForbiddenError", new ApiResponse()
								.description("Acceso prohibido - No tienes permisos suficientes")
								.content(new Content().addMediaType("application/json",
										new MediaType().addExamples("error", new Example().value(
												"{\"error\": \"Acceso prohibido\", \"mensaje\": \"No tienes permisos para esta operación\"}")))))
						.addResponses("NotFoundError", new ApiResponse().description("Recurso no encontrado")
								.content(new Content().addMediaType("application/json",
										new MediaType().addExamples("error", new Example().value(
												"{\"error\": \"No encontrado\", \"mensaje\": \"El recurso solicitado no existe\"}"))))));
	}
}
