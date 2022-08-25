import React, { useContext, useState } from "react";
import "./Buscador.css";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import { SearchBar } from "./SearchBar";
import Calendario from "./Calendario";
import { DataProductosContext } from "../../../Context/DataProductosContext";


function  Buscador(){
  // creo un estado global que llegue a listado y ahi hago una condicional de si esta en falso muestro 
  // todo el listado y si cambia a true cambio a listado ciudades
  // aca traigo el estado de un context
  const {dataProductos, setDataProductos} = useContext(DataProductosContext);

  return (
    <div className="buscador">
      <h1>¿Ya elegiste tu próximo destino?</h1>
      <div className="buscadores">
        <SearchBar />
        <Calendario className="calendario" />
        <button className="buscador-submit" onClick={() => setDataProductos(false)}>
          Buscar
        </button>
      </div>
    </div>
  );
};

export default Buscador;

