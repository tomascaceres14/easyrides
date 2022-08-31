import "./Listado.css";
import React, { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import useFetch from "../../../Hooks/useFetch";
import ListadoCiudades from "./ListadoCiudades";
import ListadoCategorias from "./ListadoCategorias";
import { DataProductosContext } from "../../../Context/DataProductosContext";
import { MostrarCategoriasContext } from "../../../Context/MostrarCategoriasContext";


export default function Listado() {
  // traigo el context y hago el booleano
  const urlProductos = "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/productos";
  //context que guarde data con un state 
  const { data } = useFetch(urlProductos);
  const { dataProductos } = useContext(DataProductosContext)
  const { mostrarCategorias, setMostrarCategorias } = useContext(
    MostrarCategoriasContext
  );

  return (
    <div className="listado-container">
      <p className="cardsProductos-titulo">Recomendaciones</p>
      <div className="cardsProductos">
        {mostrarCategorias ? (
          <ListadoCategorias />
        ) : dataProductos ? (
          data &&
          data.productos.map((prod) => (
            <div className="listado-unidad" key={prod.id}>
              <img
                key={prod.id}
                src={prod.imagenes[0].url}
                alt=""
                className="cardsProductos-unidad-img"
              />
              <h2 className="listado-unidad-nombre">{prod.titulo}</h2>
              <p className="cardsProductos-unidad-descripcion">
                {prod.ciudad.nombre + ", " + prod.ciudad.provincia}
              </p>
              {/* <img className="cardsProductos-unidad-caracteristica" src={prod.caracteristicas.url}/> */}

              <Link to="/producto">
                <button
                  className="listado-unidad-boton"
                  onClick={() =>
                    localStorage.setItem("producto", JSON.stringify(prod))
                  }
                >
                  Ver Más
                </button>
              </Link>
            </div>
          ))
        ) : !dataProductos ? (
          <ListadoCiudades />
        ) 
        // : mostrarCategorias ? (
        //   <ListadoCategorias />
        // ) 
        : null}
      </div>
    </div>
  );
}
