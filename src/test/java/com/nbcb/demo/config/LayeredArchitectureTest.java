package com.nbcb.demo.config;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.nbcb.demo")
public class LayeredArchitectureTest {
    @ArchTest
    public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .layer("Controller").definedBy("com.nbcb.demo.api.resource..")
            .layer("Service").definedBy("com.nbcb.demo.service..")
            .layer("Dao").definedBy("com.nbcb.demo.dao..")

            .whereLayer("Dao").mayOnlyBeAccessedByLayers("Service")
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Controller").mayNotBeAccessedByAnyLayer();
}