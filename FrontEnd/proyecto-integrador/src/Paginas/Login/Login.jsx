import React from 'react';
import "../styles-modules/Login.css";
import { Formik } from "formik";


function Login() {


    return (
        <React.Fragment>
            <Formik
                initialValues={{
                    correo: "",
                    contraseña: ""

                }}

                validate={(valores) => {
                    let errores = {};

                    if (!valores.correo) {
                        errores.correo = "Por favor ingresa tu correo";
                    } else if(!/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/.test(valores.correo)){

                    }
                    
                }}

                onSubmit={() => {
                    console.log("Datos ingresados")
                }}
            >
                {({ values,errors, handleSubmit, handleChange, handleBlur }) => (
                    <div className="contenedor">
                        <form className="formulario" onSubmit={handleSubmit}>



                            <h1 className="Titulo-Login">Iniciar sesión</h1>

                            <div>
                                <label htmlFor="correo">Correo electrónico</label>
                                <input
                                    type="email"
                                    name="correo"
                                    placeholder="Ej: micorreo@gmail.com"
                                    id="correo"
                                    value={values.correo}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {errors.correo && <div className="error">{errors.correo}</div>}
                            </div>

                            <div>
                                <label htmlFor="contraseña">
                                    Contraseña</label>
                                <input
                                    type="Password"
                                    name="contraseña"
                                    placeholder="Ingrese su contraseña"
                                    id="contraseña"
                                    value={values.contraseña}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                 {errors.contraseña && <div className="error">{errors.contraseña}</div>}
                            </div>

                            <div className="Buttom">
                                <button type="submit">Ingresar</button>
                                <p> ¿Aún no tienes cuenta? <a href="./Registrer.jsx" target="_self">Registrate</a></p>
                            </div>

                        </form>
                    </div>
                )}

            </Formik>
        </React.Fragment>
    )
}

export { Login };