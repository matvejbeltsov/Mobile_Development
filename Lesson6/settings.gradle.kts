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

rootProject.name = "Lesson6"
include(":app")
include(":task_2_1")
include(":securesharedpreferences")
include(":internalfilestorage")
include(":notebook")
include(":employeedb")
include(":mireaproject")
