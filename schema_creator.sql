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

create table alerts
(
    uuid        varchar(255),
    date        date         not null,
    time        time         not null,
    title    varchar(100)  not null,
    maxPrice      int   not null,
    description varchar(100)   not null,
    quantity       int          not null,
    buyer     varchar(255) not null,
	PRIMARY KEY (uuid)
);