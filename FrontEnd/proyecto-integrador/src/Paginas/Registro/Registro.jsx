
import "./Registro.css";
import React from 'react';
import { Formik, Form, Field, ErrorMessage } from "formik";

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

				{({errors}) => (
					<Form className="form">
						<h1 className="form-titulo">Crear cuenta</h1>

						<div className="seccion1">
							<div className="form-nombre">
								<label htmlFor="nombre">Nombre</label>
								<Field
									type="text"
									name="nombre"
									placeholder=""
									id="nombre"
								/>
								<ErrorMessage name="nombre" component={() => (
									<div className="error">{errors.nombre}</div>
								)} />
							</div>

							<div className="form-apellido">
								<label htmlFor="apellido">Apellido</label>
								<Field
									type="text"
									name="apellido"
									placeholder=""
									id="apellido"
								/>
								<ErrorMessage name="apellido" component={() => (
									<div className="error">{errors.apellido}</div>
								)} />
							</div>
						</div>

						<div className="seccion2">

							<div className="form-correo">
								<label htmlFor="correo electrónico">Correo electrónico</label>
								<Field
									type="email"
									name="correo"
									placeholder="Ej: correo@correo.com"
									id="correo"
								/>
								<ErrorMessage name="correo" component={() => (
									<div className="error">{errors.correo}</div>
								)} />

								<div className="form-contraseña">
									<label htmlFor="contraseña">Contraseña</label>
									<Field
										type="password"
										name="contraseña"
										placeholder=""
										id="contraseña"
									/>
									<ErrorMessage name="contraseña" component={() => (
										<div className="error">{errors.contraseña}</div>
									)} />

								</div>
								<div className="form-contraseña">
									<label htmlFor="contraseña2">Confirmar contraseña</label>
									<Field
										type="password"
										name="contraseña2"
										placeholder=""
										id="contraseña2"
									/>
									<ErrorMessage name="contraseña2" component={() => (
										<div className="error">{errors.contraseña2}</div>
									)} />
								</div>
							</div>
						</div>

						<div className="Buttom">
							<button type="submit">Crear cuenta</button>
							<p> ¿Ya tienes cuenta? <a href="../Login/Login.jsx" target="_self">Iniciar sesión</a></p>
						</div>
					</Form>
				)}
			</Formik>
		</React.Fragment >
	);
}

export default Registro;