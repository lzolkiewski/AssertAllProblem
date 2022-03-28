# TestVerifier

During our development we have encountered a problem where using kotlin's asserAll caused an exception while using other
implementation did not.

## In order to reproduce the problem

### 1. Create executable jar

```./gradlew testJar```

### 2. Get Console Launcher

```wget -q https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.2/junit-platform-console-standalone-1.8.2.jar```

### 3 Run local jar with console launcher

```java -jar junit-platform-console-standalone-1.8.2.jar -cp build/libs/*.jar --select-package=com.example```
