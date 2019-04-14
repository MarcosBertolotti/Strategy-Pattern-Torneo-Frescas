create database torneoFrescas;

	use torneoFrescas;
    
    create table ganadores(
		id_ganador int auto_increment,
		nombre varchar(50) not null,
        tolerancia int not null,
        bebido_total int not null,
        orina_retenida double not null,
        primary key (id_ganador)
    );