Miau standalone source build — resource layout
==============================================

The original client jar contains no bundled resources (pure classes).
This directory exists so Gradle's `processResources` task works and so
runtime resources can be dropped in later without touching `build.gradle.kts`.

At runtime the client expects, like vanilla Minecraft 1.8.9:

  - Minecraft assets: the normal 1.8.9 asset index under the game
    directory (`assets/`), fetched by the vanilla launcher logic.
  - LWJGL 2 native libraries: place the matching natives DLL/SO next to
    the jar (or on `java.library.path`) — see README.md.
