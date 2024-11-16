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
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:${minecraftVersion}-R0.1-SNAPSHOT")
    compileOnly("net.milkbowl.vault:VaultUnlockedAPI:2.4")
}

tasks.withType<ProcessResources> {
    inputs.property("pluginVersion", version)

    filesMatching("plugin.yml") {
        expand("pluginVersion" to version)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
