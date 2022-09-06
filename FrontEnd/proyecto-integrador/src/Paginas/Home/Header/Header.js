import { useRef, useContext } from "react";
import React from "react";
import "./Header.css";
import easyride from "./easyride.png";
import { FaBars, FaTimes} from "react-icons/fa";
import { Link } from "react-router-dom";
import { useInitialState } from "../../../Hooks/useInitialState";
import AuthContext from "../../../Context/AuthContext";
import { BotonesLoginRegister } from "./BotonesLoginRegister";
import { Avatar } from "./Avatar";

const Header = () => {
const navRef = useRef();


const { auth } = useContext(AuthContext);

const mostrarNavBar = () => {
// navRef.style.display = "";
navRef.current.classList.toggle("responsive-header");
};
return (
<header className="header">
  <div className="header-logo">
    <Link to="/">
      <img className="header-logo-img" src={easyride} alt="logo" />
    </Link>
  </div>
  
  <nav ref={navRef} className="header-derecha">
    {/*mostrar avatar en un solo compontente */}
    {auth ?
    <Avatar /> :
    <BotonesLoginRegister />}

    {/* botones para mobile */}
    <button className="header-boton header-cerrar-boton" onClick={mostrarNavBar}>
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