import React, { createContext, useState } from "react";
import useFetch from "../Hooks/useFetch";
export const DataProductosContext = createContext();

export const DataProductosProvider = ({ children }) => {
    const [dataProductos, setDataProductos] = useState();
    // const urlCiudades = "http://localhost:8080/ciudades";
    // const { data } = useFetch(urlCiudades);
    
  return (
    <DataProductosContext.Provider value={{ dataProductos, setDataProductos }}>
      {children}
    </DataProductosContext.Provider>
  );
};
