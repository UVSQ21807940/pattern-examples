plugins {
    java // Apply the java plugin to add support for Java
    application // Apply the application plugin to add support for building an application
}

application {
    mainClassName = "App"
}

dependencies {
    compile("com.google.guava:guava:23.0") // This dependency is found on compile classpath of this component and consumers.

    testCompile("junit:junit:4.12")
}

repositories {
    jcenter() // Use jcenter for resolving your dependencies.
}
