# MiauSource — standalone rebuild of the Miau 1.8.9 client

Goal (Route B): turn the decrypted source dump of the closed "Miau" client into a
**compilable, self-contained** standalone 1.8.9 client project, faithful to what
the launcher ships.

## Pipeline (tools in `..\MyauDump`)

| # | Tool | Purpose |
|---|------|---------|
| 1 | `DumpMyau.java` | Decrypt container (`d/c.bin`, `d/r.bin`, `d/a.bin`); emit `Miau-full.jar` with **all** classes under real names (zip entries survive non-Windows-filename-safe obf names; a plain disk dump silently loses 400+ classes) |
| 2 | `EvalIndy.java` | Resolve all invokedynamic obfuscation: decrypts per-site AES-GCM payloads keyed on the call-site class name, replaces constants with `LDC`, hidden member bindings with real `getstatic/getfield/invokeX`, wrapped `StringConcatFactory` bootstraps with standard concat indy. Result: **99,183/99,184 sites resolved** |
| 3 | `RestoreNames.java` | Rename the 1,192 classes with non-ASCII/illegal JVM names to deterministic ASCII names (`oc` + sha1) AND legalize the 1,595 illegal member names (raw digits/unprintable chars → `m`/`f` + 10 hex) |
| 3b | `FoldOpaque.java` | Fold the obfuscator's opaque-predicate static booleans to `false` (never-written flags + the `oc49fb68d420`/`oc69da1aa7f5` ping-pong pair) so CFR can restructure control-flow-flattened methods |
| 4 | *your decompiler* | Decompile the folded jar into the source tree under `src/main/java` |
| 5 | Gradle build | `build.gradle.kts` (Java 8, UTF-8, source-only) |

## Status / remaining work

- [x] Passwordless static extraction of the container
- [x] invokedynamic resolution: 99,183 ok / 1 intentionally left (caller-sensitive method, stays runtime-functional)
- [x] legal-name normalization (1,192 classes + 1,595 members)
- [x] opaque-predicate folding (`FoldOpaque.java`): 554 never-written + 2 ping-pong flags → 314 read sites folded to `false`
- [x] Tree-wide enum conversion (`ConvertEnums.ps1`, `RemoveEnumSynth.ps1`): all CFR
      `class X extends Enum<X>` shapes converted to real `enum` declarations; constant
      declarations with builder (`static {}` / inline-arg / anonymous-subclass) forms done
- [x] fastutil extracted into a standalone-compiling 573-file source set (closure-based, upstream 8.5.9 wholesale replaces)
- [x] Inline of `x\ocb50cc94190`'s 9 anonymous-subclass enum constants (subclasses deleted, overrides moved into constant bodies)
- [x] `Random` ambiguity qualified in 6 kotlin stdlib files; okio `okio.internal` dash-named classes renamed to match their `D*` class names
- [x] `javac` parse stage now clean over the whole 11,452-file tree (was 6,747 → 85 errors when parse errors masked follow-on passes)
- [ ] Full-tree semantic triage in progress: ~6,100 errors over ~1,050 files (see `..\MyauDump\bldlogs\build-errors.last.txt`)
      Largest buckets: kotlin stdlib generics overloads, guava/icu CFR generics artifacts,
      ambiguous `Deprecated`, missing external packages (`org.apache.tomcat.jni` for netty openssl),
      `class X extends Record` leftovers, obfuscated method name collisions (`method ?() is already defined`)
- [ ] Then: first full `gradlew build`, iterate to clean
- [ ] Runtime: LWJGL 2 natives are NOT in the source tree; fetch from Mojang's libraries (e.g.
      `https://libraries.minecraft.net/org/lwjgl.lwjgl/lwjgl/2.9.4-nightly-20150209/lwjgl-2.9.4-nightly-20150209-natives-windows.jar`)
      for `sourceSets.main` runtime config
- [ ] `ClientNativeBridge` anti-tamper: the native DLL mixes class-bytes hashes into the keys of
      the native bridge. A pure-source rebuild must stub or re-implement this bridge. (Note: the
      opaque-predicate flags folded by `FoldOpaque` are part of the same anti-tamper scheme.)

## Project structure

```
MiauSource\
├── build.gradle.kts          Java 8, UTF-8; main class net.minecraft.client.main.Main
├── settings.gradle.kts
├── gradle\wrapper\           Gradle 8.8 wrapper
├── gradlew.bat
├── libs\                     third-party jars (bouncycastle, jackson, protobuf, ...)
│   └── classpath.txt         ';'-joined classpath for plain `javac` diagnostics runs
├── src\
│   ├── main\java\            the full decompiled tree (client, vanilla MC, kotlin, all bundled libs)
│   │   ├── keystrokesmod\    the actual client (KeystrokesMod / Miau UI classes)
│   │   ├── x\                deobfuscated client-internal classes (name roots via rename-map)
│   │   └── ...               vanilla MC (net.minecraft), libs (io.netty, kotlin, okhttp3, ...)
│   └── main\resources\       placeholder — jar carries no resources; assets/natives stay external
└── sources.txt               javac @argfile listing every .java (regenerate: `Get-ChildItem src\main\java -Recurse -Filter *.java | % FullName > sources.txt` then `git`-style refresh before diagnostic builds)
```

Build diagnostics (error dumps, intermediate decompile passes) live in
`..\MyauDump\attic\` and `..\MyauDump\bldlogs\`.

## Quick command reference

```
cd C:\Users\dinhv\IdeaProjects\stuff\MyauDump

# 1. decrypt container (container jar from the launcher)
java -cp "..\Java Deobf Tools\deobfuscator.jar;." DumpMyau "%appdata%\MiauLauncher\client\Miau.jar"

# 2. resolve indy obfuscation
java -cp "..\Java Deobf Tools\deobfuscator.jar;." EvalIndy "%appdata%\MiauLauncher\client\Miau-dump\Miau-full.jar" "C:\Users\dinhv\AppData\Roaming\MiauLauncher\client\Miau-dump\Miau-indy.jar"

# 3. legalize names
java -cp "..\Java Deobf Tools\deobfuscator.jar;." RestoreNames "%appdata%\MiauLauncher\client\Miau-dump\Miau-indy.jar" ".\Miau-renamed.jar" ".\rename-map.txt"

# 4. decompile \Miau-renamed.jar with your decompiler of choice → src/main/java
# 5. build
gradlew.bat build   # from this directory
```

## Notes

- The `.class` blob layer to run was captured at `Miau-indy.jar` — if you want a
  "still-runnable & de-obfuscated" binary fallback, that is the artifact to reference.
- `rename-map.txt` maps each original obfuscated name → generated ASCII name. Keep it —
  you'll need it to correlate stack traces and to convert renamed references back if
  necessary for localization/mapping comparability.
