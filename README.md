<img src="https://i.imgur.com/ILIOFKG.png" alt=""/>

# LogiLED
A modified version of LogiLED that loads the correct system libraries based on
the system architecture. This version also modifies the naming schemes of the
functions from ```LogiLedFunctionName()``` to ```functionName()```. The renamed
functions are just short hands for their counterparts, which are also still
accessible in this library.

# Using with Maven
Since this has no official Maven release, it must be installed to the user's
machine directly. After downloading the necessary JAR files, run the following
command in the same directory as the files:
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
