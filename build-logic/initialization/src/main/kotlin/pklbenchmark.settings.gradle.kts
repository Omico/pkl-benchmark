import me.omico.gradle.initialization.includeAllSubprojectModules
import me.omico.gradm.addDeclaredRepositories

addDeclaredRepositories()

plugins {
    id("pklbenchmark.gradm")
    id("pklbenchmark.gradle-enterprise")
}

includeBuild("build-logic/project")

includeAllSubprojectModules("pklbenchmark")
