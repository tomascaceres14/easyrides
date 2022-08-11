import { formatRelative } from "date-fns";
import React from "react";
import Select from "react-select";
import ciudades from "./ciudades.json";
import "./SearchBar.css";

export const SearchBar = () => {

  const handleSelectChange = (event) => {
    console.log(event);
  };

  return (
    <div className="searchBar">
      <Select
        className="searchBar-individual"
        defaultValue={ciudades[0]}
        options={ciudades.map((ciudad) => ({
          label: ciudad.nombre,
          value: ciudad.id,
        }))}
        onChange={handleSelectChange}
        styles={{position:"relative", zIndex: 999 }}

      />
    </div>
  );
};
