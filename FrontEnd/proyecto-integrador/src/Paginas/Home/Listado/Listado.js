import "./Listado.css";
import data from "./data.json";
import React from "react";
import { Link } from "react-router-dom";
import useFetch from "../../../Hooks/useFetch";

export default function Listado() {
  // const urlProductos = "http://localhost:8080/productos";
  // const { data } = useFetch(urlProductos);
  return (
    <div>
      <p className="cardsProductos-titulo">Recomendaciones</p>
      <div className="cardsProductos">
        {data&&data.categorias.map((prod) => (
          <div className="cardsProductos-unidad">
            <img
              key={prod.id}
              src={prod.url}
              alt=""
              className="cardsProductos-unidad-img"
            />
            <h2 className="cardsProductos-unidad-nombre">
              {prod.titulo}
            </h2>
            <p className="cardsProductos-unidad-descripcion">
              {prod.descripcion}
            </p>
            <Link to="/producto">
              <button className="cardsProductos-unidad-boton">Ver Más</button>
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
}
