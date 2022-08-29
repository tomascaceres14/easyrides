import React, { useContext } from "react";
import "./Cards.css";
import useFetch from "../../../Hooks/useFetch";
import { CategoriasContext } from "../../../Context/CategoriasContext";
import { MostrarCategoriasContext } from "../../../Context/MostrarCategoriasContext";

export default function Cards() {
  const urlCategorias = "http://localhost:8080/categorias";
  const { data } = useFetch(urlCategorias)
  const { elegirCategorias, setElegirCategorias } = useContext(CategoriasContext);
  const { mostrarCategorias, setMostrarCategorias } = useContext(MostrarCategoriasContext);

  return (
    <div>
      <h2 className="cardsCategoria-titulo">Busca por categorías</h2>
      <div className="cardsCategoria">
        {data &&
          data.categorias.map((cat) => (
            
            <div
              key={cat.id}
              className="cardsCategoria-unidad"
              onClick={() =>
                setElegirCategorias(cat.titulo)
                &&setMostrarCategorias(true)
              }
            
            >
              <img src={cat.url} alt="" className="cardsCategoria-unidad-img" />
              <p className="cardsCategoria-unidad-nombre">{cat.titulo}</p>
            </div>
          ))}
      </div>
    </div>
  );
}
