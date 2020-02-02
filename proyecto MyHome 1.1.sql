drop database if exists MyHomeMaRiPo;
Create database MyHomeMaRiPo;
use MyHomeMaRiPo;

create table Usuario(
	cedula int primary key,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	telefono int not null,
	correoElectronico varchar(50) not null,
	direccionAdomicilio varchar(100) not null,
	estadoCivil varchar(20) not null,
	rol varchar(20) not null
);

create table login(
	usuario varchar(50) primary key,
	contraseña varchar(50) not null,
	cedula int not null,
	foreign key (cedula) references Usuario (cedula)
);

create table Cliente(
	idCliente varchar(10) primary key,
	telefono int not null,
	numHijos int not null
);

create table tipoCasa(
	idTipoCasa varchar(20) primary key,
	numHabitacion int not null,
	nombreCasa varchar(30) not null
);

create table casa(
	idCasa varchar(20) primary key,
	metrosCuadrados float not null,
	nroPlantas int not null,
	esEsquinera boolean not null,
	precio float not null,
	orientacion varchar(40) not null,
	tamañoPatio float not null,
	costoBase float not null,
	idTipoCasa varchar(20),
	idCliente varchar (10),
	foreign key (idTipoCasa) references tipoCasa (idTipoCasa),
	foreign key (idCliente) references Cliente (idCliente)
);

create table elementosCasa(
	idElemento varchar(20) primary key,
	precio float not null,
	nombre varchar(30) not null,
	idCasa varchar(20),
	foreign key (idCasa) references casa (idCasa)
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
	in spidCliente varchar(50), in sptelefono int, in spnumHijos int
)
begin
	insert into cliente (idCliente,telefono,numHijos)
	values (spidCliente,sptelefono,spnumHijos);
end $$

create procedure crearCasa(
	in spidCasa varchar(20), in spmetrosCuadrados float, in spnroPlantas int,
	in spesEsquinera boolean, in spprecio float, in sporientacion varchar(40),
	in sptamañoPatio float, in spcostoBase float , spidTipoCasa varchar(20),
	spidCliente varchar(10)
)
begin
	insert into Casa(idCasa,metrosCuadrados, nroPlantas,esEsquinera,precio,orientacion,tamañoPatio,costoBase,idTipoCasa,idCliente)
	values (spidCasa,spmetrosCuadrados,spnroPlantas,spesEsquinera,spprecio,sporientacion,
	sptamañoPatio,spcostoBase,spidTipoCasa,spidCliente);
end $$




create procedure crearTipoCasa(
	in spidTipoCasa varchar(20), in spnumHabitacion int, in spnombreCasa varchar(30)
)
begin
	insert into tipoCasa (idTipoCasa,numHabitacion,nombreCasa)
	values (spidTipoCasa,spnumHabitacion,spnombreCasa);
end $$

create procedure crearElementosCasa(
	in spidElemento varchar(20), in spprecio float, in spnombre varchar(30), 
	spidCasa varchar(20)
)
begin
	insert into elementosCasa (idelemento,precio,nombre,idcasa)
	values (spidElemento,spprecio,spnombre,spidCasa);
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

create procedure eliminartipocasa( in spidtipocasa varchar(20))
begin 
	delete FROM tipocasa where idtipocasa = spidtipocasa;
end $$

create procedure eliminarelementoscasa( in spidelemento varchar(20))
begin 
	delete FROM elementoscasa where idelementocasa = spidelemento;
end $$


-- procedures para buscar de acuerdo al pk de la entidad
create procedure buscarUsuario(in spcedula int)
begin 
	select * from usuario where cedula=  spcedula;
end $$

create procedure buscarlogin( in spusuario varchar(50), in spuContrasena varchar(50) )
begin 
    # SET @cedulaVar = "";
	DECLARE cedulaVar varchar(50) DEFAULT "";
    
    select lg.cedula 
    into cedulaVar
    from login lg
    where lg.usuario = spusuario and  lg.contraseña = spuContrasena;
    
	select * from usuario us where us.cedula = cedulaVar;
end $$

create procedure buscarCliente( in spidcliente varchar(10))
begin 
	select * from  cliente where idcliente = spidcliente;
end $$

create procedure buscarCasa( in spidcasa varchar(20))
begin 
	select * from casa where idcasa = spidcasa;
end $$

create procedure buscartipocasa( in spidtipocasa varchar(20))
begin 
	select * from tipocasa where idtipocasa = spidtipocasa;
end $$

create procedure buscarelementoscasa( in spidelemento varchar(20))
begin 
	select * from elementoscasa where idelementocasa = spidelemento;
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

create procedure actualizarTipoCasa(in spidtipocasa varchar(20),in spnumhabitacion int, spnombrecasa varchar(30) 
)
begin 
update tipocasa
	set numhabitacion = spnumhabitacion, nombrecasa=spnombrecasa
	where idtipocasa=spidtipocasa;
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
	in spesesquinera boolean,in spprecio float,in sporientacion varchar(40),
	in sptamañopatio float,
	in spcostobase float)
begin 
	update casa
	set metrosCuadrados= spmetros, nroPlantas=spnroPlantas,esEsquinera = spesesquinera,
	precio=spprecio, orientacion= sporientacion,tamañoPatio= sptamañoPatio
	, costoBase= spcostobase
	 where idcasa=spidcasa;
end $$
delimiter $$;


 
-- insertando datos
-- usuario 

call crearUsuario(929786366,'Christian','Portilla',0929785214,'poplays26@gmail.com','Via samborondon cdla las riberas','soltero','vendedor');
call crearUsuario(1701514785,'Genesis','Riera',0991224574,'genesisrie_24@gmail.com','la alborada etapa 11va','soltero','cliente');
call crearUsuario(914447852,'Bryan','Manzano',0981234561,'bmanzano@hotmail.com','los ceibos frente a olivos tower','soltero','administrador');
call crearUsuario(920142356,'William','Briones',0914523654,'wilfrio@gmail.com','la troncal calle principal mz y1 villa 3','soltero','vendedor');
call crearUsuario(954552102,'Alexia','Texas',0914231520,'alexiatex@gmail.com','isla mocoli cdla el paraiso','soltero','vendedor');

-- login 
call crearLogin('cp','cp',929786366);
call crearLogin('gr','gr',1701514785);
call crearLogin('bm','bm',914447852);
call crearLogin('Wilfrio','Ginpa152',920142356);
call crearLogin('AleTex','Alexizz123',954552102);

-- tipo casa
call crearTipoCasa('CAS001','2','Oasis');
call crearTipoCasa('CAS002','3','Paraiso');
call crearTipoCasa('CAS003','4','Cielo');




-- cliente
call crearcliente('CUS001',929785214,2);
call crearcliente('CUS002',991224574,1);
call crearcliente('CUS003',981234561,0);



-- casa
call crearCasa('CASNT001','250',2,true,100000,'centro',25,25000,'CAS002','CUS001');
call crearCasa('CASNT002','500',6,false,550000,'norte',50,150000,'CAS003','CUS002');
call crearCasa('CASNT003','100',1,false,57000,'sur',8,10000,'CAS001','CUS003');

-- elementosCasa
call crearelementoscasa('ELE001',350,'Cuadro','CASNT001');
call crearelementoscasa('ELE002',1500,'Mesa Billar','CASNT002');
call crearelementoscasa('ELE003',700,'Cama','CASNT003');
call crearelementoscasa('ELE004',3000,'Maquina de pesas','CASNT002');
call crearelementoscasa('ELE005',854.55,'Equipo de sonido','CASNT003');

































































