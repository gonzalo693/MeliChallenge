# README.MD
Project developed as a challenge test for Mercado Libre.

The objective of the project is to be able to select from a list of products the largest number of products that do not exceed the amount of a coupon
In a second level the App obtain a List of the most Favourites Items that has been called by the users

## Content

GIT: code is stored on main branch
Java: 11 - Spring boot 2.5.7


## How to clone
follow this steps:

* Open the cmd or gitbash and step on the folder that you choose to clone 

* git clone https://github.com/gonzalo693/MeliChallenge



## Local Install
You must follow the next steps:

* mvn clean install

* cd target

* java -jar demo-0.0.1-SNAPSHOT

## Execute from Local

to execute the project from local you can use the CURL command

curl -X POST http://localhost:8080/coupon/
-H 'Content-Type: application/json'
-d '{ "item_ids": ["MCO839643993", "MCO850939562", "MCO630791535", "MLA4", "MCO630791535"], "amount": 50000}'

or from postman as follows

 POST
URL http://localhost:8080/coupon/
Body
{
"item_ids": ["MCO839643993", "MCO850939562", "MCO630791535", "MLA4", "MCO630791535"],
"amount": 50000
}

## Execute with Swagger UI
After you run the App  open the Swagger page Similar to Postman
http://localhost:8080/swagger-ui.html

## Execute from Remote 
//TODO

to execute the project from remote you can use the CURL commands


from postman as follows

curl - POST 
/couponProcess  use the amount of a coupon and list of items in order to maximize the amount 

curl --location --request POST 'https://sheltered-fjord-22768.herokuapp.com/cupon/couponProcess' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--data-raw '{"item_ids": ["MLA811601010"],"amount": 50000}'

 curl - GET
 /coupon/stats  returns a list of favorites items founded.

 curl --location --request GET 'https://sheltered-fjord-22768.herokuapp.com/cupon/coupon/stats' \
 --header 'accept: */*'

## Resources 

Items List to test

"MLA759942879","MLA759942879","MLA791074957","MLA756385586","MLA772802098","MLA784528959"


