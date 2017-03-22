set JAVA_HOME=C:\Progra~1\Java\jdk1.8.0_121

set M2_HOME=C:\Installers\apache-maven-3.3.9-bin\apache-maven-3.3.9

set PATH=%JAVA_HOME%\bin;%M2_HOME%\bin;%PATH%

set CLASSPATH=%JAVA_HOME%\lib;%M2_HOME%\lib;%CLASSPATH%

set PROJECT_BASE=C:\WORK\SPRING\Processing

set PROJECT_BASE_LIB=%PROJECT_BASE%\lib

set CLASSPATH=%CLASSPATH%;%PROJECT_BASE_LIB%\spring-context-3.0.5.RELEASE.jar;%PROJECT_BASE_LIB%\spring-aop-3.0.5.;RELEASE.jar;%PROJECT_BASE_LIB%\aopalliance-1.0.jar;%PROJECT_BASE_LIB%\spring-beans-3.0.5.RELEASE.jar;%PROJECT_BASE_LIB%\spring-core-3.0.5.RELEASE.jar;.\%PROJECT_BASE_LIB%\commons-logging-1.1.1.jar;%PROJECT_BASE_LIB%\spring-expression-3.0.5.RELEASE.jar;%PROJECT_BASE_LIB%\spring-asm-3.0.5.RELEASE.jar;%PROJECT_BASE_LIB%\activemq-all-5.14.0.jar

set CLASSPATH=%CLASSPATH%;%PROJECT_BASE%/config

set CLASSPATH=%CLASSPATH%;%PROJECT_BASE%


cd target/classes

java tradesale.processing.TradeSaleProcessingService

 
pause

