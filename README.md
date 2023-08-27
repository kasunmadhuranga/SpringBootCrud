# SpringBootCrud
Student mark adding CRUD

#dependencies
jpa
lombok
modelmapper - https://mvnrepository.com/artifact/org.modelmapper/modelmapper/2.4.4

http://localhost:8080/api/v1/student/getStudent
http://localhost:8080/api/v1/student/saveStudent
{
    "id" : 1,
    "name" : "Kasun Madhuranga",
    "mark" : "98"
}
http://localhost:8080/api/v1/student/updateStudent
{
    "id" : 1,
    "name" : "Kasun Madhuranga",
    "mark" : "99"
}
http://localhost:8080/api/v1/student/deleteStudent/1
