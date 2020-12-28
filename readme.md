This project server as the search for stock ticker symbols and names


## Quick Command Reference

* Compilation
    * Run `gradlew build` or click the "Make" button in IntelliJ.
* Testing
    * Run `gradlew test` or right-click and "Run" the test or test directory.
* Packaging
    * Run `gradlew :zip`, which creates an `addon-*.zip` file in your `build/distributions` directory. This can uploaded using the GWDC CLI.

## Source and Conventions

* Java source is housed in the `src/main/java` directory. Beyond that, Addons should use these recommended conventions:
    * The root package is `com/{partner name}/{addon name}`.
    * The `Initializer` class is in the root package.
    * REST resources are in an `api` package.
    * DTOs are in a `dto` package.

* Java test sources are housed in the `src/test/java` directory. Test classes should reside in the same package as the source file they test.

* The Addon Properties file is in `src/main/gw`.

## Folders and Files

* .gradle/
    * This directory is used by the Gradle build tool, you can ignore this directory.
* build/
    * This is the build folder for the project. When packing your Addon, it will be placed in the `distributions` directory under build/.
* gradle/
    * This directory houses the "Gradle Wrapper", you can ignore this directory.
* src/
    * This directory contains all  source. 
* build.gradle
    * Sets up the build definition for Gradle.
* gradle.properties, settings.gradle
    * Properties used by the Gradle build.
* gradlew/gradlew.bat
    * The entry point for Gradle commands, for example "gradlew build"