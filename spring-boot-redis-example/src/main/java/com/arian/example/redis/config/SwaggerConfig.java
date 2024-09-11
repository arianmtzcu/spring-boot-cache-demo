package com.arian.example.redis.config;

import java.util.Locale;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   private static final String GROUP_PUBLIC = "public";

   private static final String BASE_PATH = "/**";

   @Bean
   public GroupedOpenApi api(final OpenApiCustomizerConfig openApiCustomizerConfig) {
      return GroupedOpenApi.builder().group(GROUP_PUBLIC).pathsToMatch(BASE_PATH).addOpenApiCustomiser(openApiCustomizerConfig).build();
   }

}

@Configuration
class OpenApiCustomizerConfig implements OpenApiCustomiser {

   public static final String CONTACT_NAME = "\"APPCU CODE\" team";

   public static final String CONTACT_MAIL = "appcucode@gmail.com";

   private static final String ENDPOINT_DESCRIPTION = "Endpoint(s) to expose to audience";

   private final BuildProperties buildProperties;

   @Autowired
   OpenApiCustomizerConfig(final BuildProperties buildProperties) {
      this.buildProperties = buildProperties;
   }

   @Override
   public void customise(final OpenAPI openApi) {
      openApi.info(new Info()
            .title(buildProperties.getArtifact().toUpperCase(Locale.ROOT))
            .version(buildProperties.getVersion())
            .description(ENDPOINT_DESCRIPTION)
            .contact(new Contact().name(CONTACT_NAME).email(CONTACT_MAIL)));
   }

}