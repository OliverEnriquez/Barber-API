

-- Create CUSTOMERS Table
CREATE TABLE CUSTOMERS (
                           CUSTOMER_ID INT AUTO_INCREMENT PRIMARY KEY,
                           FIRST_NAME VARCHAR(50),
                           LAST_NAME VARCHAR(50),
                           EMAIL VARCHAR(100),
                           PHONE VARCHAR(15),
                           ADDRESS VARCHAR(100),
                           CITY VARCHAR(50),
                           STATE VARCHAR(50),
                           ZIP VARCHAR(10),
                           DATE_OF_BIRTH DATE
);

-- Create BARBERS Table
CREATE TABLE BARBERS (
                         BARBER_ID INT AUTO_INCREMENT PRIMARY KEY,
                         FIRST_NAME VARCHAR(50),
                         LAST_NAME VARCHAR(50),
                         EMAIL VARCHAR(100),
                         PHONE VARCHAR(15),
                         ADDRESS VARCHAR(100),
                         CITY VARCHAR(50),
                         STATE VARCHAR(50),
                         ZIP VARCHAR(10),
                         SPECIALIZATION VARCHAR(100),
                         SCHEDULE VARCHAR(100)
);

-- Create SERVICES Table
CREATE TABLE SERVICES (
                          SERVICE_ID INT AUTO_INCREMENT PRIMARY KEY,
                          SERVICE_NAME VARCHAR(100),
                          DESCRIPTION TEXT,
                          PRICE DECIMAL(10, 2)
);

-- Create APPOINTMENTS Table
CREATE TABLE APPOINTMENTS (
                              APPOINTMENT_ID INT AUTO_INCREMENT PRIMARY KEY,
                              CUSTOMER_ID INT,
                              BARBER_ID INT,
                              SERVICE_ID INT,
                              APPOINTMENT_DATE_TIME DATETIME,
                              STATUS VARCHAR(20),
                              FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID),
                              FOREIGN KEY (BARBER_ID) REFERENCES barber(BARBER_ID),
                              FOREIGN KEY (SERVICE_ID) REFERENCES SERVICES(SERVICE_ID)
);

-- Create PAYMENT_HISTORY Table
CREATE TABLE PAYMENT_HISTORY (
                                 PAYMENT_ID INT AUTO_INCREMENT PRIMARY KEY,
                                 APPOINTMENT_ID INT,
                                 PAYMENT_DATE_TIME DATETIME,
                                 AMOUNT DECIMAL(10, 2),
                                 PAYMENT_METHOD VARCHAR(20),
                                 FOREIGN KEY (APPOINTMENT_ID) REFERENCES APPOINTMENTS(APPOINTMENT_ID)
);

-- Create REVIEWS Table
CREATE TABLE REVIEWS (
                         REVIEW_ID INT AUTO_INCREMENT PRIMARY KEY,
                         CUSTOMER_ID INT,
                         BARBER_ID INT,
                         SERVICE_ID INT,
                         RATING INT,
                         COMMENT TEXT,
                         REVIEW_DATE_TIME DATETIME,
                         FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID),
                         FOREIGN KEY (BARBER_ID) REFERENCES barber(BARBER_ID),
                         FOREIGN KEY (SERVICE_ID) REFERENCES SERVICES(SERVICE_ID)
);

-- Create IMAGES Table
CREATE TABLE IMAGES (
                        IMAGE_ID INT AUTO_INCREMENT PRIMARY KEY,
                        ENTITY_ID INT,
                        ENTITY_TYPE VARCHAR(20),
                        IMAGE_URL VARCHAR(255)
);
