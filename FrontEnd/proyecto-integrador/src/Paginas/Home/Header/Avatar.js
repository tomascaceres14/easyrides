import React,{useContext} from 'react'
import "./Avatar.css";
import AuthContext from "../../../Context/AuthContext";

export const Avatar = () => {
  const { auth } = useContext(AuthContext);
  return (
    <div className='avatar'>
      <p className='avatar-nombre'>Bienvenido {auth.nombre}</p>
      <button className='avatar-sesion' onClick={ () => {localStorage.clear()}}>Cerrar Sesion</button>
    </div>
  );
}
