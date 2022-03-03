@echo off

javac -classpath ".;.\log4j14\log4j-api-2.14.1.jar.;.\log4j14\log4j-core-2.14.1.jar;" %1.java

java -classpath ".;.\log4j14\log4j-api-2.14.1.jar.;.\log4j14\log4j-core-2.14.1.jar;" %1 %2