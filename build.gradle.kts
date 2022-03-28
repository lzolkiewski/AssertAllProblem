plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.register<Jar>("testJar") {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    manifest {
        attributes["Main-Class"] = "com.example.TestRunnerKt"
    }
    from(configurations.testRuntimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    from(sourceSets.test.get().output)
    with(tasks.jar.get() as CopySpec)
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
    implementation("org.assertj:assertj-core:3.22.0")
    implementation("org.junit.platform:junit-platform-launcher:1.7.2")
}