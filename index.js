const express = require("express");
const app = express();

app.get('/', function (req, res) {
  res.send('Saludos proyecto de mario');
});

app.listen(3000, () => {
 console.log("El servidor está inicializado en el puerto 3000");
});


app.post('/NutriNET/Cliente',function(req, res) {
	let cliente = {
		Nombre:"Juan",
		Apellidos: "Perez Hernandez",
		Nombre_Usuario: "Ju",
		Correo_Electronico: "jperez@hotmail.com",
		Contraseña: "juanitoperez"
		};
	let id = Math.floor(Math.random()*200);
	res.send({id, cliente});
	});

app.get('/NutriNET/Cliente',function(req, res) {
	let cliente = {
		Nombre: "Juan",
		Apellidos: "Perez Hernandez",
		Nombre_Usuario: "Ju",
		Correo_Electronico: "jperez@hotmail.com",
		Contrasena: "juanitoperez"
	};
	return res.send({ cliente });
});

app.put('/NutriNET/Cliente/:id/:Edad/:Estatura/:Peso/:GEB',function(req, res) {
	let Cliente={
		Edad: 39,
		Estatura: 1.80,
		Peso: 60,
		GEB: 1500,
		};
	const Datosanteriores = Cliente;
	let {Edad,Estatura,Peso,GEB, id} =  req.params;
	if  (id !== '59'){ res.send({Cve_Mensaje : "Usuario incorrecto"});};
	console.log(req.params);
	let Datos = {
		Edad: parseInt(req.params.Edad),
		Estatura: parseInt(req.params.Estatura),
		Peso: parseInt(req.params.Peso),
		GEB: parseInt(req.params.GEB),
		};
	return res.send({id,Datosanteriores, Datos});
});
	
	
