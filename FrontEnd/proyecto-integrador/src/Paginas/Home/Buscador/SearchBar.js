import { formatRelative } from "date-fns";
import React from "react";
import Select from "react-select";
import ciudades from "./ciudades.json";
import "./SearchBar.css";
import useFetch from "../../../Hooks/useFetch";

export const SearchBar = () => {
  const urlCiudades = "http://localhost:8080/ciudades";
  const { data } = useFetch(urlCiudades);
  console.log(data);
  const handleSelectChange = (event) => {
    console.log(event);
  };

  return (
    <div className="searchBar">
      <Select
        className="searchBar-individual"
        defaultValue={ciudades[0]}
        options={data&&data.productos.map((ciudad) => ({
          label: ciudad.nombre,
          value: ciudad.id,
        }))}
        onChange={handleSelectChange}
        

      />
    </div>
  );
};
