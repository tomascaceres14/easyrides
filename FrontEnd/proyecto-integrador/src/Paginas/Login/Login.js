import React, { useContext } from "react";
import "./Login.css";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
import AppContext from "../../Context/AppContext";
import AuthContext from "../../Context/AuthContext";

function Login() {
  const navigate = useNavigate();

  const { state } = useContext(AppContext);
  const { setAuth } = useContext(AuthContext);

  return (
    <Formik
      initialValues={{
        correo: "",
        contraseña: "",
      }}
      onSubmit={(values, onSubmitProps) => {
        // Comparar con mi base de datos de usuarios registrado
        const foundUser = state.userRegister.find(
          (user) =>
            user.correo === values.correo &&
            user.contraseña === values.contraseña
        );
        if (foundUser) {
          setAuth(foundUser);
          localStorage.setItem("user", JSON.stringify(foundUser));
          navigate("/");
        } else {
          // si no existe el usuario, mostrar error
        }
        //VER ESTO PARA RESETEAR FORM
        onSubmitProps.resetForm();
        console.log(values);
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
        } else if (!/^.{8,8}$/.test(valores.contraseña)) {
          errores.contraseña =
            "Por favor ingrese una contraseña de 8 caracteres";
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
