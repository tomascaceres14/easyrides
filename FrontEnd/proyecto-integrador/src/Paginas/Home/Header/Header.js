import { useRef, useContext } from 'react';
import React from 'react'
import './Header.css'
import logo from "./logo.jpg"
import logoeasyrides from "./logoeasyrides.jfif";
import {FaBars, FaTimes} from "react-icons/fa"
import { Link, useLocation } from 'react-router-dom';
import AppContext from '../../../Context/AppContext';
import { useInitialState } from '../../../Hooks/useInitialState';


const Header = () => {

  const navRef = useRef()
  const {pathname} = useLocation();
  // const [state, setState] = useInitialState()

  const mostrarNavBar = () => {
    navRef.current.classList.toggle("responsive-header")
  }
  // const parsearUsuario = JSON.parse(localStorage.getItem("user"));
  // const nombreUsuario = parsearUsuario.nombre


  const mostrarBotones = () => {
    if(pathname === '/registro') {
      return (
        <>
          <Link to="/login">
            <button className="header-derecha-boton sesion">
              Iniciar Sesión
            </button>
          </Link>
        </>
      );
    }
    if (pathname === "/login") {
      return (
        <>
          <Link to="/registro">
            <button
              className="header-derecha-boton cuenta"
              onClick={mostrarBotones}
            >
              Crear cuenta
            </button>
          </Link>
        </>
      );
    }
    if (pathname === "/") {
      return (
        <>
          <Link to="/login">
            <button className="header-derecha-boton sesion">
              Iniciar Sesión
            </button>
          </Link>
          <Link to="/registro">
            <button className="header-derecha-boton cuenta">
              Crear Cuenta
            </button>
          </Link>
        </>
      );
    }
    
  
  }
  // const mostrarAvatar = () => {
  // if(setValores !== undefined){
  //       return (
  //         <>
  //         {<p>{setValores.nombre}</p>}
  //         </>
  //         )
  //   } else if (setValores === undefined){
  //     mostrarBotones()
  //   }
  // } 

  return (
    <header className="header">
      <Link to="/">
        <img className="header-logo" src={logoeasyrides} alt="logo" />
      </Link>
      <nav ref={navRef} className="header-derecha">
        {/* <p>{state.userRegister.nombre}</p> */}
        {mostrarBotones()}
        {/* botones para mobile */}
        <button
          className="header-boton header-cerrar-boton"
          onClick={mostrarNavBar}
        >
          <FaTimes />
        </button>
      </nav>
      <button className="header-boton" onClick={mostrarNavBar}>
        <FaBars />
      </button>
    </header>
  );
}

export default Header