weatherexpedia
==============

A spring 3 java web application that displays the weather using the API from wunderground.com

Deploying Application on Tomcat
===============================

1. Prerequisite
===============
- Java 1.6
- Tomcat 7


2. Installing WAR file to Tomcat
================================
- After checking out the whole project from GitHub, you will see 2 folders 'Web Application' and 'Dist'
- Copy 'we.war' file from Dist folder to TOMCAT_HOME/webapps/ folder.
- Restart your Tomcat 7
- Go to your web browser and type 'http://localhost:8080/we'
- You will see 'weatherexpedia' page.


3. Importing Project into Eclipse
==============================
- Download eclipse IDE (I used Kepler version)
- Create new Dynamic Web Application project with servlet 3.0 and Tomcat 7, and you also make sure your web content folder must be 'webroot'
- Then you copy all the folders under 'Web Application' folder. Then import 'src', 'test', and 'resources' folders as source folder in Eclipse.
- If you see some compilation errors, you need to import the libraries file to build path. (You can find these jars file under webroot/WEB-INF/lib folder and import them into your build path)
- If you want to run this project in Eclipse, you have to setup Tomcat 7 in eclipse first. Then you right click project -> Run As -> Run on Server.
- You will see home page in eclipse. But you are suggested to test it using real browser because Eclipse's built-in browser is not working properly with some HTML/CSS.
