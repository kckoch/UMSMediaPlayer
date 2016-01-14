README
======

What you need to try these examples:
* Java 7 JDK (also works with Java 8)
* (optional) Eclipse  
* You do not need Gradle installed, as I have included the Gradle wrapper in the project

Instructions (with Eclipse)
---------------------------

1. (Windows) Execute the following at a command prompt in the project directory:

        gradlew eclipse

   (Linux)
   
        chmod +x gradlew
        ./gradlew eclipse
     
2. Import the project into Eclipse (File > Import > Existing Projects Into Workspace)

3. Try running the examples in Eclipse 

Instructions (without Eclipse)
------------------------------

1. (Windows) Execute the following at a command prompt in the project directory:

        gradlew build        

   (Linux)
   
        chmod +x gradlew
        ./gradlew build
     
2. Execute the jar:

    java -jar build/libs/upnpmediademo-all.jar

