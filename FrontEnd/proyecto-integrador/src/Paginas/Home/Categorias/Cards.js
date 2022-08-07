import React from "react";
import data from "./data.json";
import "./Cards.css";

export default function Cards() {
  return (
    <div className="cardsCategoria">
      {/* <h2 className="cardsCategoria-titulo">Busca por categorias</h2> */}

      {data.map((categoria) => (
        <div className="cardsCategoria-unidad">
          <img
            key={categoria.id}
            src={categoria.categoria.imagen}
            alt=""
            className="cardsCategoria-unidad-img"/>
          <h2 className="cardsCategoria-unidad-nombre">
            {categoria.categoria.nombre}
          </h2>
          <p className="cardsCategoria-unidad-descripcion">
            {categoria.categoria.descripcion}
          </p>
        </div>
      ))}
    </div>
  );
}
