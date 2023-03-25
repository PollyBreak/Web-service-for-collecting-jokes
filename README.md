# Web-service-for-collecting-jokes
Web-service for collecting jokes is the project in OOP (AITU). Team №3 (SE-2212)

This application is a web-service for collecting jokes that can manipulate with jokes and provide authorization of users. 
The application runs on a local network on port 8080. Thus, the address of the application is http://localhost:8080/. The server part is implemented using Spring MVC. All data is stored in database (MySQL) with the help of the Hibernate framework and Spring Data. The authorization and authentication system is implemented with JWT tokens.

Without authorization users can:
- read all jokes, GET mapping - "api/jokes" 
- read one joke, GET mapping - "api/jokes/{id}"  
- get one random joke, GET mapping - "api/jokes/getlucky"
- get several random jokes, GET mapping - "api/jokes/getlucky/{howMuch}"
- read all jokes by one category, GET mapping - "api/jokes/by-category/{id}"
- read all jokes sorting by their rating (desc), GET mapping - "api/jokes/sorted"
- get urls to all memes, GET mapping - /api/meme"
- log in to the web service, POST mapping - "api/auth/authenticate" (request body must contain username and password)
- register in the web-service, POST mapping - "api/auth/register" (request body must contain username, firstName, email and password)

All users after authorization using their jwt token can: 
- add jokes, POST mapping - "/api/jokes" (request body must contain a joke text and its category). Jokes are added to the table "new_jokes", then admin must accept them, only after that jokes will be added to the web-service
- rate jokes, POST mapping - "/jokes/{id}" (request body must contain the field 'rating' with value 0 or 1)
- read all categories of jokes, GET mapping - "/api/categories" 
- read one category, - "/api/categories/{id}" 

Users with the role ADMIN can: 
- add new jokes (accept jokes from offered ones), GET mapping - "api/admin/newjokes/{id}/accept"
- update existing jokes, PUT mapping - "api/admin/jokes" (request body must contain the updated joke)
- delete joke by id, DELETE mapping - "api/admin/jokes/{id}"
- read all offered by users jokes, GET mapping - "api/admin/newjokes"
- read only one offered joke by its id, GET mapping - "api/admin/newjokes/{id}"

Before launching the program please create all tables and insert data in them (use MySQL and files from the "OTHERS/SQL" "tables.sql" and "insert_data.sql".
