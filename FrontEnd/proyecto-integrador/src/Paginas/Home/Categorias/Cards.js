import React from "react";
import data from "./data.json";
import "./Cards.css";

export default function Cards() {
  return (
    <div>
      <h2 className="cardsCategoria-titulo">Busca por categoria</h2>
      <div className="cardsCategoria">
      {data.map((categoria) => (
        <div className="cardsCategoria-unidad">
          <img
            key={categoria.id}
            src={categoria.categoria.imagen}
            alt=""
            className="cardsCategoria-unidad-img"/>
          <p className="cardsCategoria-unidad-nombre">
            {categoria.categoria.nombre}
          </p>
          <p className="cardsCategoria-unidad-descripcion">
            {categoria.categoria.descripcion}
          </p>
        </div>
      ))}
    </div>
    </div>
    
  );
}
