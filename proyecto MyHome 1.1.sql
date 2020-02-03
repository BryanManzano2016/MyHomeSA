drop database if exists MyHomeMaRiPo;
Create database MyHomeMaRiPo;
use MyHomeMaRiPo;

CREATE TABLE Usuario (
    cedula INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono INT NOT NULL,
    correoElectronico VARCHAR(50) NOT NULL,
    direccionAdomicilio VARCHAR(100) NOT NULL,
    estadoCivil VARCHAR(20) NOT NULL,
    rol VARCHAR(20) NOT NULL
);

CREATE TABLE login (
    usuario VARCHAR(50) PRIMARY KEY,
    contraseña VARCHAR(50) NOT NULL,
    cedula INT NOT NULL,
    FOREIGN KEY (cedula)
        REFERENCES Usuario (cedula)
);

CREATE TABLE Cliente (
    idCliente VARCHAR(10) PRIMARY KEY,
    telefono INT NOT NULL,
    numHijos INT NOT NULL,
    cedula INT NOT NULL,
    FOREIGN KEY (cedula)
        REFERENCES Usuario (cedula)
);
 
CREATE TABLE casa (
    idCasa VARCHAR(20) PRIMARY KEY,
    metrosCuadrados FLOAT NOT NULL,
    nroPlantas INT NOT NULL,
    esEsquinera BOOLEAN NOT NULL,
    orientacion VARCHAR(40) NOT NULL,
    tamañoPatio FLOAT NOT NULL,
    costoBase FLOAT NOT NULL,
    numHabitacion INT NOT NULL,
    nombreCasa VARCHAR(50) NOT NULL
);

CREATE TABLE elementosCasa (
    idElemento VARCHAR(20) PRIMARY KEY,
    precio FLOAT NOT NULL,
    nombre VARCHAR(30) NOT NULL
);
 
CREATE TABLE casaRelacionUsuario (
    idRelacion INT AUTO_INCREMENT PRIMARY KEY,
    idCasa VARCHAR(20),
    cedula INT
);

CREATE TABLE casaRelacionElemento (
    idRelacion INT AUTO_INCREMENT PRIMARY KEY,
    idElemento VARCHAR(20),
    idCasaRelacionUsuario INT,
    FOREIGN KEY (idCasaRelacionUsuario)
        REFERENCES casaRelacionUsuario (idRelacion)
);
 
-- procedures para crear nuevo elementos...
delimiter $$
create procedure crearUsuario(
	in spcedula int, in spnombre varchar(50), in spapellido varchar(50),
	in sptelefono int, in spcorreo varchar(50), in spdireccion varchar(100),
	in spestadocivil varchar(20), in sprol varchar(20) 
)
begin
	insert into Usuario (cedula,nombre,apellido,telefono,correoElectronico,direccionAdomicilio,estadoCivil,rol)
	values (spcedula,spnombre,spapellido,sptelefono,spcorreo,spdireccion,spestadocivil,sprol);
end $$

create procedure crearLogin(
	in spusuario varchar(50), in spcontraseña varchar(50), in spcedula varchar(50)
)
begin
	insert into login (usuario,contraseña,cedula)
	values (spusuario,spcontraseña,spcedula);
end $$

create procedure crearCliente(
	in spidCliente varchar(50), in sptelefono int, in spnumHijos int,
    in spucedula varchar(50)
)
begin
	insert into cliente (idCliente,telefono,numHijos, cedula)
	values (spidCliente,sptelefono,spnumHijos, spucedula);
end $$


create procedure crearCasa(
	in spidCasa varchar(20), in spmetrosCuadrados float, in spnroPlantas int,
	in spesEsquinera boolean, in sporientacion varchar(40),
	in sptamañoPatio float, in spcostoBase float, in spuNumHabitacion int,
	in spuNombreCasa varchar(50)
)
begin
	insert into Casa(idCasa,metrosCuadrados, nroPlantas,esEsquinera,orientacion,tamañoPatio,
		costoBase ,numHabitacion, nombreCasa)
	values (spidCasa,spmetrosCuadrados,spnroPlantas,spesEsquinera,sporientacion,
	sptamañoPatio,spcostoBase,spuNumHabitacion,spuNombreCasa);
end $$

create procedure crearElementosCasa(
	in spidElemento varchar(20), in spprecio float, in spnombre varchar(30) 
)
begin
	insert into elementosCasa (idelemento,precio,nombre)
	values (spidElemento,spprecio,spnombre);
end $$

-- procedures para eliminar
create procedure eliminarUsuario( in spcedula int)
begin 
	delete FROM Usuario where cedula = spCedula;
end $$

create procedure eliminarlogin( in spusuario varchar(50))
begin 
	delete FROM login where usuario = spusuario;
end $$

create procedure eliminarCliente( in spidcliente varchar(10))
begin 
	delete FROM cliente where idcliente = spidcliente;
end $$

create procedure eliminarCasa( in spidcasa varchar(20))
begin 
	delete FROM casa where idcasa = spidcasa;
end $$

create procedure eliminarelementoscasa( in spidelemento varchar(20))
begin 
	delete FROM elementoscasa where idelementocasa = spidelemento;
end $$


-- procedures para buscar de acuerdo al pk de la entidad
create procedure buscarUsuario(in spcedula int)
begin 
	select * from usuario where cedula = spcedula;
end $$


create procedure buscarlogin( in spusuario varchar(50), in spuContrasena varchar(50) )
begin  
	DECLARE cedulaVar varchar(50) DEFAULT "";
     
    select lg.cedula 
    into cedulaVar
    from login lg
    where lg.usuario = spusuario and  lg.contraseña = spuContrasena;
    
	select * from usuario us where us.cedula = cedulaVar;
end $$

create procedure buscarClientes()
begin 
	select * from cliente cl, usuario us where cl.cedula = us.cedula;
end $$



/*
create procedure buscarCasa( in spidcasa varchar(20))
begin 
	select * from casa where idcasa = spidcasa;
end $$
*/
create procedure buscarCasaBasica()
begin 
	select idCasa, costoBase, nombreCasa from casa;
end $$

create procedure seleccionarCasaBasica(in cedula int, in idCasa varchar(20))
begin 
	insert into casaRelacionUsuario values
		(default, idCasa, cedula);
end $$

create procedure buscarelementoscasa()
begin 
	select * from elementoscasa;
end $$


-- procedures para actualizar datos poniendo como primer parametro el pk del campo que se desee
-- actualizar

create procedure actualizarUsuario(
	in spcedula int,in spnombre varchar(50),in spapellido varchar(50),
	in sptelefono int, in spcorreo varchar(50), in spdireccion varchar(100), in spestadocivil varchar(20),
	in sprol varchar(20))
begin 	
	update usuario
	set nombre= spnombre, apellido=spapellido,telefono = sptelefono,
	correoElectronico=spcorreo, direccionAdomicilio= spdireccion,estadocivil=spestadocivil, rol= sprol
	 where cedula=spcedula;
end $$

create procedure actualizarlogin(in spusuario varchar(50),in spcontraseña varchar(50)
)
begin 
	update login
	set contraseña = spcontraseña
	where usuario=spusuario;
end $$

create procedure actualizarcliente(in spidcliente varchar(10),in sptelofono int, spnumHijos int
)
begin 
	update cliente
	set telefono = sptelefono, numHijos=spnumHijos
	where idcliente=spidcliente;
end $$
 
create procedure actualizarelementoscasa(in spidelemento varchar(20),in spprecio float, spnombre varchar(30) 
)
begin 
	update elementoscasa
	set precio = spprecio, nombre=spnombre
	where idelementocasa=spidelemento;
end $$

create procedure actualizarCasa(in spidcasa varchar(20),in spmetros float,
	in spnroPlantas int,
	in spesesquinera boolean ,in sporientacion varchar(40),
	in sptamañopatio float,
	in spcostobase float,
    in spunumHabitacion int,
    in spunombreCasa varchar(50))
begin 
	update casa
	set metrosCuadrados= spmetros, nroPlantas=spnroPlantas,esEsquinera = spesesquinera,
    orientacion= sporientacion,tamañoPatio= sptamañoPatio, costoBase= spcostobase,
    numHabitacion = spunumHabitacion, nombreCasa = spunombreCasa
	where idcasa=spidcasa;
end $$
delimiter $$;
    
create procedure buscarCasaUsuario(in cedula int)
begin 
	select *
    from casa cs, casaRelacionUsuario cru
    where cs.idCasa = cru.idCasa and cru.cedula = cedula;    
end $$;

create procedure buscarCasaElementos( in idRelacion int)
begin 
	select ec.idElemento, ec.precio, ec.nombre
    from casarelacionelemento cre, casarelacionusuario cru, elementoscasa ec
    where cre.idCasaRelacionUsuario = cru.idRelacion and cre.idElemento = ec.idElemento
    and cru.idRelacion = idRelacion;   
end $$;


create procedure agregarElementoCasa( in idElemento varchar(20), in idRelacion int)
begin 
	insert into casarelacionelemento values(default, idElemento, idRelacion);
end $$;


  
call crearUsuario(929786366,'Christian','Portilla',0929785214,'poplays26@gmail.com','Via samborondon cdla las riberas','soltero','vendedor');
call crearUsuario(1701514785,'Genesis','Riera',0991224574,'genesisrie_24@gmail.com','la alborada etapa 11va','soltero','cliente');
call crearUsuario(914447852,'Bryan','Manzano',0981234561,'bmanzano@hotmail.com','los ceibos frente a olivos tower','soltero','administrador');
call crearUsuario(920142356,'William','Briones',0914523654,'wilfrio@gmail.com','la troncal calle principal mz y1 villa 3','soltero','cliente');
call crearUsuario(954552102,'Alexia','Texas',0914231520,'alexiatex@gmail.com','isla mocoli cdla el paraiso','soltero','cliente');

-- login 
call crearLogin('cp','cp',929786366);
call crearLogin('gr','gr',1701514785);
call crearLogin('bm','bm',914447852);
call crearLogin('Wilfrio','Ginpa152',920142356);
call crearLogin('AleTex','Alexizz123',954552102);


-- cliente
call crearcliente('CUS001',929785214,2, 920142356);
call crearcliente('CUS002',991224574,1, 954552102);
call crearcliente('CUS003',981234561,0, 1701514785);
 

-- casa
call crearCasa('CASNT001','250',2,true,'centro',25,25000,4,'Oasis');
call crearCasa('CASNT002','500',6,false,'norte',50,150000,3,'Paraiso');
call crearCasa('CASNT003','100',1,false,'sur',8,10000,2,'Cielo');
 
-- elementosCasa
call crearelementoscasa('ELE001',350,'Cuadro');
call crearelementoscasa('ELE002',1500,'Mesa Billar');
call crearelementoscasa('ELE003',700,'Cama');
call crearelementoscasa('ELE004',3000,'Maquina de pesas');
call crearelementoscasa('ELE005',854.55,'Equipo de sonido');  
   
insert into casaRelacionUsuario values
	(default, 'CASNT001', 1701514785),
    (default, 'CASNT002', 954552102),
    (default, 'CASNT003', 1701514785),
    (default, 'CASNT002', 1701514785),
    (default, 'CASNT001', 954552102),
    (default, 'CASNT002', 920142356);

insert into casaRelacionElemento values
	(default , 'ELE001', 1),
    (default , 'ELE002', 2),
    (default , 'ELE003', 1),
    (default , 'ELE004', 4),
    (default , 'ELE005', 5),
    (default , 'ELE001', 5),
    (default , 'ELE002', 4),
    (default , 'ELE003', 3),
    (default , 'ELE004', 2),
    (default , 'ELE005', 1),
    (default , 'ELE001', 3);
 