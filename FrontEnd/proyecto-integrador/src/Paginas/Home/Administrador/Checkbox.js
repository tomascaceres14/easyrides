// import { formatRelative } from "date-fns";
import React, { useState, useContext } from "react";
import Select from "react-select";
import makeAnimated from "react-select/animated";
import useFetch from "../../../Hooks/useFetch";
const animatedComponents = makeAnimated();

export const Checkbox = () => {
  const urlCaracteristicas =
    "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/caracteristicas";
  const { data } = useFetch(urlCaracteristicas);


  // cambiar propiedades de fetch
  return (
    <div className="searchBar">
      <Select
        className="searchBar-individual"
        defaultValue={""}
        components={animatedComponents}
        isMulti
        options={
          data &&
          data.caracteristicas.map((carac) => ({
            label: carac.titulo,
            value: carac.id,
          }))
        }
        placeholder={<div>Elegí las caracteristicas</div>}
      />
    </div>
  );
};

