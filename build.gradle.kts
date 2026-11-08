// Miau standalone 1.8.9 source build (Route B).
// Everything is compiled from source (vanilla MC + client + bundled libs).
// Only LWJGL/native DLLs and the game assets come from outside.
plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    // If you have a real JDK 8 installed, prefer the toolchain:
    // toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(8)
    // Decompiled code is loud; keep the output readable.
    options.isWarnings = false
    options.isDeprecation = false
}

sourceSets {
    main {
        java.setSrcDirs(listOf("src/main/java"))
        resources.setSrcDirs(listOf("src/main/resources"))
    }
}

dependencies {
    // Route B: optional deps referenced by bundled libs are real Maven Central jars
    // (jackson, log4j, mail, protobuf, javassist, bouncycastle, jzlib, udt, ...),
    // fetched into libs/. Everything else (netty, guava, gson, kotlin, okhttp, jna,
    // fastutil...) is compiled from the source tree itself.
    implementation(fileTree("libs") { include("*.jar") })
}

tasks.jar {
    archiveBaseName.set("Miau")
    manifest {
        attributes(
            "Main-Class" to "net.minecraft.client.main.Main",
            "Implementation-Vendor" to "unknown",
            "Implementation-Title" to "Miau Source",
            "Implementation-Version" to "src",
        )
    }
}
