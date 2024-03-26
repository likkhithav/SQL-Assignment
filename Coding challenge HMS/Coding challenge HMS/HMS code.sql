use hospital_management_system;

# insertion code

-- patient table
insert into patient (id, first_name, last_name, dob, gender, contact_number) 
values
(1, "diya", "krish", "2002-09-12", "female", "987-637-7383"),
(2, "dev", "surya", "2006-04-29", "female", "869-537-3643"),
(3, "dee", "john", "1996-02-04", "female", "963-633-6383"),
(4, "sri", "patel", "1999-05-19", "female", "953-836-6732"),
(5, "yuva", "singh", "2000-11-14", "female", "936-763-7634");

-- doctor table
insert into doctor (id, first_name, last_name, specialization, contact_number) 
values
(1, "soha", "gosh", "pediatrics", "987-637-7383"),
(2, "sona", "bose", "MBBS", "963-673-6367"),
(3, "arjun", "dev", "BDS", "953-836-4332"),
(4, "abir", "gosh", "Dermatalogists", "953-256-6832"),
(5, "kunal", "patel", "General", "973-843-6333");

-- appointment table
insert into appointment (id, patient_id, doctor_id, appointment_date, description) 
values
(1, 5, 3, "2024-03-25", "cavity"),
(2, 4, 2, "2024-03-25", "fever"),
(3, 3, 1, "2024-03-25", "cough"),
(4, 2, 2, "2024-03-25", "fever"),
(5, 1, 4, "2024-03-25", "acne");