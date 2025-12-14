Architecture Summary
This is a Spring Boot–based web application that follows the MVC architecture pattern and combines server-rendered views with RESTful APIs. The application uses Thymeleaf to render dashboards for administrators and doctors, while REST endpoints are exposed for other modules such as appointments and patient interactions.
The system supports multiple user roles—administrator, doctor, and patient—and provides core functionality such as appointment scheduling and role-specific dashboards (personal cabinets).
The application integrates two database technologies:
MySQL for structured relational data such as patients, doctors, appointments, and administrators
MongoDB for flexible, document-based data such as prescriptions
All requests are processed through controllers, delegated to the service layer for business logic, and finally routed to repositories that interact with the appropriate database.

Numbered Flow of Data and Control
1. A user accesses the AdminDashboard, DoctorDashboard, or an Appointment page through the web interface or an API client.
2. The incoming request is routed to the appropriate Thymeleaf controller (for HTML views) or REST controller (for JSON responses).
3. The controller delegates the request to the service layer, where business logic and validations are applied.
4. The service layer interacts with the repository layer to retrieve or persist data.
5. For relational data (patients, doctors, appointments, admins), a Spring Data JPA repository communicates with the MySQL database.
6. For document-based data (prescriptions), a Spring Data MongoDB repository communicates with the MongoDB database.
7. The retrieved or processed data is returned to the controller and sent back to the client as either dynamic HTML pages or JSON responses, depending on the request type.

