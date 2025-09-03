# Image Processing Project

This project implements the convolution function to apply a transformation to an image using multiple kernels. It was part of a challenge for a job interview in 2016.

## 1. Introdution
### 1.1 Purpose
The Image Processing web application shows in a visual way the different results after applying transformation, in this specific case a convolution, using some of the most well-known filters for image processing science.

### 1.2 Product Scope
For this version, the web application is limited to a static image on the principal web page, which is transformed depending of the filter selected. The transformation process to apply to the image is a convolution, defined as the multiplication of each element with its local neighbors weighted by mask. 

### 1.3 References
[Kernel](https://en.wikipedia.org/wiki/Kernel_)

## 2. Overview
### 2.1 Product Functions
The user is able to change the filter to apply a transformation to an image, the result is display on right side of the screen. 
<img width="417" height="247" alt="image" src="https://github.com/user-attachments/assets/22a6a5e4-81e9-47b2-8431-5966aa902bac" />

### 2.2 Design and Implementation
The project is a dynamic web java project that uses maven for building the project and get the dependencies needed. The dependencies gotten by maven are Junit, Gson and javax.Servlet.
The context name of the project is ImageProcessing, and it can be accessed, once deployed, by http://localhost:8080/ImageProcessing/. Change to the correct port if needed.

Some aspects of the java language covered in this project are:
•	Data Structures (List, Map, enum)
•	Logging
•	Error Handling
•	Threads and Executor
•	WebListeners and Servlets
•	ImageIO

Some concepts of OO Programing and design patterns used are the following:
•	Implementation and Extension
•	Aggregation
•	Encapsulation
•	Program for interfaces than for implementation
•	Aggregation over inheritance, when it is possible.

Some design patterns and good practices applied are:
•	Singleton design pattern
•	Code comments and javadocs
•	Use of annotation instead of xml blocks in the deploy descriptor.
•	Use int instead of String on maps.

### 2.3 Class Diagram
<img width="482" height="235" alt="image" src="https://github.com/user-attachments/assets/6633a58d-c8c5-484a-a84a-67a494211026" />

### 2.4 Documentation
JavaDocs document are included inside the project on the following path datalex\ImageProcessing\doc\index.html 

### 2.5 To be completed and improvements
It was not possible to complete the junit test cases nor the sequence diagrams
As improvements the image to be processed should be loaded by the user, the filters has to be move to a database or a config file. Some frameworks could be added like ORM, some javascript framework, spring context and mvc.








