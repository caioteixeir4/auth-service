package com.kawashisistemas.auth_service;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.kawashisistemas.auth_service")
public class ArchitectureTest {

    // REGRA 1: Camadas devem ser respeitadas
    @ArchTest
    static final ArchRule layers_should_be_respected = layeredArchitecture()
            .consideringAllDependencies()
            .layer("Controller").definedBy("..controller..")
            .layer("Service").definedBy("..service..")
            .layer("Repository").definedBy("..repository..")
            .layer("Model").definedBy("..model..")
            .layer("Dto").definedBy("..dto..")
            .layer("Infra").definedBy("..infra..")
            // Exemplo: Controller não pode ser acessado por ninguém, e Model não pode
            // acessar Controller
            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Infra")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service", "Model", "Infra")
            .whereLayer("Dto").mayOnlyBeAccessedByLayers("Controller", "Service", "Model", "infra");

    // REGRA 2: Nomenclatura das Classes
    @ArchTest
    static final ArchRule repositories_must_reside_in_repository_package = classes()
            .that().haveSimpleNameEndingWith("Repository")
            .should().resideInAPackage("..repository..");
}