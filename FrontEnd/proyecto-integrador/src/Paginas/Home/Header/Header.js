import React from 'react'
import './Header.css'
import Button from "@mui/material/Button";
import logo from "./logo.jpg"


const Header = () => {
  return (
    <div className="header">
      <div className="header-izquierda">
        <img className="header-logo" src={logo} alt="logo" />
      </div>
      <div className="header-derecha">
        <Button sx={{ mr: 2 }} variant="outlined">Crear cuenta</Button>
        <Button variant="contained">Iniciar Sesión</Button>
      </div>
    </div>
  );
}

export default Header