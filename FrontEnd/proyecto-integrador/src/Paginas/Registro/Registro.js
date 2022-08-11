
import "./Registro.css";
import React,{useContext} from 'react';
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useNavigate } from "react-router-dom";
import AppContext from "../../Context/AppContext";
import { useInitialState } from "../../Hooks/useInitialState";


function Registro() {
  const {setValores} = useContext(AppContext)
	const navigate = useNavigate();
  

	//validacion contraseña
	const validarContraseña = values => {
		let error = "";
		const regexContraseña = /(?=.*[0-9])/;
		if (!values) {
			error = "Campo requerido";
		} else if (values.length < 8) {
			error = "La contraseña debe tener 8 caracteres.";
		} else if (!regexContraseña.test(values)) {
			error = "Contraseña invalida. Debe contener un número.";
		}
		return error;
	};

	//validacion confirmar contraseña
	const validateConfirmarContraseña = (pass, value) => {
		let error = "";
		if (pass && value) {
			if (pass !== value) {
				error = "Las contraseñas no coinciden";
			}
		}
		return error;
	};

	return (
    <React.Fragment>
      <Formik
        initialValues={{
          nombre: "",
          apellido: "",
          correo: "",
          contraseña: "",
          confirmarContraseña: "",
        }}
        onSubmit={(values) => {
          navigate("/login");
		      setValores(values)
          console.log(values);
        }}
        validate={(valores) => {
          let errores = {};

          //validacion nombre
          if (!valores.nombre) {
            errores.nombre = "Por favor ingrese su nombre";
          } else if (!/^[a-zA-ZÀ-ÿ\s]{1,40}$/.test(valores.nombre)) {
            errores.nombre =
              "El nombre solo puede contener letras y espacios, pueden llevar acentos.";
          }

          //validacion apellido
          if (!valores.apellido) {
            errores.apellido = "Por favor ingrese su apellido";
          } else if (!/^[a-zA-ZÀ-ÿ\s]{1,40}$/.test(valores.nombre)) {
            errores.apellido =
              "El apellido solo puede contener letras y espacios, pueden llevar acentos.";
          }

          //validacion correo
          if (!valores.correo) {
            errores.correo = "Por favor ingresa un correo electronico";
          } else if (
            !/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/.test(
              valores.correo
            )
          ) {
            errores.correo =
              "El correo solo puede contener letras, numeros, puntos, guiones y guion bajo.";
          }
          return errores;
        }}
      >
        {({ errors, values }) => (
          <Form className="form">
            <h1 className="form-titulo">Crear cuenta</h1>

            <div className="seccion1">
              <div className="form-nombre">
                <label htmlFor="nombre">Nombre</label>
                <Field type="text" name="nombre" placeholder="" id="nombre" />
                <ErrorMessage
                  name="nombre"
                  component={() => <div className="error">{errors.nombre}</div>}
                />
              </div>

              <div className="form-apellido">
                <label htmlFor="apellido">Apellido</label>
                <Field
                  type="text"
                  name="apellido"
                  placeholder=""
                  id="apellido"
                />
                <ErrorMessage
                  name="apellido"
                  component={() => (
                    <div className="error">{errors.apellido}</div>
                  )}
                />
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
                <ErrorMessage
                  name="correo"
                  component={() => <div className="error">{errors.correo}</div>}
                />

                <div className="form-contraseña">
                  <label htmlFor="contraseña">Contraseña</label>
                  <Field
                    type="password"
                    name="contraseña"
                    validate={validarContraseña}
                  />
                </div>

                <ErrorMessage
                  name="contraseña"
                  component={() => (
                    <div className="error">{errors.contraseña}</div>
                  )}
                />

                <div className="form-contraseña">
                  <label htmlFor="contraseña2">Confirmar contraseña</label>
                  <Field
                    type="password"
                    name="confirmarContraseña"
                    validate={(value) =>
                      validateConfirmarContraseña(values.contraseña, value)
                    }
                  />
                  <ErrorMessage
                    name="confirmarContraseña"
                    component={() => (
                      <div className="error">{errors.confirmarContraseña}</div>
                    )}
                  />
                </div>
              </div>
            </div>

            <div className="Buttom">
              <button type="submit">Crear cuenta</button>
              <p>
                {" "}
                ¿Ya tienes cuenta?{" "}
                <a href="/login" target="_self">
                  Iniciar sesión
                </a>
              </p>
            </div>
          </Form>
        )}
      </Formik>
    </React.Fragment>
  );
}

export default Registro;