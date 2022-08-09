import { useRef } from 'react';
import React from 'react'
import './Header.css'
import logo from "./logo.jpg"
import {FaBars, FaTimes} from "react-icons/fa"
import { Link, useLocation } from 'react-router-dom';


const Header = () => {

  const navRef = useRef()
  const {pathname} = useLocation();

  const mostrarNavBar = () => {
    navRef.current.classList.toggle("responsive-header")
  }

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
  return (
    <header className="header">
      <Link to="/"><img className="header-logo" src={logo} alt="logo" /></Link>
      <nav ref={navRef} className="header-derecha">
        {/* <Link to="/registro"><button className="header-derecha-boton cuenta" onClick={mostrarBotones}>Crear cuenta</button></Link>
        <Link to="/login"><button className="header-derecha-boton sesion">Iniciar Sesión</button></Link> */}
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