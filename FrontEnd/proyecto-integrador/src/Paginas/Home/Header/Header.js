import { useRef } from 'react';
import React from 'react'
import './Header.css'
import Button from "@mui/material/Button";
import logo from "./logo.jpg"
import {FaBars, FaTimes} from "react-icons/fa"


const Header = () => {

  const navRef = useRef()

  const mostrarNavBar = () => {
    navRef.current.classList.toggle("responsive-header")
  }
  return (
    <header className="header">
      <img className="header-logo" src={logo} alt="logo" />
      <nav ref={navRef} className="header-derecha">
        <Button sx={{ mr: 2 }} variant="outlined">Crear cuenta</Button>
        <Button variant="contained">Iniciar Sesión</Button>


        <button className='header-boton header-cerrar-boton' onClick={mostrarNavBar}>
          <FaTimes />
        </button>
      </nav>
      <button className='header-boton' onClick={mostrarNavBar}>
        <FaBars />
      </button>
    </header>
  );
}

export default Header