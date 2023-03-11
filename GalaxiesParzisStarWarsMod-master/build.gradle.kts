import java.io.ByteArrayOutputStream

plugins {
	id("com.parzivail.internal.pswg-submodule-dependencies")
	id("fabric-loom")
	id("io.github.juuxel.loom-quiltflower")
	`maven-publish`
}

subprojects {
	if (!file("project.gradle.kts").exists()) return@subprojects

	apply(plugin = "com.parzivail.internal.pswg-submodule-dependencies")
	apply(plugin = "fabric-loom")
	apply(plugin = "io.github.juuxel.loom-quiltflower")
	apply(plugin = "maven-publish")
}

val archives_base_name: String by project.ext
val maven_group: String by project.ext
val minecraft_version: String by project.ext
val yarn_mappings: String by project.ext
val loader_version: String by project.ext
val fabric_version: String by project.ext



allprojects {
	if (!file("project.gradle.kts").exists()) return@allprojects

	repositories {
		mavenCentral()

		maven(url = "https://ladysnake.jfrog.io/artifactory/mods") {
			name = "Ladysnake Mods"
		}

		maven(url = "https://maven.terraformersmc.com/releases") {
			name = "TerraformersMC"
		}

		//	maven(url = "https://raw.githubusercontent.com/TerraformersMC/Archive/main/releases") {
		//		name = "TerraformersMC Archive"
		//	}

		maven(url = "https://maven.shedaniel.me") {
			name = "Shedaniel Maven"
		}

		maven(url = "https://maven.gegy.dev") {
			name = "Gegy Maven"
		}

		maven(url = "https://api.modrinth.com/maven") {
			name = "Modrinth"
		}

		maven(url = "https://www.jetbrains.com/intellij-repository/releases/") {
			name = "JetBrains"
		}

		maven(url = "https://maven.blamejared.com") {
			name = "BlameJared"
		}


	}

	java {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17

		// Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
		// if it is present.
		// If you remove this task, sources will not be generated.
		withSourcesJar()
	}

	quiltflower {
		quiltflowerVersion.set("1.9.0")
	}

	if (project.parent != null)
		base.archivesName.set(if (project.name.startsWith(archives_base_name)) project.name else "$archives_base_name-${project.name}")
	group = maven_group

	dependencies {
		implementation("com.google.code.findbugs:jsr305:3.0.2")
		// Used by dependencies
		implementation("com.demonwav.mcdev:annotations:1.0")

		// To change the versions, see the gradle.properties file
		minecraft("com.mojang:minecraft:${minecraft_version}")
		mappings("net.fabricmc:yarn:${yarn_mappings}:v2")
		modImplementation("net.fabricmc:fabric-loader:${loader_version}")

		// Fabric API
		modImplementation("net.fabricmc.fabric-api:fabric-api:${fabric_version}")
		constraints {
			// TODO: remove once REI gets their stuff together
			modCompileClasspath("dev.architectury:architectury-fabric:7.0.52")
			modRuntimeOnly("dev.architectury:architectury-fabric:7.0.52")
		}
	}

	tasks.processResources {
		inputs.property("version", project.version)

		filesMatching("fabric.mod.json") {
			expand("version" to project.version)
		}
	}


	// ensure that the encoding is set to UTF-8, no matter what the system default is
	// this fixes some edge cases with special characters not displaying correctly
	// see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
	tasks.withType<JavaCompile> {
		options.encoding = "UTF-8"
		options.compilerArgs.addAll(arrayOf("-Xmaxerrs", "1000", "-Xdiags:verbose"))
	}

	tasks.jar {
		from(project.file("LICENSE")) {
			rename { "${it}_${archives_base_name}" }
		}
	}

	// configure the maven publication
	publishing {
		publications {
			create<MavenPublication>("mavenJava") {
				from(components["java"])
			}
		}

		// select the repositories you want to publish to
		repositories {
			// uncomment to publish to the local maven
			// mavenLocal()
		}
	}

	apply(from = "project.gradle.kts")
}

tasks.assemble {
	setDependsOn(setOf<Task>()) // let's not take half a minute to build an empty project
}
