create table area (
    id serial primary key,
    nombre varchar(100),
    descripcion varchar(100),
    fecha_creacion date,
    fecha_fin date
)

create table oficina (
    id serial primary key,
    nombre varchar(100),
    descripcion varchar(100),
    fecha_creacion date,
    fecha_fin date,
    id_area integer,
    foreign key (id_area) references area(id)
)

create table clasificacion_persona (
    codigo varchar(10) primary key,
    nombre varchar(100),
    descripcion varchar(100)
)

create table tipo_identificacion (
    codigo varchar(10) primary key,
    nombre varchar(100),
    descripcion varchar(100)
)

create table persona (
    id serial primary key,
    nombre varchar(100),
    apellido varchar(100),
    identificacion varchar(60),
    tipo_identificacion varchar(10),
    fecha_nacimiento date,
    celular varchar(30),
    correo varchar(50),
    direccion varchar(100),
    estado varchar(20),
    fecha_vinculacion date,
    clasificacion varchar(10),
    id_oficina integer,
    foreign key (id_oficina) references oficina(id),
    foreign key (clasificacion) references clasificacion_persona(codigo),
    foreign key (tipo_identificacion) references tipo_identificacion(codigo)
)

create table salon_clase (
    id serial primary key,
    bloque varchar(10),
    numero_salon varchar(10),
    capacidad integer,
    grado varchar(10),
    estado varchar(10)
)

create table tipo_profesor (
    codigo varchar(10) primary key,
    nombre varchar(100),
    descripcion varchar(100)
)

create table profesor (
    id serial primary key,
    id_persona integer,
    id_salon_clase integer,
    tipo_profesor varchar(10),
    foreign key (id_persona) references persona(id),
    foreign key (id_salon_clase) references salon_clase(id),
    foreign key (tipo_profesor) references tipo_profesor(codigo)
)
