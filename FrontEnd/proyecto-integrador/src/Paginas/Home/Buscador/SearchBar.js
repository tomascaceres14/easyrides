// import { formatRelative } from "date-fns";
import React, { useState, useContext } from "react";
import Select from "react-select";
import "./SearchBar.css";
import useFetch from "../../../Hooks/useFetch";
import { CiudadesContext } from "../../../Context/CiudadesContext";


export const SearchBar = () => {
  const urlCiudades = "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/ciudades";
  const { data } = useFetch(urlCiudades);
  // const [elegirCiudades, setElegirCiudades] = useState()
  // context de busquedas que va a guardar elegirciudades y el resultado filtrado 

  const { elegirCiudades, setElegirCiudades } = useContext(CiudadesContext);

  const manejadorSelect = (event) => {
    setElegirCiudades(event.label);
  };
  // cambiar propiedades de fetch
  return (
    <div className="searchBar">
      <Select
        className="searchBar-individual"
        defaultValue={""}
        options={
          data &&
          data.ciudad.map((ciudad) => ({
            label: ciudad.nombre,
            value: ciudad.id,
          }))
        }
        onChange={manejadorSelect}
        placeholder={<div>Elegí tu ciudad</div>}
        
      />
    </div>
  );
};
