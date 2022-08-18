import React from "react";
import data1 from "./data1.json";
import "./Cards.css";
import useFetch from "../../../Hooks/useFetch";
export default function Cards() {
  const urlCategorias = "http://localhost:8080/categorias";
  const { data } = useFetch(urlCategorias)
  console.log(data);




  return (
    <div>
      <h2 className="cardsCategoria-titulo">Busca por categoria</h2>
      <div className="cardsCategoria">
      {data&&data.categorias.map((cat)=> (
        <div key={cat.id} className="cardsCategoria-unidad">
          <img
            src={cat.url}
            alt=""
            className="cardsCategoria-unidad-img"/>
          <p className="cardsCategoria-unidad-nombre">
            {cat.titulo}
          </p>
          <p className="cardsCategoria-unidad-descripcion">
            {cat.descripcion}
          </p>
        </div>
      ))}
    </div> 
    </div>
    
  );
}
