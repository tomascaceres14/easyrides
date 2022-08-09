
import "./Registro.css";
import React from 'react';
import { Formik } from "formik";

function Registro() {

	return (
		<React.Fragment>
			<Formik

				initialValues={{
					nombre: "",
					apellido: "",
					correo: "",
					contraseña: "",
					contraseña2: ""
				}}

				validate={(valores) => {
					let errores = {};

					//validacion nombre
					if (!valores.nombre) {
						errores.nombre = 'Por favor ingrese su nombre'
					} else if (!/^[a-zA-ZÀ-ÿ\s]{1,40}$/.test(valores.nombre)) {
						errores.nombre = 'El nombre solo puede contener letras y espacios, pueden llevar acentos.'
					}

					//validacion apellido
					if (!valores.apellido) {
						errores.apellido = 'Por favor ingrese su apellido'
					} else if (!/^[a-zA-ZÀ-ÿ\s]{1,40}$/.test(valores.nombre)) {
						errores.apellido = 'El apellido solo puede contener letras y espacios, pueden llevar acentos.'
					}

					//validacion correo
					if (!valores.correo) {
						errores.correo = 'Por favor ingresa un correo electronico'
					} else if (!/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/.test(valores.correo)) {
						errores.correo = 'El correo solo puede contener letras, numeros, puntos, guiones y guion bajo.'
					}

					//validacion contraseña
					if (!valores.contraseña) {
						errores.contraseña = "Por favor ingresa tu contraseña";
					} else if (!/^.{4,12}$/.test(valores.contraseña)) {
						errores.contraseña = "Por favor ingrese una contraseña de 4 a 12 digitos";

					}

					//validacion contraseña2
					if (!valores.contraseña2) {
						errores.contraseña2 = "Por favor ingresa tu contraseña";
					} else if (!/^.{4,12}$/.test(valores.contraseña2)) {
						errores.contraseña2 = "Ambas contraseñas deben ser iguales";

					}
				

					return errores;
				}}

			onSubmit={() => {
				console.log("Datos ingresados")
			}}
			>

			{({ values, errors, touched, handleSubmit, handleChange, handleBlur}) => (
				<form className="form" onSubmit={handleSubmit}>
					<h1 className="form-titulo">Crear cuenta</h1>

					<div className="seccion1">
						<div className="form-nombre">
							<label htmlFor="nombre">Nombre</label>
							<input
								type="text"
								name="nombre"
								placeholder=""
								id="nombre"
								value={values.nombre}
								onChange={handleChange}
								onBlur={handleBlur}
							/>
							{touched.nombre && errors.nombre && <div className="error">{errors.nombre}</div>}
						</div>

						<div className="form-apellido">
							<label htmlFor="apellido">Apellido</label>
							<input
								type="text"
								name="apellido"
								placeholder=""
								id="apellido"
								value={values.apellido}
								onChange={handleChange}
								onBlur={handleBlur}
							/>
							{touched.apellido && errors.apellido && <div className="error">{errors.apellido}</div>}

						</div>
					</div>
					<div className="seccion2">

						<div className="form-correo">
							<label htmlFor="correo electrónico">Correo electrónico</label>
							<input
								type="email"
								name="correo"
								placeholder="Ej: correo@correo.com"
								id="correo"
								value={values.correo}
								onChange={handleChange}
								onBlur={handleBlur}
							/>
							{touched.correo && errors.correo && <div className="error">{errors.correo}</div>}
						</div>

						<div className="form-contraseña">
							<label htmlFor="contraseña">Contraseña</label>
							<input
								type="password"
								name="contraseña"
								placeholder=""
								id="contraseña"
								value={values.contraseña}
								onChange={handleChange}
								onBlur={handleBlur}
							/>
							{touched.contraseña && errors.contraseña && <div className="error">{errors.contraseña}</div>}
						</div>
						<div className="form-contraseña">
							<label htmlFor="contraseña2">Confirmar contraseña</label>
							<input
								type="password"
								name="contraseña2"
								placeholder=""
								id="contraseña2"
								value={values.contraseña2}
								onChange={handleChange}
								onBlur={handleBlur}
								
							/>
							{touched.contraseña.campo !== contraseña2.campo && errors.contraseña2 && <div className="error">{errors.contraseña2}</div>}
						</div>
					</div>

					<div className="Buttom">
						<button type="submit">Crear cuenta</button>
						<p> ¿Ya tienes cuenta? <a href="../Login/Login.jsx" target="_self">Iniciar sesión</a></p>
					</div>
				</form>
			)}
		</Formik>
		</React.Fragment >
	);
}

export default Registro;