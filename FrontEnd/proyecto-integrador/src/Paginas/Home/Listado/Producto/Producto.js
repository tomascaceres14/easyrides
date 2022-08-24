import React, { useState } from "react";
import "./Producto.css";
import { FaShare, FaCity } from "react-icons/fa";
import { MdOutlineArrowBackIos } from "react-icons/md";
import { AiFillHeart } from "react-icons/ai";
import { Link } from "react-router-dom";

const Producto = () => {
  const producto = useState(JSON.parse(localStorage.getItem("producto")));
  const prodExtracto = producto[0];

  return (
    <div>
      {console.log(prodExtracto)}
      <header>
        <div className="header-producto">
          <div>
            {/* <h4>{prodExtracto.categoria.titulo}</h4> */}
            <h2>{prodExtracto.titulo}</h2>
          </div>
          <Link to="/">
            <button className="boton-volver">
              <MdOutlineArrowBackIos size={"30"}/>
              <strong>Volver al Inicio</strong>
            </button>
          </Link>
        </div>
        <div className="ubicacion">
          <div className="localidad">
          <FaCity size={"23"} color={"#767070"}/>
            <p>
               
              {" "}{prodExtracto.ciudad.nombre}, {prodExtracto.ciudad.provincia},{" "}
              {prodExtracto.ciudad.pais}
            </p>
          </div>
          <div className="valoracion">
            <h4>Puntuación:</h4>
            <h2>10</h2>
          </div>
        </div>
      </header>
      <section>
        <div className="icons-prod">
          <button>
            <AiFillHeart size={"26"} />
          </button>
          <button>
            <FaShare size={"23"} />
          </button>
        </div>

        <div className="galeriaImg">
              <img src={prodExtracto.imagenes[0].url} className={"img1"}></img>
              <img src={prodExtracto.imagenes[1].url} className={"img2"}></img>
              <img src={prodExtracto.imagenes[2].url} className={"img3"}></img>
              <img src={prodExtracto.imagenes[3].url} className={"img4"}></img>
              <img src={prodExtracto.imagenes[4].url} className={"img5"}></img>
        </div>
        <article className="cuerpo">
          <h2>{prodExtracto.titulo}</h2>
          <p className="descripcion">{prodExtracto.descripcion}</p>
        </article>
        <article className="cuerpo">
          <h2>Que ofrece este producto?</h2>
          <ul className="caracteristicas">
            {prodExtracto&&prodExtracto.caracteristicas.map((carac) => (
              <li key={carac.id}>{carac.titulo}</li>
            ))}
          </ul>
        </article>
      </section>
    </div>
  );
};

export default Producto;
