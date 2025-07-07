plugins {
    java
}

val pluginVersion: String by extra
val minecraftVersion: String by extra

group = "dev.tonimatas"
version = pluginVersion
base.archivesName = "LiteFunPlugin"

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.bundles.dependencies)
}

tasks.processResources {
    val properties = mapOf("pluginVersion" to version, "minecraftVersion" to minecraftVersion)
    inputs.properties(properties)

    filesMatching("paper-plugin.yml") {
        expand(properties)
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.compileJava {
    sourceCompatibility = "21"
    targetCompatibility = "21"
    options.encoding = "UTF-8"
}
