import React from "react";
import "./Producto.css";
import { FaShare } from "react-icons/fa";
import { MdOutlineArrowBackIos } from "react-icons/md";
import { AiOutlineHeart } from "react-icons/ai";

const Producto = (data) => {
  return (
    <div>
      <header>
        <div className="header-producto">
          <div>
            <h4>CATEGORIA</h4>
            <h2>Titulo del producto</h2>
          </div>
          <button className="boton-volver">
            <MdOutlineArrowBackIos size={"30"} />
            <p>Volver al Inicio...</p>
          </button>
        </div>
        <div className="ubicacion">
          <div>
            <p>Rivadavia 1660, CABA, Buenos Aires, Argentina</p>
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
          <h2>Volkswagen Bora</h2>
          <p className="descripcion">
            By far the most impressive Bora is the recently announced 150bhp
            diesel - it makes great financial sense and is a super car to drive.
            There are very few available second-hand, however, and those that do
            come up for sale are expensive. Instead, go for the 115bhp TDI -
            it's a fine all-rounder, and VW's diesel engines make petrol power
            look pointless, with torque on demand, excellent performance and
            brilliant refinement. SE spec is best value, but keen drivers will
            prefer the Sport, with its stiffer suspension and sharper steering.
            By far the most impressive Bora is the recently announced 150bhp
            diesel - it makes great financial sense and is a super car to drive.
            There are very few available second-hand, however, and those that do
            come up for sale are expensive. Instead, go for the 115bhp TDI -
            it's a fine all-rounder, and VW's diesel engines make petrol power
            look pointless, with torque on demand, excellent performance and
            brilliant refinement. SE spec is best value, but keen drivers will
            prefer the Sport, with its stiffer suspension and sharper steering.
          </p>
        </article>
        <article className="cuerpo">
          <h2>Que ofrece este producto?</h2>
          <ul className="caracteristicas">
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
            <li>cuatro puertas</li>
          </ul>
        </article>
      </section>
    </div>
  );
};

export default Producto;
