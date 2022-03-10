Instruction to run project

1. setup a mysql database
2. download the project
3. open in eclispse by going to
File -> import ->maven -> existing maven project -> select the project folder
( here it will be productrestapi)pom.xml file name should appear, click on finish
4. let maven download the dependencies
5. find scr/main/resources/application.properties
and replace these 3 properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb   (url of database)
spring.datasource.username=root   (username of mysql db)
spring.datasource.password=       (password of mysql db)
6. Now click on run as java application to this class com.flash.springweb.ProductrestapiApplication
7. open this url http://localhost:8080/productapi/swagger-ui/index.html#/ after successful restart

