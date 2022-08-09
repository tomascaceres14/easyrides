import React from 'react';
import "../css/Login.css";
import { Formik, Form, Field, ErrorMessage} from "formik";
import { useNavigate } from "react-router-dom";
import { Link } from 'react-router-dom';


function Login() {
    
    const navigate = useNavigate();

    return (
      <Formik
        initialValues={{
          correo: "",
          contraseña: "",
        }}
        onSubmit={() => {
            navigate("/");
        }}
        validate={(valores) => {
          let errores = {};

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

          //validacion contraseña
          if (!valores.contraseña) {
            errores.contraseña = "Por favor ingresa tu contraseña";
          } else if (!/^.{4,12}$/.test(valores.contraseña)) {
            errores.contraseña =
              "Por favor ingrese una contraseña de 4 a 12 digitos";
          }

          return errores;
        }}
      >
        {({ errors }) => (
          <div className="contenedor">
            <Form className="formulario">
              <h1 className="Titulo-Login">Iniciar sesión</h1>

              <div>
                <label htmlFor="correo">Correo electrónico</label>
                <Field
                  type="email"
                  name="correo"
                  placeholder="Ej: micorreo@gmail.com"
                  id="correo"
                />
                <ErrorMessage
                  name="correo"
                  component={() => <div className="error">{errors.correo}</div>}
                />
              </div>

              <div>
                <label htmlFor="contraseña">Contraseña</label>
                <Field
                  type="password"
                  name="contraseña"
                  placeholder="Ingrese su contraseña"
                  id="contraseña"
                />
                <ErrorMessage
                  name="contraseña"
                  component={() => (
                    <div className="error">{errors.contraseña}</div>
                  )}
                />
              </div>

              <div className="Buttom">
                <button type="submit">Ingresar</button>
                <p>
                  {" "}
                  ¿Aún no tienes cuenta?{" "}
                  <a href="/registro" target="_self">
                    Registrate
                  </a>
                </p>
              </div>
            </Form>
          </div>
        )}
      </Formik>
    );
}

export { Login };