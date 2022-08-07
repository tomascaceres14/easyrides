import "./Listado.css"
import data from "./data.json";
import React from 'react'

export default function Cards() {
  return (
    <div className="cardsProductos">
      {/* <h2 className="cardsCategoria-titulo">Busca por categorias</h2> */}

      {data.map((categoria) => (
        <div className="cardsProductos-unidad">
          <img
            key={categoria.id}
            src={categoria.categoria.imagen}
            alt=""
            className="cardsProductos-unidad-img"
          />
          <h2 className="cardsProductos-unidad-nombre">
            {categoria.categoria.nombre}
          </h2>
          <p className="cardsProductos-unidad-descripcion">
            {categoria.categoria.descripcion}
          </p>
          <button className="cardsProductos-unidad-boton">Ver Más</button>
        </div>
      ))}
    </div>
  );
}
