# LogiLED
A modified version of LogiLED that loads the correct system libraries based on the system architecture.
This version also modifies the naming schemes of the functions from ```LogiLedFunctionName()``` to
```functionName()```.

# How to use with Maven
In order to use with Maven, download the latest release and install it using:
```
mvn install:install-file -Dfile=gaming-1.0-shaded.jar -DgroupId=com.logitech -DartifactId=gaming -Dversion=1.0 -Dpackaging=jar
```

After that, place this dependency in your Maven dependencies:
```xml
<dependency>
    <groupId>com.logitech</groupId>
    <artifactId>gaming</artifactId>
    <version>1.0</version>
</dependency>
```
