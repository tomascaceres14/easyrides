import React, { useState } from "react";
import "./Producto.css";
import { FaShare } from "react-icons/fa";
import { MdOutlineArrowBackIos } from "react-icons/md";
import { AiOutlineHeart } from "react-icons/ai";
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
            <h4>{prodExtracto.categoria.titulo}</h4>
            <h2>{prodExtracto.titulo}</h2>
          </div>
          <Link to="/">
            <button className="boton-volver">
              <MdOutlineArrowBackIos size={"30"} />
              <strong>Volver al Inicio</strong>
            </button>
          </Link>
        </div>
        <div className="ubicacion">
          <div>
            <p>
              {prodExtracto.ciudad.nombre}, {prodExtracto.ciudad.provincia},{" "}
              {prodExtracto.ciudad.pais}
            </p>
          </div>
          <div className="valoracion">
            <h4>Excelente</h4>
            <h2>10</h2>
          </div>
        </div>
      </header>
      <section>
        <div className="icons-prod">
          <button>
            <AiOutlineHeart size={"20"} />
          </button>
          <button>
            <FaShare size={"20"} />
          </button>
        </div>

        <div className="galeriaImg">
          <img
            className="img1"
            src="https://images.unsplash.com/photo-1555215695-3004980ad54e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
          ></img>
          <img
            className="img2"
            src="https://images.unsplash.com/photo-1555215695-3004980ad54e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
          ></img>
          <img
            className="img3"
            src="https://images.unsplash.com/photo-1555215695-3004980ad54e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
          ></img>
          <img
            className="img4"
            src="https://images.unsplash.com/photo-1555215695-3004980ad54e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
          ></img>
          <img
            className="img5"
            src="https://images.unsplash.com/photo-1555215695-3004980ad54e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
          ></img>
        </div>
        <article className="cuerpo">
          <h2>{prodExtracto.titulo}</h2>
          <p className="descripcion">{prodExtracto.descripcion}</p>
        </article>
        <article className="cuerpo">
          <h2>Que ofrece este producto?</h2>
          <ul className="caracteristicas">
            {prodExtracto&&prodExtracto.caracteristicas.map((carac) => (
              <li>{carac.titulo}</li>
            ))}
            <li>cuatro puertas</li>
          </ul>
        </article>
      </section>
    </div>
  );
};

export default Producto;
