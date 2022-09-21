import React, { useContext, useState } from "react";
import "./Login.css";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
import AppContext from "../../Context/AppContext";
import AuthContext from "../../Context/AuthContext";
import { TokenUsuarioContext } from "../../Context/TokenUsuarioContext";
import axios from "axios";
//creo un estado y guardo response en el post despues saco el token 
// y lo guardo en un estado global 


function Login() {

  const navigate = useNavigate();
  const [cerrarLogin, setCerrarLogin] = useState(false);
  const { auth, setAuth } = useContext(AuthContext);
  const { tokenUsuario, setTokenUsuario } = useContext( TokenUsuarioContext );
  const urlLogin =
    "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/auth/login";

  
    const getUsuario = (objetoUsuario) => {
    axios({
      method: "post",
      url: urlLogin,
      data: objetoUsuario,
      headers: { "Content-Type": "application/json" },
    })
      .then(function (response) {
        //handle success
        setAuth(response.data)
        setTokenUsuario(response.data.token)
        console.log(tokenUsuario);
        localStorage.setItem('sesiontoken', response.data.token)
        setCerrarLogin(true)
        navigate("/");
      })
      .catch(function (response) {
        navigate("/login");
        setAuth(null);
        setTokenUsuario(null);
        localStorage.removeItem('sesiontoken')
        alert("Usuario o contraseña incorrectos");        
        
        //handle error
        
        
      });
  }
  


  return (
    <Formik
      initialValues={{
        email: "",
        password: "",
      }}
      
      onSubmit={(values, onSubmitProps) => {
        
        // console.log(values)
        // Comparar con mi base de datos de usuarios registrado
        getUsuario(values)
        
        //VER ESTO PARA RESETEAR FORM
        onSubmitProps.resetForm();
      }}

      validate={(valores) => {
        let errores = {};

        //validacion correo
        if (!valores.email) {
          errores.email = "Por favor ingresa un correo electronico";
        } else if (
          !/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/.test(
            valores.email
          )
        ) {
          errores.email =
            "El correo solo puede contener letras, numeros, puntos, guiones y guion bajo.";
        }

        //validacion contraseña
        if (!valores.password) {
          errores.password = "Por favor ingresa tu contraseña";
        } else if (!/^.{4,12}$/.test(valores.password)) {
          errores.password = "Por favor ingrese una contraseña de 4 a 12 caracteres";
        }
        return errores;

        // crear validacion logeo

        


        
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
                name="email"
                placeholder="Ej: micorreo@gmail.com"
                id="email"
              />
              <ErrorMessage
                name="email"
                component={() => <div className="error">{errors.email}</div>}
              />
            </div>

            <div>
              <label htmlFor="contraseña">Contraseña</label>
              <Field
                type="password"
                name="password"
                placeholder="Ingrese su contraseña"
                id="password"
              />
              <ErrorMessage
                name="password"
                component={() => <div className="error">{errors.password}</div>}
              />
            </div>

            <div className="Buttom">
              <button type="submit">Ingresar</button>
              <p>
                {" "}
                ¿Aún no tienes cuenta? <Link to="/registro">Registrate</Link>
              </p>
            </div>
          </Form>
        </div>
      )}
    </Formik>
  );
}

export { Login };
