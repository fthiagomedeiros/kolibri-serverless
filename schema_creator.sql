create table routes
(
    uuid        varchar(255),
    date        date         not null,
    time        time         not null,
    flightId    varchar(10)  not null,
    origin      varchar(4)   not null,
    destination varchar(4)   not null,
    cargo       int          not null,
    airline     varchar(255) not null,
	PRIMARY KEY (uuid)
);