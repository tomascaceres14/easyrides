import { useRef, useContext } from "react";
import React from "react";
import "./Header.css";
import logoeasyrides from "./logoeasyrides.jfif";
import { FaBars, FaTimes} from "react-icons/fa";
import { Link } from "react-router-dom";
import { useInitialState } from "../../../Hooks/useInitialState";
import AuthContext from "../../../Context/AuthContext";
import { BotonesLoginRegister } from "./BotonesLoginRegister";
import { Avatar } from "./Avatar";

const Header = (user) => {
  const navRef = useRef();
  const initialState = useInitialState();

  const { auth } = useContext(AuthContext);

  const mostrarNavBar = () => {
    navRef.current.classList.toggle("responsive-header");
  };
  // const parsearUsuario = JSON.parse(localStorage.getItem("user"));
  // const nombreUsuario = parsearUsuario.nombre

  return (
    <header className="header">
      <Link to="/">
        <img className="header-logo" src={logoeasyrides} alt="logo" />
      </Link>
      <nav ref={navRef} className="header-derecha">
        {/*mostrar avatar en un solo compontente */}
        {auth ? <Avatar/>  : <BotonesLoginRegister/>}

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
};

export default Header;
