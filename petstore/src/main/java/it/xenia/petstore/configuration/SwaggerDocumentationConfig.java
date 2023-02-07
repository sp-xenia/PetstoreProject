package it.xenia.petstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import it.xenia.petstore.controller.PetApi;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-24T08:53:54.400Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    private static final String VERSION = "1.0.11";
	private static final String LICENSE = "Apache 2.0";
	private static final String TITLE = "Petstore - OpenAPI 3.0";
	private static final String LICENSE_TXT = "http://www.apache.org/licenses/LICENSE-2.0.html";
	private static final String SPECIFICATION = "This is a sample Pet Store Server based on the OpenAPI 3.0 specification.";
	private static final String INFO_XENIACONSULTING_IT = "info@xeniaconsulting.it";

	@Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                    .apis(RequestHandlerSelectors.basePackage(PetApi.class.getPackage().getName()))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(TITLE)
            .description(SPECIFICATION)
            .license(LICENSE)
            .licenseUrl(LICENSE_TXT)
            .termsOfServiceUrl("")
            .version(VERSION)
            .contact(new Contact("","", INFO_XENIACONSULTING_IT))
            .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title(TITLE)
                .description(SPECIFICATION)
                .termsOfService("")
                .version(VERSION)
                .license(new License()
                    .name(LICENSE)
                    .url(LICENSE_TXT))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email(INFO_XENIACONSULTING_IT)));
    }

}
