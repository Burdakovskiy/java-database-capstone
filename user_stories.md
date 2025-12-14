**Admin Login:**
_As an admin, I want to log into the portal with my username and password, so that I can manage the platform securely._

**Acceptance Criteria:**
1. [Admin can access a login page and submit username and password]
2. [With valid credentials, the admin is authenticated and redirected to the Admin Dashboard]
3. [With invalid credentials, the system shows an error message and does not create a session/token]

**Priority:** [High]
**Story Points:** [3]
**Notes:**
- [Authentication will be handled using Spring Security]

**Admin Logout:**
_As an admin, I want to log out of the portal, so that system access is protected when I finish working._

**Acceptance Criteria:**
1. [Admin can click “Logout” from the dashboard or navigation]
2. [After logout, the admin session/token is invalidated]
3. [Any subsequent access to protected admin pages redirects back to login]

**Priority:** [High]
**Story Points:** [2]
**Notes:**
- [Applies to both MVC views and REST endpoints.]

**Add Doctor Profile:**
_As an admin, I want to add doctors to the portal, so that doctors can manage their appointments and availability._

**Acceptance Criteria:**
1. [Admin can create a doctor profile by providing required fields (e.g., name, specialization, email/username)]
2. [The doctor profile is saved in MySQL and becomes visible in the doctors list]
3. [The system validates required fields and rejects invalid data with a clear error message]

**Priority:** [High]
**Story Points:** [5]
**Notes:**
- [Required fields should be validated using JPA annotations.]

**Delete Doctor Profile:**
_As an admin, I want to delete a doctor’s profile from the portal, so that inactive or incorrect doctor records are removed._

**Acceptance Criteria:**
1. [Admin can delete an existing doctor profile from the doctors list]
2. [After deletion, the doctor no longer appears in the portal and cannot be used for new appointments]
3. [The system handles related records safely (e.g., prevents deletion if future appointments exist, or performs a safe deactivation depending on design choice)]

**Priority:** [Medium]
**Story Points:** [5]
**Notes:**
- [Implementation may use hard delete or soft delete (deactivation).]

**View Appointment Statistics:**
_As an admin, I want to run a stored procedure to view appointments per month, so that I can track system usage._

**Acceptance Criteria:**
1. [A stored procedure exists in MySQL to calculate monthly appointment counts]
2. [The procedure runs successfully via MySQL CLI]
3. [Results show month and appointment count]

**Priority:** [Medium]
**Story Points:** [3]
**Notes:**
- [This story directly supports Module 3 (Stored Procedures)]

**View Doctors Without Authentication:**
_As a patient, I want to view a list of doctors without logging in, so that I can explore available options before registering._
**Acceptance Criteria:**
1. [Unauthenticated users can access a public list of doctors]
2. [The list displays basic doctor information (name, specialization)]
3. [Booking actions are disabled for unauthenticated users]
**Priority:** [Medium]
**Story Points:** [2]
**Notes:**
- [Read-only access only.]

**Patient Registration:**
_As a patient, I want to sign up using my email and password, so that I can book appointments._
**Acceptance Criteria:**
1. [Patient can register using a valid email and password]
2. [Email must be unique in the system]
3. [After successful registration, the patient account is created]
**Priority:** [High]
**Story Points:** [3]
**Notes:**
- [Password validation rules should be applied.]

**Patient Login:**
_As a patient, I want to log into the portal, so that I can manage my bookings._
**Acceptance Criteria:**
1. [Patient can log in with valid credentials]
2. [After login, patient is redirected to their dashboard]
3. [Invalid credentials result in an error message]
**Priority:** [High]
**Story Points:** [3]
**Notes:**
- [Authentication handled via Spring Security / JWT.]

**Patient Logout:**
_As a patient, I want to log out of the portal, so that my account remains secure._
**Acceptance Criteria:**
1. [Patient can log out from the dashboard]
2. [Session or token is invalidated after logout]
3. [Access to protected pages is blocked after logout]
**Priority:** [Medium]
**Story Points:** [2]
**Notes:**
- [Applies to both MVC views and REST endpoints.]

**Book an Appointment:**
_As a patient, I want to log in and book an hour-long appointment with a doctor, so that I can consult with a specialist._
**Acceptance Criteria:**
1. [Patient must be authenticated to book an appointment]
2. [Patient can select a doctor and an available one-hour time slot]
3. [The appointment is saved successfully and confirmed]
**Priority:** [High]
**Story Points:** [5]
**Notes:**
- [Appointment duration is fixed to one hour.]

**Doctor Login:**
_As a doctor, I want to log into the portal, so that I can manage my appointments._
**Acceptance Criteria:**
1. [Doctor can log in using valid credentials]
2. [After successful login, doctor is redirected to the Doctor Dashboard]
3. [Invalid credentials result in an error message and access is denied]
**Priority:** [High]
**Story Points:** [3]
**Notes:**
- [Authentication is handled via Spring Security and role-based access control]

**Doctor Logout:**
_As a doctor, I want to log out of the portal, so that my data remains protected._
**Acceptance Criteria:**
1. [Doctor can log out from the dashboard]
2. [Session or authentication token is invalidated]
3. [Access to protected doctor pages is blocked after logout]
**Priority:** [Medium]
**Story Points:** [2]
**Notes:**
- [Applies to both MVC dashboards and REST endpoints.]

**View Appointment Calendar:**
_As a doctor, I want to view my appointment calendar, so that I can stay organized._
**Acceptance Criteria:**
1. [Doctor can view a calendar of their scheduled appointments]
2. [Each appointment displays date, time, and patient information]
3. [Appointments are sorted chronologically]
**Priority:** [High]
**Story Points:** [3]
**Notes:**
- [Calendar may be displayed as a list or date-based view.]

**Manage Availability and Unavailability:**
_As a doctor, I want to mark my availability and unavailability, so that patients can book only available time slots._
**Acceptance Criteria:**
1. [Doctor can define available and unavailable time slots]
2. [Unavailable slots cannot be booked by patients]
3. [Availability changes are reflected immediately in the booking system]
**Priority:** [High]
**Story Points:** [5]
**Notes:**
- [Time slots are one hour long.]

**Update Doctor Profile:**
_As a doctor, I want to update my profile with specialization and contact information, so that patients have up-to-date information._
**Acceptance Criteria:**
1. [Doctor can update profile fields such as specialization and contact details]
2. [Updated information is saved successfully]
3. [Changes are visible to patients viewing the doctor list]
**Priority:** [Medium]
**Story Points:** [3]
**Notes:**
- [Some fields may be read-only depending on admin configuration.]

