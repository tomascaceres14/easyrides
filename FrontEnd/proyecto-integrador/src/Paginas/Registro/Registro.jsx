
import "./Registro.css";
import React from 'react';

function Registro() {

	return (
		<React.Fragment>
			<form className="form">
				<h1 className="form-titulo">Crear cuenta</h1>

				<div className="seccion1">
					<div className="form-nombre">
						<label htmlFor="nombre">Nombre</label>
						<input type="text" name="nombre" placeholder="" />
					</div>

					<div className="form-apellido">
						<label htmlFor="apellido">Apellido</label>
						<input type="text" name="nombre" placeholder="" />
					</div>
				</div>
				<div className="seccion2">

					<div className="form-correo">
						<label htmlFor="correo electrónico">Correo electrónico</label>
						<input type="text" name="nombre" placeholder="Ej: correo@correo.com" />
					</div>

					<div className="form-contraseña">
						<label htmlFor="contraseña">Contraseña</label>
						<input type="text" name="nombre" placeholder="" />
					</div>
					<div className="form-contraseña">
						<label htmlFor="contraseña">Confirmar contraseña</label>
						<input type="text" name="nombre" placeholder="" />
					</div>
				</div>

				<div className="Buttom">
					<button type="submit">Crear cuenta</button>
					<p> ¿Ya tienes cuenta? <a href="../Login/Login.jsx" target="_self">Iniciar sesión</a></p>
				</div>



			</form>
		</React.Fragment>
	);
}

export default Registro;