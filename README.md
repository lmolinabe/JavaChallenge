# JavaChallenge - URL Shortener

URL Shortener is a light web api used to get shorter URL's aliases.

  - Send a long URL and retrieve a short alias from it.
  - Use the alias to access de original URL.


### Tech

URL Shortener uses:

* [Java]
* [Spring Boot]


### Examples of use

For testing purposes you can use Eclipse IDE to run the aplication.

Verify that the application is running by navigating to your server address (localhost:8080) in your preferred browser.

For testing the endpoints you can use Postman to create post and get requests.


#### Post an alias for a given URL

  - Create a POST request in Postman
   - In the request URL put localhost:8080
   - In the request body put {"url":"https://nearsoft.com"}
   - Send the request and you will see the alias generated for the given URL

#### Redirect to the original URL from a given url alias

  - Create a GET request in Postman
   - In the request URL put localhost:8080/{generated alias}
   - Send the request and in the Body > Preview of the reponse you will se the content of the original URL


### Design approach

The design implemented in this light web api seeks to simplify the maintainance of the source code.

The next are some concepts used to achieve the goals:
  - SOLID principles
   - Single Responsibility principle: Several clases with single responsability were created (controller, service, POJOs, factory, URL shortener clases for the different              scenarios, etc.)
   - Open/Closed principle: An intarface URL shortener was created so every new URL shortener class for new features should implement this interface to avoid the modification of      the existing URL shortener clases
   - Interface Segregation principle: The IUrlShortener interface contains the neccesary methods only
   - Dependency Inversion principle: The IUrlShortener interface helps to not depends on details but depends on abstractions, the factory method determine wich UrlShortener          class is the correct one
  - IoC: The service class is constructor injected to the controller class so it keeps it main reponsability and delegates this object creation to achieve loose coupling
  - Dependecy Injection: Spring @Component and @Autowired were used to autodetect the marked classes for dependency injection
