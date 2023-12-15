CREATE TABLE admin (
                       ID SERIAL primary key ,
                       EMAIL VARCHAR (255) NOT NULL,
                       PASSWORD VARCHAR (255) NOT NULL
);

CREATE TABLE address
(
    ID            SERIAL      primary key ,
    STREET_NAME   VARCHAR(255) NOT NULL,
    STREET_NUMBER VARCHAR(255) NOT NULL,
    POSTAL_CODE   VARCHAR(255) NOT NULL
);

CREATE TABLE division
(
    ID      SERIAL  primary key,
    NAME    VARCHAR(255) NOT NULL,
    ORIGINAL_NAME VARCHAR(255) NOT NULL,
    DIRECTOR   VARCHAR(255) NOT NULL,
    DIVISION_ID INT DEFAULT NULL
);

CREATE TABLE level
(
    ID            SERIAL      primary key ,
    MONTHLY_COST   NUMERIC NOT NULL,
    ALLOCATION_REDUCTION NUMERIC NOT NULL,
    MAXIMUM_TIME NUMERIC NOT NULL
);

CREATE TABLE member (
                        ID SERIAL primary key ,
                        EMAIL VARCHAR (255) NOT NULL,
                        PASSWORD VARCHAR (255) NOT NULL,
                        FIRST_NAME VARCHAR (255) NOT NULL,
                        LAST_NAME VARCHAR (255) NOT NULL,
                        ADDRESS_ID INT DEFAULT NULL,
                        LICENSE_PLATE VARCHAR (255) NOT NULL,
                        LEVEL_ID INT DEFAULT NULL,
                        REGISTRATION_DATE date NOT NULL,
                        CONSTRAINT ADDRESS_ID foreign key (ADDRESS_ID) references ADDRESS (ID),
                        CONSTRAINT LEVEL_ID foreign key (LEVEL_ID) references LEVEL (ID)
);

CREATE TABLE contact (
                         ID SERIAL primary key ,
                         FIRST_NAME VARCHAR (255) NOT NULL,
                         LAST_NAME VARCHAR (255) NOT NULL,
                         MOBILE_NUMBER VARCHAR (255) DEFAULT NULL,
                         PHONE_NUMBER VARCHAR (255) DEFAULT NULL,
                         EMAIL VARCHAR (255) NOT NULL,
                         ADDRESS_ID INT DEFAULT NULL,
                         CONSTRAINT IF NOT EXISTS ADDRESS_ID foreign key (ADDRESS_ID) references ADDRESS (ID)
);

CREATE TABLE parking_lot (
                             ID SERIAL primary key ,
                             NAME VARCHAR (255) NOT NULL,
                             CATEGORY VARCHAR (255) NOT NULL,
                             MAX_CAPACITY INT NOT NULL,
                             DIVISION_ID INT DEFAULT NULL,
                             CONSTRAINT DIVISION_ID foreign key (DIVISION_ID) references DIVISION (ID),
                             ADDRESS_ID INT DEFAULT NULL,
                             CONSTRAINT IF NOT EXISTS ADDRESS_ID foreign key (ADDRESS_ID) references ADDRESS (ID),
                             CONTACT_ID INT DEFAULT NULL,
                             CONSTRAINT IF NOT EXISTS CONTACT_ID foreign key (CONTACT_ID) references CONTACT (ID)
);

CREATE TABLE allocation (
                            ID SERIAL primary key,
                            PARKING_LOT_ID INT DEFAULT NULL,
                            CONSTRAINT PARKING_LOT_ID foreign key (PARKING_LOT_ID) references PARKING_LOT (ID),
                            MEMBER_ID INT NOT NULL,
                            CONSTRAINT MEMBER_ID foreign key (MEMBER_ID) references MEMBER (ID),
                            LICENSE_PLATE VARCHAR (255) NOT NULL,
                            STATUS VARCHAR (255) NOT NULL,
                            START_TIME TIMESTAMP NOT NULL,
                            STOP_TIME TIMESTAMP NULL
);



