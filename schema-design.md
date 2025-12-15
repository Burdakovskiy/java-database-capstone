## MySQL Database Design
### Table: admins
- id: INT, Primary Key, Auto Increment
- username: VARCHAR(50), Not Null, Unique
- email: VARCHAR(255), Not Null, Unique
- password_hash: VARCHAR(255), Not Null
- created_at: TIMESTAMP, Not Null

### Table: doctors
- id: INT, Primary Key, Auto Increment
- first_name: VARCHAR(100), Not Null
- last_name: VARCHAR(100), Not Null
- email: VARCHAR(255), Not Null, Unique
- phone: VARCHAR(30)
- specialization: VARCHAR(100), Not Null
- is_active: BOOLEAN, Not Null
- created_at: TIMESTAMP, Not Null

### Table: patients
- id: INT, Primary Key, Auto Increment
- first_name: VARCHAR(100), Not Null
- last_name: VARCHAR(100), Not Null
- email: VARCHAR(255), Not Null, Unique
- phone: VARCHAR(30)
- address: VARCHAR(255), Not Null
- created_at: TIMESTAMP, Not Null

### Table: appointments
- id: INT, Primary Key, Auto Increment
- doctor_id: INT, Foreign Key → doctors(id)
- patient_id: INT, Foreign Key → patients(id)
- appointment_time: DATETIME, Not Null
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)
<!-- Design Notes (inline justification):
Appointments reference both doctors and patients via foreign keys.
A doctor should not have overlapping appointments (to be enforced at service or DB constraint level).
Appointment history should be retained even if a patient or doctor is deactivated. -->

## MongoDB Collection Design
### Collection: prescriptions
```json
{
  "_id": "ObjectId(\"64abc123456\")",
  "appointmentId": 51,
  "patientName": "John Smith",
  "doctorName": "Dr. Alice Brown",

  "medications": [
    {
      "name": "Paracetamol",
      "dosage": "500mg",
      "frequency": "Every 6 hours",
      "durationDays": 5
    },
    {
      "name": "Ibuprofen",
      "dosage": "400mg",
      "frequency": "Twice a day",
      "durationDays": 3
    }
  ],

  "doctorNotes": "Take medications after meals and drink plenty of water.",
  "refillCount": 2,

  "pharmacy": {
    "name": "Walgreens SF",
    "location": "Market Street",
    "contact": "+1-415-555-1234"
  },

  "tags": ["pain-relief", "fever"],
  "metadata": {
    "issuedAt": "2025-12-14T10:30:00Z",
    "createdBy": "doctor",
    "status": "ACTIVE"
  }
}
