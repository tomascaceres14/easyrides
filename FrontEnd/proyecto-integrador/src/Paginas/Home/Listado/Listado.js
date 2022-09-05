import "./Listado.css";
import React, { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import useFetch from "../../../Hooks/useFetch";
import ListadoCiudades from "./ListadoCiudades";
import ListadoCategorias from "./ListadoCategorias";
import { DataProductosContext } from "../../../Context/DataProductosContext";
import { MostrarCategoriasContext } from "../../../Context/MostrarCategoriasContext";
import { DataPaginaProductosContext } from "../../../Context/DataPaginaProductosContext";


export default function Listado() {
  
  const urlProductos = "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/productos";
  const { data } = useFetch(urlProductos);
  const { dataProductos } = useContext(DataProductosContext)
  const { mostrarCategorias, setMostrarCategorias } = useContext(MostrarCategoriasContext);
  const { elegirDataPaginaProductos, setElegirDataPaginaProductos } = useContext(DataPaginaProductosContext)
  
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
              {/* {setElegirDataPaginaProductos(prod.id)} */}
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

              <Link onClick= {() =>
                    {setElegirDataPaginaProductos(prod.id)}
              } to={`/producto/${prod.id}`}>
                <button
                  className="listado-unidad-boton"
                >
                  Ver Más
                </button>
              </Link>
            </div>
          ))
        ) : !dataProductos ? (
          <ListadoCiudades />
        ) : // : mostrarCategorias ? (
        //   <ListadoCategorias />
        // )
        null}
      </div>
    </div>
  );
}
