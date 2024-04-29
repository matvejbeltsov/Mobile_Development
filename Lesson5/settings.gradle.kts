pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Lesson5"
include(":app")
include(":app:task_1_1")
include(":accelerometer")
include(":camera")
include(":audiorecord")
include(":mireaproject")
